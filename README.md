# ProyectoAPIADAT 
Nombre: Desguace AGS

Se busca crear un sistema para gestionar los distintos recursos de un desguace: empleados, balance y vehículos


Habra tres tablas: 

Usuarios, los cuales pueden ser vendedores, que añaden coches al desguace; desguazadores, los cuales quitan coches y un único usuario administrador.

Vehículos, los cuales tendran un valor monetario.

Desguace, la cual tendra el balance del desguace, cuando un vendedor introduce un coche, su valor se resta al dinero actual mientras que cuando se desguaza un coche su valor mas el 10% se suma, solo el administrador puede acceder a esta tabla


La tabla "Usuarios" contara con la información de cada uno: el id, el nombre de usuario y el rol que tiene este, puede ser "Cliente", "Desguazador" o "Administrador", este último esta definido por defecto y no se pueden añadir mas
tambien contendra los vehiculos que cada uno posee.

La tabla "Vehículos" cada uno contara con un id, modelo, valor y el id de su propietario

La tabla "Desguace" tendra un id unico, el capital actual, los empleados y coches actualmente registrados, cuando se inserta o elimina un coche se debe cambiar el capital de la empresa, cuando se elimine un empleado se debe reflejar en la tabla.


Lógica de negocio

El id de todas las tablas es autogenerado e irrepetible.


Tabla Usuarios.

El nombre de usuario no puede ser ni nulo ni repetido, la contraseña debe tener un minimo de 8 caracteres, el rol debe ser "Vendedor","Desguazador" o "Administrador", 
no se pueden añadir usuarios con rol Administrador, solo los usuarios con el rol "Vendedor" pueden insertar valores en la tabla coches, solo los usuarios con el rol "Desguazador" pueden elimiar valores, el usuario Administrador puede hacer todo lo anterior añadiendo que puede editar la tabla Administración.


Tabla Vehículos

El modelo no puede superar los 40 caracteres y el valor no puede ser nulo o negativo, siempre debe tener un propietario, que puede ser tanto un Desguace o un Usuario


Tabla Desguace

El capital no puede ser nulo aunque si negativo, los empleados no pueden ser menos de 1 ni nulo,
los vehiculos no pueden ser negativos ni nulos aunque si cero.


Para la seguridad los usuarios tendran una contraseña cifrada dentro de su tabla y esta generara un token que sera válido por una mitad de jornada laboral(4 horas) para los usuarios "cliente" y "desguazador".
Para el usuario "Administrador" el token sera válido durante 10 minutos.


//TODO: Endpoints