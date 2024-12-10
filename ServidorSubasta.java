package RMICallBackSubasta;


import RMICallBackSubasta.SubastaImpl;
import RMICallBackSubasta.SubastaInterfaz;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Servidor que inicializa la subasta
 */
public class ServidorSubasta {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            SubastaInterfaz subasta = new SubastaImpl();
            Naming.rebind("rmi://localhost/Subasta", subasta);
            System.out.println("Servidor de subasta iniciado.");
            System.out.println("Subasta de Reloj Rolex");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
