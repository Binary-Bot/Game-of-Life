package life;

import java.util.Random;

public class Cell {
    private boolean state;

    public Cell(boolean state){
        this.state = state;
    }

    public String getState(){
        if (state){
            return "O";
        }
        return " ";
    }
}
