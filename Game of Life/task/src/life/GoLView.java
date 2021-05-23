package life;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.IconUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GoLView extends JPanel {
    private JLabel GenerationLabel;
    private JLabel AliveLabel;
    private JToggleButton pause;
    private JButton reset;
    private Cell[][] cellViews;
    private GoLController controller;
    private JPanel jp;
    private Random random;
    private boolean state;
    private final static int rows = 20;
    private final static int cols = 20;

    public GoLView() {
        random = new Random(4);
        state = true;
        cellViews = new Cell[rows][cols];
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(590, 590));

        jp = new JPanel();
        jp.setLayout(new GridLayout(rows, cols));
        jp.setBounds(new Rectangle(200, 200));
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                cellViews[i][j] = new Cell(random.nextBoolean());
                jp.add(cellViews[i][j]);
            }
        }
        add(jp);

        JPanel funcPanel = new JPanel();
        funcPanel.setLayout(new FlowLayout());
        funcPanel.setPreferredSize(new Dimension(200, 200));

        pause = new JToggleButton("Play/Pause");
        pause.setName("PlayToggleButton");
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = !state;
                controller.toggle(state);
            }
        });
        funcPanel.add(pause);

        reset = new JButton("Reset");
        reset.setName("ResetButton");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.reset();
                updateCells();
            }
        });
        funcPanel.add(reset);

        GenerationLabel = new JLabel(" Generation #1");
        GenerationLabel.setName("GenerationLabel");
        GenerationLabel.setBackground(Color.GRAY);
        GenerationLabel.setBounds(0, 0, 100, 20);
        funcPanel.add(GenerationLabel);

        AliveLabel = new JLabel(" Alive: ");
        AliveLabel.setName("AliveLabel");
        AliveLabel.setBackground(Color.GRAY);
        AliveLabel.setBounds(8,8,100,20);
        funcPanel.add(AliveLabel);

        add(funcPanel, BorderLayout.WEST);

    }

    public void addController(GoLController controller) {this.controller = controller;}

    public Cell[][] getCellViews(){ return cellViews; }

    public void setCellViews(Cell[][] cellViews) { this.cellViews = cellViews;}
    
    public void setGenerationNum(int genNum) {
        this.GenerationLabel.setText(" Generation #" + genNum);
    }

    public void setAliveNum(int aliveNum) {
        this.AliveLabel.setText(" Alive: " + aliveNum);
    }

    private void updateCells() {
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                jp.add(cellViews[i][j]);
            }
        }
    }
}
