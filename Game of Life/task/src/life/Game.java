package life;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game{
    private Cell[][] universe;
    private Generation generation;
    private Random random;
    private int size;

    public Game() {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        random = new Random();
        universe = new Cell[size][size];

        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {
                universe[i][j] = new Cell(random.nextBoolean());
            }
        }
        generation = new Generation(size, universe);
    }

    public void start() {
        findGeneration();
    }

    private void findGeneration() {
        int gen = 1;
        while (gen < 14) {
            try {
                generation.findNextGeneration();
                universe = generation.copy(generation.getNextGen());
                System.out.println("Generation #" + gen);
                System.out.println("Alive: " + checkAliveCells());
                showUniverse();
                Thread.sleep(1000);
                clear();
                gen++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showUniverse() {
        for (Cell[] cells : universe) {
            for (int j = 0; j < universe.length; j++) {
                System.out.print(cells[j].getState());
            }
            System.out.println();
        }
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

    private void clear(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException e) {}
    }
}
