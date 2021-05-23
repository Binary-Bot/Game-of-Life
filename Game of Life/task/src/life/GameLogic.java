package life;

import java.io.IOException;
import java.util.Random;

public class GameLogic implements Runnable{
    private Cell[][] universe;
    private Cell[][] nextGen;
    private Thread thread;
    private boolean running;
    private GoLController controller;
    private int genNum;
    private final static int size = 30;

    public GameLogic() {
        universe = new Cell[size][size];
        running = true;
    }

    public void addController(GoLController controller){ this.controller = controller;}

    public void setUniverse(Cell[][] universe) {
        this.universe = universe;
        start();
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    private void findGeneration() {
        genNum = 1;
        while (true) {
            if (running) {
                try {
                    Thread.sleep(1000);
                    nextGen = copy(universe);
                    for (int i = 0; i < universe.length; i++) {
                        for (int j = 0; j < universe.length; j++) {
                            universe[i][j].determineState(getNeighbourCells(i, j));
                        }
                    }
                    //showUniverse(universe);
                    genNum++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            controller.update(universe, genNum, checkAliveCells());
        }
    }

    private int getNeighbourCells(int r, int c) {
        int count = 0;
        for (int i = r - 1; i < r + 2; ++i) {
            for (int j = c - 1; j < c + 2; ++j) {
                if (nextGen[adjustBounds(i)][adjustBounds(j)].isAlive()) {
                    if (!(i == r && j == c)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

//    private void showUniverse(Cell[][] array){
//        for(int i = 0; i < universe.length; ++i){
//            for(int j = 0; j < universe.length; ++j){
//                if (array[i][j].isAlive()){
//                    System.out.print("O");
//                } else { System.out.print(" ");}
//            }
//            System.out.println();
//        }
//    }

    private int adjustBounds(int n) {
        int i;
        if (n > size - 1) i = 0;
        else if (n < 0) i = size - 1;
        else i = n;
        return i;
    }

    public Cell[][] copy(Cell[][] array) {
        Cell[][] copiedArray = new Cell[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                copiedArray[i][j] = new Cell(array[i][j].isAlive());
            }
        }
        return copiedArray;
    }

    private int checkAliveCells(){
        int count = 0;
        for (Cell[] cells : universe) {
            for (int j = 0; j < universe.length; j++) {
                if (cells[j].isAlive()){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public void run() {
        findGeneration();
    }

    public void setRunning(boolean state) {
        running = state;
    }

    public void setNewUniverse() {
        Random random = new Random();
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                universe[i][j].setState(random.nextBoolean());
            }
        }
        genNum = 1;
        controller.update(universe, genNum, checkAliveCells());
    }
}
