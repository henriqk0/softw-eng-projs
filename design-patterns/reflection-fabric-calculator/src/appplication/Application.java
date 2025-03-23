package appplication;

import controller.CalcController;
import model.calculator.SimpleCalculator;
import model.exception.DivisionByZeroException;
import model.exception.IndeterminationException;
import model.exception.InvalidOperationException;
import view.Menu;

public class Application {
    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            menu.show();

            CalcController calculator  = new CalcController();
            System.out.println(calculator.putResult(menu.receiveEntry()));
        } catch (IndeterminationException e){ 
            System.out.println("ERRO. A expressão com os operandos resulta em uma interminação matemática." + e.getMessage());
        } catch (DivisionByZeroException e) {
            System.out.println("ERRO. Não é possível dividir por 0: " + e.getMessage());
        } catch (InvalidOperationException e ) {
            System.out.println("ERRO. Operação solicitada inexistente: " + e.getMessage());
        } catch (Exception e){
            System.out.println("ERRO. Ocorreu um problema na execução: " + e.getMessage());
        }
    }
}