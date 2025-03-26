package models.calcs;

import java.lang.reflect.InvocationTargetException;

import controller.dto.Request;
import controller.dto.Response;
import models.exception.InvalidOperationException;
import models.ops.interfaces.IOperation;


public class BigDecimalCalculator {
    
    public Response calculate(Request req) throws InvalidOperationException, ArithmeticException {
        Object instantiatedClass = null;
        try {
            String rootOperationType = "models.ops.classes." + req.getOperationType(req.getOption());
            instantiatedClass = Class.forName(rootOperationType).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        IOperation operation = (IOperation) instantiatedClass;
        
        Response r = new Response();
        r.setResult(operation.operate(req.getFirstOperator(), req.getSecondOperator()));
        return r;
    }
}
