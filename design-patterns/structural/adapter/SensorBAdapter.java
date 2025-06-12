public class SensorBAdapter implements ITemperatureSensor{
    public double temperature;

    public double ReadTemperature() { return ObtenerTemperaturaEnCentigrados();}

    public SensorBAdapter(double temperature) {
        this.temperature = temperature;
    }

    public double ObtenerTemperaturaEnCentigrados() {return this.temperature;}
}