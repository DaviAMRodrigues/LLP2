/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CustomExceptionGenerator extends JFrame {
    private JTextField classNameField;
    private JSpinner methodCountSpinner;
    private JComboBox<String> parentExceptionCombo;
    private JTextArea outputArea;
    
    public CustomExceptionGenerator() {
        // Configuração da janela
        setTitle("Gerador de Classe Exception");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        
        // Campo para nome da classe
        inputPanel.add(new JLabel("Nome da Classe:"));
        classNameField = new JTextField();
        inputPanel.add(classNameField);
        
        // Spinner para quantidade de métodos
        inputPanel.add(new JLabel("Quantidade de Métodos:"));
        methodCountSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        inputPanel.add(methodCountSpinner);
        
        // ComboBox para tipo de Exception pai
        inputPanel.add(new JLabel("Classe Pai:"));
        String[] exceptionTypes = {
            "Exception",
            "RuntimeException",
            "IOException",
            "NullPointerException",
            "IllegalArgumentException"
        };
        parentExceptionCombo = new JComboBox<>(exceptionTypes);
        inputPanel.add(parentExceptionCombo);
        
        // Área de saída
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        // Botão para gerar a classe
        JButton generateButton = new JButton("Gerar Classe");
        generateButton.addActionListener(e -> generateExceptionClass());
        
        // Organizar componentes
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(generateButton, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void generateExceptionClass() {
        String className = classNameField.getText().trim();
        int methodCount = (int) methodCountSpinner.getValue();
        String parentClass = (String) parentExceptionCombo.getSelectedItem();
        
        // Validação
        if (className.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, insira um nome para a classe!", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Geração do código da classe
        StringBuilder code = new StringBuilder();
        
        // Import necessário, se necessário
        if (!parentClass.equals("Exception")) {
            code.append("import java.io.*;\n\n");
        }
        
        // Declaração da classe
        code.append(String.format("public class %s extends %s {\n", className, parentClass));
        
        // Construtores
        code.append(String.format("    public %s() {\n", className));
        code.append(String.format("        super();\n"));
        code.append("    }\n\n");
        
        code.append(String.format("    public %s(String message) {\n", className));
        code.append(String.format("        super(message);\n"));
        code.append("    }\n\n");
        
        code.append(String.format("    public %s(String message, Throwable cause) {\n", className));
        code.append(String.format("        super(message, cause);\n"));
        code.append("    }\n\n");
        
        code.append(String.format("    public %s(Throwable cause) {\n", className));
        code.append(String.format("        super(cause);\n"));
        code.append("    }\n\n");
        
        // Método toString
        code.append("    @Override\n");
        code.append(String.format("    public String toString() {\n"));
        code.append(String.format("        return \"%s: \" + getMessage();\n", className));
        code.append("    }\n\n");
        
        // Métodos adicionais
        for (int i = 1; i <= methodCount; i++) {
            code.append(String.format("    public void customMethod%d() {\n", i));
            code.append(String.format("        // Implementação do método %d\n", i));
            code.append("    }\n\n");
        }
        
        code.append("}");
        
        // Exibir o código gerado
        outputArea.setText(code.toString());
        
        // Salvar em arquivo
        try (PrintWriter out = new PrintWriter(className + ".java")) {
            out.println(code.toString());
            JOptionPane.showMessageDialog(this, 
                "Classe gerada com sucesso: " + className + ".java", 
                "Sucesso", 
                JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao salvar o arquivo: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CustomExceptionGenerator().setVisible(true);
        });
    }
}*/