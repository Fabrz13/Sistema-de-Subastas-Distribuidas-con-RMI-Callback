package RMICallBackSubasta;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementacion de la interfaz de callback para el cliente
 */
public class ClienteCallbackImpl extends UnicastRemoteObject implements ClienteCallback {
    public ClienteCallbackImpl() throws RemoteException {
        super();
    }

    @Override
    public void notificarCliente(String mensaje) throws RemoteException {
        System.out.println("Notificacion del servidor: " + mensaje);
    }
}
