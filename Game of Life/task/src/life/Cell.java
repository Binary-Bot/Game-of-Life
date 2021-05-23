package life;

import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {
    private boolean state;

    public Cell(boolean state){
        this.state = state;
        repaint();
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
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        if (this.isAlive()) {
            g.fillRect(0,0,100,100);
        } else {
            g.drawRect(0, 0, 100, 100);

        }
    }
}
