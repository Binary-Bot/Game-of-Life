package life;

import javax.swing.*;

public class GameOfLife extends JFrame {
    GoLView view;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        view = new GoLView();
        add(view);

        pack();
        setVisible(true);
    }
}
