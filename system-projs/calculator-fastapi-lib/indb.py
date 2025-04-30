from CalculatorData import RequestData
from pydantic import BaseModel
import json

# "./data/calculation-datas.json"
class JsonDB(BaseModel): 
    path: str

    def read(self):
        f = open(self.path)
        data = json.load(f)
        f.close()
        return data
    
    def insert(self, calculator_data: RequestData):
        data = self.read()
        data['calculator-datas'].append(calculator_data.model_dump())
        f = open(self.path, 'w')
        f.write(json.dumps(data))
        f.close()

