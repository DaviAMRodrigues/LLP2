public class Aluno {
    private int matricula;
    private String nome;
    private String email;
    private String senha;
    private String cargo;
    private String turma;
    private String setor;

    Aluno(){
        this.matricula = 0;
        this.nome = null;
        this.email = null;
        this.senha = null;
        this.cargo = null;
        this.turma = null;
        this.setor = null;
    }
    Aluno(int matricula, String nome, String email, String senha, String cargo, String turma, String setor){
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        if (senha.length() > 6 || senha.length() < 3) {
            throw new IllegalArgumentException("A senha deve ter entre 3 e 6 caracteres.");
        }
        else{
            this.senha = senha;
        }
        this.senha = senha;
        this.cargo = cargo;
        this.turma = turma;
        this.setor = setor;
    }

    int putMatricula(int matricula){
        this.matricula = matricula;
        return this.matricula;
    }
    String putNome(String nome){
        this.nome = nome;
        return this.nome;
    }
    String putEmail(String email){
        this.email = email;
        return this.email;
    }
    String putSenha(String senha){
        this.senha = senha;
        return this.senha;
    }
    String putCargo(String cargo){
        this.cargo = cargo;
        return this.cargo;
    }
    String putTurma(String turma){
        this.turma = turma;
        return this.turma;
    }
    String putSetor(String setor){
        this.setor = setor;
        return this.setor;
    }

    void getInformacoes(){
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.print("Senha: ");
        for (int i = 0; i < this.senha.length(); i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("Cargo: " + this.cargo);
        System.out.println("Turma: " + this.turma);
        System.out.println("Setor: " + this.setor);
    }
    boolean verificaSenha(){
        if (this.senha.length() > 6 || this.senha.length() < 3) {
            System.out.println("A senha deve ter entre 3 e 6 caracteres.");
            return true;
        }
        else{
            return false;
        }
    }
}
