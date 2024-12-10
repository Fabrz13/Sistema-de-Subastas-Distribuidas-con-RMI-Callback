package RMICallBackSubasta;

import RMICallBackSubasta.SubastaInterfaz;
import RMICallBackSubasta.ClienteCallback;
import RMICallBackSubasta.ClienteCallbackImpl;
import java.rmi.Naming;
import java.util.Scanner;

/**
 * Cliente que participa en la subasta
 */
public class ClienteSubasta {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Subasta de Reloj Rolex");
            System.out.println("Introduce tu nombre:");
            String nombre = scanner.nextLine();

            SubastaInterfaz subasta = (SubastaInterfaz) Naming.lookup("rmi://localhost/Subasta");
            ClienteCallback cliente = new ClienteCallbackImpl();
            subasta.registrarCliente(cliente);

            while (true) {
                System.out.println("\n1. Realizar oferta");
                System.out.println("2. Consultar estado de la subasta");
                System.out.println("3. Retirarse");
                System.out.println("Elige una opcion:");
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Introduce tu oferta:");
                        double oferta = Double.parseDouble(scanner.nextLine());
                        System.out.println(subasta.realizarOferta(nombre, oferta));
                        break;
                    case 2:
                        System.out.println(subasta.obtenerEstadoSubasta());
                        break;
                    case 3:
                        System.out.println(subasta.retirarParticipacion(nombre));
                        return;
                    default:
                        System.out.println("Opcion invalida.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

