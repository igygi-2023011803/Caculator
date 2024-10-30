import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        setTitle("계산기");
        setSize(520,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        JPanel button = new JPanel();
        button.setLayout(new GridLayout(5, 5,3,3));

        add(button, BorderLayout.CENTER);
        setVisible(true);

    }
    public static void main(String [] args){
        new Main();
    }


}