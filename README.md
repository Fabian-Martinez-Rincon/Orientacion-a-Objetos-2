# Orientacion a Objetos 2


### Patrones de Diseño


<p><img width="250" align='right' src="https://media.giphy.com/media/RcRYrpC1pBvIB0icDm/giphy.gif"></p>


- [Ejercicio 1 Red Social](#ejercicio-1-red-social)
- [Ejercicio 2 Friday the 13th en Java](#ejercicio-2-friday-the-13th-en-java)
- [Ejercicio 2.b Usando la librería JSON.simple](#ejercicio-2b-usando-la-librería-jsonsimple)
- [Ejercicio 3 Media Player](#ejercicio-3-media-player)
- [Ejercicio 4 Topografías](#ejercicio-4-topografías)
- [Ejercicio 4.b Más Topografías](#ejercicio-4b-más-topografías)
- [Ejercicio 5 FileSystem](#ejercicio-5-filesystem)
- [Ejercicio 6 Cálculo de sueldos](#ejercicio-6-cálculo-de-sueldos)
- [Ejercicio 7 ToDoItem](#ejercicio-7-todoitem)
- [Ejercicio 8 Excursiones](#ejercicio-8-excursiones)
- [Ejercicio 9 Encriptador](#ejercicio-9-encriptador)
- [Ejercicio 10 Administrador de proyectos](#ejercicio-10-administrador-de-proyectos)
- [Ejercicio 11 Dispositivo móvil y conexiones](#ejercicio-11-dispositivo-móvil-y-conexiones)
- [Ejercicio 12 Decodificador de películas](#ejercicio-12-decodificador-de-películas)
- [Ejercicio 13 Acceso a la base de datos](#ejercicio-13-acceso-a-la-base-de-datos)
- [Ejercicio 14 File Manager](#ejercicio-14-file-manager)
- [Ejercicio 15 Estación meteorológica](#ejercicio-15-estación-meteorológica)
- [Ejercicio 16 Productos Financieros](#ejercicio-16-productos-financieros)
- [Ejercicio 17 Infraestructura en la Nube](#ejercicio-17-infraestructura-en-la-nube)
- [Ejercicio 18 SubteWay](#ejercicio-18-subteway)
- [Ejercicio 19 Personajes de juegos de rol](#ejercicio-19-personajes-de-juegos-de-rol)
- [Ejercicio 19.b Mas Personajes](#ejercicio-19b-mas-personajes)
- [Ejercicio 20 Aerolínea Regional](#ejercicio-20-aerolínea-regional)
- [Ejercicio 21 Genealogía salvaje](#ejercicio-21-genealogía-salvaje)
- [Ejercicio 22 Monitoreo de proceso industrial](#ejercicio-22-monitoreo-de-proceso-industrial)

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 1 Red Social

Se quiere programar en objetos una versión simplificada de una red social parecida a Twitter. Este servicio debe permitir a los usuarios registrados postear y leer mensajes de hasta 280 caracteres. Ud. debe modelar e implementar parte del sistema donde nos interesa que quede claro lo siguiente:

- Cada usuario conoce todos los Tweets que hizo.
- Un tweet puede ser re-tweet de otro, y este tweet debe conocer a su tweet de origen.
- Twitter debe conocer a todos los usuarios del sistema.
- Los tweets de un usuario se deben eliminar cuando el usuario es eliminado. No existen tweets no referenciados por un usuario.
- Los usuarios se identifican por su screenName.
- No se pueden agregar dos usuarios con el mismo screenName.
- Los tweets deben tener un texto de 1 carácter como mínimo y 280 caracteres como máximo.

### Tareas

Su tarea es diseñar y programar en Java lo que sea necesario para ofrecer la funcionalidad antes descrita. Se espera que entregue los siguientes productos

- **1)** Diagrama de clases UML.
- **2)** Implementación en Java de la funcionalidad requerida.
- **3)** Implementar los tests (JUnit) que considere necesarios

> **Nota** para crear el proyecto Java, lea el material llamado “Trabajando en OO2 con proyectos Maven”.

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 2 Friday the 13th en Java

> **Nota** Para realizar este ejercicio, utilice el recurso que se encuentra en el sitio de la cátedra. Allí encontrará un proyecto Maven que contiene el código fuente de las clases Biblioteca, Socio y VoorheesExporter.

La clase Biblioteca implementa la funcionalidad de exportar el listado de sus socios en formato JSON. Para ello define el método **exportarSocios()** de la siguiente forma:

```java
/**
* Retorna la representación JSON de la colección de socios.
*/
public String exportarSocios() {
    return exporter.exportar(socios);
}
```



La Biblioteca delega la responsabilidad de exportar en una instancia de la clase VoorheesExporter que dada una colección de socios, retorna un texto con la representación de la misma en formato JSON. Esto lo hace mediante el mensaje de instancia **exportar(List\<Socio>)**.

<table><tr>
<td>

- Nombre: Arya Stark
- e-mail:needle@stark.com
- legajo: 5234-5
</td>
    
<td>

- Nombre: Tyron Lannister
- e-mail:tyron@thelannisters.com
- legajo: 2345-2
</td>
</tr></table>

Ud. puede probar la funcionalidad ejecutando el siguiente código:

```java
Biblioteca biblioteca = new Biblioteca();
biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2"));
System.out.println(biblioteca.exportarSocios());
```

Al ejecutar, el mismo imprimirá el siguiente JSON:

```json
[
    {
        "nombre": "Arya Stark",
        "email": "needle@stark.com",
        "legajo": "5234-5"
    },
    {
        "nombre": "Tyron Lannister",
        "email": "tyron@thelannisters.com",
        "legajo": "2345-2"
    }
]
```

Note los corchetes de apertura y cierre de la colección, las llaves de apertura y cierre para cada socio y la coma separando a los socios

### Tareas

- **1)** Analice la implementación de la clase Biblioteca, Socio y VoorheesExporter que se provee con el material adicional de esta práctica (Archivo biblioteca.zip).
- **2)** Documente la implementación mediante un diagrama de clases UML.
- **3)** Programe los Test de Unidad para la implementación propuesta.




<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 2.b Usando la librería JSON.simple

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 3 Media Player

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 4 Topografías

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 4.b Más Topografías

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 5 FileSystem

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 6 Cálculo de sueldos

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 7 ToDoItem

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 8 Excursiones

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 9 Encriptador

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 10 Administrador de proyectos

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 11 Dispositivo móvil y conexiones

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 12 Decodificador de películas

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 13 Acceso a la base de datos

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 14 File Manager

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 15 Estación meteorológica

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 16 Productos Financieros

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 17 Infraestructura en la Nube

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 18 SubteWay

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 19 Personajes de juegos de rol

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 19.b Mas Personajes

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 20 Aerolínea Regional

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 21 Genealogía salvaje

<img src= 'https://i.gifer.com/origin/8c/8cd3f1898255c045143e1da97fbabf10_w200.gif' height="20" width="100%">

# Ejercicio 22 Monitoreo de proceso industrial

---
