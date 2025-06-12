public class App {
    
    public static void main(String[] args) {
        Shape abc = new Square();

        abc.setColor(new BlueColor());
        abc.color.ApplyColor();

        abc = new Circle();
        abc.setColor(new RedColor());
        abc.color.ApplyColor();
    }
}
