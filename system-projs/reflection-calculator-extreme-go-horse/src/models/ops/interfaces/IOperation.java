package models.ops.interfaces;

import java.math.BigDecimal;

public interface IOperation {
    public BigDecimal operate(BigDecimal value1, BigDecimal value2) throws ArithmeticException;
}
