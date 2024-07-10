create table CLIENTE(
  ID int not null AUTO_INCREMENT,
  NOMBRE varchar(100) not null,
  APELLIDO varchar(100) not null,
  EDAD int not null,
  FECHA_NACIMIENTO varchar(100) not null,
  PRIMARY KEY ( ID )
);

INSERT INTO cliente (nombre,apellido,edad,fecha_nacimiento) VALUES ('Reinaldo','Vargas',32,'26-08-1991');
INSERT INTO cliente (nombre,apellido,edad,fecha_nacimiento) VALUES ('Jennifer','Morillo',20,'26-08-2004');
INSERT INTO cliente (nombre,apellido,edad,fecha_nacimiento) VALUES ('Jack','Sparrow',18,'26-08-2006');
INSERT INTO cliente (nombre,apellido,edad,fecha_nacimiento) VALUES ('Tomy','Oliver',45,'26-08-1979');
INSERT INTO cliente (nombre,apellido,edad,fecha_nacimiento) VALUES ('Jason','Fernandez',65,'26-08-1959');
INSERT INTO cliente (nombre,apellido,edad,fecha_nacimiento) VALUES ('Michael','Miller',36,'26-08-1988');
INSERT INTO cliente (nombre,apellido,edad,fecha_nacimiento) VALUES ('Fredy','Gutierrez',54,'26-08-1970');
INSERT INTO cliente (nombre,apellido,edad,fecha_nacimiento) VALUES ('Andrea','Quiteros',48,'26-08-1976');