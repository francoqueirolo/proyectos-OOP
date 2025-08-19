import models.Expense;
import models.Income;
import models.Transaction;
import service.Account;

import java.util.Scanner;

public class FinanceManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nGestión de Finanzas Personales");
            System.out.println("1. Agregar Ingreso");
            System.out.println("2. Agregar Gasto");
            System.out.println("3. Ver Saldo");
            System.out.println("4. Ver Reporte");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer.

            switch (opcion) {
                case 1:
                    System.out.println("Monto del ingreso");
                    double montoIngreso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Descripcion");
                    String descripcionIngreso = scanner.nextLine();
                    Transaction ingreso = new Income(montoIngreso, descripcionIngreso);
                    account.addTransaction(ingreso);
                    System.out.println("Ingreso agregado exitosamente");
                    break;
                case 2:
                    System.out.println("Monto del gasto");
                    double montoGasto = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Descripcion");
                    String descripcionGasto = scanner.nextLine();
                    Transaction gasto = new Expense(montoGasto, descripcionGasto);
                    account.addTransaction(gasto);
                    System.out.println("Gasto agregado exitosamente");
                    break;
                case 3:
                    System.out.println("Monto del saldo: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Reporte de transacciones");
                    for (String linea : account.getReport()) {
                        System.out.println(linea);
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion invalida. Ingrese de nuevo");
            }
        }
        scanner.close();
        System.out.println("Programa finalizado");
    }
}
