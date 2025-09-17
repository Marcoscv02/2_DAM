[[Pareadigma de Programacion funcional]]

Como sugiere el nombre(`Factory`), es como _una fábrica_ . **La entrada** es un identificador (materia prima) y **la salida** es un producto (producto terminado).

Los patrones de Factory son “ **constructores inteligentes** ”.

![[Pasted image 20250227175413.png]]

## **¿Por qué el método de `Factory`?**

¿Te has encontrado con un escenario en el que la misma funcionalidad se combina con una estructura diferente? Por ejemplo:

- Imagen (gif, jpeg, png).
- Impresora (matricial, de inyección de tinta, láser)

Para manejar estos escenarios, necesitamos instanciar los objetos respectivos, dinámicamente.

## Ejemplo

1. 1. Crear una **interfaz** para contener la estructura básica de los productos.

```java
package products;

public interface IPrinter {
	public void print(String data);
	public boolean stop();
}
```

2. Crear una clase para cada uno de los productos concretos

```java
package products;

public class InkjetPrinter implements IPrinter {

	@Override
	public void print(String data) {
		System.out.println("Inkjet Actions performed on "+data);
	}

	@Override
	public boolean stop() {
		//perform action and then return true on success
		return false;
	}

}
```

```java
package products;

public class DotMatrixPrinter implements IPrinter {

	@Override
	public void print(String data) {
		System.out.println("DotMatrix Actions performed on "+data);
	}

	@Override
	public boolean stop() {
		//perform action and then return true on success
		return false;
	}

}
```

```java
package products;

public class LaserPrinter implements IPrinter {

	@Override
	public void print(String data) {
		System.out.println("Laser Actions performed on "+data);
	}

	@Override
	public boolean stop() {
		//perform action and then return true on success
		return false;
	}

}
```

3. Crear clase Factory

```java
package solver;

import products.DotMatrixPrinter;
import products.IPrinter;
import products.InkjetPrinter;
import products.LaserPrinter;

public class PrinterFactory {
	public static IPrinter createPrinterInstance(String type){
		
		if(type.equalsIgnoreCase("INKJET"))
			return new InkjetPrinter();
		
		else if(type.equalsIgnoreCase("DOTMATRIX"))
			return new DotMatrixPrinter();
		
		else if(type.equalsIgnoreCase("LASER"))
			return new LaserPrinter();
		
		else 
			return null;
		
	}
}
```

4. Creación de Clase `Driver` para gestionar la clase `Factory`

```java
package main;

import products.IPrinter;
/*
 * Somewhat similar to Strategy, but instead of choosing algorithms, we select sub-class
 * <https://www.quora.com/What-is-factory-pattern-design>
 * <https://www.quora.com/How-are-design-patterns-implemented-in-real-life>
 * 
 */

public class FactoryDriver {
	public static void main(String args[]){
		IPrinter printer = PrinterFactory.createPrinterInstance("LASER");
		printer.print("Statement");
		
	}
}
```