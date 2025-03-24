public class Divide implements IOperation {
    @Override
    public float operate(float value1, float value2) throws ArithmeticException {
        if (value1 == 0 && value2 == 0) throw new IndeterminationException();
        else if (value2 == 0) throw new DivisionByZeroException();
        else return value1 / value2;
    }
}
