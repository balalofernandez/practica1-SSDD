# Practica 1 - SSDD - Productos Fitosanitarios
Muchos de los productos fitosanitarios que se utilizan para tratar las plagas de las plantas cultivadas
pueden tener efectos indeseados sobre las personas, por lo que se establecen determinadas medidas de
proteccio n, entre ellas unos plazos de seguridad.

Se distinguen dos plazos de seguridad:

- Reeentrada: Plazo durante el que no se permite a ninguna persona entrar en el recinto donde
se ha aplicado el tratamiento a menos que lleve equipos especiales de proteccio n.

- Recolección: Plazo durante el cual no se pueden recolectar ni consumir los productos de las
plantas tratadas, como frutos, hojas, etc.

Se desea confeccionar una aplicacio n web que permita a una explotacio n agrí cola que disponga de
distintos cultivos llevar la cuenta de estos plazos de seguridad.

Por cada producto fitosanitario que se utilice en la explotacio n se almacenara en una base de datos el
nombre, descripcio n (que puede estar vací a) y los plazos de reentrada y recoleccio n, ambos en nu mero de
dí as (sin decimales). Si alguno de los plazos no es necesario se pondra su valor a cero.

Por cada cultivo, se almacenara en la base de datos la especie, la variedad, la fecha en la que se ha
plantado, la zona (un string, que puede estar vací o), y una lista de los tratamientos realizados hasta la fecha
actual.
Por cada tratamiento se almacenara el cultivo, el producto, el nu mero de lote de fabricacion del
producto utilizado (un string), la fecha en la que se realizo el tratamiento y la fecha en la que terminan los
respectivos plazos de seguridad de reentrada y recoleccion.

Implementar una aplicación web que permita an adir, modificar y consultar cualquiera de los
elementos de la base de datos. No es necesario incluir la operacion de borrado.

En particular, una de las páginas de la aplicación deberá mostrar los tratamientos de todos los
cultivos que tengan algún plazo de seguridad en vigor en una fecha en concreto introducida por el
usuario, y en esa pa gina los usuarios podra n elegir entre ordenarlos por especie, por fecha de reentrada o
por fecha de recoleccio n.

Al mostrar los resultados de cualquier consulta se incluira al lado de cada elemento un enlace o
boto n que permita modificarlo.

Al añadir un nuevo tratamiento, la aplicacio n debera permitir elegir entre los cultivos y productos
que ya esta n en la base de datos o definir alguno nuevo, y debera calcular automa ticamente las fechas en las
que terminan los plazos de reentrada y de recoleccio n.

La aplicacio n debe construirse utilizando Java, Maven, Spring MVC, Thymeleaf y el gestor de bases de
datos H2 y debe funcionar correctamente en Windows y en el navegador Mozilla Firefox. Para el acceso a la
base de datos se utilizara el ORM de Spring Data (es decir no se podra n utilizar anotaciones @Query o
similares).

*La URL inicial de la aplicación debe ser la URL base del servidor Web (localhost:8080 si está en la
máquina local y el puerto 8080).*

Se utilizarán pa ginas y plantillas HTML5 y hojas de estilo CSS. Toda la informacio n sobre la
presentacio n de los elementos debera estar en la(s) hoja(s) de estilos CSS. Se puede utilizar como base una
hoja de estilos ya existente de las muchas que pueden conseguirse en Internet, así como Bootstrap (ve ase
por ejemplo https://www.mkyong.com/spring-boot/spring-boot-hello-world-example-thymeleaf/ ).

**Si algún grupo desea utilizar algún otro lenguaje, biblioteca o herramienta distinto de los
indicados debe consultarlo previamente con la profesora.**

En la prática que se entregue se utilizaran me todos anotados con **@PostConstruct** para cargar en la
base de datos un pequen o nu mero de datos de ejemplo, que debera n incluir como mí nimo:

1. 5 productos fitosanitarios que cumplan los siguientes requisitos:
   - 3 de ellos con plazos de reentrada y recoleccio n
   - 1 de ellos con plazo de recoleccio n y no de reentrada
   - 1 de ellos sin plazo de recoleccio n ni de reentrada
2. 6 cultivos que cumplan los siguientes requisitos:
   - 1 de ellos con tres tratamientos con otros tantos productos diferentes aplicados en la misma fecha, uno de ellos con plazo de recoleccio n pero no de reentrada y dos con ambos.
   - 1 de ellos con dos tratamientos realizados en distintas fechas con sendos productos
diferentes, ambos con tanto plazo de reentrada como de recoleccio n.
   - 1 de ellos con un tratamiento con un u nico producto fitosanitario con fechas de
reentrada y recoleccio n
   - 1 de ellos con un u nico producto fitosanitario con plazo de recoleccio n y no de
reentrada
   - 1 de ellos un u nico producto fitosanitario sin plazo de recoleccio n ni de reentrada
   - 1 de ellos sin ningu n tratamiento.
No es necesario que los datos correspondan a productos, plazos o cultivos reales.
