
import java.util.ArrayList;
import java.io.*;

public class GerenciadorDeContas {
    public ArrayList<Conta> listaDeContas = new ArrayList<Conta>();
  
    private ArrayList<String> carregaDados() {
      ArrayList<String> linhasArquivo = new ArrayList<String>();
      String linha;
  
      try (BufferedReader reader = new BufferedReader(new FileReader("contas.csv"))) {
        while((linha = reader.readLine()) != null) {
          linhasArquivo.add(linha);
        }
      } catch (Exception e) {
        System.err.println("Erro ao abrir o arquivo: " + e.getMessage());
      }
  
      return linhasArquivo;
    }
  
  
    public void colocaNoArray() {
      ArrayList<String> linhasDeContas = carregaDados();
  
      for (String dadosDaConta : linhasDeContas) {
        String[] dadosSeparados = dadosDaConta.split(",", -1);
  
        if (dadosSeparados[3].isEmpty() && (dadosSeparados[4].isEmpty())) 
        listaDeContas.add(new Conta(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]));
        
        if (!dadosSeparados[3].isEmpty() && dadosSeparados[4].isEmpty()) 
        listaDeContas.add(new ContaEspecial(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3]));
  
        if (dadosSeparados[3].isEmpty() && !dadosSeparados[4].isEmpty()) 
        listaDeContas.add(new ContaPoupanca(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[4]));
      }
    }
  
  }
