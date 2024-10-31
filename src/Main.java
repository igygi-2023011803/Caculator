import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private  JTextField textField;
    private  String operator = "";
    private  double num1, num2;

    public Main() {
        setTitle("계산기");
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel PanelA = new JPanel();
        PanelA.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        textField = new JTextField(20);
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(400, 60));
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setBorder(BorderFactory.createEmptyBorder());
        PanelA.add(textField);
        add(PanelA, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "x",
                "1", "2", "3", "-",
                ".", "0", "=", "+",
                "C", "", "", "Del"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 26));
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);

    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0)>= '0' && command.charAt(0) <= '9') {
                textField.setText(textField.getText() + command);
            } else if (command.equals("C")) {
                textField.setText("");
                operator = "";
                num1 = num2 = 0;
            }
              else if (command.equals("Del")) {
                 String currentText = textField.getText();
                 if (currentText.length() > 0) {
                     textField.setText(currentText.substring(0, currentText.length() -1));
                 }
            }
              else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+":
                        textField.setText(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        textField.setText(String.valueOf(num1 - num2));
                        break;
                    case "x":
                        textField.setText(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        if (num2 != 0) {
                            textField.setText(String.valueOf(num1 / num2));
                        } else {
                            textField.setText(String.valueOf(num1 / num2));
                        }
                        break;
                }
                operator = "";
            } else {
                if (!operator.isEmpty()) {
                    return;
                }
                operator = command;
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
            }
        }

    }

    public static void main(String [] args){
        new Main();
    }


}