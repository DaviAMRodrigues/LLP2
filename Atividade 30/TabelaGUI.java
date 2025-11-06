import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TabelaGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private int index = 0;

	private JTextField matriculaField;
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField senhaField;
	private JTextField cargoField;
	private JTextField turmaField;
	private JTextField setorField;
	private DAO dao;

	public TabelaGUI() {
		dao = new AlunoImplements();
		// Configura��o inicial da janela
		setTitle("Tabela");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Carregar dados do arquivo

		// Configurar layout
		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(new JLabel("Matr�cula:"));
		matriculaField = new JTextField(50);
		add(matriculaField);

		add(new JLabel("Nome:"));
		nomeField = new JTextField(50);
		add(nomeField);

		add(new JLabel("Email:"));
		emailField = new JTextField(50);
		add(emailField);

		add(new JLabel("Senha:"));
		senhaField = new JTextField(50);
		add(senhaField);

		add(new JLabel("Cargo:"));
		cargoField = new JTextField(50);
		add(cargoField);

		add(new JLabel("Turma:"));
		turmaField = new JTextField(50);
		add(turmaField);

		add(new JLabel("Setor:"));
		setorField = new JTextField(50);
		add(setorField);

		JButton prevButton = new JButton("Anterior");
		prevButton.addActionListener(e -> mostrarAnterior());
		add(prevButton);

		JButton nextButton = new JButton("Pr�ximo");
		nextButton.addActionListener(e -> mostrarProximo());
		add(nextButton);

		JButton updateButton = new JButton("Atualizar");
		updateButton.addActionListener(e -> atualizarDado());
		add(updateButton);

		JButton deleteButton = new JButton("Deletar");
		deleteButton.addActionListener(e -> deletarDado());
		add(deleteButton);

		JButton saveButton = new JButton("Salvar");
		saveButton.addActionListener(e -> salvarDados());
		add(saveButton);

		// Mostrar o primeiro dado
		mostrarDado();
	}

	private void mostrarDado() {
		if (!dao.getAlunos().isEmpty() && index < dao.getAlunos().size() && index >= 0) {
			Aluno aluno = dao.getAluno(index);
			matriculaField.setText(aluno.getMatricula());
			nomeField.setText(aluno.getNome());
			emailField.setText(aluno.getEmail());
			senhaField.setText(aluno.getSenha());
			cargoField.setText(aluno.getCargo());
			turmaField.setText(aluno.getTurma());
			setorField.setText(aluno.getSetor());
		}
	}

	private void mostrarAnterior() {
		if (index > 0) {
			index--;
			mostrarDado();
		}
	}

	private void mostrarProximo() {
		if (index < dao.getAlunos().size() - 1) {
			index++;
			mostrarDado();
		}
	}

	private void atualizarDado() {
		if (!dao.getAlunos().isEmpty() && index < dao.getAlunos().size() && index >= 0) {
			Aluno aluno = new Aluno(matriculaField.getText(), nomeField.getText(), emailField.getText(), senhaField.getText(), cargoField.getText(), turmaField.getText(), setorField.getText());
			dao.atualizarAluno(aluno, index);
		}
	}

	private void deletarDado() {
		if (!dao.getAlunos().isEmpty() && index < dao.getAlunos().size() && index >= 0) {
			dao.deletarAluno(index);
			if (index > 0) {
				index--;
			}
			mostrarDado();
		}
	}

	private void salvarDados() {
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new TabelaGUI().setVisible(true);
		});
	}
}
