package model.factories;
// import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import model.exception.InvalidOperationException;
// import java.lang.reflect.Method;
import model.operation.IOperation;
import model.operation.Operation;

public class OperationFactory {
    private static OperationFactory instance;
    private static Operation operation;

    private OperationFactory() {}

    public static OperationFactory getInstance() {
        if (OperationFactory.instance == null) {
            OperationFactory.instance = new OperationFactory();
        }
        return instance;
    }

    public static IOperation factory(int operationType) throws InvalidOperationException {
        Object instantiatedClass = null;
        try {
             if (operation == null) {
                operation = new Operation();
            }

            OperationFactory o = OperationFactory.getInstance();
            String rootOperationType = "model.operation." + o.getOperationType(operationType);
            instantiatedClass = (IOperation)Class.forName(rootOperationType).getDeclaredConstructor().newInstance();
            
            o.operation.setOps((IOperation)instantiatedClass);
            return o.operation.getOps();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public String getOperationType(int option) throws InvalidOperationException{
        if (option == 1) return "Add";
        if (option == 2) return "Subtract";
        if (option == 3) return "Multiply";
        if (option == 4) return "Divide";
        if (option == 5) return "Exponentiation";
        throw new InvalidOperationException();
    }
}


