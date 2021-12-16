import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Head demo");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new GridLayout(2, 2));
        f.add(new Head());
        f.add(new Head());
        f.add(new Head());
        f.add(new Head());

        f.pack();
        f.setVisible(true);
    }
}

