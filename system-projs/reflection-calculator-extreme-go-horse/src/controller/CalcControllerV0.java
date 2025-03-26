package controller;

import java.math.BigDecimal;

import controller.dto.Request;
import models.calcs.BigDecimalCalculator;

public class CalcControllerV0 {

    BigDecimalCalculator calculator = new BigDecimalCalculator();

    public BigDecimal calculate(Request request) {
        return calculator.calculate(request).getResult();
    }

}
