import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Janela {
    private JLabel labelNumero;
    private JLabel labelMatricula;
    private JLabel labelNome;
    private JButton buttonCreate;
    private JButton buttonRead;
    private JButton buttonUpdate;
    private JButton buttonDelete;
    private JTextField textFieldNumero;
    private JTextField textFieldMatricula;
    private JTextField textFieldNome;

    public Janela() {
        labelNumero = new JLabel("Número:");
        labelMatricula = new JLabel("Matrícula:");
        labelNome = new JLabel("Nome:");
        
        buttonCreate = new JButton("Criar");
        buttonRead = new JButton("Ler");
        buttonUpdate = new JButton("Atualizar");
        buttonDelete = new JButton("Excluir");
        
        textFieldNumero = new JTextField(10);
        textFieldMatricula = new JTextField(10);
        textFieldNome = new JTextField(20);
    }

    public JLabel getLabelNumero() {
        return labelNumero;
    }
    public JLabel getLabelMatricula() {
        return labelMatricula;
    }
    public JLabel getLabelNome() {
        return labelNome;
    }
    public JTextField getTextFieldNumero() {
        return textFieldNumero;
    }
    public JTextField getTextFieldMatricula() {
        return textFieldMatricula;
    }
    public JTextField getTextFieldNome() {
        return textFieldNome;
    }

    public JButton getButtonCreate() {
        return buttonCreate;
    }

    public JButton getButtonRead() {
        return buttonRead;
    }

    public JButton getButtonUpdate() {
        return buttonUpdate;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }
    
}
