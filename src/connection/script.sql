CREATE DATABASE IF NOT EXISTS estacionamento;
USE estacionamento;

CREATE TABLE vaga (
    idVaga  int NOT NULL AUTO_INCREMENT,
    numero  int NOT NULL,
    rua     varchar(100) NOT NULL,
    obliqua boolean NOT NULL,
    PRIMARY KEY (idVaga));



CREATE TABLE motorista (
    idMotorista  int NOT NULL AUTO_INCREMENT,
    nome  varchar(100) NOT NULL,
    genero     varchar(100) NOT NULL,
    RG int(20) NOT NULL,
    CPF int(11) NOT NULL,
    numero int(20) NOT NULL,
    email varchar(100) NOT NULL,
    senha varchar(100) NOT NULL,
    PRIMARY KEY (idMotorista));