public class TrafficLightModel {
    private String currentState; // текущее состояние светофора
    private int redDuration;     // длительность красного света
    private int yellowDuration;  // длительность желтого света
    private int greenDuration;   // длительность зеленого света

    public TrafficLightModel(int redDuration, int yellowDuration, int greenDuration) {
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
        this.greenDuration = greenDuration;
        this.currentState = "RED"; // начальное состояние
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public void nextState() {
        switch (currentState) {
            case "RED":
                currentState = "GREEN";
                break;
            case "GREEN":
                currentState = "YELLOW";
                break;
            case "YELLOW":
                currentState = "RED";
                break;
        }
    }

    public int getDurationForCurrentState() {
        switch (currentState) {
            case "RED":
                return redDuration;
            case "YELLOW":
                return yellowDuration;
            case "GREEN":
                return greenDuration;
            default:
                return 0;
        }
    }
}