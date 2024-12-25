import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightController {
    private TrafficLightModel model;
    private TrafficLightView view;
    private final Timer timer;

    public TrafficLightController(TrafficLightModel model, TrafficLightView view) {
        this.model = model;
        this.view = view;
        this.view.show();

        // Таймер для переключения состояния светофора
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.nextState();
                view.setTrafficLightState(model.getCurrentState());
                timer.setDelay(model.getDurationForCurrentState() * 1000); // Обновить интервал
            }
        });

        // Добавление обработчика для кнопки
        view.addControlButtonListener(e -> toggleSimulation());
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