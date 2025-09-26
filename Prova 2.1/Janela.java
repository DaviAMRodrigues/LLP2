package src;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Janela {
    private JLabel labelNumero;
    private JLabel labelNome;
    private JLabel labelEmail;
    private JLabel labelSenha;
    private JLabel labelCargo;
    private JLabel labelTurma;
    private JLabel labelSetor;
    private JTextField textFieldNumero;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JTextField textFieldSenha;
    private JTextField textFieldCargo;
    private JTextField textFieldTurma;
    private JTextField textFieldSetor;
    private JButton proximo;
    private JButton anterior;

    

    public Janela() {
        this.labelNumero = new JLabel("Matricula:");;
        this.labelNome = new JLabel("Nome:");;
        this.labelEmail = new JLabel("Email:");;
        this.labelSenha = new JLabel("Senha:");;
        this.labelCargo = new JLabel("Cargo:");;
        this.labelTurma = new JLabel("Turma:");;
        this.labelSetor = new JLabel("Setor:");;
        this.textFieldNumero = new JTextField(10);
        this.textFieldNome = new JTextField(10);
        this.textFieldEmail = new JTextField(10);
        this.textFieldSenha = new JTextField(10);
        this.textFieldCargo = new JTextField(10);
        this.textFieldTurma = new JTextField(10);
        this.textFieldSetor = new JTextField(10);
        this.proximo = new JButton("Proximo");
        this.anterior = new JButton("Anterior");
    }
    public JLabel getLabelNumero() {
        return labelNumero;
    }
    public void setLabelNumero(JLabel labelNumero) {
        this.labelNumero = labelNumero;
    }
    public JLabel getLabelNome() {
        return labelNome;
    }
    public void setLabelNome(JLabel labelNome) {
        this.labelNome = labelNome;
    }
    public JLabel getLabelEmail() {
        return labelEmail;
    }
    public void setLabelEmail(JLabel labelEmail) {
        this.labelEmail = labelEmail;
    }
    public JLabel getLabelSenha() {
        return labelSenha;
    }
    public void setLabelSenha(JLabel labelSenha) {
        this.labelSenha = labelSenha;
    }
    public JLabel getLabelCargo() {
        return labelCargo;
    }
    public void setLabelCargo(JLabel labelCargo) {
        this.labelCargo = labelCargo;
    }
    public JLabel getLabelTurma() {
        return labelTurma;
    }
    public void setLabelTurma(JLabel labelTurma) {
        this.labelTurma = labelTurma;
    }
    public JLabel getLabelSetor() {
        return labelSetor;
    }
    public void setLabelSetor(JLabel labelSetor) {
        this.labelSetor = labelSetor;
    }
    public JTextField getTextFieldNumero() {
        return textFieldNumero;
    }
    public void setTextFieldNumero(JTextField textFieldNumero) {
        this.textFieldNumero = textFieldNumero;
    }
    public JTextField getTextFieldNome() {
        return textFieldNome;
    }
    public void setTextFieldNome(JTextField textFieldNome) {
        this.textFieldNome = textFieldNome;
    }
    public JTextField getTextFieldEmail() {
        return textFieldEmail;
    }
    public void setTextFieldEmail(JTextField textFieldEmail) {
        this.textFieldEmail = textFieldEmail;
    }
    public JTextField getTextFieldSenha() {
        return textFieldSenha;
    }
    public void setTextFieldSenha(JTextField textFieldSenha) {
        this.textFieldSenha = textFieldSenha;
    }
    public JTextField getTextFieldCargo() {
        return textFieldCargo;
    }
    public void setTextFieldCargo(JTextField textFieldCargo) {
        this.textFieldCargo = textFieldCargo;
    }
    public JTextField getTextFieldTurma() {
        return textFieldTurma;
    }
    public void setTextFieldTurma(JTextField textFieldTurma) {
        this.textFieldTurma = textFieldTurma;
    }
    public JTextField getTextFieldSetor() {
        return textFieldSetor;
    }
    public void setTextFieldSetor(JTextField textFieldSetor) {
        this.textFieldSetor = textFieldSetor;
    }
    public JButton getProximo() {
        return proximo;
    }
    public void setProximo(JButton proximo) {
        this.proximo = proximo;
    }
    public JButton getAnterior() {
        return anterior;
    }
    public void setAnterior(JButton anterior) {
        this.anterior = anterior;
    }
    
    
    
}
