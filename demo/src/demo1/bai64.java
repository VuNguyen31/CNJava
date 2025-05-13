package demo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bai64 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JLabel lblNewLabel ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai64 frame = new bai64();
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
	public bai64() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Status");
		lblNewLabel.setBounds(109, 74, 29, 13);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Run Task");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(false);
                lblNewLabel.setText("Status: Running...");

                
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                          
                            Thread.sleep(2000);
                            
                            
                            throw new Exception("Task failed unexpectedly!");
                        } catch (Exception ex) {
                          
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    lblNewLabel.setText("Status: Error occurred");
                                    JOptionPane.showMessageDialog(
                                        bai64.this,
                                        ex.getMessage(),
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE
                                    );
                                    btnNewButton.setEnabled(true);
                                }
                            });
                        }
                    }
                }).start();
            }
        });
		btnNewButton.setBounds(238, 174, 75, 21);
		contentPane.add(btnNewButton);
	}

}
