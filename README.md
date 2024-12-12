# ProyectoAPIADAT 
Nombre: Desguaze AGS

La api servira para guardar datos sobre un desguaze


Habra tres tablas: 

Usuarios, los cuales pueden ser vendedores, que añaden coches al desguze y desguazadores, los cuales quitan coches y un único usuario administrador.

Coches, los cuales tendran piezas.

Administración, la cual tendra el balance de la empresa, cuando un vendedor introduce un coche, su valor se resta al dinero actual mientras que cuando se desguaza un coche su valor mas el 10% se suma, solo el administrador puede acceder a esta tabla


La tabla "Usuarios" contara con la información de cada uno: el id(Int autogenerado), el nombre de ususario(no mas de 20 caracteres), el nombre(no mas de 20 caracteres), la contraseña(Cifrada con un minimo de 8 caracteres), los apellidos(no mas de 40 caracteres pero nulable), la edad(mayor igual que 18) y el rol que tiene este, puede ser o "Vendedor" o "Desguazador" o "Administrador" aunque esta definido por defecto y no se pueden añadir mas.

La tabla "Coches" cada uno contara con un id(Int autogenerado), modelo(String de no mas de 40 caracteres), valor(Float)

La tabla "Administración" tendra una única fila que tendra el capital(Float) actual de la empresa, el número de empleados(Int) y coches(Int) actualmente registrados, cuando se inserta o elimina un coche se debe cambiar el capital de la empresa, cuando se elimine un empleado se debe reflejar en la tabla.


La tabla Usuarios podra añadir y eliminar entradas de la tabla coches si tienen el rol adecuado, nunca se podra acceder a los datos no insertados por uno mismo, asimismo, si se tiene el rol administrador, se podra hacer ambas cosas ademas de acceder a la tabla Administración para editar, ya que no se puede insertar ni eliminar de esta tabla.

//QUIZAS FALTA LA LÓGICA AUNQUE CREO QUE ESTA EN LAS LINEAS 16-20

Para la seguridad los usuarios tendran una contraseña cifrada dentro de su tabla y esta generara un token que sera válido por una mitad de jornada laboral(4 horas) para los usuarios "cliente" y "desguazador" para el usuario "Administrador" el token sera válido durante 10 minutos.
