public class SensorCAdapter implements ITemperatureSensor{
    public double temperature;

    public double ReadTemperature() { return FetchTempC();}

    public double FetchTempC() {return this.temperature;}

    public SensorCAdapter(double temperature) {
        this.temperature = temperature;
    }
}