public class SensorAAdapter implements ITemperatureSensor{
    public double temperature;
    
    public double ReadTemperature() {
        return GetTemperaturaCelsius();
    }

    public double GetTemperaturaCelsius(){
        return this.temperature;
    }

    public SensorAAdapter(double temperature) {
        this.temperature = temperature;
    }
}