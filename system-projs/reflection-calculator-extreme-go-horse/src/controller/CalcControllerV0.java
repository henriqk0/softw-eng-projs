package controller;

import java.lang.reflect.InvocationTargetException;
import controller.dto.Request;
import controller.dto.Response;
import model.exception.InvalidOperationException;
import models.ops.IOperation;

public class CalcControllerV0 {

    public Response calculate(Request req) throws InvalidOperationException, ArithmeticException {
        Object instantiatedClass = null;
        try {
            String rootOperationType = "models.ops." + req.getOperationType(req.getOption());
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
