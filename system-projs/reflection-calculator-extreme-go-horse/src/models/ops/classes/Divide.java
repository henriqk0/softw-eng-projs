package models.ops.classes;

import java.math.BigDecimal;

import models.exception.DivisionByZeroException;
import models.exception.IndeterminationException;
import models.ops.interfaces.IOperation;


public class Divide implements IOperation {
    @Override
    public BigDecimal operate(BigDecimal value1, BigDecimal value2) throws ArithmeticException {
        if (value1.intValue() == 0 && value2.intValue() == 0) throw new IndeterminationException();
        else if (value2.intValue() == 0) throw new DivisionByZeroException();
        else return value1.divide(value2);
    }
}
