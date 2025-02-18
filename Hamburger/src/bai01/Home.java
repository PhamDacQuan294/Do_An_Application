import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    public MultiPanelCalculator() {
        setTitle("Multi Panel Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));

        add(createOperationPanel("Addition", "+"));
        add(createOperationPanel("Subtraction", "-"));
        add(createOperationPanel("Multiplication", "*"));
        add(createOperationPanel("Division", "/"));
    }

    private JPanel createOperationPanel(String title, String operator) {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        
        JLabel num1Label = new JLabel("Number 1:");
        JTextField num1Field = new JTextField();
        JLabel num2Label = new JLabel("Number 2:");
        JTextField num2Field = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        JButton calculateButton = new JButton("Calculate");
        
        panel.add(num1Label);
        panel.add(num1Field);
        panel.add(num2Label);
        panel.add(num2Field);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(calculateButton);
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = 0;
                    
                    switch (operator) {
                        case "+": result = num1 + num2; break;
                        case "-": result = num1 - num2; break;
                        case "*": result = num1 * num2; break;
                        case "/": 
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                                return;
                            }
                            break;
                    }
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
                }
            }
        });
        
        return panel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MultiPanelCalculator().setVisible(true);
        });
    }
}
