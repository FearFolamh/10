
public class TrafficLightApp {
    public static void main(String[] args) {
        TrafficLightModel model = new TrafficLightModel(5, 2, 3);
        TrafficLightView view = new TrafficLightView();
        TrafficLightController controller = new TrafficLightController(model, view);
    }
}