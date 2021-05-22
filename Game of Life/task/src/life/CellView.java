package life;

import javax.swing.*;
import java.awt.*;

public class CellView extends JLabel {
    private Cell cell;

    public CellView(boolean state) {
        cell = new Cell(state);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        if (cell.isAlive()) {
            g.drawRect(0, 0, 100, 100);
        } else {
            g.fillRect(0,0,100,100);
        }

    }
}
