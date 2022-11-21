CREATE DATABASE contodb


CREATE TABLE users(

    userID INTEGER PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)


)

CREATE TABLE operations (

    operationID INTEGER PRIMARY KEY,
    contoID INTEGER,
    ammontare FLOAT,
    Foreign Key (contoid) REFERENCES conti(contoid)

)


CREATE TABLE conti(

    contoid INTEGER PRIMARY KEY,
    userid INTEGER,
    saldo FLOAT,
    Foreign Key (userid) REFERENCES users(userid)


)