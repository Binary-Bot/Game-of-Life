package life;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GoLView extends JPanel {
    private JLabel label;
    private CellView[][] cellViews;
    private final static int rows = 20;
    private final static int cols = 20;

    public GoLView() {
        Random random = new Random();
        cellViews = new CellView[rows][cols];
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(290, 290));

        label = new JLabel("Generation");
        label.setBackground(Color.GRAY);
        //label.setBounds(10, 10, 100, 50);
        add(label, BorderLayout.NORTH);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(rows, cols));
        jp.setBounds(new Rectangle(200, 200));
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                cellViews[i][j] = new CellView(random.nextBoolean());
                jp.add(cellViews[i][j]);
            }
        }
        this.add(jp);

    }
}
