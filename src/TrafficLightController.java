import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightController {
    private TrafficLightModel model;
    private TrafficLightView view;
    private Timer timer; // Таймер для изменения состояния светофора

    public TrafficLightController(TrafficLightModel model, TrafficLightView view) {
        this.model = model;
        this.view = view;
        this.view.show();

        // Таймер, который будет переключать состояние светофора
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int duration = model.getDurationForCurrentState();
                if (duration == 0) return;

                model.nextState();
                view.setTrafficLightState(model.getCurrentState());
                timer.setDelay(duration * 1000); // меняем задержку в зависимости от состояния
            }
        });
    }

    public void startSimulation() {
        timer.start();
    }

    public void stopSimulation() {
        timer.stop();
    }

    public void toggleSimulation() {
        if (timer.isRunning()) {
            stopSimulation();
        } else {
            startSimulation();
        }
    }
}