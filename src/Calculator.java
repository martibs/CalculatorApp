import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Calculator extends JFrame{

    public Calculator() {
        //gittest
        setTitle("JFrame Calculator");
        setSize(400, 500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(204, 204, 179));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel screentext = new JLabel("2148972", SwingConstants.RIGHT );
        screentext.setFont(new Font(Font.SANS_SERIF, 1, 50));
        JPanel buttons = new JPanel(new GridLayout(0,4,2,2));

        buttons.add(new JButton("7"));
        buttons.add(new JButton("8"));
        buttons.add(new JButton("9"));
        buttons.add(new JButton("C"));
        buttons.add(new JButton("4"));
        buttons.add(new JButton("5"));
        buttons.add(new JButton("6"));
        buttons.add(new JButton("/"));
        buttons.add(new JButton("1"));
        buttons.add(new JButton("2"));
        buttons.add(new JButton("3"));
        buttons.add(new JButton("*"));
        buttons.add(new JButton("M"));
        buttons.add(new JButton("0"));
        buttons.add(new JButton("R"));
        buttons.add(new JButton("+"));
        buttons.add(new JLabel(""));
        buttons.add(new JLabel(""));
        buttons.add(new JButton("-"));

        JLabel smalltext = new JLabel("214872", SwingConstants.RIGHT);
        smalltext.setFont(new Font(Font.SANS_SERIF, 1, 20));
        smalltext.setMaximumSize(new Dimension(50,5));

        JPanel screen = new JPanel(new GridLayout(2,1));

        for (Component c : buttons.getComponents()) {
            if (c instanceof JButton) {
                c.setBackground(new Color(26,117,255));
                c.setFont(new Font(Font.SANS_SERIF, 1, 30));
                c.setForeground(Color.WHITE);
                ((JButton) c).addActionListener(e -> {
                    JButton btn = (JButton) e.getSource();
                    System.out.println(btn.getText());
                });
            }
        }

        JButton equals = new JButton("=");
        equals.setBackground(new Color(0,153,51));
        equals.setFont(new Font(Font.SANS_SERIF, 1, 30));
        equals.setForeground(Color.WHITE);

        buttons.add(equals);

        screen.add(screentext);
        screen.add(smalltext);

        add(screen, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);
    }

//    public static void main(String[] args) {
  //      Calculator ex = new Calculator();
    //    ex.setVisible(true);
   // }
}
