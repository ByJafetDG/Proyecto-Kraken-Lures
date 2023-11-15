CREATE SCHEMA proyecto_progra4;

use proyecto_progra4;

-- Crear la tabla de Clientes
CREATE TABLE CLIENTE (
    CLIENTE_ID INT AUTO_INCREMENT PRIMARY KEY,
    TIPO_IDENTIFICACION INT,-- 1=CEDULA FISICA, 2=DIMEX, 3=PASAPORTE
    IDENTIFICACION VARCHAR(50),
    NOMBRE VARCHAR(255),
    APELLIDO_1 VARCHAR(255),
    APELLIDO_2 VARCHAR(255),
    PROVINCIA VARCHAR(50),
    CANTON VARCHAR(50),
    DISTRITO VARCHAR(50),
    DIRECCION_DETALLE TEXT,
    CORREO_ELECTRONICO VARCHAR(255),
    TELEFONO VARCHAR(20)
);
-- Inserta un cliente default para el uso de la tabla usuario
INSERT INTO CLIENTE(TIPO_IDENTIFICACION,IDENTIFICACION,NOMBRE)
VALUES(1,"0","CLIENTE DEFAULT");

-- Crear la tabla de proyecto_progra4.producto
CREATE TABLE PRODUCTO (
    PRODUCTO_ID INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(255),
    DESCRIPCION TEXT,
    PRECIO FLOAT,
    CANTIDAD_EN_STOCK INT,
    SKU VARCHAR(50),
    IMAGEN TEXT,
    FECHA_INCLUSION date,
    CATEGORIA VARCHAR(255),
    VECES_COMPRADO INT,
    ES_TENDENCIA boolean,
    IMPUESTO FLOAT
);

-- Crear la tabla de Usuarios que incluye las columnas de Clientes
CREATE TABLE USUARIO (
    USUARIO_ID INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(255),
    APELLIDO_1 VARCHAR(255),
    APELLIDO_2 VARCHAR(255),
    CORREO_ELECTRONICO VARCHAR(255),
    TELEFONO VARCHAR(20),
    CONTRASEÑA VARCHAR(255) NOT NULL,
    CLIENTE_ID INT DEFAULT 1,
    FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(CLIENTE_ID)
);


-- Tabla pedido

CREATE TABLE PEDIDO (
	PEDIDO_ID INT AUTO_INCREMENT PRIMARY KEY,
    CLIENTE_ID INT,
    FECHA DATE,
    ESTADO VARCHAR(1), -- R=RECIBIDO, A=APROBADO, C=COMPLETADO
    ENVIADO BOOLEAN,
    SUBTOTAL FLOAT,
    IMPUESTO FLOAT,
    TOTAL FLOAT,
    FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(CLIENTE_ID)
);

-- Tabla pedido linea

CREATE TABLE PEDIDO_LINEA (
	PEDIDO_ID INT PRIMARY KEY,
    LINEA INT,
    PRODUCTO_ID INT,
    CANTIDAD INT,
    SUBTOTAL FLOAT,
    IMPUESTO FLOAT,
    TOTAL FLOAT,
    FOREIGN KEY (PEDIDO_ID) REFERENCES PEDIDO(PEDIDO_ID),
    FOREIGN KEY (PRODUCTO_ID) REFERENCES PRODUCTO(PRODUCTO_ID)
);


-- -------------------------------Inserts------------------------------------------- --


-- FALTA LA COLUMNA IMAGEN EN CADA INSERT --

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Venator GS', 'Carrete de BaitCasting Venator GS de Marine, para agua dulce', 72000, 100, 'SKU001', CURDATE(), 'Carretes BaitCasting', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Evolution', 'Caña BaitCasting Evolution de Marine', 32000, 100, 'SKU002', CURDATE(), 'Cañas BaitCasting', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Versus 12000', 'Carrete de BaitCasting Versus 12000 de Marine', 47000, 100, 'SKU003', CURDATE(), 'Carretes BaitCasting', 0, 0, 0.13);


-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Penn Persuit IV 4000', 'Caña Spinning Penn Persuit IV 4000 para agua salada, 7" pies, 10-30LB', 72000, 100, 'SKU004', CURDATE(), 'Cañas Spinning', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Fingerling 110mm', 'Señuelo Fingerling 110mm de Yo-Zuri', 9000, 100, 'SKU005', CURDATE(), 'Señuelos', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Hammer 100', 'Señuelo Hammer 100, de Marine', 5400, 100, 'SKU006', CURDATE(), 'Señuelos', 0, 0, 0.13);


-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Camisa manga corta', 'Camisa de manga corta, Tallas: S, M, XL', 5000, 100, 'SKU007', CURDATE(), 'Camisas', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Guantes Glacer Glover', 'Guantes de pesca, de Glacer Glover', 14400, 100, 'SKU008', CURDATE(), 'Guantes', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Bichero', 'Bichero South Bend', 10000, 100, 'SKU009', CURDATE(), 'Bicheros', 0, 0, 0.13);


-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Leader Vexter', 'Lider Leader Vexter, 44-33LB, de Marine', 14000, 100, 'SKU010', CURDATE(), 'Lideres', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('BG 5000', 'Carrete Spinning BG 5000 de Daiwa', 96000, 100, 'SKU011', CURDATE(), 'Carretes Spinning', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Versus 500', 'Carrete Spinning Versus 500 económico de Marine', 17500, 100, 'SKU012', CURDATE(), 'Carretes Spinning', 0, 0, 0.13);


-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Sun Bandit', 'Buff Sun Bandit Pro Series de Flying Fisherman', 13200, 100, 'SKU013', CURDATE(), 'Buffs', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Colas', 'Colas de Marine', 4800, 100, 'SKU014', CURDATE(), 'Colas', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Caja para anzuelos y plomadas', 'Caja para anzuelos y plomadas, Tamaño: 10x7cm de Marine', 2000, 100, 'SKU015', CURDATE(), 'Cajas', 0, 0, 0.13);


-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Alicate Noeby 178mm', 'Alicate Noeby 178mm de Noeby', 18000, 100, 'SKU016', CURDATE(), 'Alicates', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Gorras Regalarte', 'Gorras Regalarte', 9500, 100, 'SKU017', CURDATE(), 'Gorras', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Cuerda YGR X8', 'Cuerda YGR X8, de POWER STRONG', 12000, 100, 'SKU018', CURDATE(), 'Cuerdas', 0, 0, 0.13);


-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Bolso Plano grande', 'Bolso Plano grande, incluye caja grande, de Plano', 36000, 100, 'SKU019', CURDATE(), 'Bolsos', 0, 0, 0.13);

-- Insertar un nuevo proyecto_progra4.producto en la tabla de proyecto_progra4.producto
INSERT INTO proyecto_progra4.producto (NOMBRE, DESCRIPCION, Precio, CANTIDAD_EN_STOCK, SKU, FECHA_INCLUSION, CATEGORIA, VECES_COMPRADO, ES_TENDENCIA, IMPUESTO)
VALUES ('Lentes de pesca polarizados', 'Lentes de pesca polarizados, de Flying Fisherman', 20000, 100, 'SKU020', CURDATE(), 'Lentes', 0, 0, 0.13);



