from pydantic import BaseModel


class RequestData(BaseModel):
    value1: float
    value2: float


class ResponseData(BaseModel):
    result: float


class RecordData(BaseModel):
    inputs: RequestData
    output: ResponseData
    operation: str
