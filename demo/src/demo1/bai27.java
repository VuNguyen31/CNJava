package demo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.awt.Color;

public class bai27 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer timer;
	private JLabel lblNewLabel; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai27 frame = new bai27();
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
	public bai27() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(300, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 0, 0));
		progressBar.setBackground(Color.RED);
		progressBar.setBounds(225, 80, 186, 43);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(142, 171, 105, 28);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(false);
				progressBar.setValue(0);
				
				timer = new Timer(50, new ActionListener() {
					int valus = 0;
					
					@Override
					public void actionPerformed(ActionEvent e) {
						valus +=1;
						lblNewLabel.setText(String.valueOf(valus));
						progressBar.setValue(valus);
						
						if (valus >= 100) {
							timer.stop();
							btnNewButton.setEnabled(true);
						}
					}
				});
				timer.start();
			}
		});
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Loading....");
		lblNewLabel.setBounds(165, 95, 69, 13);
		contentPane.add(lblNewLabel);
		contentPane.add(progressBar);
		contentPane.add(btnNewButton);
	}
}
