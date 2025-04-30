from CalculatorData import RequestData, ResponseData
from indb import JsonDB
from fastapi import FastAPI

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

        match entry['operator'].lower():
            case 'sum' | 'soma':
                op_label = '+' 
                result = value1 + value2 
            case 'subtract' | 'subtração':
                op_label = '-' 
                result = value1 - value2
            case 'multiply' | 'multiplicação':
                op_label = '*' 
                result = value1 * value2
            case 'divide' | 'divisão':
                op_label = '/' 
                if value2 == 0 and value1 == 0:
                    result = "Error. 0/0 results in a indetermination."
                elif value2 == 0:
                    result = "Error. Its not possible divide by 0."
                else: 
                    result = value1 / value2
            case _:
                op_label = "?"
                result = "Error. Unknown operator"

        print(f"{value1} {op_label} {value2} = {result}")
        results.append({"operation": entry, "result": result} )
    
    return {"results": results}

