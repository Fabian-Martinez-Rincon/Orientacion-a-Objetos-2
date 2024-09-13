<div align="center"> 

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)
[![GitHub stars](https://img.shields.io/github/stars/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2/stargazers/)
[![GitHub repo size in bytes](https://img.shields.io/github/repo-size/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)


<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=34&duration=1700&pause=800&color=28CDF7&center=true&width=863&lines=☕ Orientación a Objetos 2"/>
 </div>

- [Parciales Frameworks](#parciales-frameworks)
- [Cuadernillo](#cuadernillo)

---

Que hacer ante cada bad smell:
- **Data Expose** (Atributos que son publicos)
    - `Refactoring`: Encapsulate Field
    - `Que hacer`: Pasamos los atributos a privados y en los lugares en donde se usaban los atributos, se cambia por los metodos get y set.
- **Envidia de Atributos** (Nos tenemos que acordar de aplicar el refactor anterior antes de este)
    - `Refactoring`: Move Method to Component
    - `Que hacer`: Mover el metodo a la clase que tiene los atributos que necesita.
- **Long Method** (Casi siempre se corresponde al exceso de responsabilidades)
    - `Refactoring`: Extract Method
    - `Que hacer`: Movemos el codigo a un metodo de la misma clase con un nombre descriptivo

> [!TIP]
> En la consulta me dijeron que no hace falta copiar y pegar el codigo, con explicar el paso a paso de los refactorings basta. Podes usar las reglas que se encuentran arriba.

---

**`Refactoring`**: Transformaciones de código que preservan el comportamiento
- Preservar el comportamiento
- (Hace lo que hacía antes) & (No hace lo que no hacía antes) *

---

#### 1.1 Protocolo de Cliente

La clase Cliente tiene el siguiente protocolo. ¿Cómo puede mejorarlo?


```java
/**
* Retorna el límite de crédito del cliente
*/
protected double lmtCrdt() {...
/**
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double mtFcE(LocalDate f1, LocalDate f2) {...
/**
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
protected double mtCbE(LocalDate f1, LocalDate f2) {...
```

El bad smell es `nombre poco descriptivo` ya que si en un futuro vienen nuevos desarrolladores a trabajar, no van a entender como funciona el código. 

El **refactoring** a utilizar es `rename method`, sobre los metodos. Pero esto no termina aca, el refactoring termina recien cuando en todas las llamadas a estos metodos se cambie el nombre. En caso contrario, no se considera refactoring ya que tendremos errores al llamar un metodo que antes no existia.

Hacemos lo mismo con los parametros pero en este caso, solo hace falta modificarlos en el metodo, ya que la funcionalidad externa se abstrae del nombre de los parametros.

---

#### 1.2 Participación en proyectos

Al revisar el siguiente diseño inicial (Figura 1), se decidió realizar un cambio para evitar lo que se consideraba un mal olor. El diseño modificado se muestra en la Figura 2. Indique qué tipo de cambio se realizó y si lo considera apropiado. Justifique su respuesta.

Diseño inicial:

![image](https://github.com/user-attachments/assets/0a186728-efb2-4feb-9dd0-fc1bd050c2cc)

La clase `Persona` tiene el mal olor de que no cumple con **`el principio de responsabilidad única`**. Se utiliza el refactoring de `move method to component` para mover el metodo `participaEnProyecto` a la clase `Proyecto`.

No se considera un refactoring ya que estas eliminando el metodo del objeto `Persona` esto no preserva el comportamiento en la clase.

Si queremos que de verdad sea un refactoring podemos tener a la clase `Persona` de la siguiente manera:


<table><td>

```java
public class Persona {
    public String id;
    public boolean participaEnProyecto(Proyecto proyecto) {
        return proyecto.participa(this);
    }
}
```
</td><td>

```java
public clase  Proyecto {
    private List<Persona> participantes;
    public boolean participa(Persona persona) {
        return participantes.contains(persona);
    }
}
```
</td></table>

De esta forma, la gente que trabaja con la clase, no se ve afectada por el cambio.

---

#### 1.3 Cálculos

Analice el código que se muestra a continuación. Indique qué defectos encuentra y cómo pueden corregirse.

```java
public void imprimirValores() {
    int totalEdades = 0;
    double promedioEdades = 0;
    double totalSalarios = 0;
    for (Empleado empleado : personal) {
        totalEdades = totalEdades + empleado.getEdad();
        totalSalarios = totalSalarios + empleado.getSalario();
    }
    promedioEdades = totalEdades / personal.size();
    String message = String.format("El promedio de las edades es %s y el total de salarios es %s", promedioEdades, totalSalarios);
    System.out.println(message);
}
```

El mal olor es `Long Method` ya que el metodo esta teniendo muchas responsabilidades como "Calcular el promedio de edades" y "Calcular el total de salarios".

Para mejorar el codigo aplicamos `extract method` y creamos dos metodos `calcularPromedioEdades` y `calcularTotalSalarios`.


