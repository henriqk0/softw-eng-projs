package view;

import java.math.BigDecimal;
import java.util.Scanner;
import models.exception.InvalidOperationException;
import controller.dto.Request;


public class MenuV0 {

    public void show() {
        System.out.println("Escolha uma opcao:\n1 - Adicao\n2 - Subtracao\n3 - Multiplicacao\n4 - Divisao");
    }

    public Request newEntry() throws InvalidOperationException { 
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (option > 4 || option < 1) throw new InvalidOperationException();

        System.out.println("1º operador: ");
        BigDecimal value1 = scanner.nextBigDecimal();
        System.out.println("2º operador: ");
        BigDecimal value2 = scanner.nextBigDecimal();
        
        return new Request(option, value1, value2);
    }


}

