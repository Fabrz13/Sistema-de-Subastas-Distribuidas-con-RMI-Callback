package RMICallBackSubasta;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Implementacion remota de la subasta
 */
public class SubastaImpl extends UnicastRemoteObject implements SubastaInterfaz {
    private double mejorOferta = 0.0;
    private String mejorPostor = "Nadie";
    private Map<String, Double> participantes;
    private List<ClienteCallback> clientes;

    public SubastaImpl() throws RemoteException {
        super();
        participantes = new HashMap<>();
        clientes = new ArrayList<>();
    }

    @Override
    public void registrarCliente(ClienteCallback cliente) throws RemoteException {
        clientes.add(cliente);
        cliente.notificarCliente("Te has registrado en la subasta.");
    }

    @Override
    public String realizarOferta(String nombre, double monto) throws RemoteException {
        if (monto > mejorOferta) {
            mejorOferta = monto;
            mejorPostor = nombre;
            participantes.put(nombre, monto);

            notificarATodos("Nueva oferta: " + mejorOferta + " por " + mejorPostor);
            return "Oferta aceptada. Mejor oferta actual: " + mejorOferta + " por " + mejorPostor;
        } else {
            return "Oferta rechazada. Debe ser mayor a la actual: " + mejorOferta;
        }
    }

    @Override
    public String obtenerEstadoSubasta() throws RemoteException {
        return "Mejor oferta: " + mejorOferta + " por " + mejorPostor;
    }

    @Override
    public String retirarParticipacion(String nombre) throws RemoteException {
        if (participantes.containsKey(nombre)) {
            participantes.remove(nombre);

            if (participantes.isEmpty()) {
                notificarATodos("La subasta ha terminado. Ganador: " + mejorPostor + 
                                " con una oferta de " + mejorOferta);
                reiniciarSubasta();
                return "Te has retirado. La subasta ha terminado.";
            }

            notificarATodos("El participante " + nombre + " se ha retirado.");
            return "Te has retirado de la subasta.";
        }
        return "No estas registrado en la subasta.";
    }

    private void notificarATodos(String mensaje) throws RemoteException {
        for (ClienteCallback cliente : clientes) {
            cliente.notificarCliente(mensaje);
        }
    }

    private void reiniciarSubasta() {
        mejorOferta = 0.0;
        mejorPostor = "Nadie";
        participantes.clear();
    }
}

