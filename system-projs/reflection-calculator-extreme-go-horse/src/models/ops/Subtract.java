package models.ops;

import java.math.BigDecimal;

public class Subtract implements IOperation {
    @Override
    public BigDecimal operate(BigDecimal value1, BigDecimal value2) throws ArithmeticException {
        return value1.subtract(value2);
    }
}
