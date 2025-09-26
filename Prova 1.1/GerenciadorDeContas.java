
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class GerenciadorDeContas {
    public ArrayList<Movel> listaDeContas = new ArrayList<Movel>();
  
    private ArrayList<String> carregaDados() {
      ArrayList<String> linhasArquivo = new ArrayList<String>();
      String linha;
      
  
      try (BufferedReader reader = new BufferedReader(new FileReader("moveis.txt"))) {
        linha = reader.readLine();
        while((linha = reader.readLine()) != null) {
          linhasArquivo.add(linha);
        }
      } catch (Exception e) {
        System.err.println("Erro ao abrir o arquivo: " + e.getMessage());
      }
  
      return linhasArquivo;
    }
  
  
    public List<Movel> lerPessoas(String caminho) throws IOException {
        String separador = ";"; // <-- DEFINIR O SEPARADOR AQUI
        List<Movel> pessoas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dadosSeparados = linha.split(separador);

                
                if ((dadosSeparados[4].isEmpty())&& (dadosSeparados[5].isEmpty())&& (dadosSeparados[6].isEmpty())&& (dadosSeparados[7].isEmpty())) {
                  Movel movelAdd = new Movel(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]);
                  movelAdd.setVelocidade(dadosSeparados[3]);
                  listaDeContas.add(movelAdd);
                  System.out.println(movelAdd.toString());
                }
        
                
                
                if (Integer.parseInt(dadosSeparados[2]) > 2021 && (dadosSeparados[6].isEmpty())&& (dadosSeparados[7].isEmpty())) {
                  Esportivo esportivo = new Esportivo(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]);
                  esportivo.setVelocidade(dadosSeparados[3]);
                  esportivo.setCilindradas(dadosSeparados[4]);
                  esportivo.setNumPassageiros(dadosSeparados[5]);
                  listaDeContas.add(esportivo);
                  System.out.println(esportivo.toString());
                }
                
          
                if (Integer.parseInt(dadosSeparados[2]) > 2021 && (dadosSeparados[4].isEmpty())&& (dadosSeparados[5].isEmpty())) {
                  Carga carga = new Carga(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]);
                  carga.setVelocidade(dadosSeparados[3]);
                  carga.setVolumeMaximo(dadosSeparados[6]);
                  carga.setPesoMaximo(dadosSeparados[7]);
                  listaDeContas.add(carga);
                  System.out.println(carga.toString());
                }
                
            }
        }

        return pessoas;
      }
    public void colocaNoArray() {
      ArrayList<String> linhasDeContas = carregaDados();
  
      for (String dadosDaConta : linhasDeContas) {
        String[] dadosSeparados = dadosDaConta.split(";", -1);
        System.out.println(dadosSeparados);
        
        if (Integer.parseInt(dadosSeparados[2]) > 2021 && (dadosSeparados[4].isEmpty())&& (dadosSeparados[5].isEmpty())&& (dadosSeparados[6].isEmpty())&& (dadosSeparados[7].isEmpty())) {
          Movel movelAdd = new Movel(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]);
          movelAdd.setVelocidade(dadosSeparados[3]);
          listaDeContas.add(movelAdd);
          System.out.println(movelAdd.toString());
        }

        
        
        if (Integer.parseInt(dadosSeparados[2]) > 2021 && (dadosSeparados[6].isEmpty())&& (dadosSeparados[7].isEmpty())) {
          Esportivo esportivo = new Esportivo(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]);
          esportivo.setVelocidade(dadosSeparados[3]);
          esportivo.setCilindradas(dadosSeparados[4]);
          esportivo.setNumPassageiros(dadosSeparados[5]);
          listaDeContas.add(esportivo);
          System.out.println(esportivo.toString());
        }
        if (Integer.parseInt(dadosSeparados[2]) > 2021 && (dadosSeparados[6].isEmpty())&& (dadosSeparados[7].isEmpty())&& (dadosSeparados[4].isEmpty())) {
          Esportivo esportivo = new Esportivo(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]);
          esportivo.setVelocidade(dadosSeparados[3]);
          //esportivo.setCilindradas(dadosSeparados[4]);
          esportivo.setNumPassageiros(dadosSeparados[5]);
          listaDeContas.add(esportivo);
          System.out.println(esportivo.toString());
        }
        if (Integer.parseInt(dadosSeparados[2]) > 2021 && (dadosSeparados[6].isEmpty())&& (dadosSeparados[7].isEmpty())&& (dadosSeparados[5].isEmpty())) {
          Esportivo esportivo = new Esportivo(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]);
          esportivo.setVelocidade(dadosSeparados[3]);
          esportivo.setCilindradas(dadosSeparados[4]);
          //esportivo.setNumPassageiros(dadosSeparados[5]);
          listaDeContas.add(esportivo);
          System.out.println(esportivo.toString());
        }
        
  
        if (Integer.parseInt(dadosSeparados[2]) > 2021 && (dadosSeparados[4].isEmpty())&& (dadosSeparados[5].isEmpty())) {
          Carga carga = new Carga(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]);
          carga.setVelocidade(dadosSeparados[3]);
          carga.setVolumeMaximo(dadosSeparados[6]);
          carga.setPesoMaximo(dadosSeparados[7]);
          listaDeContas.add(carga);
          System.out.println(carga.toString());
        }
        
        if (Integer.parseInt(dadosSeparados[2]) > 2021 && (dadosSeparados[4].isEmpty())&& (dadosSeparados[5].isEmpty())&& (dadosSeparados[7].isEmpty())) {
          Carga carga = new Carga(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]);
          carga.setVelocidade(dadosSeparados[3]);
          carga.setVolumeMaximo(dadosSeparados[6]);
          //carga.setPesoMaximo(dadosSeparados[7]);
          listaDeContas.add(carga);
          System.out.println(carga.toString());
        }
        if (Integer.parseInt(dadosSeparados[2]) > 2021 && (dadosSeparados[4].isEmpty())&& (dadosSeparados[5].isEmpty())&& (dadosSeparados[6].isEmpty())) {
          Carga carga = new Carga(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2]);
          carga.setVelocidade(dadosSeparados[3]);
          //carga.setVolumeMaximo(dadosSeparados[6]);
          carga.setPesoMaximo(dadosSeparados[7]);
          listaDeContas.add(carga);
          System.out.println(carga.toString());
        }
        
      }
    }
  
  }
