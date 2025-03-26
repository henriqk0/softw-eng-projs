package view;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;
import models.exception.InvalidOperationException;
import controller.dto.Request;


public class MenuV0 {
    public void show() {
        // att to builds this auto
        System.out.println("Escolha uma opcao:\n1 - Adicao\n2 - Subtracao\n3 - Multiplicacao\n4 - Divisao");
    }

    public Request newEntry(){ 
        int option;
        BigDecimal value1, value2;

        option = MenuV0.readOption();
        System.out.println("1º operator: ");
        value1 = MenuV0.readBigDecimal();
        System.out.println("2º operator: ");
        value2 = MenuV0.readBigDecimal();
        
        return new Request(option, value1, value2);
    }

    public static BigDecimal readBigDecimal() {
        Scanner scanner = new Scanner(System.in);

        BigDecimal value; 
        while (true) {
            try {
                value = scanner.nextBigDecimal();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid value. Try again:");
                value = scanner.nextBigDecimal();
            }
        }
        scanner.close();
        return value;
    }

    public static int readOption() {
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while (true) {
            try {
                option = scanner.nextInt();
                if (option > 4 || option < 1) throw new InvalidOperationException();
                break;
            }
            catch(InvalidOperationException | InputMismatchException e){
                System.out.println("Invalid option. Try again:");
                option = scanner.nextInt();
            }
        }
        scanner.close();
        return option;
    }
}

