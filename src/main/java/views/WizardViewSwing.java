package views;

import controllers.WizardController;
import models.Wizard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class WizardViewSwing extends JFrame {

    private WizardController wizardController;
    private DefaultTableModel model;
    private JTable table;
    private JTextField txtName, txtAge, txtId;

    public WizardViewSwing() throws SQLException {
        wizardController = new WizardController();
        setTitle("🏰 Hogwarts - Gestión de Magos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //QUe no ponga en el panel las cosas donde le dé la gana
        setLocationRelativeTo(null);

        //Panel principal
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        //Tabla
        model = new DefaultTableModel(new String[] {"ID", "Nombre", "Edad"}, 0);
        table = new JTable(model);
        panel.add(table);

        //Botones
        JButton btnAdd = new JButton("Agregar ✚");
        JButton btnDelete = new JButton("Eliminar ❌");
        JButton btnRefresh = new JButton("Actualizar lista 🌀");

        JPanel inputPanel = new JPanel();

        panel.add(inputPanel, BorderLayout.SOUTH);

        //Label
        inputPanel.add(new JLabel("ID:"));
        //Input de texto
        txtId = new JTextField(5);
        inputPanel.add(txtId);

        inputPanel.add(new JLabel("Nombre:"));
        txtName = new JTextField(10);
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Edad:"));
        txtAge = new JTextField(5);
        inputPanel.add(txtAge);

        inputPanel.add(btnAdd);
        inputPanel.add(btnDelete);
        inputPanel.add(btnRefresh);

        btnAdd.addActionListener(e ->{
            String name = txtName.getText();
            int age = Integer.parseInt(txtAge.getText());
            wizardController.addWizardSwing(name, age);
            loadData();
        });

        loadData();
    }

    private void loadData() {
        model.setRowCount(0);
        List<Wizard> wizardList = wizardController.getAllWizards();
        if(!wizardList.isEmpty()) {
            for(Wizard w: wizardList) {
                model.addRow(new Object[]{w.getId(), w.getName(), w.getAge()});
            }
        }
    }


}
