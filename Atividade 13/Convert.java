import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Convert extends JFrame {

// ...existing code...

    public Convert(){

        setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        JLabel labelCelsius = new JLabel("Celsius");
        JLabel labelFahrenheit = new JLabel("32 Fahrenheit");
        JButton button = new JButton("Convert");
        JTextField inputField = new JTextField("0", 10);


        javax.swing.JPanel panelTop = new javax.swing.JPanel(new FlowLayout());
        panelTop.add(inputField);
        panelTop.add(labelCelsius);

        javax.swing.JPanel panelBottom = new javax.swing.JPanel(new FlowLayout());
        panelBottom.add(button);
        panelBottom.add(labelFahrenheit);

        add(panelTop);
        add(panelBottom);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int celsius = Integer.parseInt(inputField.getText());
                    int fahrenheit = (int) ((celsius * 9.0 / 5.0) + 32);
                    labelFahrenheit.setText(fahrenheit + " fahrenheit");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Entre com valor valido");
                }
            }
        });

        setTitle("Celsius Converter");
        setSize(320, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

// ...existing code...

    public static void main(String[] args) {
        new Convert();
    }
}
