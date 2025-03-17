package model.operation;

import model.exception.DivisionByZeroException;

public class Divide implements IOperation {
    @Override
    public float operate(float value1, float value2) throws ArithmeticException {
        if (value2 == 0) throw new DivisionByZeroException();
        else return value1 / value2;
    }
}
