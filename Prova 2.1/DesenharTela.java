package src;
import javax.swing.JFrame;

public class DesenharTela {

    private Janela janela = new Janela();
    private JFrame frame = new JFrame("Cadastro Pessoal");
    
    public void desenharTela(String matricula, String nome, String email, String senha, String cargo, String turma, String setor){
        frame = new JFrame("Cadastro de Pessoa");

        janela.getTextFieldNumero().setText(matricula);
        janela.getTextFieldNome().setText(nome);
        janela.getTextFieldEmail().setText(email);
        janela.getTextFieldSenha().setText(senha);
        janela.getTextFieldCargo().setText(cargo);
        janela.getTextFieldTurma().setText(turma);
        janela.getTextFieldSetor().setText(setor);

        frame.add(janela.getLabelNumero());
        frame.add(janela.getTextFieldNumero());

        frame.add(janela.getLabelNome());
        frame.add(janela.getTextFieldNome());

        frame.add(janela.getLabelEmail());
        frame.add(janela.getTextFieldEmail());

        frame.add(janela.getLabelSenha());
        frame.add(janela.getTextFieldSenha());

        frame.add(janela.getLabelCargo());
        frame.add(janela.getTextFieldCargo());

        frame.add(janela.getLabelTurma());
        frame.add(janela.getTextFieldTurma());

        frame.add(janela.getLabelSetor());
        frame.add(janela.getTextFieldSetor());

        frame.add(janela.getAnterior());
        frame.add(janela.getProximo());

        frame.setVisible(true);
    }

    public void configurarEventos(Janela janela){
        //janela.getProximo().addActionListener();
        //janela.getAnterior().addActionListener();
    }


}
