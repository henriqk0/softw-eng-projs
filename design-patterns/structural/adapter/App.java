public class App {

    public static void main(String[] args) {
        // using interface to call the proper Adapter methods inside the implemented method
        ITemperatureSensor exAdaptPolimorfism = new SensorAAdapter(5.5);
        System.out.println(exAdaptPolimorfism.ReadTemperature());
        exAdaptPolimorfism = new SensorBAdapter(30.23);
        System.out.println(exAdaptPolimorfism.ReadTemperature());
        exAdaptPolimorfism = new SensorCAdapter(100);
        System.out.println(exAdaptPolimorfism.ReadTemperature());
    }
}
