package RMICallBackSubasta;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz remota para callbacks del cliente
 */
public interface ClienteCallback extends Remote {
    void notificarCliente(String mensaje) throws RemoteException;
}

