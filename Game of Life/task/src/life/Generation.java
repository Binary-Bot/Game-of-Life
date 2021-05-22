package life;

public class Generation{
    private Cell[][] universe;
    private Cell[][] nextGen;
    private int size;

    public Generation(int size, Cell[][] universe){
        this.size = size;
        this.universe = copy(universe);
        
    }

    public void findNextGeneration(){
        nextGen = copy(universe);
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {
                nextGen[i][j].determineState(getNeighbourCells(i, j));
            }
        }
        universe = copy(nextGen);
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

    public Cell[][] copy(Cell[][] array) {
        Cell[][] copiedArray = new Cell[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                copiedArray[i][j] = new Cell(array[i][j].isAlive());
            }
        }
        return copiedArray;
    }

    public Cell[][] getNextGen(){
        return nextGen;
    }
}
