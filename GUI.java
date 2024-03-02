import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private static double income;
    private static double tax;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Tax Calculator 2023-2024");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel incomeLabel = new JLabel("Enter your income:");
        incomeLabel.setBounds(10, 20, 120, 25);
        panel.add(incomeLabel);

        JTextField incomeText = new JTextField(20);
        incomeText.setBounds(140, 20, 140, 25);
        panel.add(incomeText);

        JButton calculateButton = new JButton("Calculate Tax");
        calculateButton.setBounds(10, 60, 270, 25);
        panel.add(calculateButton);

        ActionListener calculateAction = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String userInput = incomeText.getText();
                    if (isNumeric(userInput)) {
                        income = Double.parseDouble(userInput);
                        tax = new taxCalc().yearlyTax(income);
                        JOptionPane.showMessageDialog(null, "Your income tax is: $" + tax);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    }
                }
            };

        calculateButton.addActionListener(calculateAction);
        incomeText.addActionListener(calculateAction);
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
