package demo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bai65 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer timer;
	private JButton btnNewButton, btnNewButton_1, btnNewButton_2;
	private JLabel lblNewLabel_1;
	private int seconds = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai65 frame = new bai65();
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
	public bai65() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Time : 00.00");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(75, 26, 162, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(233, 16, 0, 0);
		contentPane.add(lblNewLabel);
		
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                updateTimeLabel();
            }
        });
        
        
		
		btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		                timer.start();
		                btnNewButton.setEnabled(false);
		                btnNewButton_1.setEnabled(true);
			
			}
		});
		btnNewButton.setBounds(35, 110, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Stop");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				timer.stop();
                btnNewButton.setEnabled(true);
                btnNewButton_1.setEnabled(false);
			}
		});
		btnNewButton_1.setBounds(148, 110, 85, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
                seconds = 0;
                updateTimeLabel();
                btnNewButton.setEnabled(true);
                btnNewButton_1.setEnabled(false);
			}
		});
		
		btnNewButton_1.setEnabled(false);
		btnNewButton_2.setBounds(253, 110, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(75, 60, 32, 0);
		contentPane.add(lblNewLabel_2);
	}
	private void updateTimeLabel() {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        lblNewLabel_1.setText(String.format("Time: %02d:%02d", minutes, secs));
    }

}
