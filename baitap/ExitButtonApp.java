import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonApp {
    public static void main(String[] args) {
        // Tạo JFrame với kích thước 300x200
        JFrame frame = new JFrame("Exit Button App");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Căn giữa màn hình
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Đặt màu nền cho JFrame
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        // Tạo JButton "Exit"
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16)); // Font chữ lớn và in đậm
        exitButton.setBackground(Color.RED); // Màu nền nút đỏ
        exitButton.setForeground(Color.WHITE); // Màu chữ trắng

        // Thêm sự kiện thoát ứng dụng khi nhấn nút
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Thoát ứng dụng
            }
        });

        // Sử dụng layout để căn nút ở giữa
        frame.setLayout(new GridBagLayout());
        frame.add(exitButton);

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}