DROP TABLE IF EXISTS HOTEL;
CREATE TABLE HOTEL (
    NOMBRE VARCHAR(255) PRIMARY KEY,
    DESTINO VARCHAR(255) NOT NULL,
    CAPACIDAD INTEGER NOT NULL,
    OCUPACION INTEGER NOT NULL,
    ESTADO BOOLEAN NOT NULL
);