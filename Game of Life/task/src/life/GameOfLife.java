package life;

import javax.swing.*;

public class GameOfLife extends JFrame {
    GoLView view;
    GameLogic game;
    GoLController controller;

    public GameOfLife() {
        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        view = new GoLView();
        game = new GameLogic();
        controller = new GoLController(view, game);

        this.getContentPane().add(view);
        pack();
        setVisible(true);
    }
}
