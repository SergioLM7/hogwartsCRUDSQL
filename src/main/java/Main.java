import models.*;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        House gryffindor = new House("Gryffindor", "Godric Gryffindor");
        House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw");
        House slytherin = new House("Slytherin", "Salazar Slytherin");
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff");

        HouseDAO houseDao = new HouseDAO();
//        houseDao.create(gryffindor);
//        houseDao.create(slytherin);
//        houseDao.create(ravenclaw);
//        houseDao.create(hufflepuff);

        List<House> result = houseDao.getAll();
        result.forEach(System.out::println);

        Wand wand1 = new Wand("Acebo", "Pluma de fénix", 28.0);
        Wand wand2 = new Wand("Espino", "Pelo de unicornio", 25.4);
        Wand wand3 = new Wand("Vid", "Corazón de dragón", 25.0);
        Wand wand4 = new Wand("Sauce", "Pelo de unicornio", 25.2);

        WandDAO wandDAO = new WandDAO();
//        wandDAO.create(wand1);
//        wandDAO.create(wand2);
//        wandDAO.create(wand3);
//        wandDAO.create(wand4);

        List<Wand> wands = wandDAO.getAll();
        wands.forEach(System.out::println);


        Wizard harry = new Wizard("Harry Potter", 17, 1, 1);
        Wizard ron = new Wizard("Ron Weasley", 17, 1, 2);
        Wizard hermione = new Wizard("Hermione Granger", 17, 1, 3);
        Wizard draco = new Wizard("Draco Malfoy", 17, 2, 4);

        WizardDAO wizardDao = new WizardDAO();
        wizardDao.create(harry);
        wizardDao.create(ron);
        wizardDao.create(hermione);
        wizardDao.create(draco);

        List<Wizard> wizards = wizardDao.getAll();
        wizards.forEach(System.out::println);


    }
}
