package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int seed = scanner.nextInt();
        Random random = new Random(seed);

        Cell[][] universe = new Cell[size][size];
        for(int i = 0; i < universe.length; i++){
            for(int j = 0; j < universe.length; j++){
                universe[i][j] = new Cell(random.nextBoolean());
                System.out.print(universe[i][j].getState());
            }
            System.out.println();
        }



    }
}
