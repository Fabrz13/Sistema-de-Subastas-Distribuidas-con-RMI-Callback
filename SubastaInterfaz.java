package RMICallBackSubasta;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz remota para la subasta
 */
public interface SubastaInterfaz extends Remote {
    void registrarCliente(ClienteCallback cliente) throws RemoteException;

    String realizarOferta(String nombre, double monto) throws RemoteException;

    String obtenerEstadoSubasta() throws RemoteException;

    String retirarParticipacion(String nombre) throws RemoteException;
}

