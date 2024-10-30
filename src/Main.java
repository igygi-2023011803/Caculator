import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private  JTextField textField;
    private  String operator;
    private  double num1, num2;
    public Main() {
        setTitle("계산기");
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel PanelA = new JPanel();
        textField = new JTextField(20);
        textField.setEditable(false);
        PanelA.add(textField);
        add(PanelA, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4,10,10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "x",
                "1", "2", "3", "-",
                ".", "0", "=", "+",
                "C", "", "", "Del"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);

    }

    private class ButtonClickListner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt)

    }

    public static void main(String [] args){
        new Main();
    }


}