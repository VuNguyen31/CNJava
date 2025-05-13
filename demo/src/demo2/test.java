package demo2;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class test extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField idField;
    private JTextField dobField;
    private JTextArea outputArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                test frame = new test();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public test() {
        setTitle("Student Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        nameField = new JTextField();
        nameField.setColumns(10);
        nameField.setToolTipText("Enter name (letters and spaces only)");

        idField = new JTextField();
        idField.setColumns(10);
        idField.setToolTipText("Enter student ID (numbers only)");

        dobField = new JTextField();
        dobField.setColumns(10);
        dobField.setToolTipText("Enter date in DD/MM/YYYY format");

        JButton showButton = new JButton("Show");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String id = idField.getText().trim();
                String dob = dobField.getText().trim();

                // Collect validation errors
                List<String> errors = new ArrayList<>();

                // Validate name
                if (name.isEmpty()) {
                    errors.add("Name is required.");
                } else if (!name.matches("^[\\p{L}\\s]+$")) {
                    errors.add("Name must contain only letters and spaces (no numbers).");
                }

                // Validate student ID
                if (id.isEmpty()) {
                    errors.add("Student ID is required.");
                } else if (!id.matches("^[0-9]+$")) {
                    errors.add("Student ID must contain only numbers (no letters).");
                }

                // Validate date of birth
                if (dob.isEmpty()) {
                    errors.add("Date of birth is required.");
                } else if (!isValidDate(dob)) {
                    errors.add("Date of birth must be in DD/MM/YYYY format and a valid date.");
                }

                // Display errors if any
                if (!errors.isEmpty()) {
                    String errorMessage = String.join("\n", errors);
                    JOptionPane.showMessageDialog(test.this,
                            errorMessage,
                            "Input Errors",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Display information
                outputArea.setText("Student Information:\n" +
                        "Name: " + name + "\n" +
                        "Student ID: " + id + "\n" +
                        "Date of Birth: " + dob);
            }
        });

        JLabel nameLabel = new JLabel("Họ tên");
        JLabel idLabel = new JLabel("Mã SV");
        JLabel dobLabel = new JLabel("Ngày sinh");
        JLabel titleLabel = new JLabel("Thông tin sinh viên");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));

        outputArea = new JTextArea();
        outputArea.setText("Enter information and click Show...");
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(100)
                            .addComponent(titleLabel))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(30)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(idLabel, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(dobLabel, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(nameField)
                                .addComponent(idField)
                                .addComponent(dobField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(170)
                            .addComponent(showButton))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(30)
                            .addComponent(outputArea, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGap(10)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(10)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(idLabel)
                        .addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(10)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(dobLabel)
                        .addComponent(dobField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addComponent(showButton)
                    .addGap(20)
                    .addComponent(outputArea, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }

    // Validate date format (DD/MM/YYYY)
    private boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Strict parsing
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}