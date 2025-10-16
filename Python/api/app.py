from flask import Flask, jsonify, request
import db

app = Flask(__name__)


@app.route('/', methods=['GET'])
def hello_world():
    info = {'msg': 'hello world'}# put application's code here
    return info

@app.route('/carros', methods=['GET'])
def findAll():
    return db.carros

@app.route('/carros/<int:id>', methods=['GET'])
def findById(id:int):
    for carro in db.carros:
        if carro['id'] == id:
            return carro, 200
    info = {'title': 'nenhum carro encontrado', 'status': 404}
    return info, 404

@app.route('/carros', methods=['POST'])
def save():
    info = request.json
    db.carros.append(info)
    return info, 201

@app.route('/carros/<int:id>', methods=['PUT'])
def update(id:int):
    info = request.json
    i = 0
    while i < len(db.carros):
        carro = db.carros[i]
        if carro['id'] == info['id']:
            db.carros[i] = info
            return info, 200
        i += 1
    error = {'status': 400, 'title': 'erro na hora de substituir o carro no arquivo original'}
    return error, 400



app.run(debug=True)
