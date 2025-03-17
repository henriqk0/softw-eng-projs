package model.calculator;

import javax.management.OperationsException;

import model.datatransfer.Outputs;
import model.datatransfer.Inputs;
import model.exception.DivisionByZeroException;
import model.exception.InvalidOperationException;
import model.factories.OperationFactory;
import model.operation.IOperation;

public class SimpleCalculator {
     
    public Outputs calculate(Inputs inputs) throws InvalidOperationException, DivisionByZeroException {
        IOperation operation = OperationFactory.factory(inputs.getOption());

        
    }
    
}
