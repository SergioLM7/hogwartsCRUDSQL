package controllers;

import models.Wizard;
import models.WizardDAO;

import java.sql.SQLException;
import java.util.List;

public class WizardController {

    private WizardDAO wizardDAO;

    public WizardController() throws SQLException {
        wizardDAO = new WizardDAO();
    }

    public void addWizard(String name, int age, int house_id, int wand_id) {
        //Comprobar permisos
        //Comprobar parámetros (verificación en servidor)
        //transacciones
        try {
            Wizard miMago = new Wizard(name, age, house_id, wand_id);
            wizardDAO.create(miMago);
            System.out.println("✅ Mago agregado con éxito.");

        } catch (SQLException e) {
            System.out.println("❌ Error al agregar mago: " + e.getMessage());
        }
    }

    public void listWizards() {

        try {
            List<Wizard> wizardsList = wizardDAO.getAll();
            if(wizardsList.isEmpty()) {
                System.out.println("🌪️ No hay magos en la BBDD.");
            }

            for(Wizard wizard: wizardsList) {
                System.out.println(wizard);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar los magos: " + e.getMessage());
        }
    }

    public void updateWizard(int id, String name, int age, int houseId, int wandId) {
        try {
            Wizard wizard = new Wizard(name, age, houseId, wandId);
            wizard.setId(id);
            wizardDAO.update(wizard);
            System.out.println("✅ ¡Mago actualizado con éxito!");
        } catch(SQLException e){
            System.out.println("❌ Error al actualizar el mago " + name + ": " + e.getMessage());
        }
    }

    public void deleteWizard(int id) {
        try {
            wizardDAO.delete(id);
            System.out.println("👋🚂¡Mago eliminado correctamente!");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar el mago con id " + id + ": " + e.getMessage());
        }
    }

    public List<Wizard> getAllWizards() {
        try {
            return wizardDAO.getAll();
        } catch (SQLException e) {
            System.out.println("❌ Error al recuperar los magos de la BBDD: " + e.getMessage());
            return null;
        }
    }

    public void addWizardSwing(String name, int age) {
        try {
            wizardDAO.create2(new Wizard(name, age));
            System.out.println("✅ Mago agregado con éxito.");
        } catch (SQLException e) {
            System.out.println("❌ Error al añadir el mago: " + e.getMessage());
        }
    }
}
