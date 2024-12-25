import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TrafficLightView {
    private JFrame frame;
    private JPanel lightPanel; // Панель для рисования светофора
    private JButton controlButton; // Кнопка управления симуляцией
    private Color redLight = Color.DARK_GRAY;
    private Color yellowLight = Color.DARK_GRAY;
    private Color greenLight = Color.DARK_GRAY;

    public TrafficLightView() {
        frame = new JFrame("Симулятор светофора");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 400);
        frame.setLayout(new BorderLayout());

        // Панель для светофора
        lightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(redLight);
                g2d.fillOval(50, 30, 100, 100); // Красный свет
                g2d.setColor(yellowLight);
                g2d.fillOval(50, 140, 100, 100); // Желтый свет
                g2d.setColor(greenLight);
                g2d.fillOval(50, 250, 100, 100); // Зеленый свет
            }
        };
        lightPanel.setPreferredSize(new Dimension(200, 450));
        frame.add(lightPanel, BorderLayout.CENTER);

        // Кнопка управления
        controlButton = new JButton("Начать/Остановить");
        controlButton.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(controlButton, BorderLayout.SOUTH);
    }

    // Метод для обновления состояния светофора
    public void setTrafficLightState(String state) {
        switch (state) {
            case "RED":
                redLight = Color.RED;
                yellowLight = Color.DARK_GRAY;
                greenLight = Color.DARK_GRAY;
                break;
            case "YELLOW":
                redLight = Color.DARK_GRAY;
                yellowLight = Color.YELLOW;
                greenLight = Color.DARK_GRAY;
                break;
            case "GREEN":
                redLight = Color.DARK_GRAY;
                yellowLight = Color.DARK_GRAY;
                greenLight = Color.GREEN;
                break;
        }
        lightPanel.repaint(); // Перерисовать светофор
    }

    // Метод для добавления обработчика события для кнопки
    public void addControlButtonListener(ActionListener listener) {
        controlButton.addActionListener(listener);
    }

    public void show() {
        frame.setVisible(true);
    }
}