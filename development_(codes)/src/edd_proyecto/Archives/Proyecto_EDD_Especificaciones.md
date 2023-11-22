# Estructura de Datos
## Proyecto Final - Biblioteca

## Equipo:
-  Flores Javier
-  Gabriel Alondra
- Lugo Hava
- Valdés Maximiliano


## Descripción general
El conjunto de códigos a continuación ha sido creado con el fin de simular el sistema utilizado por una biblioteca para administrar sus libros. Todo esto se logra a través de una estructura de datos específica, en este caso, se emplea una lista.

- Main.java
- MenuUsusario.java
- Biblioteca.java
- Usuario.java
  - UsuarioAdmi.java
  - UsuarioCliente,java
- Libro.java
- AdmiArchivo.java



A continuación de comentara de manera general cada clase.
## Funcionalidades Clave:

1. Inicio de sesión y autenticación para usuarios.
1. Gestión de libros: búsqueda, visualización detallada, préstamo, devolución y modificación.
1. Gestión de usuarios: diferenciación entre administradores y clientes, manejo de multas y préstamos.
1. Interacción mediante ventanas emergentes.
1. Lectura y escritura de datos desde y hacia archivos CSV.
## Main.java
La clase Main inicia el programa y configura los componentes principales del sistema, como la biblioteca, el administrador de archivos y el menú de usuario. Además, da la bienvenida al usuario y comienza el flujo de inicio de sesión para utilizar la aplicación de la biblioteca.

- **Clase Main**:
Define la clase principal que contiene el método main, el punto de entrada de la aplicación.

 - **Método main(String[] args):**
Crea una instancia de la clase **Biblioteca** llamada _biblioteca_obj._
Crea una instancia de la clase **AdminArchivo** llamada admin.
Crea una instancia de la clase **MenuUsuario** llamada _menu_obj_, pasando las instancias de _biblioteca_obj_ y _admin_ como parámetros al constructor.
Llama al método **_crear_listas()_** de la instancia admin, pasando _menu_obj_ como argumento. Este método carga información de archivos CSV para crear listas de libros y usuarios en **_menu_obj_.**
Llama al método **crear_listas()** de la instancia admin, pasando _biblioteca_obj_ como argumento. Este método carga información de archivos CSV para crear la lista de libros en _biblioteca_obj._
Muestra un mensaje de bienvenida a través de una ventana emergente.
Llama al método **inicioDeSesion()** de _menu_obj_ para iniciar el flujo de inicio de sesión en el sistema.

- **Flujo de Ejecución:**
Al inicio, se inicializan las estructuras de datos (Biblioteca, AdminArchivo, MenuUsuario) y se cargan datos iniciales desde archivos CSV.
Se muestra un mensaje de bienvenida al usuario antes de que se inicie el proceso de inicio de sesión.
El método **inicioDeSesion()** probablemente maneja la interacción con el usuario para iniciar sesión en el sistema.

## MenuUsusario.java
Controla el flujo de interacciones entre el usuario y la aplicación de la biblioteca, ofreciendo diferentes opciones según el tipo de usuario y actualizando los archivos CSV después de cada operación realizada.

- **Clase MenuUsuario:**
Esta clase maneja las interacciones con el usuario y las opciones disponibles para los usuarios normales  **(UsuarioCliente)** y administradores  **(UsuarioAdmi)** en la aplicación de la biblioteca.

-  **Atributos:**
_private Biblioteca biblioteca_: Almacena una referencia a la biblioteca utilizada en la aplicación.
_public ArrayList<UsuarioCliente> usuarios_clientes_: Almacena una lista de usuarios clientes.
_public ArrayList<UsuarioAdmi> usuarios_admin_: Almacena una lista de usuarios administradores.
_private AdminArchivo admin_: Almacena una referencia al administrador de archivos utilizado para la gestión de archivos CSV.

 - **Constructor:**
Recibe instancias de _Biblioteca_ y _AdminArchivo_ y las asigna a sus respectivos atributos para su posterior uso.

-  **Método inicioDeSesion():**
Realiza la autenticación del usuario solicitando un nombre de usuario y contraseña.
Verifica si el usuario existe en las listas de usuarios clientes o administradores.
Si se encuentra una coincidencia, muestra un mensaje de inicio de sesión correcto y dirige al usuario al menú correspondiente  (_menuOpciones()_ para usuarios clientes o _menuAdmin()_ para usuarios administradores).

- **Método menuOpciones(Integer codigo_usuario):**
Presenta un conjunto de opciones disponibles para usuarios clientes como mostrar libros, pedir préstamos, devolver libros, cambiar fecha, etc.
Realiza acciones según la elección del usuario, como mostrar libros, buscar por autor o título, solicitar préstamo, devolver libro, cambiar fecha, etc.
Actualiza archivos CSV después de cada operación realizada.

- **Método menuAdmin(Integer codigo_usuario):**
Presenta un conjunto de opciones disponibles para usuarios administradores como ingresar, eliminar o modificar libros.
Realiza acciones según la elección del usuario, como agregar libros, eliminar libros, modificar libros, etc.
Actualiza archivos CSV después de cada operación realizada.

- **Método verificarUsuario(String nombre_usuario, String password):**
Verifica si el nombre de usuario y la contraseña ingresados corresponden a algún usuario en las listas de usuarios clientes o administradores.
Retorna el índice del usuario encontrado o -1 si no se encuentra coincidencia.


## Biblioteca.java
Prroporciona funcionalidades básicas para manejar la lista de libros, permitiendo la búsqueda por ISBN o autor, la visualización detallada de libros individuales o de toda la lista, así como la capacidad de ordenar los libros por título. 

- **Clase Biblioteca:**
Administra una lista de libros (ArrayList<Libro> libros_biblioteca).

- **Constructor:**
Inicializa la lista de libros al crear una instancia de la clase Biblioteca.

- **Método buscar_isbn(String isbn):**
Busca un libro por su ISBN dentro de la lista de libros.
Retorna el índice del libro si se encuentra o muestra un mensaje de error si el ISBN no existe.

- **Método mostrarLibros():**
Muestra una ventana emergente (JOptionPane) con información detallada de todos los libros en la biblioteca.
Presenta título, autor, género, cantidad de copias, estado y ISBN de cada libro.

- **Método buscarAutor(String autor):**
Busca y muestra los libros escritos por un autor específico.
Utiliza el método mostrarLibro(Libro libro) para mostrar la información de cada libro encontrado.

- **Método mostrarLibro(Libro libro):**
Muestra la información detallada de un libro específico a través de una ventana emergente.
Presenta título, autor, género, cantidad de copias, estado y ISBN del libro dado.

- **Método ordenarLibros():**
Ordena la lista de libros por orden alfabético de títulos utilizando el algoritmo de burbuja.
Compara los títulos de los libros y los intercambia si es necesario para ordenar la lista.

## Usuario.java
Sirve como una plantilla básica para representar y manejar la información asociada con un usuario en un sistema, permitiendo la configuración y recuperación de datos relacionados con el usuario.

- **Clase Usuario**:
Define una clase que representa a un usuario genérico en un sistema.
Contiene atributos privados como **nombreUsuario, password, codigoUsuario y tipoUsuario** que almacenan la información básica del usuario.

 - **Constructor**:
Crea una instancia de Usuario con información inicial, incluyendo el nombre de usuario, contraseña, código de usuario y tipo de usuario.

- **Métodos get y set**:
_getNombreUsuario(), getPassword(), getCodigoUsuario(), getTipoUsuario()_: Devuelven los valores actuales de los atributos respectivos.
_setNombreUsuario(String nombre), setPassword(String password), setCodigoUsuario(int codigo), setTipoUsuario(int tipoUsuario)_: Permiten establecer nuevos valores para los atributos correspondientes.

- **Encapsulación**:
Los atributos se mantienen privados y se accede a ellos a través de métodos públicos (get y set), siguiendo el principio de encapsulación para controlar el acceso a los datos del usuario.

## UsuarioAdmi.java
la clase _UsuarioAdmi_ extiende las funcionalidades de un usuario normal (Usuario) al proporcionar métodos específicos para agregar, modificar y eliminar libros en la biblioteca que administra este tipo de usuario. 

- **Clase UsuarioAdmi:**
Es una subclase de Usuario que representa a un usuario administrador en un sistema.
Además de los atributos heredados de Usuario, tiene un atributo adicional _bibliotecaInf_, que almacena información sobre la biblioteca que este usuario administra.

- **Constructor:**
Crea una instancia de UsuarioAdmi con información inicial, incluyendo la llamada al constructor de la clase padre _(Usuario)_ y estableciendo la biblioteca que administra.

- **Método agregarLibros():**
Solicita al usuario ingresar información sobre un nuevo libro.
Crea un objeto _Libro_ con los datos ingresados y lo agrega a la lista de libros de la biblioteca.
Muestra un mensaje de confirmación al usuario sobre la adición exitosa del libro.

- **Método modificarLibros():**
Solicita al usuario ingresar el ISBN de un libro a modificar a través de una ventana emergente.
Busca el libro por su ISBN en la biblioteca y, si se encuentra, crea una copia de respaldo del libro original.
Permite al usuario modificar información específica del libro (título, autor, género, cantidad de copias, ISBN) a través de ventanas emergentes.
Muestra los datos originales del libro.
Actualiza el libro con la información modificada y muestra un mensaje de confirmación al usuario.

- **Método eliminarLibros():**
Solicita al usuario ingresar el ISBN de un libro a eliminar a través de una ventana emergente.
Busca el libro por su ISBN en la biblioteca y, si se encuentra, lo elimina de la lista de libros.
Muestra un mensaje de confirmación al usuario sobre la eliminación exitosa del libro.

- **Métodos get y set para bibliotecaInf:**
Permiten obtener y establecer la información de la biblioteca que este usuario administra.

## UsuarioCliente,java
Permite a los usuarios clientes de la biblioteca tomar prestados y devolver libros, calculando multas en caso de retraso en la devolución. Está diseñada para interactuar con objetos de la clase **Libro** y manejar la información de préstamos y multas de los clientes.

- **Clase UsuarioCliente:**
Esta clase gestiona las acciones relacionadas con los usuarios que son clientes de la biblioteca.

- **Atributos:**
_private Libro libroPrestado:_Almacena el libro que está actualmente prestado al cliente.
_private float multa:_ Registra el monto de la multa, si existe, para el usuario.
_private Date fechaPrestacion:_ Guarda la fecha en la que se prestó el libro al usuario.

- **Constructor:**
Recibe información del usuario (nombre, contraseña, código, tipo), el libro prestado, la multa actual y la fecha de préstamo.

- **Método prestarLibro(Libro libro, Date fechaPrestamo):**
Permite al usuario cliente tomar prestado un libro si no tiene ninguno prestado actualmente.
Verifica si hay copias disponibles del libro antes de prestarlo.
Actualiza la información del libro prestado, la fecha de préstamo y muestra un mensaje de confirmación.

- **Método devolverLibro(Date fechaDevolucion):**
Permite al usuario cliente devolver un libro prestado.
Calcula la multa si el libro se devuelve tarde (más de 5 días) y muestra el monto.
Actualiza la cantidad de copias del libro devuelto y limpia la información del libro prestado y la fecha de préstamo.

- **Método calcularMulta(Date fechaDevolucion):**
Calcula la multa basada en la diferencia de días entre la fecha de devolución y la fecha de préstamo.
Si la devolución se hace después de 5 días, se calcula una multa y se muestra un mensaje con el monto.

## Libro.java
Proporciona métodos para establecer y obtener información sobre los libros, cambiar su estado entre "Disponible" y "Ocupado" dependiendo de si están prestados o no. 

- **Clase Libro:**
Administra la información relacionada con un libro en la biblioteca.

- **Atributos:**
_private String titulo:_ Almacena el título del libro.
_private String autor:_ Almacena el nombre del autor del libro.
_private String genero:_ Guarda la categoría o género del libro.
_private Integer cantidad_copias:_ Representa la cantidad de copias disponibles del libro.
_private String isbn:_ Guarda el número de ISBN del libro.
_private String estado:_ Indica si el libro está disponible o está prestado.
_private Integer COSTODIA:_ Representa el costo por día de retraso en la devolución del libro.

- **Constructor:**
Recibe información sobre el título, autor, género, cantidad de copias y número de ISBN.
Establece el estado del libro dependiendo de la cantidad de copias disponibles.

- **Métodos:**
_mostrar_libro():_ Muestra la información del libro-
_cambiar_estado(int index)_: Cambia el estado del libro a "Ocupado" si se presta una copia y actualiza la cantidad de copias disponibles.
_devolver_libro(int index):_ Cambia el estado del libro a "Disponible" cuando se devuelve y actualiza la cantidad de copias.
_getCOSTODIA() y setCOSTODIA(Integer cOSTODIA):_ Métodos para obtener y establecer el costo por día de retraso en la devolución.

## AdmiArchivo.java
La clase **AdminArchivo** define una clase que se encarga de administrar archivos relacionados con la biblioteca.

- **Atributos**: _nombre_archivo_libros y nombre_archivo_usuarios_: Son rutas de los archivos que contienen la información de los libros y usuarios respectivamente.

- **Constructor**: Establece las rutas predeterminadas para los archivos de libros y usuarios al crear una instancia de _AdminArchivo_.

- **Métodos**:
 -- crear_listas(Biblioteca biblioteca): 
      Lee el archivo de libros línea por línea y los datos separados se almacenan en un ArrayList.
Los datos se recorren para extraer información sobre cada libro (título, autor, género, etc.).
Se crea un objeto Libro con la información extraída y se agrega a la lista de libros de la biblioteca.
 -- crear_listas(MenuUsuario menu_usuario):
Lee el archivo de usuarios línea por línea y almacena los datos separados en un ArrayList.
Para usuarios clientes (con multa), extrae los datos relevantes como nombre, contraseña, código, etc.
Obtiene el libro prestado por el usuario, busca su información en la biblioteca y crea un objeto _UsuarioCliente_.
Para usuarios administradores, obtiene los datos relevantes y crea un objeto _UsuarioAdmi_.
Agrega los objetos de usuario (cliente o administrador) a la lista de usuarios en el menú de usuarios.
- **Manejo de excepciones**:
Se manejan excepciones de lectura y parseo de datos desde archivos, imprimiendo detalles en caso de error.

## Estructura de Datos:
El proyecto utiliza listas (ArrayList) para almacenar libros y usuarios, permitiendo la manipulación y gestión de estos datos dentro de la aplicación de la biblioteca.
Esta estructura de datos y funcionalidades asociadas permiten una gestión completa de una biblioteca, desde la adición y modificación de libros hasta el préstamo y devolución, manteniendo un control sobre los usuarios y sus interacciones con los recursos de la biblioteca.