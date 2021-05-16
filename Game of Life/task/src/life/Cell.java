package life;

import java.util.Random;

public class Cell {
    private boolean state;

    public Cell(boolean state){
        this.state = state;
    }

    public void setState(boolean state){
        this.state = state;
    }

    public String getState(){
        if (state){
            return "O";
        }
        return " ";
    }

    public boolean isAlive(){
        return state;
    }

    public void determineState(int neighborCells){
        if (this.isAlive()){
            if (neighborCells < 2 || neighborCells > 3){
                this.state = false;
            }
        } else {
            if (neighborCells == 3){
                this.state = true;
            }
        }
    }
}
