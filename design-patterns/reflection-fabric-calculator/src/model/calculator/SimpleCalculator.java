package model.calculator;

import javax.management.OperationsException;

import model.datatransfer.Outputs;
import model.datatransfer.Inputs;
import model.exception.DivisionByZeroException;
import model.exception.IndeterminationException;
import model.exception.InvalidOperationException;
import model.factories.OperationFactory;
import model.operation.IOperation;

public class SimpleCalculator {
     
    public Outputs calculate(Inputs inputs) throws  InvalidOperationException, 
                                                    IndeterminationException ,
                                                    DivisionByZeroException {
        IOperation operation = OperationFactory.factory(inputs.getOption());
        operation.operate(inputs.getValue1(), inputs.getValue2());

        Outputs result = new Outputs();
        result.setResult(operation.operate(inputs.getValue1(), inputs.getValue2()));

        return result;
    }
    
}
