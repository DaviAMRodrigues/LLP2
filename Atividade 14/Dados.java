/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;
import java.io.BufferedWriter;

public class Dados {

    private int num;
    private String matricula;
    private String nome;

    public Dados() {
        this.num = 0;
        this.matricula = "";
        this.nome = "";
    }

    public Dados(int num, String matricula, String nome) {
        this.num = num;
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
    public Boolean read(int num, String matricula, String nome) {
        Dados dados = new Dados(num, matricula, nome);

        try (BufferedReader br = new BufferedReader(new FileReader("dados.csv"))) {
            String linha;
            // Pula o cabeçalho (primeira linha)
            br.readLine();
            
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                if (Integer.parseInt(campos[0]) == num && campos[1].equals(matricula) && campos[2].equals(nome)) {
                    dados.setNum(Integer.parseInt(campos[0]));
                    dados.setMatricula(campos[1]);
                    dados.setNome(campos[2]);
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }    
    public void update(int num, String matricula, String nome, String novaMatricula, String novoNome) {
        if (read(num, matricula, nome)) {

            Vector<Dados> dadosVector = new Vector<>();
            try (BufferedReader br = new BufferedReader(new FileReader("dados.csv"))) {
                String linha;
                // Pula o cabeçalho (primeira linha)
                br.readLine();
                while ((linha = br.readLine()) != null) {
                    String[] campos = linha.split(",");
                    if (num == Integer.parseInt(campos[0]) && matricula.equals(campos[1]) && nome.equals(campos[2])) {
                        Dados dados = new Dados(num, novaMatricula, novoNome);
                        dadosVector.add(dados);
                        continue; 
                    }

                    int numVetor = Integer.parseInt(campos[0]);
                    String matriculaVetor = campos[1];
                    String nomeVetor = campos[2];
                    Dados dados = new Dados(numVetor, matriculaVetor, nomeVetor);                    dadosVector.add(dados);
                }

                // Reescreve o arquivo com os dados atualizados
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("dados.csv"))) {
                    // Escreve o cabeçalho
                    bw.write("Num,Matricula, Nome\n");
                    // Escreve todos os dados
                    for (Dados d : dadosVector) {
                        bw.write(d.getNum() + "," + d.getMatricula() + "," + d.getNome() + "\n");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Dados não encontrados para atualização.");
        }

    }    
    public void delete(int num, String matricula, String nome) {
        if (read(num, matricula, nome)) {

            Vector<Dados> dadosVector = new Vector<>();
            try (BufferedReader br = new BufferedReader(new FileReader("dados.csv"))) {
                String linha;
                // Pula o cabeçalho (primeira linha)
                br.readLine();
                while ((linha = br.readLine()) != null) {
                    String[] campos = linha.split(",");
                    if (num == Integer.parseInt(campos[0]) && matricula.equals(campos[1]) && nome.equals(campos[2])) {
                        continue; 
                    }

                    int numVetor = Integer.parseInt(campos[0]);
                    String matriculaVetor = campos[1];
                    String nomeVetor = campos[2];
                    Dados dados = new Dados(numVetor, matriculaVetor, nomeVetor);
                    dadosVector.add(dados);                }

                // Reescreve o arquivo com os dados atualizados (sem o registro deletado)
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("dados.csv"))) {
                    // Escreve o cabeçalho
                    bw.write("Num,Matricula, Nome\n");
                    // Escreve todos os dados restantes
                    for (Dados d : dadosVector) {
                        bw.write(d.getNum() + "," + d.getMatricula() + "," + d.getNome() + "\n");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Dados não encontrados para exclusão.");
        }

    }    
    public Dados create(int num, String matricula, String nome) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("dados.csv", true))) {
            bw.write(num + "," + matricula + "," + nome + "\n");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dados dados = new Dados(num, matricula, nome);
        return dados;
    }
    
}*/