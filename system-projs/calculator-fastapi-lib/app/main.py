from .models import RequestData, ResponseData, RecordData
from .indb import JsonDB
from fastapi import FastAPI, HTTPException
from calculator_lib import sum_to_api, subtract_to_api, multiply_to_api, divide_to_api, sqrt_to_api, pow_to_api

app = FastAPI()

calculatorDataDB = JsonDB(path='./data/calculation-datas.json')

@app.get("/")
async def get_operations():
    calculator_datas = calculatorDataDB.read()
    return calculator_datas

@app.get("/list-results")
async def get_results():
    calculator_datas = calculatorDataDB.read()

    results = []

    if len(calculator_datas['calculator-datas']) > 0:
        for entry in calculator_datas['calculator-datas']:
            value1, value2 = entry['inputs']['value1'], entry['inputs']['value2']
            operation = entry['operation']
            result = entry['output']['result']

            if operation != '√':
                label_entry = f"{value1} {operation} {value2} = {result}"
            else:
                label_entry = f"{value1} ^ (1/{value2}) = {result}"

            results.append(label_entry)
    
    return {"results": results}


@app.post("/add", response_model=ResponseData, summary="Adição", description="Soma dois números.")
def add_numbers(request: RequestData): 
    """
    sum 2 numbers from request
    """
    result = sum_to_api(request.value1, request.value2);

    calculatorDataDB.insert(RecordData(inputs=request, output=(ResponseData(result=result)), operation="+"))
    return ResponseData(result=result)


@app.post("/subtract", response_model=ResponseData, summary="Subtração", description="Subtrai' dois números.")
def subtract_numbers(request: RequestData): 
    """
    subtract 2 numbers from request
    """
    result = subtract_to_api(request.value1, request.value2);

    calculatorDataDB.insert(RecordData(inputs=request, output=(ResponseData(result=result)), operation="-"))
    return ResponseData(result=result)


@app.post("/divide", response_model=ResponseData, summary="Divisão", description="Divide dois números.")
def divide_numbers(request: RequestData): 
    """
    divide 2 numbers from request
    """
    try:
        result = divide_to_api(request.value1, request.value2);
        calculatorDataDB.insert(RecordData(inputs=request, output=(ResponseData(result=result)), operation="/"))
        return ResponseData(result=result)
    except ValueError as E:
        raise HTTPException(status_code=400, detail=str(E))


@app.post("/multiply", response_model=ResponseData, summary="Multiplicação", description="Multiplica dois números.")
def multiply_numbers(request: RequestData): 
    """
    multiply 2 numbers from request
    """
    try:
        result = multiply_to_api(request.value1, request.value2);
        calculatorDataDB.insert(RecordData(inputs=request, output=(ResponseData(result=result)), operation="*"))
        return ResponseData(result=result)
    except ValueError as E:
        raise HTTPException(status_code=400, detail=str(E))


@app.post("/pow", response_model=ResponseData, summary="Exponenciação", description="Eleva um numero a outro como índice.")
def pow_numbers(request: RequestData): 
    """
    pow between 2 numbers from request 
    """
    try:
        result = pow_to_api(request.value1, request.value2);
        calculatorDataDB.insert(RecordData(inputs=request, output=(ResponseData(result=result)), operation="^"))
        return ResponseData(result=result)
    except ValueError as E:
        raise HTTPException(status_code=400, detail=str(E))


@app.post("/root", response_model=ResponseData, summary="Radiciação", description="Realiza a raiz de numero com outro como índice.")
def sqrt_numbers(request: RequestData): 
    """
    root between 2 numbers from request 
    """
    try:
        result = sqrt_to_api(request.value1, request.value2);
        calculatorDataDB.insert(RecordData(inputs=request, output=(ResponseData(result=result)), operation="√"))
        return ResponseData(result=result)
    except ValueError as E:
        raise HTTPException(status_code=400, detail=str(E))


