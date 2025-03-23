package controller;

import model.calculator.SimpleCalculator;
import model.datatransfer.Inputs;

public class CalcController {
    public SimpleCalculator calculator = new SimpleCalculator();
    
    public String putResult(Inputs in) {
        return "" + calculator.calculate(in).getResult();
    }
}
