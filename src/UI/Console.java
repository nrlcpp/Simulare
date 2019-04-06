package UI;
import Domain.Factura;

import Service.FacturaService;

import java.util.Scanner;

public class Console {
    private FacturaService facturaService;

    private Scanner scanner;

    public Console(FacturaService facturaService) {
        this.facturaService = facturaService;

        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Factura");
        System.out.println("x. Exit");
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runFactura();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runFactura() {
        while (true) {
            System.out.println("1. Add or update a factura");
            System.out.println("2. Show all facturi");
            System.out.println("3. Make the sum of facturi");
            System.out.println("4. Back");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateFactura();
                    break;
                case "2":
                    handleShowAll();
                    break;
                case "3":
                    handleViewSum();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }

        }
    }

    private void handleViewSum() {
        for (Factura factura : facturaService.getSum()) {
            System.out.println(factura);
        }
    }

    private void handleShowAll() {
            for (Factura factura : facturaService.getAll()) {
                System.out.println(factura);
            }
        }



    private void handleAddUpdateFactura() {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter sum: ");
            String sum = scanner.nextLine();
            System.out.print("Enter description: ");
            String description = scanner.nextLine();
            System.out.print("Enter date: ");
            String date = scanner.nextLine();
            
            Factura factura = facturaService.addOrUpdate(id, sum, description,date);
        }
        catch (Exception ex){
            System.out.println("Errors:\n" + ex.getMessage());
        }

    }

}
