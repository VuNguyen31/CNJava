package demo1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bktr extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldDob;
    private JTextField textFieldHometown;
    private JTable table;
    private DefaultTableModel tableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bktr frame = new bktr();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public bktr() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Labels
        JLabel lblName = new JLabel("Họ tên");
        lblName.setBounds(35, 33, 45, 13);
        contentPane.add(lblName);

        JLabel lblDob = new JLabel("Ngày sinh");
        lblDob.setBounds(35, 56, 62, 13);
        contentPane.add(lblDob);

        JLabel lblHometown = new JLabel("Quê quán");
        lblHometown.setBounds(35, 89, 62, 13);
        contentPane.add(lblHometown);

        // Text Fields
        textFieldName = new JTextField();
        textFieldName.setBounds(112, 30, 183, 19);
        contentPane.add(textFieldName);
        textFieldName.setColumns(10);

        textFieldDob = new JTextField();
        textFieldDob.setBounds(112, 53, 183, 19);
        contentPane.add(textFieldDob);
        textFieldDob.setColumns(10);

        textFieldHometown = new JTextField();
        textFieldHometown.setBounds(112, 86, 183, 19);
        contentPane.add(textFieldHometown);
        textFieldHometown.setColumns(10);

        // Table
        String[] columns = {"Họ tên", "Ngày sinh", "Quê quán"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setBounds(35, 126, 380, 127);
        contentPane.add(table);

        // Button
        JButton btnDisplay = new JButton("Hiển thị");
        btnDisplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText().trim();
                String dob = textFieldDob.getText().trim();
                String hometown = textFieldHometown.getText().trim();

                if (name.isEmpty() || dob.isEmpty() || hometown.isEmpty()) {
                    JOptionPane.showMessageDialog(bktr.this, 
                        "Vui lòng điền đầy đủ thông tin", 
                        "Lỗi", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                tableModel.addRow(new Object[]{name, dob, hometown});

                // Clear text fields after adding
                textFieldName.setText("");
                textFieldDob.setText("");
                textFieldHometown.setText("");
            }
        });
        btnDisplay.setBounds(330, 29, 85, 73);
        contentPane.add(btnDisplay);
    }
}