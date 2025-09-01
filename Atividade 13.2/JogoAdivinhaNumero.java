import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JogoAdivinhaNumero {

    public JogoAdivinhaNumero() {
        int palpite = 0,
                sorteado,
                tentativas = 0;


        
        Random geradorDeAleatorios = new Random();
        sorteado = geradorDeAleatorios.nextInt(1000) + 1;
        System.out.println("Número entre 1 e 1000 sorteado!");

        JLabel label = new JLabel("", JLabel.CENTER);

        String dica = "";

        do {
            label.setText("<html>" + dica + "Numero de tentativas: " + tentativas + "<br/>Qual seu palpite?</html>");
            String input = JOptionPane.showInputDialog(label);
            palpite = Integer.parseInt(input);

            tentativas++;

            dica = dica(palpite, sorteado, tentativas, label, dica);
        } while (palpite != sorteado);

        JOptionPane.showMessageDialog(null, "<html>" + dica + "</html>", "Resultado", JOptionPane.INFORMATION_MESSAGE);

    }

    public String dica(int palpite, int numero, int tentativas, JLabel label, String string) {
        if (palpite > numero) {
            label.setText("<html>Seu palpite é maior que o número sorteado.<br/></html>");
            string = "Seu palpite é maior que o número sorteado.<br/>";
            return string;
        } else {
            if (palpite < numero) {
                string = "Seu palpite é menor que o número sorteado.<br/>";
                return string;
            } else {
                string = "Parabéns, você acertou! O número era " + numero + "<br/>" +
                        "Você tentou " + tentativas + " vezes antes de acertar!";
                        return string;
            }
        }
    }

    public static void main(String[] args) {
        new JogoAdivinhaNumero();

    }

}