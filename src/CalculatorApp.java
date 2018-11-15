import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame{

    JLabel displayLabel;

    Controller controller;

    public CalculatorApp() {

        controller = new Controller(this);

        setTitle("Calculator");
        setSize(400, 500);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(204, 204, 179));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLayout(new GridLayout(2,1));
        //Lag 2 jpanel, en med fluid en med grid

        JPanel screen = new JPanel(new GridLayout(1,1));

        displayLabel = new JLabel("0", SwingConstants.RIGHT);
        //displayLabel.setBounds(0,0,500,100);
        displayLabel.setFont(new Font(Font.SANS_SERIF, 1, 50));
        screen.add(displayLabel);



        JPanel buttons = new JPanel(new GridLayout(0,4,2,2));


        JButton sevenButton = new JButton("7");
        buttons.add(sevenButton);
        sevenButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                String num = "7";
                controller.numberButton(num);
            }
        });

        JButton eightButton = new JButton("8");
        buttons.add(eightButton);
        eightButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                String num = "8";
                controller.numberButton(num);
            }
        });

        JButton nineButton = new JButton("9");
        buttons.add(nineButton);
        nineButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                String num = "9";
                controller.numberButton(num);
            }
        });

        JButton clearButton = new JButton("C");
        buttons.add(clearButton);
        clearButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                controller.clearView();
            }
        });

        JButton fourButton = new JButton("4");
        buttons.add(fourButton);
        fourButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                String num = "4";
                controller.numberButton(num);
            }
        });

        JButton fiveButton = new JButton("5");
        buttons.add(fiveButton);
        fiveButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                String num = "5";
                controller.numberButton(num);
            }
        });

        JButton sixButton = new JButton("6");
        buttons.add(sixButton);
        sixButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                String num = "6";
                controller.numberButton(num);
            }
        });

        JButton divButton = new JButton("/");
        buttons.add(divButton);
        divButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                controller.setOperator("/");
            }
        });

        JButton oneButton = new JButton("1");
        buttons.add(oneButton);
        oneButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                String num = "1";
                controller.numberButton(num);
            }
        });

        JButton twoButton = new JButton("2");
        buttons.add(twoButton);
        twoButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                String num = "2";
                controller.numberButton(num);
            }
        });

        JButton threeButton = new JButton("3");
        buttons.add(threeButton);
        threeButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                String num = "3";
                controller.numberButton(num);
            }
        });

        JButton multButton = new JButton("*");
        buttons.add(multButton);
        multButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                controller.setOperator("*");
            }
        });


        JButton saveButton = new JButton("M");
        buttons.add(saveButton);
        saveButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                controller.setSaveArg();
            }
        });


        JButton zeroButton = new JButton("0");
        buttons.add(zeroButton);
        zeroButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                String num = "0";
                controller.numberButton(num);
            }
        });



        JButton retrieveButton = new JButton("R");
        buttons.add(retrieveButton);
        retrieveButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                controller.recallSaved();
            }
        });



        JButton plusButton = new JButton("+");
        buttons.add(plusButton);
        plusButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                controller.setOperator("+");
            }
        });

        JButton minusButton = new JButton("-");
        buttons.add(minusButton);
        minusButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                controller.setOperator("-");
            }
        });





        JButton enterButton = new JButton("=");
        buttons.add(enterButton);
        enterButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0){
                controller.enterButton();
            }
        });



        for (Component c : buttons.getComponents()) {
            if (c instanceof JButton) {
                c.setBackground(new Color(26,117,255));
                c.setFont(new Font(Font.SANS_SERIF, 1, 30));
                c.setForeground(Color.WHITE);
            }
        }

        enterButton.setBackground(new Color(0,153,51));
        enterButton.setFont(new Font(Font.SANS_SERIF, 1, 30));
        enterButton.setForeground(Color.WHITE);

        add(screen, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        CalculatorApp ex = new CalculatorApp();
        ex.setVisible(true);
    }

    public void updateView(String firstArg, String secondArg, String operator){
        displayLabel.setText(firstArg + operator + secondArg);
    }

}

