import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aluno [] alunos = new Aluno[3];
        for (int i = 0; i < 3; i++) {
            alunos[i] = new Aluno();
            System.out.println("Digite a matricula do aluno " + (i + 1) + ": ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            alunos[i].putMatricula(matricula);
            System.out.println("Digite o nome do aluno " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            alunos[i].putNome(nome);
            System.out.println("Digite o email do aluno " + (i + 1) + ": ");
            String email = scanner.nextLine();
            alunos[i].putEmail(email);
            do{
                System.out.println("Digite a senha do aluno " + (i + 1) + ": ");
                String senha = scanner.nextLine();
                alunos[i].putSenha(senha);
            }
            while (alunos[i].verificaSenha());
            System.out.println("Digite o cargo do aluno " + (i + 1) + ": ");
            String cargo = scanner.nextLine();
            alunos[i].putCargo(cargo);
            System.out.println("Digite a turma do aluno " + (i + 1) + ": ");
            String turma = scanner.nextLine();
            alunos[i].putTurma(turma);
            System.out.println("Digite o setor do aluno " + (i + 1) + ": ");
            String setor = scanner.nextLine();
            alunos[i].putSetor(setor);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("\nInformacoes do aluno " + (i + 1) + ": ");
            alunos[i].getInformacoes();
        }
        scanner.close();
    }
}