package controller.dto;

import java.math.BigDecimal;

import models.exception.InvalidOperationException;

public class Request {
    String option;
    BigDecimal firstOperator, secondOperator;

    public Request(String option, BigDecimal firstOperator, BigDecimal secondOperator) {
        this.option = option;
        this.firstOperator = firstOperator;
        this.secondOperator = secondOperator;
    }
    public String getOption() {
        return this.option ;
    }
    public void setOption(String option) {
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
}
