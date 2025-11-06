import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AlunoImplements implements DAO{

    public ArrayList<Aluno> getAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("tabela.csv")))) {
			String linha;
			br.readLine(); // Pular o cabe�alho
			while ((linha = br.readLine()) != null) {
				String[] lista = linha.split(";",-1);
                Aluno aluno = new Aluno(lista[0], lista[1], lista[2], lista[3], lista[4], lista[5], lista[6]);
                alunos.add(aluno);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        return alunos;
    }

    public void atualizarAluno(Aluno aluno, int id){
        ArrayList<Aluno> alunos = getAlunos();
        ArrayList<Aluno> novoAlunos = new ArrayList<>();
        for(int i = 0; i< alunos.size(); i++){
            if(id == i){
                novoAlunos.add(aluno);
                continue;
            }
            novoAlunos.add(alunos.get(i));
        }
        sobrescrever(novoAlunos);
    }

    public void deletarAluno(int id){
        ArrayList<Aluno> alunos = getAlunos();
        ArrayList<Aluno> novoAlunos = new ArrayList<>();
        for(int i = 0; i< alunos.size(); i++){
            if(id == i){
                continue;
            }
            novoAlunos.add(alunos.get(i));
        }
        sobrescrever(novoAlunos);
    }

    public void sobrescrever(ArrayList<Aluno> alunos){
        String nomeArquivo = "tabela.csv";
        try (FileWriter fw = new FileWriter(nomeArquivo); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("matr�cula;nome;email;senha;cargo;turma;setor\n");
            for (Aluno aluno : alunos) {
                bw.write(aluno.toString());
                bw.newLine(); // Adiciona uma quebra de linha
            }

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Aluno getAluno(int id){
        ArrayList<Aluno> alunos = getAlunos();
        return alunos.get(id);
    }
}
