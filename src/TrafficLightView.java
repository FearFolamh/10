import javax.swing.*;
import java.awt.*;

public class TrafficLightView {
    JFrame frame;
    private JLabel label;

    public TrafficLightView() {
        frame = new JFrame("Симулятор светофора");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        label = new JLabel("Светофор: RED", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(label, BorderLayout.CENTER);
    }

    public void setTrafficLightState(String state) {
        label.setText("Светофор: " + state);
    }

    public void show() {
        frame.setVisible(true);
    }
}