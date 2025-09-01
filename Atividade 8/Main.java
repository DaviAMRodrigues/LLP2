import java.util.*;

public class Main {
  /*public static void contadorDoTipoDeConta(ArrayList<Conta> listaDeContas) {
    int numeroContaComum = 0;
    int numeroContasEspecial = 0;
    int numeroContasPoupanca = 0;

    for (Conta conta : listaDeContas) {
      if (conta instanceof ContaEspecial) {
        numeroContasEspecial++;
      }

      if (conta instanceof ContaPoupanca) {
        numeroContasPoupanca++;
      }
    }
    numeroContaComum = listaDeContas.size() - (numeroContasEspecial + numeroContasPoupanca);

    System.out.println("Contas Comuns:" + numeroContaComum);
    System.out.println("Contas Especiais:" + numeroContasEspecial);
    System.out.println("Contas Poupanca:" + numeroContasPoupanca);
  }

  public static void saldoMenorQueLimite(ArrayList<Conta> listaDeContas) {
    for (Conta conta : listaDeContas) {
      if (conta instanceof ContaEspecial) {
        ContaEspecial contaEspecial = (ContaEspecial) conta;

        if (contaEspecial.verificaSaldo() < contaEspecial.getLimite()) {
          System.out.println(contaEspecial);
        }
      } else {
        if (conta.verificaSaldo() < 0) {
          System.out.println(conta);
        }
      }
    }
  }

  public static void contasComRendimento(ArrayList<Conta> listaDeContas) {
    for (Conta conta : listaDeContas) {
      if (conta instanceof ContaPoupanca) {
        ContaPoupanca contaPoupanca = (ContaPoupanca) conta;

        System.out.println(conta + " - Rendimento: " + contaPoupanca.calculaRendimento());
      }
    }
  }*/

  public static void main(String[] args) {
    /*GerenciadorDeContas gerenciadorDeContas = new GerenciadorDeContas();
    gerenciadorDeContas.colocaNoArray();

    System.out.println("Quantidade de Contas Por Tipo: ");
    contadorDoTipoDeConta(gerenciadorDeContas.listaDeContas);

    System.out.println("\nContas com saldo menor o limite: ");
    saldoMenorQueLimite(gerenciadorDeContas.listaDeContas);

    System.out.println("\nContas com seus respectivos rendimentos: ");
    contasComRendimento(gerenciadorDeContas.listaDeContas);*/

  
    try {
      LeitorTxt leitorTxt = new LeitorTxt();
      leitorTxt.lerSequencial("bolas.txt");
      String linha1 = leitorTxt.lerLinha("bolas.txt", 0);
      System.out.println("Primeira linha: " + linha1);
      LeitorCsv leitorCsv = new LeitorCsv();
      leitorCsv.lerSequencial("contas.csv");
      String[] linha2 = leitorCsv.lerLinha("contas.csv", 0);
      System.out.println("Primeira linha: " + Arrays.toString(linha2));
      EscritorTxt escritorTxt = new EscritorTxt();
      escritorTxt.substituirTexto("bolas.txt", "guri", "pessoa");
      EscritorCsv escritorCsv = new EscritorCsv();
      escritorCsv.substituirTexto("contas.csv", "456", "183");

    } catch (Exception e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }
  }
}
