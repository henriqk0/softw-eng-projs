package model.factories;
// import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import model.exception.InvalidOperationException;
// import java.lang.reflect.Method;
import model.operation.IOperation;

public class OperationFactory {
    public static IOperation factory(String operationType) {
        Object instantiatedClass = null;
        try {
            String rootOperationType = "models." + operationType;
            instantiatedClass = Class.forName(rootOperationType).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return (IOperation) instantiatedClass;
    }
    public String getOperationType(int option) throws InvalidOperationException{
        if (option == 1) return "Add";
        if (option == 2) return "Subtract";
        if (option == 3) return "Multiply";
        if (option == 4) return "Divide";
        throw new InvalidOperationException();
    }
}


