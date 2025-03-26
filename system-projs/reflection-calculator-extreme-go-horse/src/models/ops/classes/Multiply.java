package models.ops.classes;

import java.math.BigDecimal;

import models.ops.interfaces.IOperation;

public class Multiply implements IOperation{
    @Override
    public BigDecimal operate(BigDecimal value1, BigDecimal value2) throws ArithmeticException {
        return value1.multiply(value2);
    }
}
