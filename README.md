# ProyectoAPIADAT 
Nombre: Desguace AGS

Se busca crear un sistema para gestionar los distintos recursos de un desguace: empleados, balance y vehículos


Habra tres tablas: 

Usuarios, los cuales pueden ser vendedores, que añaden coches al desgace y desguazadores, los cuales quitan coches y un único usuario administrador.

Vehículos, los cuales tendran un valor monetario.

Administración, la cual tendra el balance de la empresa, cuando un vendedor introduce un coche, su valor se resta al dinero actual mientras que cuando se desguaza un coche su valor mas el 10% se suma, solo el administrador puede acceder a esta tabla


La tabla "Usuarios" contara con la información de cada uno: el id, el nombre de usuario, el nombre, la contraseña, los apellidos, la edad y el rol que tiene este, puede ser o "Vendedor" o "Desguazador" o "Administrador" aunque esta definido por defecto y no se pueden añadir mas.

La tabla "Vehículos" cada uno contara con un id, modelo y valor

La tabla "Administración" tendra una única fila que tendra el capital actual de la empresa, el número de empleados y coches actualmente registrados, cuando se inserta o elimina un coche se debe cambiar el capital de la empresa, cuando se elimine un empleado se debe reflejar en la tabla.


Lógica de negocio

El id de todas las tablas es autogenerado e irrepetible, el nombre de usuario no puede ser ni nulo ni repetido, el nombre y apellidos no pueden pasar de 40 caracteres cada uno, la contraseña debe ser minimo de 8 caracteres


La tabla Usuarios podra añadir y eliminar entradas de la tabla coches si tienen el rol adecuado, nunca se podra acceder a los datos no insertados por uno mismo, asimismo, si se tiene el rol administrador, se podra hacer ambas cosas ademas de acceder a la tabla Administración para editar, ya que no se puede insertar ni eliminar de esta tabla.

//QUIZAS FALTA LA LÓGICA AUNQUE CREO QUE ESTA EN LAS LINEAS 16-20

Para la seguridad los usuarios tendran una contraseña cifrada dentro de su tabla y esta generara un token que sera válido por una mitad de jornada laboral(4 horas) para los usuarios "cliente" y "desguazador" para el usuario "Administrador" el token sera válido durante 10 minutos.
