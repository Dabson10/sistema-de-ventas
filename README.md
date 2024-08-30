Sistema de Ventas
Sistema de Ventas es una interfaz gráfica desarrollada en Java utilizando Swing y Maven, con una base de datos MySQL. Este sistema está diseñado para administrar las ventas de un negocio de manera eficiente.

Funcionalidades
*Productos
-Agregar Productos: Permite añadir nuevos productos a la base de datos, especificando el nombre, precio y cantidad.

*Ventas
-Realizar Ventas: Facilita la venta de productos, permitiendo buscar productos existentes en la base de datos y agregarlos a una tabla de productos seleccionados.
-Calculo Automático: El sistema suma automáticamente el valor total de los productos agregados y lo muestra en pantalla.
-Eliminar Productos: Los productos pueden ser eliminados de la venta si es necesario.

*Recorte Diario
Al finalizar cada venta, el valor de la transacción se agrega a una tabla que gestiona las ventas diarias. 
El sistema cuenta con un ciclo de 7 días, lo que requiere realizar un recorte diario para mantener un registro ordenado.

*Ventas Semanales
Muestra un resumen de las ventas realizadas durante la semana. Al llegar al límite de los 7 días, es necesario realizar un recorte semanal. 
Estos recortes se almacenan en una tabla separada, que contiene todas las ventas semanales sin límite de tiempo.
