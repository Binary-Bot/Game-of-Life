package life;

import java.util.Random;
import java.util.Scanner;

public class GameOfLife {
    private Cell[][] universe;
    private Generation generation;
    private Random random;
    private int size, seed, genNumber;

    public GameOfLife() {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        seed = scanner.nextInt();
        genNumber = scanner.nextInt();
        random = new Random(seed);
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
        showUniverse();
    }

    private void findGeneration() {
        int current = 0;
        while (current < genNumber) {
            generation.findNextGeneration();
            universe = generation.copy(generation.getNextGen());
            current++;
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
}
