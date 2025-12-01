package views;

import controllers.WizardController;

import java.sql.SQLException;
import java.util.Scanner;

public class WizardView {

    private final Scanner sc;
    private final WizardController controller;

    public WizardView() throws SQLException {
        controller = new WizardController();
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        int option;

        do {
            System.out.println("\n ---- ¡Bienvenidos a Hogwarts! ----");
            System.out.println("1. Listar magos");
            System.out.println("2. Agregar mago");
            System.out.println("3. Actualizar mago");
            System.out.println("4. Eliminar mago");
            System.out.println("0. Salir");
            System.out.println("Elige una opción: ");
            option = sc.nextInt();
            sc.nextLine();

            switch(option) {
                case 1 -> controller.listWizards();
                case 2 -> addWizard();
                case 3 -> updateWizard();
                case 4 -> deleteWizard();
                case 0 -> System.out.println("Hasta la próxima");
                default -> System.out.println("Esa opción no es válida.");
            }
        } while (option != 0);
    }

    private void addWizard() {
        System.out.println("Nombre: ");
        String name = sc.nextLine();
        System.out.println("Edad: ");
        int age = sc.nextInt();
        System.out.println("ID de casa: ");
        int houseId = sc.nextInt();
        System.out.println("ID de varita: ");
        int wandId = sc.nextInt();
        controller.addWizard(name, age, houseId, wandId);
    }

    private void updateWizard() {
        System.out.println("Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nuevo nombre: ");
        String name = sc.nextLine();
        System.out.println("Nueva edad: ");
        int age = sc.nextInt();
        System.out.println("Nuevo ID de casa: ");
        int houseId = sc.nextInt();
        System.out.println("Nuevo ID de varita: ");
        int wandId = sc.nextInt();

        controller.updateWizard(id, name, age, houseId, wandId);
    }

    private void deleteWizard() {
        System.out.println("Id del mago a eliminar: ");
        int id = sc.nextInt();

        controller.deleteWizard(id);
    }
}
