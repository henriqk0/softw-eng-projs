package view;

import java.util.Scanner;

import model.datatransfer.Inputs;
import model.exception.InvalidOperationException;

public class Menu {
    public void show() {
        System.out.println("Escolha uma opcao:\n1 - Adicao\n2 - Subtracao\n3 - Multiplicacao\n4 - Divisao\n5 - Exponenciação");
    }

    public Inputs receiveEntry() throws InvalidOperationException{
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();


        if (option < 1 && option > 5) throw new InvalidOperationException();

        System.out.println("1º operador: ");
        float value1 = scanner.nextFloat();
        System.out.println("2º operador: ");
        float value2 = scanner.nextFloat();
        return new Inputs(option, value1, value2);
    }
    
}
