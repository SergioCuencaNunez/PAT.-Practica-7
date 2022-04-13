DROP TABLE IF EXISTS TABLA_REGISTRO;

CREATE TABLE TABLA_REGISTRO (
    NIF VARCHAR(9) PRIMARY KEY,
    NOMBRE VARCHAR(255) NOT NULL,
    APELLIDO1 VARCHAR(255) NOT NULL,
    APELLIDO2 VARCHAR(255) NOT NULL,
    CORREO VARCHAR(255) NOT NULL,
    CUMPLEANOS DATE NOT NULL
);