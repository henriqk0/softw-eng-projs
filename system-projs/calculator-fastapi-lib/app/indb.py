from .models import RecordData
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
    
    def insert(self, calculator_data: RecordData):
        data = self.read()
        if 'calculator-datas' not in data:
            data['calculator-datas'] = []
        data['calculator-datas'].append(calculator_data.model_dump())
        f = open(self.path, 'w')
        f.write(json.dumps(data))
        f.close()

