import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Sistema de Gerenciamento de Alunos
 * 
 * Esta classe gerencia um sistema CRUD (Create, Read, Update, Delete) 
 * para alunos usando interface gráfica Swing e armazenamento em CSV.
 */
public class Main {
    // Variáveis de instância para componentes principais
    private LerCSV lerCSV;
    private ArrayList<Aluno> alunos;
    private Janela janela;
    private Aluno alunoSelecionado;
    private JFrame frameInicial;
    private JFrame frameEdicao;
    
    /**
     * Construtor da classe Main
     * Inicializa os componentes e carrega os dados
     */
    public Main() {
        this.lerCSV = new LerCSV();
        this.alunos = new ArrayList<>();
        this.janela = new Janela();
        this.alunoSelecionado = new Aluno();
        
        carregarDados();
        configurarJanelas();
        configurarEventos();
    }
    
    /**
     * Método principal - ponto de entrada da aplicação
     */
    public static void main(String[] args) {
        new Main().iniciarAplicacao();
    }
    
    /**
     * Inicia a aplicação exibindo a janela inicial
     */
    public void iniciarAplicacao() {
        frameInicial.setVisible(true);
    }
    
    /**
     * Carrega os dados dos alunos do arquivo CSV
     */
    private void carregarDados() {
        alunos = lerCSV.LerCSV();
        
        if (alunos != null) {
            System.out.println("=== DADOS CARREGADOS ===");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        } else {
            System.out.println("Erro ao ler o arquivo CSV.");
            alunos = new ArrayList<>(); // Inicializa lista vazia se houve erro
        }
    }
    
    /**
     * Configura as janelas da aplicação
     */
    private void configurarJanelas() {
        // Configuração da janela inicial (Cadastrar/Ler)
        frameInicial = new JFrame("Sistema de Alunos - Cadastrar ou Consultar");
        configurarJanelaBase(frameInicial);
        adicionarComponentesJanelaInicial();
        
        // Configuração da janela de edição (Atualizar/Excluir)
        frameEdicao = new JFrame("Sistema de Alunos - Editar ou Excluir");
        configurarJanelaBase(frameEdicao);
    }
    
    /**
     * Configura as propriedades básicas de uma janela
     */
    private void configurarJanelaBase(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null); // Centraliza a janela
    }
    
    /**
     * Adiciona e posiciona os componentes na janela inicial
     */
    private void adicionarComponentesJanelaInicial() {
        // Posicionamento dos labels e campos de texto
        janela.getLabelNumero().setBounds(10, 40, 80, 25);
        janela.getTextFieldNumero().setBounds(100, 40, 160, 25);
        
        janela.getLabelMatricula().setBounds(10, 70, 80, 25);
        janela.getTextFieldMatricula().setBounds(100, 70, 160, 25);
        
        janela.getLabelNome().setBounds(10, 100, 80, 25);
        janela.getTextFieldNome().setBounds(100, 100, 160, 25);
        
        // Posicionamento dos botões
        janela.getButtonCreate().setBounds(10, 130, 250, 25);
        janela.getButtonRead().setBounds(10, 160, 250, 25);
        
        // Adição dos componentes à janela
        frameInicial.add(janela.getLabelNumero());
        frameInicial.add(janela.getTextFieldNumero());
        frameInicial.add(janela.getLabelMatricula());
        frameInicial.add(janela.getTextFieldMatricula());
        frameInicial.add(janela.getLabelNome());
        frameInicial.add(janela.getTextFieldNome());
        frameInicial.add(janela.getButtonCreate());
        frameInicial.add(janela.getButtonRead());
    }
    
    /**
     * Configura os eventos dos botões
     */
    private void configurarEventos() {
        janela.getButtonCreate().addActionListener(event -> criarAluno());
        janela.getButtonRead().addActionListener(event -> buscarAluno());
        janela.getButtonUpdate().addActionListener(event -> atualizarAluno());
        janela.getButtonDelete().addActionListener(event -> excluirAluno());
    }
    
    /**
     * Cria um novo aluno com os dados informados
     */
    private void criarAluno() {
        try {
            // Coleta os dados dos campos
            int numero = Integer.parseInt(janela.getTextFieldNumero().getText());
            String matricula = janela.getTextFieldMatricula().getText();
            String nome = janela.getTextFieldNome().getText();
            
            // Validação básica
            if (matricula.trim().isEmpty() || nome.trim().isEmpty()) {
                mostrarMensagem("Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Cria e adiciona o novo aluno
            Aluno novoAluno = new Aluno(numero, matricula, nome);
            alunos.add(novoAluno);
            
            // Salva no arquivo
            lerCSV.escreverCSV(alunos);
            
            // Limpa os campos
            limparCampos();
            
            mostrarMensagem("Aluno criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            mostrarMensagem("Por favor, insira um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Busca um aluno com os dados informados
     */
    private void buscarAluno() {
        try {
            // Coleta os dados dos campos
            int numero = Integer.parseInt(janela.getTextFieldNumero().getText());
            String matricula = janela.getTextFieldMatricula().getText();
            String nome = janela.getTextFieldNome().getText();
            
            // Busca o aluno
            Aluno alunoEncontrado = encontrarAluno(numero, matricula, nome);
            
            if (alunoEncontrado != null) {
                // Armazena o aluno encontrado
                copiarDadosAluno(alunoEncontrado, alunoSelecionado);
                
                // Abre a janela de edição
                abrirJanelaEdicao(alunoEncontrado);
                
            } else {
                mostrarMensagem("Aluno não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (NumberFormatException ex) {
            mostrarMensagem("Por favor, insira um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Atualiza os dados do aluno selecionado
     */
    private void atualizarAluno() {
        try {
            // Encontra o aluno na lista
            Aluno aluno = encontrarAlunoPorDados(alunoSelecionado);
            
            if (aluno != null) {
                // Atualiza os dados
                aluno.setNumero(Integer.parseInt(janela.getTextFieldNumero().getText()));
                aluno.setMatricula(janela.getTextFieldMatricula().getText());
                aluno.setNome(janela.getTextFieldNome().getText());
                
                // Atualiza também o aluno selecionado
                copiarDadosAluno(aluno, alunoSelecionado);
                
                // Salva no arquivo
                lerCSV.escreverCSV(alunos);
                
                mostrarMensagem("Aluno atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                mostrarMensagem("Aluno não encontrado para atualização!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (NumberFormatException ex) {
            mostrarMensagem("Por favor, insira um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Exclui o aluno selecionado
     */
    private void excluirAluno() {
        Aluno alunoParaExcluir = encontrarAlunoPorDados(alunoSelecionado);
        
        if (alunoParaExcluir != null) {
            // Confirma a exclusão
            int resposta = JOptionPane.showConfirmDialog(
                null, 
                "Tem certeza que deseja excluir o aluno " + alunoParaExcluir.getNome() + "?",
                "Confirmar Exclusão", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (resposta == JOptionPane.YES_OPTION) {
                alunos.remove(alunoParaExcluir);
                lerCSV.escreverCSV(alunos);
                
                // Volta para a janela inicial
                voltarParaJanelaInicial();
                
                mostrarMensagem("Aluno excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            mostrarMensagem("Aluno não encontrado para exclusão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Abre a janela de edição com os dados do aluno
     */
    private void abrirJanelaEdicao(Aluno aluno) {
        frameInicial.setVisible(false);
        
        // Limpa a janela de edição
        frameEdicao.getContentPane().removeAll();
        
        // Adiciona informações do aluno encontrado
        JLabel labelInfo = new JLabel("Aluno encontrado:");
        labelInfo.setBounds(10, 10, 150, 25);
        
        JLabel labelNomeAluno = new JLabel(aluno.getNome());
        labelNomeAluno.setBounds(160, 10, 200, 25);
        
        frameEdicao.add(labelInfo);
        frameEdicao.add(labelNomeAluno);
        
        // Configura os labels para edição
        janela.getLabelNumero().setText("Novo Número:");
        janela.getLabelMatricula().setText("Nova Matrícula:");
        janela.getLabelNome().setText("Novo Nome:");
        
        // Posiciona os componentes na janela de edição
        janela.getLabelNumero().setBounds(10, 40, 100, 25);
        janela.getTextFieldNumero().setBounds(120, 40, 160, 25);
        
        janela.getLabelMatricula().setBounds(10, 70, 100, 25);
        janela.getTextFieldMatricula().setBounds(120, 70, 160, 25);
        
        janela.getLabelNome().setBounds(10, 100, 100, 25);
        janela.getTextFieldNome().setBounds(120, 100, 160, 25);
        
        janela.getButtonUpdate().setBounds(10, 130, 120, 25);
        janela.getButtonDelete().setBounds(140, 130, 120, 25);
        
        // Adiciona os componentes
        frameEdicao.add(janela.getLabelNumero());
        frameEdicao.add(janela.getTextFieldNumero());
        frameEdicao.add(janela.getLabelMatricula());
        frameEdicao.add(janela.getTextFieldMatricula());
        frameEdicao.add(janela.getLabelNome());
        frameEdicao.add(janela.getTextFieldNome());
        frameEdicao.add(janela.getButtonUpdate());
        frameEdicao.add(janela.getButtonDelete());
        
        // Limpa os campos para nova entrada
        limparCampos();
        
        frameEdicao.revalidate();
        frameEdicao.repaint();
        frameEdicao.setVisible(true);
    }
    
    /**
     * Encontra um aluno pelos dados informados
     */
    private Aluno encontrarAluno(int numero, String matricula, String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNumero() == numero &&
                aluno.getMatricula().equals(matricula) && 
                aluno.getNome().equals(nome)) {
                return aluno;
            }
        }
        return null;
    }
    
    /**
     * Encontra um aluno pelos dados de outro aluno
     */
    private Aluno encontrarAlunoPorDados(Aluno alunoReferencia) {
        return encontrarAluno(
            alunoReferencia.getNumero(),
            alunoReferencia.getMatricula(),
            alunoReferencia.getNome()
        );
    }
    
    /**
     * Copia os dados de um aluno para outro
     */
    private void copiarDadosAluno(Aluno origem, Aluno destino) {
        destino.setNumero(origem.getNumero());
        destino.setMatricula(origem.getMatricula());
        destino.setNome(origem.getNome());
    }
    
    /**
     * Limpa todos os campos de entrada
     */
    private void limparCampos() {
        janela.getTextFieldNumero().setText("");
        janela.getTextFieldMatricula().setText("");
        janela.getTextFieldNome().setText("");
    }
    
    /**
     * Restaura os labels originais para a janela inicial
     */
    private void restaurarLabelsOriginais() {
        janela.getLabelNumero().setText("Número:");
        janela.getLabelMatricula().setText("Matrícula:");
        janela.getLabelNome().setText("Nome:");
    }
    
    /**
     * Volta para a janela inicial
     */
    private void voltarParaJanelaInicial() {
        frameEdicao.setVisible(false);
        restaurarLabelsOriginais();
        limparCampos();
        frameInicial.setVisible(true);
    }
    
    /**
     * Exibe uma mensagem para o usuário
     */
    private void mostrarMensagem(String mensagem, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
    }
}
