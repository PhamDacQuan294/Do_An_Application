package bai01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CV_DT_HCN extends JFrame {
    private JTextField sideLengthField;
    private JLabel perimeterLabel;
    private JLabel areaLabel;

    public CV_DT_HCN() {
        setTitle("Tính chu vi và diện tích hình vuông");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 5, 5));

        JLabel sideLengthLabel = new JLabel("Nhập cạnh hình vuông:");
        sideLengthField = new JTextField();
        JButton calculateButton = new JButton("Tính toán");
        perimeterLabel = new JLabel("Chu vi: ");
        areaLabel = new JLabel("Diện tích: ");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSquareProperties();
            }
        });

        add(sideLengthLabel);
        add(sideLengthField);
        add(calculateButton);
        add(new JLabel());
        add(perimeterLabel);
        add(areaLabel);
    }

    private void calculateSquareProperties() {
        try {
            double sideLength = Double.parseDouble(sideLengthField.getText());
            if (sideLength <= 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double perimeter = 4 * sideLength;
            double area = sideLength * sideLength;

            perimeterLabel.setText("Chu vi: " + perimeter);
            areaLabel.setText("Diện tích: " + area);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CV_DT_HCN().setVisible(true);
        });
    }
}

