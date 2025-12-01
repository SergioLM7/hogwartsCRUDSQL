import views.WizardView;

import java.sql.SQLException;

public class Main_controllers_test {
    public static void main(String[] args) throws SQLException {
        WizardView view = new WizardView();
        view.showMenu();
    }
}
