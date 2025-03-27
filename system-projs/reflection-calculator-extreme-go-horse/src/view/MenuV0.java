package view;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import application.FileLister;
import models.exception.InvalidOperationException;
import controller.dto.Request;


public class MenuV0 {
    static Scanner scanner = new Scanner(System.in);

    static String dir = "system-projs"+ File.separator +"reflection-calculator-extreme-go-horse" + File.separator + "src" + File.separator + "models" + File.separator + "ops" + File.separator + "classes";
    static FileLister fl = new FileLister();
    static ArrayList<String> operations = fl.loadOperations(dir);

    public void show() {
        System.out.println("Choose an option:");
        for (String op : operations) {
            System.out.println(op);
        }
    }

    public Request newEntry(){ 
        String option;
        BigDecimal value1, value2;

        option = MenuV0.readOption();
        System.out.println("1º operator: ");
        value1 = MenuV0.readBigDecimal();
        System.out.println("2º operator: ");
        value2 = MenuV0.readBigDecimal();
        
        scanner.close();
        return new Request(option, value1, value2);
    }

    public static BigDecimal readBigDecimal() {
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
        return value;
    }

    public static String readOption() {
        String option;
        while (true) {
            try {
                option = scanner.nextLine();
                for (String operation : operations) {
                    if (option.equalsIgnoreCase(operation)) {
                        option = operation;
                        return option;
                    }
                }
                throw new InvalidOperationException();
            }
            catch(NoSuchElementException | InvalidOperationException | IllegalStateException e){
                System.out.println("Invalid option. Try again:");
            }
        }
    }
}

