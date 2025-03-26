package models.ops.classes;

import java.math.BigDecimal;

import models.ops.interfaces.IOperation;

public class Add implements IOperation{
    @Override
    public BigDecimal operate(BigDecimal value1, BigDecimal value2) throws ArithmeticException {
        return value1.add(value2) ;
    }
}
