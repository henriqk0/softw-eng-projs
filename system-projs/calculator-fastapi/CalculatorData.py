from pydantic import BaseModel


class CalculatorData(BaseModel):
    value1: float
    value2: float
    operator: str