package life;

import java.util.Random;
import java.util.Scanner;

public class GameOfLife {
    private Cell[][] universe;
    private Cell[][] generation;
    private Random random;
    private int size, seed, genNumber;

    public GameOfLife() {
    }

    public void start() {
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
        findGeneration();
        showUniverse();
    }

    private void findGeneration() {
        int current = 0;
        while (current < genNumber) {
            generation = copy(universe);
            for (int i = 0; i < universe.length; i++) {
                for (int j = 0; j < universe.length; j++) {
                    generation[i][j].determineState(getNeighbourCells(i, j));
                }
            }
            universe = copy(generation);
            current++;
        }
    }

    private int getNeighbourCells(int r, int c) {
        int count = 0;
        for (int i = r - 1; i < r + 2; ++i) {
            for (int j = c - 1; j < c + 2; ++j) {
                if (universe[adjustBounds(i)][adjustBounds(j)].getState().equals("O")) {
                    if (!(i == r && j == c)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int adjustBounds(int n) {
        int i;
        if (n > size - 1) i = 0;
        else if (n < 0) i = size - 1;
        else i = n;
        return i;
    }

    private void showUniverse() {
        for (Cell[] cells : universe) {
            for (int j = 0; j < universe.length; j++) {
                System.out.print(cells[j].getState());
            }
            System.out.println();
        }
    }

    private Cell[][] copy(Cell[][] array) {
        Cell[][] copiedArray = new Cell[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                copiedArray[i][j] = new Cell(array[i][j].isAlive());
            }
        }
        return copiedArray;
    }
}
