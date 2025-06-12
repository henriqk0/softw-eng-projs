package composite;

public class App {

    public static void main(String[] args) {

        IMenuComponent megamenu = new Menu();   
        
        megamenu.Add(new MenuItem("batata", 4));
        megamenu.Add(new MenuItem("peixe", 20));

        megamenu.Display();
    }
}
