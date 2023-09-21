DROP DATABASE IF EXISTS hotelDB;
CREATE DATABASE hotelDB;
USE hotelDB;

CREATE TABLE IF NOT EXISTS reservas (
    id INT NOT NULL AUTO_INCREMENT,
    fecha_entrada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    forma_pago VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS huespedes (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    nacionalidad VARCHAR(255) NOT NULL,
    telefono VARCHAR(255) NOT NULL,
    id_reserva INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_reserva) REFERENCES reservas(id)
);

CREATE TABLE IF NOT EXISTS usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    nombre_usuario VARCHAR(255) NOT NULL UNIQUE,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);


-- Usuario por defecto
INSERT INTO usuarios (nombre_usuario, nombre, apellido, email, password)
VALUES ('admin', 'admin', 'admin', 'admin@gmail.com', 'admin');