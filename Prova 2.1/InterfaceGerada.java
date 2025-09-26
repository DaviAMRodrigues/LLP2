package src;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfaceGerada extends JFrame {
    private JTextField matricula;
    private JTextField nome;
    private JTextField email;
    private JTextField senha;
    private JTextField cargo;
    private JTextField turma;
    private JTextField setor;
    private JButton anterior;
    private JButton proximo;
    private ArrayList<Pessoal> elementosPessoa = new ArrayList<>();
    private int indiceAtual = 0;

    public InterfaceGerada() {
        initComponents();
        setupLayout();
        setupEvents();
    }
    
    private void initComponents() {
        
        
        matricula = new JTextField(20);
        nome = new JTextField(20);
        email = new JTextField(20);
        senha = new JTextField(20);
        cargo = new JTextField(20);
        turma = new JTextField(20);
        setor = new JTextField(20);
        anterior = new JButton("Anterior");
        proximo = new JButton("Proximo");
    }
    
    private void setupLayout() {
        setTitle("Interface Gerada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        // Painel para campos de texto
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));

        // Campo matricula
        JPanel panelMatricula = new JPanel();
        panelMatricula.add(new JLabel("Matricula:"));
        panelMatricula.add(matricula);
        panelCampos.add(panelMatricula);
        
        // Campo nome
        JPanel panelNome = new JPanel();
        panelNome.add(new JLabel("Nome:"));
        panelNome.add(nome);
        panelCampos.add(panelNome);
        
        // Campo email
        JPanel panelEmail = new JPanel();
        panelEmail.add(new JLabel("Email:"));
        panelEmail.add(email);
        panelCampos.add(panelEmail);
        
        // Campo senha
        JPanel panelSenha = new JPanel();
        panelSenha.add(new JLabel("Senha:"));
        panelSenha.add(senha);
        panelCampos.add(panelSenha);
        
        // Campo cargo
        JPanel panelCargo = new JPanel();
        panelCargo.add(new JLabel("Cargo:"));
        panelCargo.add(cargo);
        panelCampos.add(panelCargo);
        
        // Campo turma
        JPanel panelTurma = new JPanel();
        panelTurma.add(new JLabel("Turma:"));
        panelTurma.add(turma);
        panelCampos.add(panelTurma);
        
        // Campo setor
        JPanel panelSetor = new JPanel();
        panelSetor.add(new JLabel("Setor:"));
        panelSetor.add(setor);
        panelCampos.add(panelSetor);
        
        add(panelCampos);

        // Painel para botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.add(anterior);
        panelBotoes.add(proximo);
        add(panelBotoes);

        pack();
        setLocationRelativeTo(null);
    }
    
    private void setupEvents() {
        anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação do botão anterior
                JOptionPane.showMessageDialog(InterfaceGerada.this, 
                    "Botão Anterior foi clicado!");
            }
        });
        
        proximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação do botão proximo
                JOptionPane.showMessageDialog(InterfaceGerada.this, 
                    "Botão Proximo foi clicado!");
            }
        });
        
    }
    
    public void desenhar(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceGerada().setVisible(true);
            }
        });
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceGerada().setVisible(true);
            }
        });
    }*/
}