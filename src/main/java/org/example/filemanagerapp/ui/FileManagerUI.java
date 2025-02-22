package org.example.filemanagerapp.ui;

import org.example.filemanagerapp.controller.FileManagerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class FileManagerUI extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JList<String> resultList;
    private DefaultListModel<String> listModel;
    private FileManagerController fileManager;

    public FileManagerUI() {
        setTitle("Buscador de Archivos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar componentes
        fileManager = new FileManagerController();
        searchField = new JTextField(30);
        searchButton = new JButton("Buscar");
        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);

        // Configurar el diseño
        setLayout(new BorderLayout());

        // Panel superior para la búsqueda
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Buscar:"));
        topPanel.add(searchField);
        topPanel.add(searchButton);

        // Panel central para los resultados
        JScrollPane resultScrollPane = new JScrollPane(resultList);

        // Agregar componentes a la ventana
        add(topPanel, BorderLayout.NORTH);
        add(resultScrollPane, BorderLayout.CENTER);

        // Acción del botón "Buscar"
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                if (!searchTerm.isEmpty()) {
                    File directory = new File("."); // Directorio actual (puedes cambiarlo)
                    List<File> results = fileManager.searchFiles(directory, searchTerm);
                    listModel.clear();
                    if (results.isEmpty()) {
                        listModel.addElement("No se encontraron archivos.");
                    } else {
                        for (File file : results) {
                            listModel.addElement(file.getAbsolutePath());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(FileManagerUI.this, "Ingresa un término de búsqueda.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileManagerUI().setVisible(true);
            }
        });
    }
}