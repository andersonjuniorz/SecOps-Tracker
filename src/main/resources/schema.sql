CREATE DATABASE IF NOT EXISTS secopstracker_db;

create table IF NOT EXISTS tb_viatura(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    placa VARCHAR(255) NOT NULL
);