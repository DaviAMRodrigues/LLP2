import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Desafio {
    public static void main(String[] args) {
        String filePath = "pessoal.csv"; 
        ArrayList<AlunoDesafio> alunos = new ArrayList<>();
        int i = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                try {
                    int matricula = Integer.parseInt(values[0]);
                    String nome = values[1].isEmpty() ? "Nome não informado" : values[1];
                    String email = values[2].isEmpty() ? "Email não informado" : values[2];
                    String senha = values[3].isEmpty() ? "123" : values[3]; 
                    String cargo = values[4].isEmpty() ? "Cargo não informado" : values[4];
                    String turma = values.length > 5 ? values[5] : ""; 
                    String setor = values.length > 6 ? values[6] : "";

                    alunos.add(new AlunoDesafio(matricula, nome, email, senha, cargo, turma, setor));
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao criar aluno: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Erro ao processar linha: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Alunos cadastrados: ");
        for (AlunoDesafio aluno : alunos) {
            System.out.println("\nInformacoes do aluno " + (i + 1) + ": ");
            aluno.getInformacoes();
            System.out.println("---------------------------------------");
            i++;
        }
        
        System.out.println("\nFim Do Programa\n\n---------------------------------------");
    }
}