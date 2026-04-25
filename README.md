# 🌳 ABB Visualizer - Visualizador de Árbol Binario de Búsqueda

## 📋 Descripción General

**ABB Visualizer** es una aplicación interactiva diseñada en Java que permite visualizar, manipular y explorar un **Árbol Binario de Búsqueda (ABB)** de forma gráfica e intuitiva. La aplicación proporciona una interfaz amigable para realizar operaciones fundamentales sobre árboles binarios, incluyendo inserción, eliminación, búsqueda y visualización de diferentes tipos de recorrido.

---

## 🎯 ¿Qué es un Árbol Binario de Búsqueda (ABB)?

Un **Árbol Binario de Búsqueda** es una estructura de datos que cumple con las siguientes propiedades:

- **Cada nodo tiene máximo 2 hijos**: uno izquierdo y uno derecho
- **Propiedad de búsqueda**: 
  - Todos los valores en el subárbol **izquierdo** son **menores** que el valor del nodo
  - Todos los valores en el subárbol **derecho** son **mayores** que el valor del nodo
- **No permite duplicados**: Cada valor es único en el árbol

### Ejemplo de un ABB válido:
```
        5
       / \
      3   7
     / \ / \
    2  4 6  8
```

---

## ✨ Funcionalidades Principales

### 1️⃣ **Insertar Valor**
- Agrega un número nuevo al árbol
- Mantiene automáticamente la propiedad de búsqueda
- **Rechaza duplicados** con un mensaje de advertencia
- **Validación**: Solo acepta números enteros válidos

**Casos de respuesta:**
- ✅ **Éxito**: Valor insertado correctamente (dialogo azul)
- ⚠️ **Duplicado**: El valor ya existe en el árbol (dialogo amarillo)
- ❌ **Error**: Entrada inválida (dialogo rojo)

---

### 2️⃣ **Eliminar Valor**
- Remueve un nodo del árbol
- Mantiene la estructura y propiedad del ABB
- Maneja 4 casos de eliminación:
  1. **Nodo hoja** (sin hijos): Se elimina directamente
  2. **Un hijo derecho**: El hijo reemplaza al nodo
  3. **Un hijo izquierdo**: El hijo reemplaza al nodo
  4. **Dos hijos**: Se busca el sucesor inorden (menor valor del subárbol derecho) para reemplazar

**Casos de respuesta:**
- ✅ **Éxito**: Valor eliminado y árbol redibujado (dialogo azul)
- ❌ **No existe**: El valor no se encontró en el árbol (dialogo rojo)
- ❌ **Error**: Entrada inválida (dialogo rojo)

---

### 3️⃣ **Buscar Valor**
- Realiza una búsqueda binaria eficiente
- Recorre el árbol comparando valores
- **No modifica** el árbol

**Casos de respuesta:**
- ✅ **Encontrado**: El valor existe en el árbol (dialogo azul)
- ⚠️ **No encontrado**: El valor no existe (dialogo amarillo)
- ❌ **Error**: Entrada inválida (dialogo rojo)

---

### 4️⃣ **Recorridos del Árbol**

Los recorridos permiten obtener los elementos del árbol en diferentes órdenes. Se muestran como una secuencia en una ventana emergente.

#### **InOrder (Izquierda-Raíz-Derecha)**
- Visita primero el subárbol izquierdo
- Luego el nodo actual
- Finalmente el subárbol derecho
- **Resultado**: Números en orden ascendente

**Ejemplo:** Para el árbol anterior → `2 3 4 5 6 7 8`

#### **PreOrder (Raíz-Izquierda-Derecha)**
- Visita primero el nodo actual
- Luego el subárbol izquierdo
- Finalmente el subárbol derecho
- **Uso**: Copiar el árbol o generar una expresión prefija

**Ejemplo:** Para el árbol anterior → `5 3 2 4 7 6 8`

#### **PostOrder (Izquierda-Derecha-Raíz)**
- Visita primero el subárbol izquierdo
- Luego el subárbol derecho
- Finalmente el nodo actual
- **Uso**: Eliminar el árbol o generar una expresión postfija

**Ejemplo:** Para el árbol anterior → `2 4 3 6 8 7 5`

**Casos de respuesta:**
- ✅ **Éxito**: Se muestra la secuencia de nodos (dialogo azul)
- ❌ **Error**: Árbol vacío, no se puede ejecutar (dialogo rojo)

---

## 🚀 Cómo Usar la Aplicación

### Paso 1: Iniciar la Aplicación
```bash
# Ejecuta el proyecto compilado
java -cp target/classes com.example.Main
```

La ventana principal se abrirá con la interfaz gráfica.

### Paso 2: Familiarizarse con la Interfaz

```
┌─────────────────────────────────────────────────────────┐
│ Valor: [_____] [Insertar] [Eliminar] [Buscar]          │
│        [InOrder] [PreOrder] [PostOrder]                │
├─────────────────────────────────────────────────────────┤
│                                                         │
│                    ÁREA DE VISUALIZACIÓN               │
│              (Aquí se dibuja el árbol)                 │
│                                                         │
│  (Los nodos aparecen como círculos blancos con líneas) │
└─────────────────────────────────────────────────────────┘
```

### Paso 3: Operaciones Básicas

#### **Insertar un Valor:**
1. Escriba un número en el campo de texto (ej: `5`)
2. Haga clic en el botón **"Insertar"**
3. El árbol se redibuja automáticamente
4. Se muestra un diálogo confirmando el resultado

#### **Eliminar un Valor:**
1. Escriba el número a eliminar (ej: `5`)
2. Haga clic en el botón **"Eliminar"**
3. El árbol se redibuja automáticamente
4. Se muestra un diálogo confirmando el resultado

#### **Buscar un Valor:**
1. Escriba el número a buscar (ej: `5`)
2. Haga clic en el botón **"Buscar"**
3. Se muestra un diálogo indicando si existe o no

#### **Ver Recorridos:**
1. Haga clic en cualquiera de los botones: **"InOrder"**, **"PreOrder"** o **"PostOrder"**
2. Se abrirá una ventana mostrando la secuencia de nodos

---

## 📁 Estructura del Proyecto

```
ArbolesDinamicos/
└── demo/
    ├── pom.xml                          (Configuración Maven)
    ├── README.md                        (Este archivo)
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       └── com/example/
    │   │           ├── Main.java                    (Punto de entrada)
    │   │           ├── Vista/
    │   │           │   └── VisualizadorABB.java   (Interfaz gráfica)
    │   │           └── Model/
    │   │               └── ArbolBase/
    │   │                   ├── Node.java            (Nodo del árbol)
    │   │                   └── Tree.java            (Implementación del ABB)
    │   └── test/
    │       └── java/                    (Tests futuros)
    └── target/
        └── classes/                     (Archivos compilados)
```

### Descripción de Archivos Clave:

| Archivo | Descripción |
|---------|-------------|
| **Main.java** | Punto de entrada de la aplicación. Inicializa Swing y muestra la ventana principal. |
| **VisualizadorABB.java** | Interfaz gráfica (Vista). Contiene todos los componentes Swing, botones y eventos. |
| **Tree.java** | Implementación del Árbol Binario de Búsqueda. Contiene la lógica de inserción, eliminación, búsqueda y recorridos. |
| **Node.java** | Clase que representa un nodo individual del árbol. Almacena el valor y referencias a los hijos. |

---

## 🔧 Requisitos Técnicos

- **Java**: JDK 11 o superior
- **Maven**: Para compilar y ejecutar el proyecto
- **Sistema Operativo**: Windows, macOS o Linux
- **RAM mínima**: 512 MB
- **Pantalla**: Resolución mínima 800x600 píxeles

---

## 🏗️ Detalles Técnicos

### Clase Node<T>
```java
- Genérica: Puede almacenar cualquier tipo comparable
- Atributos:
  * value: El valor almacenado
  * left: Referencia al hijo izquierdo
  * right: Referencia al hijo derecho
- Métodos: Getters, setters y compareTo()
```

### Clase Tree<T>
```java
- Genérica: Implementa ABB para cualquier tipo comparable
- Métodos principales:
  * put(T data): Inserta un valor (retorna boolean)
  * remove(T data): Elimina un valor (retorna boolean)
  * binarySearch(T data): Busca un valor (retorna boolean)
  * inOrder(), preOrder(), postOrder(): Retornan String con recorrido
- Utiliza recursión para todas las operaciones
- Mantiene un contador de tamaño (size)
```

### Algoritmos Utilizados

#### **Inserción (O(log n) promedio)**
1. Si el árbol está vacío, crea la raíz
2. Si no, compara el nuevo valor con el nodo actual
3. Si es menor, va a la izquierda
4. Si es mayor, va a la derecha
5. Rechaza duplicados

#### **Eliminación (O(log n) promedio)**
1. Busca el nodo a eliminar
2. **Si no tiene hijos**: Simplemente se elimina
3. **Si tiene un hijo**: El hijo reemplaza al padre
4. **Si tiene dos hijos**: 
   - Encuentra el sucesor inorden (nodo mínimo del subárbol derecho)
   - Reemplaza el valor con el del sucesor
   - Elimina el sucesor

#### **Búsqueda (O(log n) promedio)**
1. Compara el valor buscado con el nodo actual
2. Si es igual, retorna true
3. Si es menor, busca en el subárbol izquierdo
4. Si es mayor, busca en el subárbol derecho

---

## 🎨 Interfaz Gráfica

### Componentes:

1. **Campo de Texto**: Entrada para números
2. **Botones de Operación**: Insertar, Eliminar, Buscar
3. **Botones de Recorrido**: InOrder, PreOrder, PostOrder
4. **Área de Visualización**: 
   - Dibuja el árbol en tiempo real
   - Nodos como círculos blancos con valor
   - Líneas grises conectando padres e hijos
   - Offset dinámico para mejor visualización

### Diálogos (JOptionPane):

| Tipo | Color | Uso |
|------|-------|-----|
| INFORMATION_MESSAGE | Azul | Operaciones exitosas |
| WARNING_MESSAGE | Amarillo | Advertencias (duplicados, no encontrado) |
| ERROR_MESSAGE | Rojo | Errores (entrada inválida, árbol vacío) |

---

## 💡 Ejemplo de Uso Paso a Paso

### Escenario: Crear un árbol y explorar sus recorridos

**Pasos:**
1. Inicie la aplicación: `java -cp target/classes com.example.Main`
2. Inserte los números: 5, 3, 7, 2, 4, 6, 8 (en ese orden)
   - Campo: `5` → Click "Insertar" ✓
   - Campo: `3` → Click "Insertar" ✓
   - Campo: `7` → Click "Insertar" ✓
   - (... continúe con los demás)
3. Verá un árbol dibujado como:
   ```
           ⭕5
          /  \
        ⭕3  ⭕7
        / \  / \
      ⭕2⭕4⭕6⭕8
   ```
4. Pruebe los recorridos:
   - Click "InOrder" → Verá: `2 3 4 5 6 7 8`
   - Click "PreOrder" → Verá: `5 3 2 4 7 6 8`
   - Click "PostOrder" → Verá: `2 4 3 6 8 7 5`

---

## ⚠️ Limitaciones y Comportamiento

- ✅ Solo acepta **números enteros**
- ✅ **No permite valores duplicados**
- ✅ El árbol se redibuja automáticamente después de cada inserción/eliminación
- ✅ La visualización se ajusta automáticamente al tamaño de la ventana
- ✅ El campo de texto se limpia automáticamente después de operaciones exitosas

---

## 🔍 Solución de Problemas

| Problema | Solución |
|----------|----------|
| **"Ingrese un número válido"** | Asegúrese de escribir solo dígitos enteros |
| **"El valor X ya existe"** | No puede insertar valores duplicados |
| **"El valor X no existe"** | Verifique que el número fue insertado previamente |
| **"Árbol vacío"** | Primero debe insertar al menos un número |
| **El árbol no se dibuja** | Haga clic en un botón para disparar un redibujado |

---

## 📚 Conceptos Educativos

Esta aplicación es útil para aprender:

- Estructuras de datos: Árboles binarios de búsqueda
- Algoritmos de inserción, eliminación y búsqueda
- Recursión en programación
- Recorridos en profundidad (DFS)
- Interfaz gráfica con Swing
- Patrones de diseño (MVC: Model-View-Control)
- Genéricos en Java

---

## 🎓 Autor

Proyecto desarrollado como parte de la asignatura **Estructura de Datos**

---

## 📝 Notas Finales

- La aplicación está optimizada para demostración y educación
- El tamaño máximo del árbol está limitado por la memoria disponible y el espacio visual
- Para árboles muy grandes, la visualización puede ser menos clara
- Se recomienda no insertar más de 20-30 nodos para una visualización óptima

---

**¡Disfrute explorando Árboles Binarios de Búsqueda con ABB Visualizer!** 🌳✨
