import javax.swing.*;
import java.awt.*;

public class MyFirstSwingApp {
    public static void main(String[] args) {
        // Tạo JFrame với tiêu đề "My First Swing App"
        JFrame frame = new JFrame("My First Swing App");

        // Đặt kích thước 400x500
        frame.setSize(400, 500);

        // Căn giữa màn hình
        frame.setLocationRelativeTo(null);

        // Tạo JLabel hiển thị "Hello World" ở giữa cửa sổ
        JLabel label = new JLabel("Hello World", SwingConstants.CENTER);

        // Thêm màu sắc cho văn bản
        label.setForeground(Color.BLUE); // Màu chữ xanh dương
        label.setFont(new Font("Arial", Font.BOLD, 24)); // Font chữ lớn và in đậm

        // Đặt màu nền cho JFrame
        frame.getContentPane().setBackground(Color.LIGHT_GRAY); // Màu nền xám nhạt

        // Thêm JLabel vào JFrame
        frame.add(label);

        // Đặt hành động đóng cửa sổ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}