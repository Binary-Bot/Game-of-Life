package life;

import java.util.Random;
import java.util.Scanner;

public class GameOfLife {
    private Cell[][] universe;
    private Cell[][] generation;
    private Random random;
    private int size, seed, genNumber;

    public GameOfLife(){
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        seed = scanner.nextInt();
        genNumber = scanner.nextInt();
        random = new Random(seed);
        universe = new Cell[size][size];

        for(int i = 0; i < universe.length; i++){
            for(int j = 0; j < universe.length; j++){
                universe[i][j] = new Cell(random.nextBoolean());
            }
        }
        int s = getNeighbouringCells(3,0);
        //showUniverse();
    }

    private void findGeneration(int genNumber){

    }

    private int getNeighbouringCells(int r, int c){

    }

    private int checkForBounds(int r, int c){
        
    }

    public void showUniverse(){
        for (Cell[] cells : universe) {
            for (int j = 0; j < universe.length; j++) {
                System.out.print(cells[j].getState());
            }
            System.out.println();
        }
    }
}
