package composite;

import java.util.ArrayList;

public class Menu implements IMenuComponent{
    public ArrayList<IMenuComponent> items;

    public void Display() {
        for (IMenuComponent comp : this.items) {
            comp.Display();
        }
    }
    public void Add(IMenuComponent comp) {
        this.items.add(comp);
    }
}
