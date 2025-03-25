package controller.dto;

import java.math.BigDecimal;

import models.exception.InvalidOperationException;

public class Request {
    int option;
    BigDecimal firstOperator, secondOperator;

    public Request(int option, BigDecimal firstOperator, BigDecimal secondOperator) {
        this.option = option;
        this.firstOperator = firstOperator;
        this.secondOperator = secondOperator;
    }
    public int getOption() {
        return option;
    }
    public void setOption(int option) {
        this.option = option;
    }
    public BigDecimal getFirstOperator() {
        return firstOperator;
    }
    public void setFirstOperator(BigDecimal firstOperator) {
        this.firstOperator = firstOperator;
    }
    public BigDecimal getSecondOperator() {
        return secondOperator;
    }
    public void setSecondOperator(BigDecimal secondOperator) {
        this.secondOperator = secondOperator;
    }

    public String getOperationType(int option) throws InvalidOperationException{
        if (option == 1) return "Add";
        if (option == 2) return "Subtract";
        if (option == 3) return "Multiply";
        if (option == 4) return "Divide";
        throw new InvalidOperationException();
    }
}
