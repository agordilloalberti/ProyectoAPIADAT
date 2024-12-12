# ProyectoAPIADAT 
Nombre: Dessguaze AGS

La api servira para guardar datos sobre un desguaze


Habra tres tablas: 

Usuarios, los cuales pueden ser vendedores, que añaden coches al desguze y desguazadores, los cuales quitan coches y un único usuario administrador.

Coches, los cuales tendran piezas.

Administración, la cual tendra el balance de la empresa, cuando un vendedor introduce un coche, su valor se resta al dinero actual mientras que cuando se desguaza un coche su valor mas el 10% se suma, solo el administrador puede acceder a esta tabla


La tabla "Usuarios" contara con la información de cada uno: el id(Int autogenerado), el nombre(no mas de 20 caracteres), la contraseña(Cifrada con un minimo de 8 caracteres), los apellidos(no mas de 40 caracteres), la edad(mayor igual que 18) y el rol que que tiene este que puede ser o "Vendedor" o "Desguazador", el administrador esta definido por defecto

La tabla "Coches" cada uno contara con un id(Int autogenerado), modelo(String de no mas de 40 caracteres), valor(Float)

La tabla "Administración" tendra una única fila que tendra el capital actual de la empresa, el número de empleados y coches actualmente registrados, cuando se inserta o elimina un coche se debe cambiar el capital de la empresa, cuando se elimine un empleado se debe reflejar en la tabla.
