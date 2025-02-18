package bai01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Don_Vi extends JFrame {
    private JTextField inputField;
    private JComboBox<String> fromUnit;
    private JComboBox<String> toUnit;
    private JLabel resultLabel;

    private static final Map<String, Double> conversionRates = new HashMap<>();

    static {
        conversionRates.put("m", 1.0);
        conversionRates.put("cm", 100.0);
        conversionRates.put("mm", 1000.0);
        conversionRates.put("km", 0.001);
    }

    public Don_Vi() {
        setTitle("Đổi đơn vị");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 5, 5));

        JLabel inputLabel = new JLabel("Nhập số:");
        inputField = new JTextField();
        JLabel fromLabel = new JLabel("Từ đơn vị:");
        fromUnit = new JComboBox<>(new String[]{"m", "cm", "mm", "km"});
        JLabel toLabel = new JLabel("Sang đơn vị:");
        toUnit = new JComboBox<>(new String[]{"m", "cm", "mm", "km"});
        JButton convertButton = new JButton("Chuyển đổi");
        resultLabel = new JLabel("Kết quả: ");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertUnit();
            }
        });

        add(inputLabel);
        add(inputField);
        add(fromLabel);
        add(fromUnit);
        add(toLabel);
        add(toUnit);
        add(convertButton);
        add(resultLabel);
    }

    private void convertUnit() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String from = (String) fromUnit.getSelectedItem();
            String to = (String) toUnit.getSelectedItem();

            double valueInMeters = inputValue / conversionRates.get(from);
            double convertedValue = valueInMeters * conversionRates.get(to);

            resultLabel.setText("Kết quả: " + convertedValue + " " + to);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Don_Vi().setVisible(true);
        });
    }
}
