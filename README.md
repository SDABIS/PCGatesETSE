# PcGatesETSE
## Introduccion
Esta es una aplicacion desarrollada para la asignatura **Bases de Datos II** en el Grado de Ingenieria Informatica en la USC. El objetivo era crear una tienda informatica y lograr desarrollar una aplicacion para la gestion de la tienda, mediante el uso de **JAVA8** y **PostgreSQL**, por lo que sera necesaria una conexion con la base de datos para acceder a los diferentes datos almacenada en la misma. De manera mas concreta, cuenta con interfaz gráfica desarrollada sobre **JAVA Swing**, y la conexion con la base de datos se realiza mediante **JDBC**.

El desarrollo de la aplicacion se realizo en dos partes, donde esta descrita se trata de la parte para acceder a la aplicacion, realizar ventas, editar datos de usuarios y gestionar la reparacion de equipos. Basicamente, se crea la parte para asistentes y reparadores.

La aplicacion estaba pensada como una aplicacion que se encontraria en la propia tienda y a la que no se podria acceder de ninguna otra manera. Es decir, seria una aplicacion que estaria en la tienda mediante la que se podria interaccionar por pantallas del propio local, y para lo cual los clientes deben estar dados de alta en la aplicacion, de lo que se encargarian los empleados. Cabe resaltar que todo usuario puede crear un equipo a su medida, o llevar un ordenador propio a reparar.

## ¿Como se realiza la conexion con la base de datos?
La base de datos tendra de nombre **PcGates**, donde las ceredenciales aparecen en el archivo _**baseDatos.properties**_, en la carpeta _**PcGates/**_. El gestor utilizado sera **PostgreSQL** y la conexion se realiza empleando **JDBC**.

## ¿Que tablas se utilizan?
En la base de datos, se crearan multiples tablas para permitir el desarrollo adecuado de la aplicacion. Todas las tablas empleadas aparecen en el archivo de creacion **CreacionTablas.sql**, donde los datos para estas estan en **DatosTiendaInfor.sql**. De manera general, habra una tabla para clientes y otra para empleados. Tambien, para los equipos que creen los usuarios y los propios que venda la tienda, asi como componentes y una para los equipos que deben ser reparados y otra para los que ya lo han sido.

## ¿Como se accede a la tienda?
Para acceder a la tienda, es necesario que el usuario este dado de alta en la base de datos en la tabla correspondiente. El acceso a la aplicacion se realiza mediante las credenciales **ID** y **Clave**, donde el ID se tratará del DNI del usuario. Este usuario podrá seleccionar cual es su rol en la aplicacion (cliente, asistente, reparador o jefe). 

Para corroborar que este se trata de un usuario correcto, se corroborara chequeando sobre la tabla de la base de datos correspondiente si este usuario existe, es decir, si ha introducido unas credenciales y un rol correctos.

## ¿Que puede hacer un asistente?
Un asistente podra completar multiples acciones, entre las que se encuentran consultar datos de clientes, crear nuevos usuarios, vender productos (componentes, ordenadores...), reparar equipos que llevan los usuarios a la tienda, editar datos de un cliente o añadir stock a la tienda.

Para aclarar, la reparacion de equipos consiste en introducir un equipo que debe ser reparado, para que asi un reparador pueda visualizarlo desde su ventana concreta para poder determinar si ya lo ha reparado o no.

## ¿Como actua un reparador?
Como bien se ha comentado, un reparador tendra una ventana propia donde visualizara los equipos que deben ser reparados y que introducira un asistente a la base de datos. Con un equipo concreto, el reparador podra seleccionar los componentes con los que el terminal debe ser reparado, calculando el precio a la vez que se seleccionan componentes. Una vez haya terminado, podra pulsar en repara, actualizando el equipo en la base de datos y marcandolo como reparado.

## ¿Como se ejecuta la aplicacion?
En la carpeta _**PcGates/dist/**_ se encontrara el .jar de la aplicacion. Para ejecutar la aplicacion, sera tan sencillo como ejecutar, situdados en esta capeta, el siguiente comando.
```
java -jar PcGatesDefinitivo.jar
```
Resaltar que la aplicacion cuenta con interfaz grafica.

## Autores
* [Francisco Javier Saa Besteiro](https://github.com/franjsb1903)
* Miguel Ventoso Fernandez
* David Soler Garcia
