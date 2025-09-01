public class Aluno {
    private String nome;
    private String matricula;
    private int numero;

    public Aluno(int numero, String matricula, String nome) {
        this.nome = nome;
        this.matricula = matricula;
        this.numero = numero;
    }

    public Aluno() {
        // Default constructor
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", matricula=" + matricula + ", numero=" + numero + "]";
    }

    
}
