Proyecto Creado Por Ing. Fabrizio Castro

Componentes Principales:

Servidor de Subasta:
-Inicia el registro RMI y publica el objeto remoto.
-Administra el estado de la subasta, incluyendo la mejor oferta y el mejor postor.

Cliente de Subasta:
-Permite a los usuarios participar en la subasta realizando ofertas, consultando el estado actual o retirándose de la subasta.
-Notificaciones mediante Callback:
-Los clientes registrados reciben actualizaciones en tiempo real sobre los cambios en el estado de la subasta (nuevas ofertas, ganadores, etc.).

Funcionalidades:
-Registro de Clientes: Los clientes se registran para participar en la subasta y recibir notificaciones.
-Realización de Ofertas: Los usuarios pueden realizar ofertas, y el sistema valida que sean mayores a la oferta actual.
-Consulta del Estado de la Subasta: Los participantes pueden consultar la mejor oferta y el mejor postor actual.
-Retiro de Participación: Los usuarios pueden retirarse de la subasta. Si todos los participantes se retiran, la subasta termina automáticamente.
-Notificaciones en Tiempo Real: Los cambios en la subasta se comunican a todos los clientes registrados mediante callbacks.

Funciones:

Servidor:
-Inicia la subasta: Publica el objeto remoto y administra la lógica de la subasta.
-Notifica a los clientes: Utiliza callbacks para enviar actualizaciones en tiempo real.

Cliente:
-Registrar cliente: Se conecta al servidor y recibe notificaciones.
-Realizar ofertas: Valida que las ofertas sean mayores a la oferta actual.
-Consultar estado: Informa sobre la mejor oferta y el mejor postor.
-Retirarse: Permite al usuario abandonar la subasta.

Estructura de las clases del Código:
-ServidorSubasta.java: Inicializa el servidor RMI y publica el objeto remoto de la subasta.
-ClienteSubasta.java: Cliente que interactúa con el servidor para participar en la subasta.
-SubastaImpl.java: Implementación de la lógica de la subasta.
-SubastaInterfaz.java: Interfaz remota de la subasta.
-ClienteCallback.java: Interfaz remota para callbacks del cliente.
-ClienteCallbackImpl.java: Implementación del callback para las notificaciones.

Uso del Sistema:
-Inicie el servidor.
-Ejecute uno o más clientes.
-Participe en la subasta realizando ofertas o consultando el estado.
Los clientes recibirán notificaciones en tiempo real sobre los eventos importantes de la subasta.
