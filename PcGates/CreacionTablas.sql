
CREATE TABLE Clientes (
	id varchar(20),
	nombre varchar(50),
	clave varchar(20),
	direccion varchar(50),
	email varchar(50),
	telefono varchar(15),
	PRIMARY KEY (id)
);


CREATE TABLE PCs (
	id SERIAL PRIMARY KEY 
);


CREATE TABLE Empleados (
	dni varchar(10),
	nombre varchar(50),
	clave varchar(20),
	direccion varchar(50),
	email varchar(50),
	telefono varchar(15),
	sueldo float CHECK (sueldo >= 0),
	asistente boolean,
	reparador boolean,
	jefe boolean,
	PRIMARY KEY (dni)
);

CREATE TABLE EjemplaresVenta (
	pc integer,
	nombre varchar(20),
	precio float CHECK (precio >=0),
	fechaCreacion date NOT NULL,
	cliente varchar(20) default NULL,
	empleado varchar(10) default NULL,
	fechaCompraPc date default NULL,
	PRIMARY KEY (pc),
	FOREIGN KEY (pc) REFERENCES PCs (id),
	FOREIGN KEY (cliente) REFERENCES Clientes(id),
	FOREIGN KEY (empleado) REFERENCES  Empleados(dni)
);


CREATE TABLE AReparar (
	pc integer,
	descripcion varchar(200) NOT NULL,
	cliente varchar(20) NOT NULL,
	fechaIngreso date NOT NULL,
	fechaRetirada date default NULL,
	empleadoIngreso varchar(10) NOT NULL,
	empleadoRetirada varchar(10) default NULL,
	PRIMARY KEY (pc),
	FOREIGN KEY (pc) REFERENCES PCs (id),
	FOREIGN KEY (cliente) REFERENCES Clientes(id),
	FOREIGN KEY (empleadoIngreso) REFERENCES  Empleados(dni),
	FOREIGN KEY (empleadoRetirada) REFERENCES  Empleados(dni)
);


CREATE TABLE Componentes (
	nombre varchar(50),
	marca varchar(20) NOT NULL,
	precio float CHECK (precio >= 0),
	descripcion varchar(100),
	PRIMARY KEY (nombre)
);


CREATE TABLE Reparar (
	pc integer,
	empleado varchar(10),
	componente varchar(50),
	fecha date,
	precio float CHECK (precio >= 0),
	PRIMARY KEY (fecha, empleado, componente, pc),
	FOREIGN KEY (empleado) REFERENCES Empleados (dni),
	FOREIGN KEY (componente) REFERENCES Componentes (nombre),
	FOREIGN KEY (pc) REFERENCES PCs (id)
);


CREATE TABLE EjemplaresComponente (
	id SERIAL NOT NULL,
	componente varchar(50) NOT NULL,
	cliente varchar(20) default NULL,
	empleado varchar(10) default NULL,
	fechaTiendaCompraEjemplar date NOT NULL,
	fechaClienteCompraEjemplar date default NULL,
	PRIMARY KEY (id, componente),
	FOREIGN KEY (empleado) REFERENCES Empleados (dni),
	FOREIGN KEY (cliente) REFERENCES Clientes (id),
	FOREIGN KEY (componente) REFERENCES Componentes (nombre)
);


CREATE TABLE PlacasBase (
	componente varchar(50),
	chipset varchar(20),
	tamano float,
	PRIMARY KEY (componente),
	FOREIGN KEY (componente) REFERENCES Componentes(nombre)
);

CREATE TABLE CPUs (
	componente varchar(50),
	sockets varchar(10),
	cores int,
	threads int,
	frecuencia float,
	tdp float,
	microarquitectura varchar(50),
	PRIMARY KEY (componente),
	FOREIGN KEY (componente) REFERENCES Componentes(nombre)
);

CREATE TABLE RAMs (
	componente varchar(50),
	tipoDDR varchar(30),
	memoria float CHECK ( memoria > 0),
	frecuencia float CHECK (frecuencia > 0),
	formato varchar(10),
	PRIMARY KEY (componente),
	FOREIGN KEY (componente) REFERENCES Componentes(nombre)
);

CREATE TABLE GPUs (
	componente varchar(50),
	nucleos integer CHECK (nucleos > 0),
	frecuencia float CHECK (frecuencia > 0),
	procesoFabricacion integer CHECK (procesoFabricacion  > 0),
	PRIMARY KEY (componente),
	FOREIGN KEY (componente) REFERENCES Componentes(nombre)
);

CREATE TABLE DiscosDuros (
	componente varchar(50),
	tipo varchar(10) CHECK (tipo IN ('SSD', 'HDD')),
	capacidad integer CHECK (capacidad  > 0),
	velocidad float CHECK (velocidad  > 0),
	PRIMARY KEY (componente),
	FOREIGN KEY (componente) REFERENCES Componentes(nombre)
);

CREATE TABLE Alimentacion (
	componente varchar(50),
	potencia float CHECK (potencia > 0),
	modular boolean,
	PRIMARY KEY (componente),
	FOREIGN KEY (componente) REFERENCES Componentes(nombre)
);

CREATE TABLE Refrigeracion (
	componente varchar(50),	
	tipo varchar(10) CHECK (tipo IN ('CPU', 'GPU', 'Ventilador')),
	tamano integer CHECK (tamano  > 0),
	PRIMARY KEY (componente),
	FOREIGN KEY (componente) REFERENCES Componentes(nombre)
);

CREATE TABLE Perifericos (
	componente varchar(50),
	tipo varchar(20),
	PRIMARY KEY (componente),
	FOREIGN KEY (componente) REFERENCES Componentes(nombre)
);


CREATE TABLE Personalizados (
	pc integer,
	nombre varchar(25) NOT NULL,
	cliente varchar(20) NOT NULL,
	numVentas integer default 0,
	placaBase varchar(50) NOT NULL,
	cpu varchar(50) NOT NULL,
	gpu varchar(50) NOT NULL,
	numGPUs integer CHECK (numGPUs >=0 AND numGPUs <5),
	ram varchar(50) NOT NULL,
	numRAMs integer CHECK (numRAMs >=0 AND numRAMs <9),
	discoDuro1 varchar(50) NOT NULL,
	numDiscoDuro1 integer CHECK (numDiscoDuro1 >=0 AND numDiscoDuro1 < 5),
	discoDuro2 varchar(50),
	numDiscoDuro2 integer CHECK (numDiscoDuro2 >=0 AND numDiscoDuro2 < 5),
	alimentacion varchar(50),
	refrigeracion1 varchar(50),
	refrigeracion2 varchar(50),
	numRefrigeracion2 integer,
	periferico1 varchar(50),
	periferico2 varchar(50),
	periferico3 varchar(50),
	periferico4 varchar(50),    

	PRIMARY KEY (pc),
	FOREIGN KEY (pc) REFERENCES PCs(id),
	FOREIGN KEY (cliente) REFERENCES Clientes(id),
	FOREIGN KEY (placaBase) REFERENCES PlacasBase(componente),
	FOREIGN KEY (cpu) REFERENCES CPUs(componente),
	FOREIGN KEY (gpu) REFERENCES GPUs(componente),
	FOREIGN KEY (ram) REFERENCES RAMs(componente),
	FOREIGN KEY (discoDuro1) REFERENCES DiscosDuros(componente),
	FOREIGN KEY (discoDuro2) REFERENCES DiscosDuros(componente),
	FOREIGN KEY (alimentacion)REFERENCES Alimentacion(componente),
	FOREIGN KEY (refrigeracion1) REFERENCES Refrigeracion(componente),
	FOREIGN KEY (refrigeracion2) REFERENCES Refrigeracion(componente),
	FOREIGN KEY (periferico1) REFERENCES Perifericos(componente),
	FOREIGN KEY (periferico2) REFERENCES Perifericos(componente),
	FOREIGN KEY (periferico3) REFERENCES Perifericos(componente),
	FOREIGN KEY (periferico4) REFERENCES Perifericos(componente),
	UNIQUE (cliente,nombre)
);

    



