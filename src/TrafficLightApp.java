import javax.swing.*;
import java.awt.*;

public class TrafficLightApp {
    public static void main(String[] args) {
        TrafficLightModel model = new TrafficLightModel(5, 2, 3); // 5 секунд для красного, 2 для желтого, 3 для зеленого
        TrafficLightView view = new TrafficLightView();
        TrafficLightController controller = new TrafficLightController(model, view);

        // Настроим кнопку для управления симуляцией
        JButton startStopButton = new JButton("Начать/Остановить");
        startStopButton.setFont(new Font("Arial", Font.PLAIN, 16));
        startStopButton.addActionListener(e -> controller.toggleSimulation());

        // Добавим кнопку на экран
        view.frame.add(startStopButton, BorderLayout.SOUTH);
    }
}