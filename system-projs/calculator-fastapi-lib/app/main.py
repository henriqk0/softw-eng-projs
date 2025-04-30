from models import RequestData, ResponseData
from indb import JsonDB
from fastapi import FastAPI, HTTPException
from calculator_lib import sum_to_api, subtract_to_api, multiply_to_api, division_to_api, sqrt_to_api, pow_to_api

app = FastAPI()

calculatorDataDB = JsonDB(path='./data/calculation-datas.json')

@app.get("/")
async def get_operations():
    calculator_datas = calculatorDataDB.read()
    return calculator_datas

@app.post("/create-data-calculator")
async def post_operations(calculator_data: RequestData):
    calculatorDataDB.insert(calculator_data)

    print("new operation", calculator_data)

    return {"status": "inserted"}

@app.get("/list-results")
async def get_results():
    calculator_datas = calculatorDataDB.read()

    results = []

    for entry in calculator_datas['calculator-datas']:
        op_label = ''
        value1 = entry['value1']
        value2 = entry['value2']
        result = 0
    
    return {"results": results}


@app.post("/add", response_model=RequestData, summary="Adição", description="Soma dois números.")
def add_numbers(request: RequestData): 
    """
    sum 2 numbers from request
    """
    result = sum_to_api(request.value1, request.value2);
    return ResponseData(result=result)


@app.post("/subtract", response_model=RequestData, summary="Subtração", description="Subtrai' dois números.")
def subtract_numbers(request: RequestData): 
    """
    subtract 2 numbers from request
    """
    result = subtract_to_api(request.value1, request.value2);
    return ResponseData(result=result)


@app.post("/divide", response_model=RequestData, summary="Divisão", description="Divide dois números.")
def divide_numbers(request: RequestData): 
    """
    divide 2 numbers from request
    """
    try:
        result = divide_to_api(request.value1, request.value2);
        return ResponseData(result=result)
    except ValueError as E:
        raise HTTPException(status_code=400, detail=str(E))
