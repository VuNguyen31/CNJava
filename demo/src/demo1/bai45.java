package demo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class bai45 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai45 frame = new bai45();
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
	public bai45() {
		setMinimumSize(new Dimension(400, 400));
		setBounds(new Rectangle(0, 0, 400, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox checkBox = new JCheckBox("Show Image");
		checkBox.setSelected(true);
		checkBox.setBounds(166, 305, 97, 23);
		checkBox.addActionListener(e -> {
			if(checkBox.isSelected()) {
				Label.setIcon(new ImageIcon("D:\\New folder\\J'aime ou je n'aime pas - Page 17.jfif"));
			}
			else {
				Label.setIcon(null);
			}
		});
		contentPane.add(checkBox);
		
		Label = new JLabel("Image");
		Label.setIcon(new ImageIcon("D:\\New folder\\J'aime ou je n'aime pas - Page 17.jfif"));
	
		Label.setBounds(0, 10, 436, 289);
		contentPane.add(Label);
	}

}