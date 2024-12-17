# Sistema de Subastas Distribuidas con RMI y Callbacks

## Descripción
**Proyecto Creado Por:** Ing. Fabrizio Castro  

Este proyecto implementa un **sistema distribuido de subastas** utilizando **Java RMI (Remote Method Invocation)** con **callbacks**. Permite a un servidor administrar una subasta en tiempo real y a múltiples clientes participar, realizar ofertas y recibir **notificaciones automáticas** sobre el estado de la subasta.

---

## Componentes Principales

### **Servidor de Subasta**
- **Inicia el registro RMI** y publica el objeto remoto.
- **Administra el estado de la subasta**, incluyendo la mejor oferta y el mejor postor.
- **Envía notificaciones a los clientes** cuando ocurren cambios en la subasta.

### **Cliente de Subasta**
- Permite a los usuarios:
  - **Participar en la subasta** realizando ofertas.
  - **Consultar el estado actual** (mejor oferta y postor).
  - **Retirarse** de la subasta.
- **Notificaciones mediante Callback:**
  - Los clientes registrados reciben **actualizaciones en tiempo real** sobre nuevas ofertas, cambios de postor o finalización de la subasta.

---

## Funcionalidades

### **Servidor**
1. **Registro de Clientes:**
   - Los clientes se registran para participar y recibir notificaciones.
2. **Administración de Ofertas:**
   - Valida que las nuevas ofertas sean **mayores** a la oferta actual.
3. **Notificaciones en Tiempo Real:**
   - Envía actualizaciones a todos los clientes mediante **callbacks**.
4. **Finalización Automática:**
   - Si todos los clientes se retiran, la subasta finaliza automáticamente.

### **Cliente**
1. **Registrar Cliente:**
   - Conexión al servidor y registro para participar en la subasta.
2. **Realizar Ofertas:**
   - Permite al usuario ingresar ofertas válidas.
3. **Consultar el Estado:**
   - Visualiza la **mejor oferta** y el **mejor postor** actual.
4. **Retirarse de la Subasta:**
   - El cliente puede abandonar la subasta en cualquier momento.

---

## Estructura del Proyecto

### **Clases Principales**
1. **Servidor**
   - `ServidorSubasta.java`:  
     Inicializa el servidor RMI y publica el objeto remoto de la subasta.
   - `SubastaImpl.java`:  
     Implementación de la lógica de la subasta.
   - `SubastaInterfaz.java`:  
     Interfaz remota que define las operaciones disponibles para los clientes.

2. **Cliente**
   - `ClienteSubasta.java`:  
     Cliente que permite a los usuarios interactuar con la subasta (realizar ofertas, consultar estado, retirarse).
   - `ClienteCallback.java`:  
     Interfaz remota que define el callback para recibir notificaciones.
   - `ClienteCallbackImpl.java`:  
     Implementación del callback que maneja las notificaciones del servidor.

---

## Uso del Sistema

### Iniciar el Servidor
```bash
java ServidorSubasta
```

### Ejecutar Clientes
```bash
java ClienteSubasta
```

### Pasos de Participación
1. **Iniciar el Servidor de Subasta**
2. **Conectar Clientes**
3. **Participar en la Subasta:**
   * Realizar ofertas válidas
   * Consultar la mejor oferta y el mejor postor
   * Retirarse de la subasta
4. **Notificaciones en Tiempo Real:**
   * Recibir actualizaciones automáticas sobre:
     - Nuevas ofertas
     - Cambios de mejor postor
     - Finalización de la subasta

## Requisitos
* **Java JDK:** Versión 8 o superior
* **Red Local o Internet:** Necesaria para la comunicación RMI entre servidor y clientes

## Notas Importantes
* Asegúrate de que el **servidor esté en funcionamiento** antes de iniciar los clientes
* Configura correctamente la red o los parámetros RMI si trabajas en diferentes equipos
* El sistema valida las ofertas y finaliza la subasta automáticamente cuando no hay participantes activos
