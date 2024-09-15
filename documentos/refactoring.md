## Como actuar ante los malos olores

---

- [Declaración de atributos pública](#declaración-de-atributos-pública)
- [Mala asignación de responsabilidades](#mala-asignación-de-responsabilidades)

---

### Declaración de atributos pública

La declaración pública de atributos de una clase, genera una ruptura del encapsulamiento. Declaramos los atributos como privados y hacemos que se acceda a ellos sólo a través de los getters y setters.

<table>
<tr><td>Antes del Refactoring</td><td>Encapsulate Field</td></tr>
<tr><td>

```java
public class Persoona {
    public List<Llamada> lista1 = new ArrayList<Llamada>();
    public String t;
    public String nya;
    public String tel;
    public String cuit;
    public String doc;
    public Persoona1 sis;
}
```

```java
else if (t.equals("juridica")) {
    String tel = lista3.guia.last();
    lista3.guia.remove(tel);
    var.nya = nombre;
    var.t = t;
    var.tel = tel;
    var.cuit = data;
    var.sis = this;
}
```
</td><td>

```java
public class Persoona {
    private List<Llamada> lista1 = new ArrayList<Llamada>();
    private String t;
    private String nya;
    private String tel;
    private String cuit;
    private String doc;
    private Persoona1 sis;
}
```

```java
else if (t.equals("juridica")) {
    String tel = lista3.guia.last();
    lista3.guia.remove(tel);
    var.setNya(nombre);
    var.setT(t);
    var.setTel(tel);
    var.setCuit(data);
}
var.setSis(this);
```
</td></tr>

</table>





## Mala asignación de responsabilidades

Se observa una mala asignación de responsabilidades en la clase X que en la mayoria de las veces esta asociada a una evidente envidia de atributos.

- [Move Method](#move-method)

### Move Method

En este ejemplo, la clase `Persoona` no deberia tener esta responsabilidad, y la delegamos a la clase `GuiaTelefonica`. `Move Method` Del metodo `agregarTelefono` a la clase GuiaTelefonica

Mecánica `Move Method`:
1. Revisar las v.i. usadas por el método a mover. Tiene sentido moverlas también?
2. Revisar super y subclases por otras declaraciones del método. Si hay otras tal vez no se pueda mover.
3. Crear un nuevo método en la clase target cuyo nombre explique su propósito
4. Copiar el código a mover al nuevo método. Ajustar lo que haga falta
5. Compilar la clase target
6. Determinar como referenciar al target desde el source
7. Reemplazar el método original por llamada a método en target
8. Compilar y testear
9. Decidir si remover el método original o mantenerlo como delegación


<table>
<tr><td>Antes del Refactoring</td><td>Despues del Refactoring</td></tr>
<tr><td>

```java
public Class Persoona{
    public boolean agregarTelefono(String str) {
        boolean encontre = lista3.guia.contains(str);
        if (!encontre) {
            lista3.guia.add(str);
            encontre = true;
            return encontre;
        } else {
            encontre = false;
            return encontre;
        }
    }
}
```
</td><td>

```java
public class Persoona {
    public boolean agregarTelefono(String str) {
        return this.lista3.agregarTelefono(str);
    }
}
public class GuiaTelefonica {
    public boolean agregarTelefono(String str) {
        boolean encontre = guia.contains(str);
        if (!encontre) {
            guia.add(str);
            encontre = true;
            return encontre;
        } else {
            encontre = false;
            return encontre;
        }
    }
}
```
</td></tr>
</table>


---

### Extract Method y Move Method

`Extract Method` del método `obtenerNuevoTelefono` y despues un `Move Method` a la clase GuiaTelefonica

<table>
<tr><td>Antes del refactoring</td><td>Extract Method</td><td>Move Method</td></tr>

<tr>
<td>

```java
public Persoona registrarUsuario(String data, String nombre, String t) {
    Persoona var = new Persoona();
    if (t.equals("fisica")) {
        var.setNya(nombre);
        String tel = lista3.guia.last();
        lista3.guia.remove(tel);
        var.setT(t);
        var.setTel(tel);
        var.setDoc(data);
    } else if (t.equals("juridica")) {
        String tel = lista3.guia.last();
        lista3.guia.remove(tel);
        var.setNya(nombre);
        var.setT(t);
        var.setTel(tel);
        var.setCuit(data);
    }
    var.setSis(this);
    lista1.add(var);
    return var;
}
```
</td>

<td>

```java
public class Persoona {
    public String obtenerNuevoTelefono() {
        String tel = this.guia.last();
        this.guia.remove(tel);
        return tel;
    }
    public Persoona registrarUsuario(String data, String nombre, String t) {
        Persoona var = new Persoona();
        if (t.equals("fisica")) {
            var.setNya(nombre);
            String tel = this.obtenerNuevoTelefono();
            var.setT(t);
            var.setTel(tel);
            var.setDoc(data);
        } else if (t.equals("juridica")) {
            String tel = this.obtenerNuevoTelefono();
            var.setNya(nombre);
            var.setT(t);
            var.setTel(tel);
            var.setCuit(data);
        }
        var.setSis(this);
        lista1.add(var);
        return var;
    }
}
```
</td><td>

```java
public class GuiaTelefonica {
    public String obtenerNuevoTelefono() {
        String tel = this.guia.last();
        this.guia.remove(tel);
        return tel;
    }
}
public class Persoona{
    public Persoona registrarUsuario(String data, String nombre, String t) {
        Persoona var = new Persoona();
        if (t.equals("fisica")) {
            var.setNya(nombre);
            String tel = this.lista3.obtenerNuevoTelefono();
            var.setT(t);
            var.setTel(tel);
            var.setDoc(data);
        } else if (t.equals("juridica")) {
            String tel = this.lista3.obtenerNuevoTelefono();
            var.setNya(nombre);
            var.setT(t);
            var.setTel(tel);
            var.setCuit(data);
        }
        var.setSis(this);
        lista1.add(var);
        return var;
    }
}
```
</td></tr>
</table>


---
