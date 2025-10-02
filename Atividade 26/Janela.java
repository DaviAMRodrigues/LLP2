import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*

a) Crie uma janela (GUI usando JFrame) que possui um label com o nome do campo e umtextFieldparaodadodecada campo da tabela. 
b) A janela deve ter um botão para próximo e anterior que permite ir para o próximo registro ou retornar aoregistroanterior, respectivamente. 
c) resolva o problema dos limites (voltar do primeiro registro e próximo registro a partir do último). 

*/
public class Janela extends JFrame {
    JButton botaoProximo, botaoVoltar;
    JTextField matriculaPessoa, nomePessoa, emailPessoa, senhaPessoa, cargoPessoa, turmaPessoa, setorPessoa;
    int id = 0;
    Cliente cliente;

    public Janela() {
        super("Pessoal cadastrado");
        setLayout(new BorderLayout());

        matriculaPessoa = new JTextField(25);
        nomePessoa = new JTextField(25);
        emailPessoa = new JTextField(25);
        senhaPessoa = new JTextField(25); 
        cargoPessoa  = new JTextField(25);
        turmaPessoa = new JTextField(25); 
        setorPessoa = new JTextField(25);
        
        botaoProximo = new JButton("Proximo");
        botaoVoltar = new JButton("Voltar");

        matriculaPessoa.setEditable(false);
        nomePessoa.setEditable(false);
        emailPessoa.setEditable(false);
        senhaPessoa.setEditable(false);
        cargoPessoa.setEditable(false);
        turmaPessoa.setEditable(false);
        setorPessoa.setEditable(false);

        cliente = new Cliente();

        adicionaItens();
        configuraListeners();
        setSize(300, 460);
        //botaoEditar.setEnabled(false);
       // botaoDeletar.setEnabled(false);
    }

    private void adicionaItens() {

        JPanel painelCampos = new JPanel(new FlowLayout());
        painelCampos.add(new JLabel("Matricula"));
        
        painelCampos.add(matriculaPessoa);
        painelCampos.add(new JLabel("Nome"));
        painelCampos.add(nomePessoa);
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(emailPessoa);
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(senhaPessoa);
        painelCampos.add(new JLabel("Cargo:"));
        painelCampos.add(cargoPessoa);
        painelCampos.add(new JLabel("Turma:"));
        painelCampos.add(turmaPessoa);
        painelCampos.add(new JLabel("Setor:"));
        painelCampos.add(setorPessoa);

        JPanel painelBotoes = new JPanel(new GridLayout(3, 2, 5, 5));
        painelBotoes.add(botaoProximo);
        painelBotoes.add(botaoVoltar);
        

        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void configuraListeners() {
        botaoProximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (id != cliente.getTamanho()) {
                        id++;
                    }
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    mostraDados();
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(id != 0){
                    id--;
                }
                try {
                    mostraDados();
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    public void verificaBotao(Scanner br){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public int getID(){
        return id;
    }

    public void mostraDados() throws RemoteException {
        Pessoal pessoa = cliente.getPessoa(id);
        matriculaPessoa.setText(Integer.toString(pessoa.getMatricula()));
        nomePessoa.setText(pessoa.getNome());
        emailPessoa.setText(pessoa.getEmail());
        senhaPessoa.setText(pessoa.getSenha());
        cargoPessoa.setText(pessoa.getCargo());
        turmaPessoa.setText(pessoa.getTurma());
        setorPessoa.setText(pessoa.getSetor());         
    }
}