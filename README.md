<div align="center"> 

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)
[![GitHub stars](https://img.shields.io/github/stars/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2/stargazers/)
[![GitHub repo size in bytes](https://img.shields.io/github/repo-size/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)](https://github.com/Fabian-Martinez-Rincon/Orientacion-a-Objetos-2)


<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=34&duration=1700&pause=800&color=28CDF7&center=true&width=863&lines=☕ Orientación a Objetos 2"/>
 </div>

Seguro  1 -> Vehiculo
- Covertura de Vida
- Covertura de daños a otros Vehiculos
- Covertura de daños al vehiculo Propio

Seguro > Contra Terceros
Seguro > Terceros Completo
Seguro > Todo Riesgo

Persona N -> Vehiculo
Persona 0.1 -> Promocion

Promocion > Promoción Por múltiples pólizas
Promocion > Promoción Por Campaña Excepcional
Promocion > Sin Promoción

### Vehiculo

```java
public class Vehiculo {
}
```

### Seguro

```java
public abstract class Seguro {
	private Vehiculo vehiculo;
	private Persona asegurado;

	abstract public double CostoDelSeguroDeVida();
	abstract public double CostoCoberturaDaniosTerceros();
	abstract public double CostoCoberturaDestruccionTotal();
}
```

### SeguroContraTerceros

```java
public class SeguroContraTerceros extends Seguro {
	public double CostoDelSeguroDeVida() {
		return 0;
	}
}
```