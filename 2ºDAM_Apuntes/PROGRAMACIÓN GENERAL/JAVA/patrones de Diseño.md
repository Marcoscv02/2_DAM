[[Patrón Factory]]
Los patrones de diseño son soluciones comprobadas a problemas recurrentes en el desarrollo de software. A continuación, veremos los más conocidos y cómo se aplican, junto con ejemplos y detalles visuales.

---

## **1. Modelo-Vista-Controlador (MVC) 🖼️📦**

|**Componente**|**Descripción**|**Ejemplo**|
|---|---|---|
|**Modelo**|Maneja la lógica de negocio y los datos.|Base de datos, clases de negocio.|
|**Vista**|Renderiza la interfaz gráfica.|HTML, CSS, plantillas.|
|**Controlador**|Coordina las interacciones entre Vista y Modelo.|Enrutadores, controladores.|

### 📋 **Diagrama Conceptual**

```markdown
 Usuario ↔ Controlador ↔ Modelo ↔ Base de Datos
            ↕
          Vista
```

### ✏️ **Ejemplo de Código (Python + Flask)**

```python
# Modelo
class User:
    def __init__(self, name):
        self.name = name

# Controlador
from flask import Flask, render_template
app = Flask(__name__)

@app.route("/")
def home():
    user = User("Alice")
    return render_template("index.html", name=user.name)

# Vista (index.html)
<!-- HTML -->
<h1>Hola, {{ name }}!</h1>

```

---

## **2. Patrón Singleton 🧍‍♂️**

Garantiza que una clase tenga **una sola instancia** durante el ciclo de vida de la aplicación.

### 🎯 **Uso Común**: Registro de logs, configuraciones globales.

### ✏️ **Ejemplo de Código (Python)**

```python
class Singleton:
    _instance = None

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super(Singleton, cls).__new__(cls, *args, **kwargs)
        return cls._instance

# Uso
singleton1 = Singleton()
singleton2 = Singleton()
print(singleton1 is singleton2)  # True

```

---

## **3. Patrón Observador (Observer) 👀**

Define una relación **uno-a-muchos** donde los objetos (observadores) son notificados cuando cambia el estado de un sujeto.

### 🎯 **Uso Común**:

- Interfaces de usuario (eventos de clic).
- Publicación-suscripción (sistemas de notificaciones).

### 📋 **Diagrama Conceptual**

```scss
Sujeto ↔ Observadores
 (Notifica cambios)
```

### ✏️ **Ejemplo de Código (Python)**

```python
class Subject:
    def __init__(self):
        self.observers = []

    def attach(self, observer):
        self.observers.append(observer)

    def notify(self, message):
        for observer in self.observers:
            observer.update(message)

class Observer:
    def update(self, message):
        print(f"Recibido: {message}")

# Uso
subject = Subject()
observer1 = Observer()
subject.attach(observer1)

subject.notify("Cambio detectado!")  # Recibido: Cambio detectado!
```

---

## **4. Patrón Fábrica (Factory) 🏭**

Proporciona una forma de crear objetos sin especificar la clase exacta a instanciar.

### 🎯 **Uso Común**:

- Crear objetos complejos.
- Polimorfismo.

### 📋 **Diagrama Conceptual**

```r
Cliente ↔ Fábrica ↔ Producto
```

### ✏️ **Ejemplo de Código (Python)**

```python
class Animal:
    def speak(self):
        pass

class Dog(Animal):
    def speak(self):
        return "Woof!"

class Cat(Animal):
    def speak(self):
        return "Meow!"

class AnimalFactory:
    @staticmethod
    def create_animal(type_):
        if type_ == "dog":
            return Dog()
        elif type_ == "cat":
            return Cat()

# Uso
animal = AnimalFactory.create_animal("dog")
print(animal.speak())  # Woof!
```

---

## **5. Patrón Decorador (Decorator) 🎨**

Permite **extender** la funcionalidad de un objeto **dinámicamente**, sin modificar su estructura.

### 🎯 **Uso Común**:

- Añadir características a objetos.
- Logging, autenticación.

### 📋 **Diagrama Conceptual**

```
Objeto ↔ Decorador 1 ↔ Decorador 2
```

### ✏️ **Ejemplo de Código (Python)**

```python
def bold_decorator(func):
    def wrapper():
        return f"<b>{func()}</b>"
    return wrapper

@bold_decorator
def say_hello():
    return "Hola Mundo!"

# Uso
print(say_hello())  # <b>Hola Mundo!</b>

```

---

## **6. Patrón Estado (State) 🚦**

Permite que un objeto cambie su comportamiento basado en su estado interno.

### 🎯 **Uso Común**:

- Máquinas de estados (Ej: semáforos).
- Sistemas de flujos.

### 📋 **Diagrama Conceptual**

```
CopiarEditar
Estado Actual ↔ Contexto ↔ Próximo Estado

```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class TrafficLightState:
    def handle(self):
        pass

class RedLight(TrafficLightState):
    def handle(self):
        print("STOP")

class GreenLight(TrafficLightState):
    def handle(self):
        print("GO")

class TrafficLight:
    def __init__(self):
        self.state = RedLight()

    def change_state(self, state):
        self.state = state

    def operate(self):
        self.state.handle()

# Uso
light = TrafficLight()
light.operate()  # STOP
light.change_state(GreenLight())
light.operate()  # GO

```

---

## **7. Patrón Cadena de Responsabilidad (Chain of Responsibility) 🔗**

Permite que una solicitud pase a través de una **cadena de manejadores** hasta que uno de ellos la procese.

### 🎯 **Uso Común**:

- Procesamiento de eventos.
- Validación.

### 📋 **Diagrama Conceptual**

```
CopiarEditar
Cliente ↔ Handler 1 ↔ Handler 2 ↔ Handler 3

```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class Handler:
    def __init__(self, successor=None):
        self.successor = successor

    def handle(self, request):
        if self.successor:
            self.successor.handle(request)

class ConcreteHandler1(Handler):
    def handle(self, request):
        if request < 10:
            print(f"Handler1 procesó {request}")
        else:
            super().handle(request)

class ConcreteHandler2(Handler):
    def handle(self, request):
        if request >= 10:
            print(f"Handler2 procesó {request}")
        else:
            super().handle(request)

# Uso
handler_chain = ConcreteHandler1(ConcreteHandler2())
handler_chain.handle(5)   # Handler1 procesó 5
handler_chain.handle(15)  # Handler2 procesó 15

```

---

## **7. Patrón Cadena de Responsabilidad (Chain of Responsibility) 🔗**

Permite que una solicitud pase a través de una **cadena de manejadores** hasta que uno de ellos la procese.

### 🎯 **Uso Común**:

- Procesamiento de eventos.
- Validación.

### 📋 **Diagrama Conceptual**

```
Cliente ↔ Handler 1 ↔ Handler 2 ↔ Handler 3
```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class Handler:
    def __init__(self, successor=None):
        self.successor = successor

    def handle(self, request):
        if self.successor:
            self.successor.handle(request)

class ConcreteHandler1(Handler):
    def handle(self, request):
        if request < 10:
            print(f"Handler1 procesó {request}")
        else:
            super().handle(request)

class ConcreteHandler2(Handler):
    def handle(self, request):
        if request >= 10:
            print(f"Handler2 procesó {request}")
        else:
            super().handle(request)

# Uso
handler_chain = ConcreteHandler1(ConcreteHandler2())
handler_chain.handle(5)   # Handler1 procesó 5
handler_chain.handle(15)  # Handler2 procesó 15

```

---

¡Espero que esta presentación más visual y detallada te sea útil! Si necesitas más patrones o explicación, avísame. 🚀

4o

### Tú dijiste:

continua hasta todos los que has puesto antes

### ChatGPT Plus

ChatGPT

¡Claro! Continuemos con el resto de los patrones mencionados anteriormente, manteniendo el formato visual, con ejemplos, tablas y diagramas. 🚀✨

---

## **8. Patrón Estrategia (Strategy) ♟️**

El patrón Estrategia define una **familia de algoritmos**, los encapsula en clases separadas y los hace intercambiables sin modificar el código cliente.

### 🎯 **Uso Común**:

- Cálculo de costos, impuestos.
- Métodos de encriptación o compresión.

### 📋 **Diagrama Conceptual**

```markdown
markdown
CopiarEditar
Contexto ↔ Estrategia 1
           Estrategia 2
           Estrategia 3

```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class Strategy:
    def execute(self, a, b):
        pass

class AddStrategy(Strategy):
    def execute(self, a, b):
        return a + b

class MultiplyStrategy(Strategy):
    def execute(self, a, b):
        return a * b

class Context:
    def __init__(self, strategy):
        self.strategy = strategy

    def set_strategy(self, strategy):
        self.strategy = strategy

    def execute_strategy(self, a, b):
        return self.strategy.execute(a, b)

# Uso
context = Context(AddStrategy())
print(context.execute_strategy(5, 3))  # 8

context.set_strategy(MultiplyStrategy())
print(context.execute_strategy(5, 3))  # 15

```

---

## **9. Patrón Adaptador (Adapter) 🔌**

Permite que dos interfaces incompatibles trabajen juntas al usar una clase puente que traduce las llamadas entre ellas.

### 🎯 **Uso Común**:

- Integrar APIs de terceros.
- Soporte de sistemas heredados.

### 📋 **Diagrama Conceptual**

```
CopiarEditar
Cliente ↔ Adaptador ↔ Servicio Incompatible

```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class OldSystem:
    def old_method(self):
        return "Sistema Antiguo"

class Adapter:
    def __init__(self, old_system):
        self.old_system = old_system

    def new_method(self):
        return self.old_system.old_method()

# Uso
old_system = OldSystem()
adapter = Adapter(old_system)
print(adapter.new_method())  # Sistema Antiguo

```

---

## **10. Patrón Fachada (Facade) 🏢**

Proporciona una **interfaz simplificada** para un subsistema complejo.

### 🎯 **Uso Común**:

- Simplificar el uso de bibliotecas complejas.
- Proveer una API más amigable.

### 📋 **Diagrama Conceptual**

```
CopiarEditar
Cliente ↔ Fachada ↔ Subsistema Complejo

```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class SubsystemA:
    def operation_a(self):
        return "Operación A"

class SubsystemB:
    def operation_b(self):
        return "Operación B"

class Facade:
    def __init__(self):
        self.a = SubsystemA()
        self.b = SubsystemB()

    def simple_operation(self):
        return f"{self.a.operation_a()} + {self.b.operation_b()}"

# Uso
facade = Facade()
print(facade.simple_operation())  # Operación A + Operación B

```

---

## **11. Patrón Proxy 🕵️**

Actúa como un **intermediario** para controlar el acceso a un objeto.

### 🎯 **Uso Común**:

- Implementar caché.
- Control de acceso o permisos.

### 📋 **Diagrama Conceptual**

```jsx
javascript
CopiarEditar
Cliente ↔ Proxy ↔ Objeto Real

```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class RealService:
    def request(self):
        return "Respuesta del Servicio Real"

class Proxy:
    def __init__(self, real_service):
        self.real_service = real_service

    def request(self):
        print("Proxy: Verificando acceso...")
        return self.real_service.request()

# Uso
real_service = RealService()
proxy = Proxy(real_service)
print(proxy.request())  # Proxy: Verificando acceso... Respuesta del Servicio Real

```

---

## **12. Patrón Repositorio (Repository) 📂**

Abstrae el acceso a los datos y proporciona una interfaz común para interactuar con ellos.

### 🎯 **Uso Común**:

- Gestión de bases de datos.
- Abstracción de ORM (Object Relational Mapping).

### 📋 **Diagrama Conceptual**

```
CopiarEditar
Aplicación ↔ Repositorio ↔ Base de Datos

```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class Repository:
    def __init__(self):
        self.data = {}

    def add(self, id, value):
        self.data[id] = value

    def get(self, id):
        return self.data.get(id, None)

# Uso
repo = Repository()
repo.add(1, "Usuario 1")
print(repo.get(1))  # Usuario 1

```

---

## **13. Patrón Command (Comando) 🎮**

Encapsula una **solicitud como un objeto**, permitiendo operaciones como deshacer/rehacer.

### 🎯 **Uso Común**:

- Implementar menús.
- Operaciones deshacer/rehacer.

### 📋 **Diagrama Conceptual**

```
CopiarEditar
Cliente ↔ Invocador ↔ Comando ↔ Receptor

```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class Command:
    def execute(self):
        pass

class LightOnCommand(Command):
    def execute(self):
        print("Luz encendida")

class LightOffCommand(Command):
    def execute(self):
        print("Luz apagada")

class Invoker:
    def __init__(self):
        self.commands = []

    def store_command(self, command):
        self.commands.append(command)

    def execute_commands(self):
        for command in self.commands:
            command.execute()

# Uso
invoker = Invoker()
invoker.store_command(LightOnCommand())
invoker.store_command(LightOffCommand())
invoker.execute_commands()

```

---

## **14. Patrón Builder (Constructor) 🏗️**

Separa la construcción de un objeto complejo de su representación.

### 🎯 **Uso Común**:

- Construcción de objetos con múltiples configuraciones.

### 📋 **Diagrama Conceptual**

```
CopiarEditar
Director ↔ Constructor ↔ Producto

```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class Builder:
    def __init__(self):
        self.product = ""

    def add_part_a(self):
        self.product += "Parte A "

    def add_part_b(self):
        self.product += "Parte B "

    def get_result(self):
        return self.product

# Uso
builder = Builder()
builder.add_part_a()
builder.add_part_b()
print(builder.get_result())  # Parte A Parte B

```

---

## **15. Patrón Puente (Bridge) 🌉**

Separa una abstracción de su implementación, permitiendo que ambas evolucionen de manera independiente.

### 🎯 **Uso Común**:

- Interfaces de dispositivos.
- Drivers.

### 📋 **Diagrama Conceptual**

```
CopiarEditar
Abstracción ↔ Implementación

```

### ✏️ **Ejemplo de Código (Python)**

```python
python
CopiarEditar
class Device:
    def on(self):
        pass

    def off(self):
        pass

class TV(Device):
    def on(self):
        print("TV encendida")

    def off(self):
        print("TV apagada")

class Remote:
    def __init__(self, device):
        self.device = device

    def toggle_power(self):
        self.device.on()
        self.device.off()

# Uso
tv = TV()
remote = Remote(tv)
remote.toggle_power()

```