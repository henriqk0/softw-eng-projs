package application;


import controller.CalcControllerV0;
import models.exception.DivisionByZeroException;
import models.exception.IndeterminationException;
import view.MenuV0;


public class ApplicationPROJ {
    public static void main(String[] args) {
        MenuV0 menu = new MenuV0();
        menu.show();

        CalcControllerV0 calc = new CalcControllerV0();
        try {
            System.out.println(calc.calculate(menu.newEntry()));
        } catch (IndeterminationException e ){
            System.out.println("ERRO. O resultado da expressão é indeterminado " + e);
        }
        catch (DivisionByZeroException e){
            System.out.println("ERRO de divisão por 0 " + e);
        }
        catch ( RuntimeException e ) {
            System.out.println("ERRO de execução.");
            e.printStackTrace();
        }
    }
}
