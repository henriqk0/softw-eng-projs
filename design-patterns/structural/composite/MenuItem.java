package composite;

public class MenuItem implements IMenuComponent{
    public String name;
    public double value;

    public MenuItem(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public void Display(){ 
        System.out.println(this.name + " -- R$" + value);
    }

    public void Add(IMenuComponent a){}
}
