<div align="center"> 

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)
[![GitHub stars](https://img.shields.io/github/stars/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2/stargazers/)
[![GitHub repo size in bytes](https://img.shields.io/github/repo-size/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)


<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=34&duration=1700&pause=800&color=28CDF7&center=true&width=863&lines=☕ Orientación a Objetos 2"/>
 </div>

- [Parciales Frameworks](#parciales-frameworks)
- [Cuadernillo](#cuadernillo)

## Parciales Frameworks

![alt text](/Finales/image.png)

<details><summary>1 ¿La ejecución del código de esta subclase, se realiza mediante inversión de control? Justifique su respuesta de forma concisa. </summary>

Sí, se realiza mediante inversión de control. En el marco del `RuleEngine`, la clase `Rule` define los métodos abstractos `shouldProcess()` y `process()`, y el método `run()` controla cuándo se llaman estos métodos. La ejecución del comportamiento específico de cada regla depende de cómo estas funciones son implementadas en las subclases de `Rule`, mientras que `RuleEngine` maneja el flujo de ejecución general sin saber los detalles específicos de las implementaciones de las reglas. Este patrón donde el control del flujo del programa está invertido, con el marco llamando a métodos definidos por el usuario, es un ejemplo clásico de inversión de control.
</details>

<details><summary>2 ¿Cuáles son los hook methods?</summary>
   
Los hook methods en el contexto del documento y el diagrama de clases son `shouldProcess()` y `process()`. Estos métodos actúan como ganchos porque proporcionan puntos de intervención específicos para que el usuario del framework personalice el comportamiento del mismo sin cambiar su código base. Permiten que la lógica de la decisión (`shouldProcess()`) y la acción (`process()`) sean definidas por el usuario, adaptando el framework a necesidades específicas.</details>

<details><summary>3 Describa, de forma concisa, el frozen spot del extracto del framework presentado.</summary>
   
El frozen spot en el marco de `RuleEngine` es la estructura y el flujo de control definidos en el método `run()` de la clase `RuleEngine`. Este método gestiona cómo las reglas se revisan y ejecutan, invocando `rule.run()` para cada `Rule` en la lista `this.rules`. La lógica que determina que todas las reglas deben ser evaluadas y ejecutadas en orden y la forma en que esto se orquesta, son aspectos del framework que no están destinados a ser modificados por el usuario, estableciendo así un frozen spot.

</details>

---

![alt text](/Finales/image-1.png)

<details><summary>1 ¿El comportamiento variable del framework (hotspots), está implementado mediante herencia o composición? Justifique su respuesta.</summary>

El comportamiento variable del framework está implementado mediante **herencia**. Esto se puede ver en la clase `EmailFilter`, que es una clase abstracta con métodos abstractos `isEmailAllowed` y `addEmail`. Estos métodos deben ser implementados por las subclases que extienden `EmailFilter`, permitiendo personalizar cómo se filtran y agregan los correos electrónicos a `EmailInbox`. La herencia se utiliza aquí para definir un "contrato" o una interfaz que las subclases deben cumplir, permitiendo diferentes comportamientos mientras se mantiene la estructura básica del filtro de correo.

</details>

<details><summary>2 Indique la(s) línea(s) donde encuentra inversión de control. Justifique su respuesta.</summary>

La inversión de control se encuentra en la línea 8 dentro del método `filterEmail`, específicamente en el llamado `this.isEmailAllowed(anEmail)`. Este método es abstracto y su implementación será proporcionada por las subclases de `EmailFilter`. Aquí, el control del flujo del programa es "invertido" porque la clase `EmailFilter` no controla cómo se realiza la verificación de los correos; en cambio, delega esta responsabilidad a las subclases que definen el comportamiento específico de `isEmailAllowed`. Esto es inversión de control porque la clase base (framework) llama a métodos que son implementados por el usuario del framework (las subclases).

</details>

<details><summary>3. El método isEmailAllowed, ¿es un hot spot? ¿Por qué?</summary>

Sí, el método `isEmailAllowed` es un hot spot. Un hot spot en un framework es una parte del código que está intencionadamente diseñada para ser modificada o extendida para adaptar el comportamiento del framework a necesidades específicas. En este caso, `isEmailAllowed` es un método abstracto que debe ser implementado por cualquier subclase de `EmailFilter`, lo que permite a los usuarios del framework definir criterios específicos para decidir si un correo electrónico debe ser aceptado en el inbox. Esto proporciona un punto flexible donde el comportamiento puede ser modificado sin cambiar el código del framework en sí.

</details>

---

![alt text](/Finales/image-2.png)

<details><summary>1. ¿El comportamiento variable del framework (hotspots), está implementado mediante herencia o composición? Justifique su respuesta.</summary>

El comportamiento variable en este framework está implementado mediante **composición**. Esto se observa en cómo `RedundancyEngine` gestiona múltiples objetos de tipo `Storage`. El framework permite que diferentes tipos de almacenamiento (como `FileStorage` o `InMemoryStorage`) sean agregados dinámicamente a la lista de `storages`. Cada `Storage` puede tener una implementación diferente de cómo guardar y recuperar datos, pero `RedundancyEngine` los maneja uniformemente a través de la interfaz `Storage`. Este enfoque de composición permite la flexibilidad de agregar o cambiar las implementaciones de almacenamiento sin modificar el código existente del motor de redundancia.

</details>

<details><summary>2. ¿Cuáles son los hook methods?</summary>

Los métodos hook en este caso son `save(String key, String data)`, `hasKey(String key)` y `get(String key)` definidos en la interfaz `Storage`. Estos métodos permiten a las clases que implementan la interfaz `Storage` definir cómo se realizan estas operaciones esenciales. Al ser métodos que deben ser implementados por cualquier almacenamiento que se quiera integrar en el `RedundancyEngine`, actúan como puntos de extensión donde se puede alterar el comportamiento del almacenamiento.

</details>


<details><summary>3. ¿Cuál es el Frozen Spot?</summary>

El **Frozen Spot** en este framework es la clase `RedundancyEngine` y su interacción con la interfaz `Storage`. En particular, la forma en que `RedundancyEngine` itera sobre cada almacenamiento disponible para guardar y recuperar datos (los bucles en los métodos `save` y `get`) constituye un frozen spot. Estas partes del código están diseñadas para no ser modificadas, ya que dictan cómo se debe interactuar con los objetos `Storage` en cualquier configuración del framework. El flujo de guardar datos en todos los almacenamientos y recuperar el primer dato disponible que corresponde a una clave garantiza la redundancia de datos y no está destinado a ser cambiado por los usuarios del framework.

</details>

---

![alt text](/Finales/image-3.png)

<details><summary>1. ¿El comportamiento variable del framework (hotspots), está implementado mediante herencia o composición?</summary>

El comportamiento variable del framework, representado en este caso por la capacidad de definir diferentes estrategias de autorización, se implementa a través de **composición**. Esto se evidencia en la utilización de la interfaz `Permission`, que diferentes implementaciones pueden cumplir para proporcionar distintas lógicas de autorización. Al crear un objeto `API` con una lista de `Permission`, se delega la responsabilidad de la verificación de acceso a los objetos de `Permission` que se pasen en tiempo de ejecución. Esta estructura permite modificar el comportamiento del framework sin alterar su código fuente, adheriéndose al principio de composición sobre herencia para mejorar la flexibilidad y mantenibilidad.

</details>


<details><summary>2. ¿Observa hook methods? ¿Cuáles?</summary>

Los hook methods en este framework son `allowAccess(Request request)` y `throwException(Request request)`, definidos en la interfaz `Permission`. Estos métodos actúan como ganchos, permitiendo a los implementadores de la interfaz `Permission` definir cómo se manejan las verificaciones de permisos y las excepciones. Esta estructura permite a los usuarios del framework personalizar cómo se gestionan los permisos y las respuestas en caso de acceso denegado, ofreciendo un punto flexible para adaptar el comportamiento del sistema a requerimientos específicos.

</details>


<details><summary>3. ¿Cuál es el Frozen Spot?</summary>

El frozen spot en este framework está representado por la clase `API`, en particular, por la lógica encapsulada en el método `processRequest(Request request)`. Este método establece el flujo de procesamiento de solicitudes, donde siempre se verifica la autorización mediante `checkPermissions(request)` y se manejan las respuestas basadas en si el acceso es permitido o denegado. Este flujo de procesamiento es fijo y no está destinado a ser modificado por los usuarios del framework, garantizando que todas las solicitudes sean procesadas de manera consistente.

</details>

<details><summary>4. ¿En lo que se describe anteriormente y lo que se indica debe hacer quien utiliza el framework, ¿observa inversión de control? ¿dónde?</summary>

Sí, hay una inversión de control evidente en cómo la clase `API` maneja las solicitudes. En lugar de la clase `API` controlar directamente cómo se verifican los permisos, este control se invierte hacia las implementaciones de la interfaz `Permission` que son pasadas al constructor de `API`. Este patrón es un ejemplo clásico de inversión de control, donde el framework (clase `API`) no realiza directamente las tareas de verificación, sino que llama a métodos definidos en objetos que son proporcionados por el usuario del framework (implementaciones de `Permission`), permitiendo que detalles específicos de la autorización sean definidos externamente y pasados al framework para su uso.

</details>

---

![alt text](/Finales/image-4.png)


`1)` Indique, para cada uno de los siguientes items, si es parte de algún hotspot o si no corresponde a ninguno de los dos.

<details><summary> a. El framework se asegura de que la preparación y el desarmado se efectúan antes y después de cada test.</summary>

**Frozen spot:** Esto es parte del frozen spot porque la lógica que maneja el setup (`setUp()`) y el teardown (`tearDown()`) antes y después de cada test es parte del flujo controlado por el framework (`TestCase`) y no está destinado a ser modificado por el usuario.

</details>

<details><summary> b. Al definir una prueba, el programador determina cómo hacer la preparación (si es necesaria).</summary>

**Hotspot:** Esto es un hotspot, ya que permite al desarrollador personalizar cómo se prepara cada prueba al sobrescribir el método `setUp()`.

</details>

<details><summary> c. La clase Test es abstracta.</summary>

**Hotspot:** La clase `Test` ser abstracta es un diseño que requiere que el usuario del framework implemente el método `test()`, lo que indica un punto de extensión o hotspot, ya que permite al usuario definir el comportamiento específico de la prueba.

</details>

<details><summary> d. Al correr un caso de prueba se corren todas las pruebas incluidas en el caso.</summary>

**Frozen spot:** Esto es parte del frozen spot porque la lógica de ejecución de todas las pruebas (`runTests()`) dentro de un caso de prueba está controlada por el framework y no se espera que los usuarios la modifiquen.

</details>

<details><summary>e. Al definir una prueba el programador define los pasos de la prueba (usando los asserts que provee el framework).</summary>

**Hotspot:** Definir los pasos específicos de la prueba y cómo se utilizan los asserts es un hotspot, ya que permite al usuario del framework especificar la lógica de verificación dentro del método `test()` que deben implementar.

</details>

<details><summary>2. ¿Observa métodos gancho? ¿Cuáles?</summary>

Los métodos gancho observados en este framework incluyen:
- **`setUp()`:** Método que puede ser sobrescrito por el usuario para preparar el entorno antes de cada test.
- **`tearDown()`:** Método que puede ser sobrescrito para limpiar después de cada test.
- **`test()`:** Método abstracto que debe ser implementado por el usuario para definir los pasos específicos de la prueba.

</details>

<details><summary>3. ¿Observa inversión de control? ¿Dónde?</summary>

Sí, se observa inversión de control en la manera en que el framework gestiona la ejecución de las pruebas:
- **En `TestCase`:** La clase `TestCase` controla cuándo y cómo se ejecutan los métodos `setUp()`, `test()` y `tearDown()`. No es el código del usuario el que llama a estos métodos directamente, sino el framework quien los invoca en orden específico, lo cual es un claro ejemplo de inversión de control.

</details>

<details><summary>4. ¿Caracterizaría el framework como caja blanca o caja negra? ¿Por qué?</summary>

El framework podría caracterizarse como **caja blanca** debido a que:
- Los usuarios necesitan tener un conocimiento interno de cómo funciona el framework para poder implementar correctamente sus pruebas. Deben saber qué métodos sobrescribir (`setUp()`, `tearDown()`, `test()`) y cómo se comportan en el contexto del flujo de control del framework.
- La estructura del framework y los métodos que deben ser implementados o extendidos son visibles y accesibles para el usuario, lo que es típico de los frameworks de caja blanca.

</details>

---

### Cuadernillo

- [Ejercicio 1 Red Social](#ejercicio-1-red-social)
- [Ejercicio 2 Piedra Papel o Tijera](#ejercicio-2-piedra-papel-o-tijera)
- [Ejercicio 3: Friday the 13th en Java](#ejercicio-3-friday-the-13th-en-java)
- [Ejercicio 3.b - Usando la librería JSON.simple](#ejercicio-3b---usando-la-librería-jsonsimple)
- [Ejercicio 4: Cálculo de sueldos](#ejercicio-4-cálculo-de-sueldos)
- [Ejercicio 5: Media Player](#ejercicio-5-media-player)
- [Ejercicio 6: Topografías](#ejercicio-6-topografías)
- [Ejercicio 6b: Más Topografías](#ejercicio-6b-más-topografías)
- [Ejercicio 7: FileSystem](#ejercicio-7-filesystem)
- [Ejercicio 8: ToDoItem](#ejercicio-8-todoitem)
- [Ejercicio 9: Excursiones](#ejercicio-9-excursiones)
- [Ejercicio 10: Encriptador](#ejercicio-10-encriptador)
- [Ejercicio 11: Administrador de proyectos](#ejercicio-11-administrador-de-proyectos)
- [Ejercicio 12 - Dispositivo móvil y conexiones](#ejercicio-12---dispositivo-móvil-y-conexiones)
- [Ejercicio 13 - Decodificador de películas](#ejercicio-13---decodificador-de-películas)
- [Ejercicio 14: Acceso a la base de datos](#ejercicio-14-acceso-a-la-base-de-datos)
- [Ejercicio 15 - File Manager](#ejercicio-15---file-manager)
- [Ejercicio 16 - Estación meteorológica](#ejercicio-16---estación-meteorológica)
- [Ejercicio 17 - Productos Financieros](#ejercicio-17---productos-financieros)
- [Ejercicio 18 - Sistema de monitoreo](#ejercicio-18---sistema-de-monitoreo)
- [Ejercicio 19 - Personajes de juegos de rol](#ejercicio-19---personajes-de-juegos-de-rol)
- [Ejercicio 19b - Mas Personajes](#ejercicio-19b---mas-personajes)
- [Ejercicio 20 - Filtros de Imágenes](#ejercicio-20---filtros-de-imágenes)
- [Ejercicio 20b - Secuencia de Filtros](#ejercicio-20b---secuencia-de-filtros)
- [Ejercicio 20c - Instanciando Secuencia de Filtros](#ejercicio-20c---instanciando-secuencia-de-filtros)
- [Ejercicio 21 - Genealogía salvaje](#ejercicio-21---genealogía-salvaje)
- [Ejercicio 22 - SubteWay](#ejercicio-22---subteway)
- [Ejercicio 23: Aerolínea Regional](#ejercicio-23-aerolínea-regional)
- [Ejercicio 24 - Monitoreo de proceso industrial](#ejercicio-24---monitoreo-de-proceso-industrial)
- [Ejercicio 25 - Acceso bajo demanda ](#ejercicio-25---acceso-bajo-demanda)

---

### Ejercicio 1 Red Social

Se quiere programar en objetos una versión simplificada de una red social parecida a Twitter. Este servicio debe permitir a los usuarios registrados postear y leer mensajes de hasta 280 caracteres. Ud. debe modelar e implementar parte del sistema donde nos interesa que quede claro lo siguiente:

- Cada usuario conoce todos los Tweets que hizo.
- Un tweet puede ser re-tweet de otro, y este tweet debe conocer a su tweet de origen.
- Twitter debe conocer a todos los usuarios del sistema.
- Los tweets de un usuario se deben eliminar cuando el usuario es eliminado. No existen tweets no referenciados por un usuario.
- Los usuarios se identifican por su screenName.
- No se pueden agregar dos usuarios con el mismo screenName.
- Los tweets deben tener un texto de 1 carácter como mínimo y 280 caracteres como máximo.
- Un re-tweet no tiene texto adicional.

#### Tareas

Su tarea es diseñar y programar en Java lo que sea necesario para ofrecer la funcionalidad antes descrita. Se espera que entregue los siguientes productos.

- Diagrama de clases UML.
- Implementación en Java de la funcionalidad requerida.
- Implementar los tests (JUnit) que considere necesarios.

> Nota: para crear el proyecto Java, lea el material llamado “Trabajando en OO2 con proyectos Maven”.

---

### Ejercicio 2 Piedra Papel o Tijera

Se quiere programar en objetos una versión del juego Piedra Papel o Tijera. En este juego dos jugadores eligen entre tres opciones: piedra, papel o tijera. La piedra aplasta la tijera, la tijera corta el papel, y el papel envuelve la piedra. Los jugadores eligen una opción y se determina un ganador según las reglas: 

Here is the table in text format:

|        | Piedra | Papel | Tijera |
|--------|--------|-------|--------|
| Piedra | Empate | Papel | Piedra |
| Papel  | Papel  | Empate| Tijera |
| Tijera | Piedra | Tijera| Empate |

#### Tareas:

`Ejercicio 1)` Diseñe e implemente una solución a este problema, de forma tal que dadas dos opciones, determine cuál fue la ganadora, o si hubo empate

`Ejercicio 2)` Se desea extender al juego a una versión más equitativa que integre a lagarto y Spock, con las siguientes reglas:

- Piedra aplasta tijera y aplasta lagarto.
- Papel cubre piedra y desaprueba Spock.
- Tijera corta papel y decapita lagarto.
- Lagarto come papel y envenena Spock.
- Spock rompe tijera y vaporiza piedra.

¿Qué cambios se necesitan agregar?

Agregue los cambios a la solución anterior.


---

### Ejercicio 3: Friday the 13th en Java

> Nota: Para realizar este ejercicio, utilice el material adicional que se encuentra en el siguiente [link](https://drive.google.com/file/d/1xCC1uWt8DC_beCwg6vJTb7brcD7_2W7T/view). Allí encontrará un proyecto Maven que contiene el código fuente de las clases Biblioteca, Socio y VoorheesExporter.

La clase Biblioteca implementa la funcionalidad de exportar el listado de sus socios en formato JSON. Para ello define el método **exportarSocios()** de la siguiente forma:

```java
/**
 * Retorna la representación JSON de la colección de socios.
 */
public String exportarSocios() {
   return exporter.exportar(socios);
}
```


La Biblioteca delega la responsabilidad de exportar en una instancia de la clase  VoorheesExporter que dada una colección de socios, retorna un texto con la representación de la misma en formato JSON. Esto lo hace mediante el mensaje de instancia **exportar(List<.Socio>)**. 

De un socio se conoce el nombre, el email y el número de legajo. Por ejemplo, para una biblioteca que posee una colección con los siguientes socios:

<table>
    <tr>
        <td>
            <ul>
                <li>Nombre: Arya Stark</li>
                <li>e-mail: needle@stark.com</li>
                <li>legajo: 5234-5</li>
            </ul>
        </td>
        <td>
            <ul>
                <li>Nombre: Tyron Lannister</li>
                <li>e-mail: tyron@thelannisters.com</li>
                <li>legajo: 2345-2</li>
            </ul>
        </td>
    </tr>
</table>

Ud. puede probar la funcionalidad ejecutando el siguiente código:

```java
Biblioteca biblioteca = new Biblioteca();
biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com",  "2345-2"));
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

Note los corchetes de apertura y cierre de la colección, las llaves de apertura y cierre para cada socio y la coma separando a los socios.

#### Tareas:
- Analice la implementación de la clase Biblioteca, Socio y VoorheesExporter que se provee con el material adicional de esta práctica ([Archivo biblioteca.zip](https://drive.google.com/file/d/1xCC1uWt8DC_beCwg6vJTb7brcD7_2W7T/view)).
- Documente la implementación mediante un diagrama de clases UML. 
- Programe los Test de Unidad para la implementación propuesta.


---

### Ejercicio 3.b - Usando la librería JSON.simple

Su nuevo desafío consiste en utilizar la librería JSON.simple para imprimir en formato JSON a los socios de la Biblioteca en lugar de utilizar la clase VoorheesExporter. Pero con la siguiente condición: **nada de esto debe generar un cambio en el código de la clase Biblioteca.**

La librería JSON.simple es liviana y muy utilizada para leer y escribir archivos JSON.  

Entre las clases que contiene se encuentran:

- JSONObject : Usada para representar los datos que se desean exportar de un objeto.  Esta clase provee el método put(Object, Object) para agregar los campos al mismo. Aunque el primer argumento sea de tipo Object, usted debe proveer el nombre del atributo como un string. El segundo argumento contendrá el valor del mismo. Por ejemplo, si point es una instancia de JSONObject, se podrá ejecutar point.put(“x”, 50);
- JSONArray: Usada para generar listas. Provee el método add(Object) para agregar los elementos a la lista, los cuales, para este caso, deben ser JSONObject.

Ambas clases implementan el mensaje toJSONString() el cual retorna un String con la representación JSON del objeto.

- JSONParser : Usada para recuperar desde un String con formato JSON los elementos que lo componen. 

#### Tareas

`1)` Instale la librería JSON.simple agregando la siguiente dependencia al archivo pom.xml de Maven

```xml
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>
```

`2)` Utilice esta librería para imprimir, en formato JSON, los socios de la Biblioteca en lugar de utilizar la clase VoorheesExporter, sin que esto genere un cambio en el código de la clase Biblioteca.

- Modele una solución a esta alternativa utilizando un diagrama de clases UML. Si utiliza patrones de diseño indique los roles en las clases utilizando estereotipos.
- Implemente en Java la solución incluyendo los tests que crea necesarios.

`3)` Investigue sobre la librería Jackson, la cual también permite utilizar el formato JSON para serializar objetos Java.  Extienda la implementación para soportar también esta librería.

---

### Ejercicio 4: Cálculo de sueldos

Sea una empresa que paga sueldos a sus empleados, los cuales están organizados en tres tipos: Temporarios, Pasantes y Planta. El sueldo se compone de 3 elementos: sueldo básico, adicionales y descuentos.

<table>
    <tr>
        <th></th>
        <th>Temporario</th>
        <th>Pasante</th>
        <th>Planta</th>
    </tr>
    <tr>
        <td>básico</td>
        <td>$ 20.000 + cantidad de horas que trabaje * $ 300.</td>
        <td>$20.000</td>
        <td>$50.000</td>
    </tr>
    <tr>
        <td>adicional</td>
        <td>$5.000 si está casado<br>$2.000 por cada hijo</td>
        <td>$2.000 por examen que rindió</td>
        <td>$5.000 si está casado<br>$2.000 por cada hijo<br>$2.000 por cada año de antigüedad</td>
    </tr>
    <tr>
        <td>descuento</td>
        <td>13% del sueldo básico<br>5% del sueldo adicional</td>
        <td>13% del sueldo básico<br>5% del sueldo adicional</td>
        <td>13% del sueldo básico<br>5% del sueldo adicional</td>
    </tr>
</table>

### Tareas

- Diseñe la jerarquía de Empleados de forma tal que cualquier empleado puede responder al mensaje #sueldo. 
- Desarrolle los test cases necesarios para probar todos los casos posibles.
- Implemente en Java.


---

### Ejercicio 5: Media Player

---

### Ejercicio 6: Topografías

---

### Ejercicio 6b: Más Topografías

---

### Ejercicio 7: FileSystem

---

### Ejercicio 8: ToDoItem

---

### Ejercicio 9: Excursiones

---

### Ejercicio 10: Encriptador

---

### Ejercicio 11: Administrador de proyectos

---

### Ejercicio 12 - Dispositivo móvil y conexiones

---

### Ejercicio 13 - Decodificador de películas

---

### Ejercicio 14: Acceso a la base de datos

---

### Ejercicio 15 - File Manager

---

### Ejercicio 16 - Estación meteorológica

---

### Ejercicio 17 - Productos Financieros

---

### Ejercicio 18 - Sistema de monitoreo

---

### Ejercicio 19 - Personajes de juegos de rol

---

### Ejercicio 19b - Mas Personajes

---

### Ejercicio 20 - Filtros de Imágenes

---

### Ejercicio 20b - Secuencia de Filtros

---

### Ejercicio 20c - Instanciando Secuencia de Filtros

---

### Ejercicio 21 - Genealogía salvaje

---

### Ejercicio 22 - SubteWay

---

### Ejercicio 23: Aerolínea Regional

---

### Ejercicio 24 - Monitoreo de proceso industrial

---

### Ejercicio 25 - Acceso bajo demanda

---