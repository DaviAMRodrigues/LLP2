/*import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Gerenciamento de Dados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();       
        JTextField campoNumero = new JTextField(15);
        JTextField campoMatricula = new JTextField(15);
        JTextField campoNome = new JTextField(15);
        
        Dimension tamanhoPreferido = new Dimension(200, 25);
        campoNumero.setPreferredSize(tamanhoPreferido);
        campoMatricula.setPreferredSize(tamanhoPreferido);
        campoNome.setPreferredSize(tamanhoPreferido);

        JLabel labelNumero = new JLabel("Numero:");
        JLabel labelMatricula = new JLabel("Matricula:");
        JLabel labelNome = new JLabel("Nome:");

        JButton botaoLer = new JButton("Ler");
        JButton botaoCriar = new JButton("Criar");        
        JButton botaoInserir = new JButton("Inserir");
        JButton botaoLimpar = new JButton("Limpar");
        JButton botaoVoltar = new JButton("Voltar");
        botaoInserir.setVisible(false);
        botaoLimpar.setVisible(false);
        botaoVoltar.setVisible(false);

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(labelNumero, gbc);
        gbc.gridx = 1;
        frame.add(campoNumero, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(labelMatricula, gbc);
        gbc.gridx = 1;
        frame.add(campoMatricula, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(labelNome, gbc);
        gbc.gridx = 1;
        frame.add(campoNome, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(botaoLer, gbc);
        gbc.gridx = 1;
        frame.add(botaoCriar, gbc); 

        gbc.gridx = 0; gbc.gridy = 4;
        frame.add(botaoInserir, gbc);
        gbc.gridx = 1;
        frame.add(botaoLimpar, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        frame.add(botaoVoltar, gbc);
        gbc.gridwidth = 1; 

        botaoLer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(campoNumero.getText());
                    String matricula = campoMatricula.getText();
                    String nome = campoNome.getText();
                    
                    Dados dados = new Dados();
                    boolean encontrou = dados.read(num, matricula, nome);
                    
                    if (encontrou) {
                        JOptionPane.showMessageDialog(frame, "Dados encontrados!");
                        botaoLer.setVisible(false);
                        botaoCriar.setVisible(false);                        
                        botaoInserir.setVisible(true);
                        botaoLimpar.setVisible(true);
                        botaoVoltar.setVisible(true);
                        frame.revalidate();
                        frame.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Dados não encontrados!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido!");
                }
            }
        });

        botaoCriar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(campoNumero.getText());
                    String matricula = campoMatricula.getText();
                    String nome = campoNome.getText();
                    
                    if (matricula.trim().isEmpty() || nome.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!");
                        return;
                    }
                    
                    Dados dados = new Dados();
                    dados.create(num, matricula, nome);
                    JOptionPane.showMessageDialog(frame, "Dados criados com sucesso!");
                    
                    campoNumero.setText("");
                    campoMatricula.setText("");
                    campoNome.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido!");
                }
            }
        });  

        botaoInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(campoNumero.getText());
                    String matricula = campoMatricula.getText();
                    String nome = campoNome.getText();
                    
                    if (matricula.trim().isEmpty() || nome.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!");
                        return;
                    }
                    
                    JPanel painelEdicao = new JPanel(new GridLayout(2, 2, 5, 5));
                    JTextField campoNovaMatricula = new JTextField(matricula);
                    JTextField campoNovoNome = new JTextField(nome);
                    
                    painelEdicao.add(new JLabel("Nova Matrícula:"));
                    painelEdicao.add(campoNovaMatricula);
                    painelEdicao.add(new JLabel("Novo Nome:"));
                    painelEdicao.add(campoNovoNome);
                    
                    int resultado = JOptionPane.showConfirmDialog(frame, painelEdicao, 
                        "Editar Dados", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    
                    if (resultado == JOptionPane.OK_OPTION) {
                        String novaMatricula = campoNovaMatricula.getText();
                        String novoNome = campoNovoNome.getText();
                        
                        if (!novaMatricula.trim().isEmpty() && !novoNome.trim().isEmpty()) {
                            Dados dados = new Dados();
                            dados.update(num, matricula, nome, novaMatricula, novoNome);
                            JOptionPane.showMessageDialog(frame, "Dados atualizados com sucesso!");
                            
                            campoMatricula.setText(novaMatricula);
                            campoNome.setText(novoNome);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido!");
                }
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(campoNumero.getText());
                    String matricula = campoMatricula.getText();
                    String nome = campoNome.getText();
                    
                    if (matricula.trim().isEmpty() || nome.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!");
                        return;
                    }
                    
                    // Confirma a exclusão
                    int resposta = JOptionPane.showConfirmDialog(frame, 
                        "Tem certeza que deseja deletar este registro?", 
                        "Confirmar Exclusão", 
                        JOptionPane.YES_NO_OPTION);
                    
                    if (resposta == JOptionPane.YES_OPTION) {
                        Dados dados = new Dados();
                        dados.delete(num, matricula, nome);
                        JOptionPane.showMessageDialog(frame, "Dados deletados com sucesso!");
                        campoNumero.setText("");
                        campoMatricula.setText("");
                        campoNome.setText("");                        
                        botaoInserir.setVisible(false);
                        botaoLimpar.setVisible(false);
                        botaoVoltar.setVisible(false);
                        botaoLer.setVisible(true);
                        botaoCriar.setVisible(true);
                        frame.revalidate();
                        frame.repaint();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um número válido!");
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                botaoInserir.setVisible(false);
                botaoLimpar.setVisible(false);
                botaoVoltar.setVisible(false);
                botaoLer.setVisible(true);
                botaoCriar.setVisible(true);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.pack();
        frame.setMinimumSize(frame.getSize()); 
        frame.setVisible(true);
    }
}*/
