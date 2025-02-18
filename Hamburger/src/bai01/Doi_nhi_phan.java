package bai01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Doi_Nhi_Phan {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chuyển đổi số thập phân sang nhị phân");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());
        
        JLabel label = new JLabel("Nhập số thập phân:");
        JTextField textField = new JTextField(10);
        JButton convertButton = new JButton("Chuyển đổi");
        JLabel resultLabel = new JLabel("Nhị phân: ");
        
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int decimalNumber = Integer.parseInt(textField.getText());
                    String binaryString = Integer.toBinaryString(decimalNumber);
                    resultLabel.setText("Nhị phân: " + binaryString);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Vui lòng nhập số hợp lệ!");
                }
            }
        });
        
        frame.add(label);
        frame.add(textField);
        frame.add(convertButton);
        frame.add(resultLabel);
        
        frame.setVisible(true);
    }
}

