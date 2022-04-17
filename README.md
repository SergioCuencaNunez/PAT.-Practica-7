# Práctica 7. Persistencia con queries

En este práctica se ha desarrollado una aplicación de Spring Boot que incluye una serie de funcionalidades que permiten persistir información utilizando la librería ``Spring Data JDBC`` con una base de datos ``H2``.

La aplicación se encarga de gestionar la información de una cadena de hoteles, para lo cuál se han creado 4 tablas: Cliente, Reserva, Hotel y Habitación. En cada tabla se incluyen los atributos correspondientes para almacenar la información
más relevante y poder operar con ella. Definida la base de datos, se realizan las operaciones pedidas a través de las que se podrán insertar, actualizar, seleccionar y eliminar datos a cada una de las tablas.

Para ello, en cada uno de los repositorios se definen las queries necesarias en ``SQL`` para poder modificar la información de cada una de las tablas por los métodos especificados: ``INSERT``,``UPDATE``,``SELECT``y ``DELETE``. Los servicios son las interfaces
más importantes debido a que son los que comunican los repositorios con la capa REST, en la que se definen los ``endpoints`` y cómo se podrá modificar la información. Estos servicios son encargados de realizar las funcionalidades que se definen en las queries de ``SQL`` y 
en cada uno de ellos se describen los métodos necesarios para gestionar de manera correcta las funcionalidades pedidas por los controladores.

Asimismo, en ellos se incluyen las operaciones ``JOIN`` que unen tablas según el atributo que tengan en común para tener de manera condensada la información que se refiere a un mismo dato. Se han realizado 3 ``INNER-JOIN``. El primero Cliente-Reserva, para tener cada
cliente con su reserva correspondiente con NIF como atributo de unión; el segundo Hotel-Reserva, para que cada hotel disponga de las reservas realizadas en el mismo; y el último Hotel-Habitación, para que en cada hotel se muestre la información respectiva a sus habitaciones.


