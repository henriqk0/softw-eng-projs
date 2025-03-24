package model.operation;

public class Operation implements Cloneable, IOperation{
    private IOperation ops;

    @Override
    public float operate(float value1, float value2) throws ArithmeticException {
        return this.ops.operate(value1, value2);
    }
    
    public void setOps(IOperation operation) {
        this.ops = operation;
    }
    
    public IOperation getOps() {
        return ops;
    }

    @Override
    public Operation clone() throws CloneNotSupportedException {
        return (Operation)super.clone();
    }

}
