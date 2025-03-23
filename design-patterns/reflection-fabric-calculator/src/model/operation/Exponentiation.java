package model.operation;

import model.exception.IndeterminationException;

public class Exponentiation implements IOperation{
    @Override
    public float operate(float value1, float value2) throws ArithmeticException {
        if (value1 == 0 && value2 == 0) throw new IndeterminationException();
        float result = 1;
        for (int i = 0; i < value2; i++) {
            result = result * value1;
        }
        return result;
    }
}
