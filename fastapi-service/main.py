from fastapi import FastAPI
from fastapi.responses import JSONResponse

app = FastAPI(root_path="/python-service")

@app.get("/hello")
def read_root():
    return JSONResponse(content={"message": "Hello from FastAPI service!"})