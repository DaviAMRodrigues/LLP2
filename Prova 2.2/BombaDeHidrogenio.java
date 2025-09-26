
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.TitledBorder;

// Classe auxiliar para gerenciar ordem dos componentes
class ComponenteOrdem {
    private String tipo;
    private String nome;
    private int ordem;
    
    public ComponenteOrdem(String tipo, String nome, int ordem) {
        this.tipo = tipo;
        this.nome = nome;
        this.ordem = ordem;
    }
    
    public String getTipo() { return tipo; }
    public String getNome() { return nome; }
    public int getOrdem() { return ordem; }
    public void setOrdem(int ordem) { this.ordem = ordem; }
    
    @Override
    public String toString() {
        return tipo + ": " + nome;
    }
}

public class BombaDeHidrogenio extends JFrame {

    private JTextField entradaCaixas;
    private JCheckBox checkBotoes;
    private JTextField entradaBotoes;
    private JCheckBox checkCheckboxes;
    private JTextField entradaCheckboxes;
    private JCheckBox checkListeners;
    private JTextField entradaListeners;
    private JCheckBox checkLabels;
    private JTextField entradaLabels;
    private JCheckBox checkComboBoxes;
    private JTextField entradaComboBoxes;
    private JCheckBox checkTextAreas;
    private JTextField entradaTextAreas;
    private JCheckBox checkSliders;
    private JTextField entradaSliders;
    private JLabel rotuloResultado;
    private boolean botoesHabilitados = false;
    private boolean checkboxesHabilitados = false;
    private boolean listenersHabilitados = false;
    private boolean labelsHabilitados = false;
    private boolean comboBoxesHabilitados = false;
    private boolean textAreasHabilitados = false;
    private boolean slidersHabilitados = false;

    private java.util.List<JTextField> entradasCaixas = new ArrayList<>();
    private java.util.List<JTextField> entradasBotoes = new ArrayList<>();
    private java.util.List<JTextField> entradasCheckboxes = new ArrayList<>();
    private java.util.List<JTextField> entradasListeners = new ArrayList<>();
    private java.util.List<JTextField> entradasLabels = new ArrayList<>();
    private java.util.List<JTextField> entradasComboBoxes = new ArrayList<>();
    private java.util.List<JTextField> entradasSliders = new ArrayList<>();
    private java.util.List<JTextField> entradasTextAreas = new ArrayList<>();
    private java.util.List<JComboBox<String>> tiposListeners = new ArrayList<>();
    private java.util.Map<String, java.util.Set<String>> listenersParaComponentes = new java.util.HashMap<>();
    private java.util.List<ComponenteOrdem> ordemComponentes = new ArrayList<>();

    public BombaDeHidrogenio() {
        setTitle("Window Creator - Interface Generator");
        setSize(650, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        
        // Usar BorderLayout principal
        setLayout(new BorderLayout(10, 10));
        
        // Painel principal com scroll
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título
        JLabel titleLabel = new JLabel("Interface Component Generator", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(34, 139, 34));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        mainPanel.add(titleLabel);
        
        // Seção de Text Fields (obrigatório)
        JPanel textFieldSection = new JPanel();
        textFieldSection.setLayout(new BorderLayout(10, 5));
        textFieldSection.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                "Text Fields (Required)",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 12),
                new Color(70, 70, 70)
            ),
            BorderFactory.createEmptyBorder(10, 15, 15, 15)
        ));
        textFieldSection.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JLabel label = new JLabel("Enter number of text fields:");
        label.setFont(new Font("Arial", Font.PLAIN, 11));
        
        entradaCaixas = new JTextField(5);
        entradaCaixas.setFont(new Font("Arial", Font.PLAIN, 11));
        entradaCaixas.setPreferredSize(new Dimension(60, 25));
        
        inputPanel.add(label);
        inputPanel.add(entradaCaixas);
        textFieldSection.add(inputPanel, BorderLayout.CENTER);
        textFieldSection.add(Box.createVerticalStrut(5), BorderLayout.SOUTH);
        
        mainPanel.add(textFieldSection);
        
        // Seção de Buttons
        JPanel buttonSection = createComponentSection("Buttons", "Number of buttons:", 
                                                    entradaBotoes = new JTextField(5), 
                                                    checkBotoes = new JCheckBox("Include buttons"), 
                                                    botoesHabilitados);
        mainPanel.add(buttonSection);
        
        // Seção de Checkboxes
        JPanel checkboxSection = createComponentSection("Checkboxes", "Number of checkboxes:", 
                                                       entradaCheckboxes = new JTextField(5), 
                                                       checkCheckboxes = new JCheckBox("Include checkboxes"), 
                                                       checkboxesHabilitados);
        mainPanel.add(checkboxSection);
        
        // Seção de Labels
        JPanel labelSection = createComponentSection("Labels", "Number of labels:", 
                                                    entradaLabels = new JTextField(5), 
                                                    checkLabels = new JCheckBox("Include labels"), 
                                                    labelsHabilitados);
        mainPanel.add(labelSection);
        
        // Seção de ComboBoxes
        JPanel comboSection = createComponentSection("ComboBoxes", "Number of combo boxes:", 
                                                    entradaComboBoxes = new JTextField(5), 
                                                    checkComboBoxes = new JCheckBox("Include combo boxes"), 
                                                    comboBoxesHabilitados);
        mainPanel.add(comboSection);
        
        // Seção de TextAreas
        JPanel textAreaSection = createComponentSection("Text Areas", "Number of text areas:", 
                                                       entradaTextAreas = new JTextField(5), 
                                                       checkTextAreas = new JCheckBox("Include text areas"), 
                                                       textAreasHabilitados);
        mainPanel.add(textAreaSection);
        
        // Seção de Sliders
        JPanel sliderSection = createComponentSection("Sliders", "Number of sliders:", 
                                                     entradaSliders = new JTextField(5), 
                                                     checkSliders = new JCheckBox("Include sliders"), 
                                                     slidersHabilitados);
        mainPanel.add(sliderSection);
        
        // Seção de Listeners
        JPanel listenerSection = createComponentSection("Event Listeners", "Number of listeners:", 
                                                       entradaListeners = new JTextField(5), 
                                                       checkListeners = new JCheckBox("Include listeners"), 
                                                       listenersHabilitados);
        mainPanel.add(listenerSection);
        
        // Configurar ações dos checkboxes
        setupCheckboxActions();
        
        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        buttonPanel.setPreferredSize(new Dimension(600, 70));
        buttonPanel.setBackground(new Color(248, 248, 248));
        
        JButton botaoOK = new JButton("Generate Interface");
        botaoOK.setFont(new Font("Arial", Font.BOLD, 14));
        botaoOK.setBackground(new Color(34, 139, 34));
        botaoOK.setForeground(Color.WHITE);
        botaoOK.setPreferredSize(new Dimension(180, 40));
        botaoOK.setFocusPainted(false);
        botaoOK.setBorder(BorderFactory.createRaisedBevelBorder());
        
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 14));
        resetButton.setBackground(new Color(220, 220, 220));
        resetButton.setPreferredSize(new Dimension(100, 40));
        resetButton.setFocusPainted(false);
        resetButton.setBorder(BorderFactory.createRaisedBevelBorder());
        
        buttonPanel.add(resetButton);
        buttonPanel.add(botaoOK);
        
        // Label de resultado
        rotuloResultado = new JLabel("Ready to generate interface...", JLabel.CENTER);
        rotuloResultado.setFont(new Font("Arial", Font.PLAIN, 12));
        rotuloResultado.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        rotuloResultado.setPreferredSize(new Dimension(600, 40));
        rotuloResultado.setOpaque(true);
        rotuloResultado.setBackground(new Color(245, 245, 245));
        
        // Adicionar componentes ao frame
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        
        // Painel inferior para botões e resultado
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(rotuloResultado, BorderLayout.SOUTH);
        
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        // Configurar ações
        botaoOK.addActionListener(e -> criarAbaNomes());
        resetButton.addActionListener(e -> resetForm());

        setVisible(true);
    }
    
    private JPanel createComponentSection(String title, String labelText, JTextField textField, 
                                        JCheckBox checkBox, boolean isEnabled) {
        JPanel section = new JPanel();
        section.setLayout(new BorderLayout(10, 5));
        section.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                title,
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 12),
                new Color(70, 70, 70)
            ),
            BorderFactory.createEmptyBorder(10, 15, 15, 15)
        ));
        section.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        
        if (checkBox != null) {
            checkBox.setFont(new Font("Arial", Font.PLAIN, 11));
            section.add(checkBox, BorderLayout.WEST);
        }
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 11));
        
        textField.setFont(new Font("Arial", Font.PLAIN, 11));
        textField.setPreferredSize(new Dimension(60, 25));
        
        if (checkBox != null) {
            textField.setVisible(false);
            label.setVisible(false);
        }
        
        inputPanel.add(label);
        inputPanel.add(textField);
        section.add(inputPanel, BorderLayout.CENTER);
        
        // Adicionar espaçamento
        section.add(Box.createVerticalStrut(5), BorderLayout.SOUTH);
        
        return section;
    }
    
    private void setupCheckboxActions() {
        checkBotoes.addActionListener(e -> {
            botoesHabilitados = checkBotoes.isSelected();
            toggleComponentVisibility(checkBotoes.getParent(), botoesHabilitados);
        });

        checkCheckboxes.addActionListener(e -> {
            checkboxesHabilitados = checkCheckboxes.isSelected();
            toggleComponentVisibility(checkCheckboxes.getParent(), checkboxesHabilitados);
        });

        checkListeners.addActionListener(e -> {
            listenersHabilitados = checkListeners.isSelected();
            toggleComponentVisibility(checkListeners.getParent(), listenersHabilitados);
        });
        
        checkLabels.addActionListener(e -> {
            labelsHabilitados = checkLabels.isSelected();
            toggleComponentVisibility(checkLabels.getParent(), labelsHabilitados);
        });
        
        checkComboBoxes.addActionListener(e -> {
            comboBoxesHabilitados = checkComboBoxes.isSelected();
            toggleComponentVisibility(checkComboBoxes.getParent(), comboBoxesHabilitados);
        });
        
        checkTextAreas.addActionListener(e -> {
            textAreasHabilitados = checkTextAreas.isSelected();
            toggleComponentVisibility(checkTextAreas.getParent(), textAreasHabilitados);
        });
        
        checkSliders.addActionListener(e -> {
            slidersHabilitados = checkSliders.isSelected();
            toggleComponentVisibility(checkSliders.getParent(), slidersHabilitados);
        });
    }
    
    private void toggleComponentVisibility(Container parent, boolean visible) {
        Component[] components = parent.getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel) {
                JPanel panel = (JPanel) comp;
                Component[] panelComponents = panel.getComponents();
                for (Component panelComp : panelComponents) {
                    if (panelComp instanceof JLabel || panelComp instanceof JTextField) {
                        panelComp.setVisible(visible);
                    }
                }
            }
        }
        revalidate();
        repaint();
    }
    
    private void resetForm() {
        // Resetar text fields
        entradaCaixas.setText("");
        entradaBotoes.setText("");
        entradaCheckboxes.setText("");
        entradaListeners.setText("");
        entradaLabels.setText("");
        entradaComboBoxes.setText("");
        entradaTextAreas.setText("");
        entradaSliders.setText("");
        
        // Resetar checkboxes
        checkBotoes.setSelected(false);
        checkCheckboxes.setSelected(false);
        checkListeners.setSelected(false);
        checkLabels.setSelected(false);
        checkComboBoxes.setSelected(false);
        checkTextAreas.setSelected(false);
        checkSliders.setSelected(false);
        
        // Resetar estado
        botoesHabilitados = false;
        checkboxesHabilitados = false;
        listenersHabilitados = false;
        labelsHabilitados = false;
        comboBoxesHabilitados = false;
        textAreasHabilitados = false;
        slidersHabilitados = false;
        
        // Ocultar campos
        toggleComponentVisibility(checkBotoes.getParent(), false);
        toggleComponentVisibility(checkCheckboxes.getParent(), false);
        toggleComponentVisibility(checkListeners.getParent(), false);
        toggleComponentVisibility(checkLabels.getParent(), false);
        toggleComponentVisibility(checkComboBoxes.getParent(), false);
        toggleComponentVisibility(checkTextAreas.getParent(), false);
        toggleComponentVisibility(checkSliders.getParent(), false);
        
        // Limpar resultado
        rotuloResultado.setText("Ready to generate interface...");
        
        // Limpar ordem dos componentes
        ordemComponentes.clear();
    }

    private void criarAbaNomes() {
        try {
            int numeroCaixas = Integer.parseInt(entradaCaixas.getText());
            int numeroBotoes = 0;
            int numeroCheckboxes = 0;
            int numeroListeners = 0;
            int numeroLabels = 0;
            int numeroComboBoxes = 0;
            int numeroTextAreas = 0;
            int numeroSliders = 0;

            if (botoesHabilitados) {
                numeroBotoes = Integer.parseInt(entradaBotoes.getText());
            }

            if (checkboxesHabilitados) {
                numeroCheckboxes = Integer.parseInt(entradaCheckboxes.getText());
            }

            if (listenersHabilitados) {
                numeroListeners = Integer.parseInt(entradaListeners.getText());
            }

            if (labelsHabilitados) {
                numeroLabels = Integer.parseInt(entradaLabels.getText());
            }

            if (comboBoxesHabilitados) {
                numeroComboBoxes = Integer.parseInt(entradaComboBoxes.getText());
            }

            if (textAreasHabilitados) {
                numeroTextAreas = Integer.parseInt(entradaTextAreas.getText());
            }

            if (slidersHabilitados) {
                numeroSliders = Integer.parseInt(entradaSliders.getText());
            }

            JDialog janelaNomes = new JDialog(this, "Define Names", true);
            janelaNomes.setSize(400, 600);
            janelaNomes.setLayout(new BorderLayout());

            JPanel painelCampos = new JPanel();
            painelCampos.setLayout(new BoxLayout(painelCampos, BoxLayout.Y_AXIS));

            entradasCaixas.clear();
            entradasBotoes.clear();
            entradasCheckboxes.clear();
            entradasListeners.clear();
            entradasLabels.clear();
            entradasComboBoxes.clear();
            entradasTextAreas.clear();
            entradasSliders.clear();
            tiposListeners.clear();

            if (numeroCaixas > 0) {
                painelCampos.add(new JLabel("Text field names:"));
                for (int i = 0; i < numeroCaixas; i++) {
                    JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    linha.add(new JLabel("Field " + (i + 1) + ":"));
                    JTextField campo = new JTextField("field" + (i + 1), 20);
                    linha.add(campo);
                    painelCampos.add(linha);
                    entradasCaixas.add(campo);
                }
            }

            if (numeroBotoes > 0) {
                painelCampos.add(new JLabel("Button names:"));
                for (int i = 0; i < numeroBotoes; i++) {
                    JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    linha.add(new JLabel("Button " + (i + 1) + ":"));
                    JTextField campo = new JTextField("button" + (i + 1), 20);
                    linha.add(campo);
                    painelCampos.add(linha);
                    entradasBotoes.add(campo);
                }
            }

            if (numeroCheckboxes > 0) {
                painelCampos.add(new JLabel("Checkbox names:"));
                for (int i = 0; i < numeroCheckboxes; i++) {
                    JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    linha.add(new JLabel("Checkbox " + (i + 1) + ":"));
                    JTextField campo = new JTextField("checkbox" + (i + 1), 20);
                    linha.add(campo);
                    painelCampos.add(linha);
                    entradasCheckboxes.add(campo);
                }
            }

            if (numeroListeners > 0) {
                painelCampos.add(new JLabel("Listener class names and types:"));
                String[] tiposDisponiveis = {"ActionListener", "MouseListener", "KeyListener", "FocusListener", "ItemListener", "ChangeListener", "ListSelectionListener"};
                
                for (int i = 0; i < numeroListeners; i++) {
                    JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    linha.add(new JLabel("Listener " + (i + 1) + ":"));
                    JTextField campo = new JTextField("Listener" + (i + 1), 15);
                    linha.add(campo);
                    
                    linha.add(new JLabel("Type:"));
                    JComboBox<String> tipoCombo = new JComboBox<>(tiposDisponiveis);
                    linha.add(tipoCombo);
                    
                    painelCampos.add(linha);
                    entradasListeners.add(campo);
                    tiposListeners.add(tipoCombo);
                }
            }

            if (numeroLabels > 0) {
                painelCampos.add(new JLabel("Label names:"));
                for (int i = 0; i < numeroLabels; i++) {
                    JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    linha.add(new JLabel("Label " + (i + 1) + ":"));
                    JTextField campo = new JTextField("label" + (i + 1), 20);
                    linha.add(campo);
                    painelCampos.add(linha);
                    entradasLabels.add(campo);
                }
            }

            if (numeroComboBoxes > 0) {
                painelCampos.add(new JLabel("ComboBox names:"));
                for (int i = 0; i < numeroComboBoxes; i++) {
                    JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    linha.add(new JLabel("ComboBox " + (i + 1) + ":"));
                    JTextField campo = new JTextField("comboBox" + (i + 1), 20);
                    linha.add(campo);
                    painelCampos.add(linha);
                    entradasComboBoxes.add(campo);
                }
            }

            if (numeroTextAreas > 0) {
                painelCampos.add(new JLabel("TextArea names:"));
                for (int i = 0; i < numeroTextAreas; i++) {
                    JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    linha.add(new JLabel("TextArea " + (i + 1) + ":"));
                    JTextField campo = new JTextField("textArea" + (i + 1), 20);
                    linha.add(campo);
                    painelCampos.add(linha);
                    entradasTextAreas.add(campo);
                }
            }

            if (numeroSliders > 0) {
                painelCampos.add(new JLabel("Slider names:"));
                for (int i = 0; i < numeroSliders; i++) {
                    JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    linha.add(new JLabel("Slider " + (i + 1) + ":"));
                    JTextField campo = new JTextField("slider" + (i + 1), 20);
                    linha.add(campo);
                    painelCampos.add(linha);
                    entradasSliders.add(campo);
                }
            }

            JScrollPane scroll = new JScrollPane(painelCampos);
            janelaNomes.add(scroll, BorderLayout.CENTER);

            JPanel painelBotoes = new JPanel();
            JButton confirmar = new JButton("Confirm");
            JButton ordenar = new JButton("Set Order");
            JButton cancelar = new JButton("Cancel");

            painelBotoes.add(cancelar);
            painelBotoes.add(ordenar);
            painelBotoes.add(confirmar);
            janelaNomes.add(painelBotoes, BorderLayout.SOUTH);

            confirmar.addActionListener(e -> {
                java.util.List<String> nomesCaixas = new ArrayList<>();
                java.util.List<String> nomesBotoes = new ArrayList<>();
                java.util.List<String> nomesCheckboxes = new ArrayList<>();
                java.util.List<String> nomesListeners = new ArrayList<>();
                java.util.List<String> nomesLabels = new ArrayList<>();
                java.util.List<String> nomesComboBoxes = new ArrayList<>();
                java.util.List<String> nomesTextAreas = new ArrayList<>();
                java.util.List<String> nomesSliders = new ArrayList<>();
                java.util.List<String> tiposListenersTexto = new ArrayList<>();

                for (JTextField campo : entradasCaixas) {
                    nomesCaixas.add(campo.getText());
                }
                for (JTextField campo : entradasBotoes) {
                    nomesBotoes.add(campo.getText());
                }
                for (JTextField campo : entradasCheckboxes) {
                    nomesCheckboxes.add(campo.getText());
                }
                for (JTextField campo : entradasListeners) {
                    nomesListeners.add(campo.getText());
                }
                for (JTextField campo : entradasLabels) {
                    nomesLabels.add(campo.getText());
                }
                for (JTextField campo : entradasComboBoxes) {
                    nomesComboBoxes.add(campo.getText());
                }
                for (JTextField campo : entradasTextAreas) {
                    nomesTextAreas.add(campo.getText());
                }
                for (JTextField campo : entradasSliders) {
                    nomesSliders.add(campo.getText());
                }
                for (JComboBox<String> combo : tiposListeners) {
                    tiposListenersTexto.add((String) combo.getSelectedItem());
                }

                janelaNomes.dispose();
                
                if (!nomesListeners.isEmpty()) {
                    abrirConfiguracaoListeners(nomesCaixas, nomesBotoes, nomesCheckboxes, nomesLabels, nomesComboBoxes, nomesTextAreas, nomesSliders, nomesListeners, tiposListenersTexto);
                } else {
                    gerarCodigoJava(nomesCaixas, nomesBotoes, nomesCheckboxes, nomesLabels, nomesComboBoxes, nomesTextAreas, nomesSliders, nomesListeners, tiposListenersTexto);
                    mostrarResultado(nomesCaixas, nomesBotoes, nomesCheckboxes, nomesLabels, nomesComboBoxes, nomesTextAreas, nomesSliders, nomesListeners);
                }
            });

            ordenar.addActionListener(e -> {
                // Coletar todos os nomes primeiro
                java.util.List<String> nomesCaixas = new ArrayList<>();
                java.util.List<String> nomesBotoes = new ArrayList<>();
                java.util.List<String> nomesCheckboxes = new ArrayList<>();
                java.util.List<String> nomesLabels = new ArrayList<>();
                java.util.List<String> nomesComboBoxes = new ArrayList<>();
                java.util.List<String> nomesTextAreas = new ArrayList<>();
                java.util.List<String> nomesSliders = new ArrayList<>();

                for (JTextField campo : entradasCaixas) {
                    nomesCaixas.add(campo.getText());
                }
                for (JTextField campo : entradasBotoes) {
                    nomesBotoes.add(campo.getText());
                }
                for (JTextField campo : entradasCheckboxes) {
                    nomesCheckboxes.add(campo.getText());
                }
                for (JTextField campo : entradasLabels) {
                    nomesLabels.add(campo.getText());
                }
                for (JTextField campo : entradasComboBoxes) {
                    nomesComboBoxes.add(campo.getText());
                }
                for (JTextField campo : entradasTextAreas) {
                    nomesTextAreas.add(campo.getText());
                }
                for (JTextField campo : entradasSliders) {
                    nomesSliders.add(campo.getText());
                }
                
                abrirConfiguracaoOrdem(nomesCaixas, nomesBotoes, nomesCheckboxes, nomesLabels, nomesComboBoxes, nomesTextAreas, nomesSliders);
            });

            cancelar.addActionListener(e -> janelaNomes.dispose());

            janelaNomes.setLocationRelativeTo(this);
            janelaNomes.setVisible(true);

        } catch (NumberFormatException ex) {
            rotuloResultado.setText("Please enter a valid number!");
        }
    }

    private void mostrarResultado(java.util.List<String> nomesCaixas, java.util.List<String> nomesBotoes, 
                                 java.util.List<String> nomesCheckboxes, java.util.List<String> nomesLabels,
                                 java.util.List<String> nomesComboBoxes, java.util.List<String> nomesTextAreas,
                                 java.util.List<String> nomesSliders, java.util.List<String> nomesListeners) {
        StringBuilder resultado = new StringBuilder("Configuration created!\n");
        if (!nomesCaixas.isEmpty()) {
            resultado.append("Text fields: ").append(String.join(", ", nomesCaixas)).append("\n");
        }
        if (!nomesBotoes.isEmpty()) {
            resultado.append("Buttons: ").append(String.join(", ", nomesBotoes)).append("\n");
        }
        if (!nomesCheckboxes.isEmpty()) {
            resultado.append("Checkboxes: ").append(String.join(", ", nomesCheckboxes)).append("\n");
        }
        if (!nomesLabels.isEmpty()) {
            resultado.append("Labels: ").append(String.join(", ", nomesLabels)).append("\n");
        }
        if (!nomesComboBoxes.isEmpty()) {
            resultado.append("ComboBoxes: ").append(String.join(", ", nomesComboBoxes)).append("\n");
        }
        if (!nomesTextAreas.isEmpty()) {
            resultado.append("TextAreas: ").append(String.join(", ", nomesTextAreas)).append("\n");
        }
        if (!nomesSliders.isEmpty()) {
            resultado.append("Sliders: ").append(String.join(", ", nomesSliders)).append("\n");
        }
        if (!nomesListeners.isEmpty()) {
            resultado.append("Listeners: ").append(String.join(", ", nomesListeners)).append("\n");
        }
        resultado.append("Java file generated: InterfaceGerada.java");

        rotuloResultado.setText("<html>" + resultado.toString().replace("\n", "<br>") + "</html>");
    }

    private void abrirConfiguracaoOrdem(java.util.List<String> nomesCaixas, java.util.List<String> nomesBotoes,
                                       java.util.List<String> nomesCheckboxes, java.util.List<String> nomesLabels,
                                       java.util.List<String> nomesComboBoxes, java.util.List<String> nomesTextAreas,
                                       java.util.List<String> nomesSliders) {
        JDialog janelaOrdem = new JDialog(this, "Configure Component Order", true);
        janelaOrdem.setSize(500, 600);
        janelaOrdem.setLayout(new BorderLayout());

        // Criar lista de componentes para ordenação
        ordemComponentes.clear();
        int ordem = 0;
        
        for (String caixa : nomesCaixas) {
            ordemComponentes.add(new ComponenteOrdem("TextField", caixa, ordem++));
        }
        for (String botao : nomesBotoes) {
            ordemComponentes.add(new ComponenteOrdem("Button", botao, ordem++));
        }
        for (String checkbox : nomesCheckboxes) {
            ordemComponentes.add(new ComponenteOrdem("CheckBox", checkbox, ordem++));
        }
        for (String label : nomesLabels) {
            ordemComponentes.add(new ComponenteOrdem("Label", label, ordem++));
        }
        for (String comboBox : nomesComboBoxes) {
            ordemComponentes.add(new ComponenteOrdem("ComboBox", comboBox, ordem++));
        }
        for (String textArea : nomesTextAreas) {
            ordemComponentes.add(new ComponenteOrdem("TextArea", textArea, ordem++));
        }
        for (String slider : nomesSliders) {
            ordemComponentes.add(new ComponenteOrdem("Slider", slider, ordem++));
        }

        // Painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        
        // Instruções
        JLabel instrucoes = new JLabel("<html><center>Use the buttons to reorder components.<br>" +
                                     "Components will appear in this order in the generated interface.</center></html>");
        instrucoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelPrincipal.add(instrucoes, BorderLayout.NORTH);

        // Lista de componentes
        DefaultListModel<ComponenteOrdem> listModel = new DefaultListModel<>();
        for (ComponenteOrdem comp : ordemComponentes) {
            listModel.addElement(comp);
        }
        
        JList<ComponenteOrdem> listaComponentes = new JList<>(listModel);
        listaComponentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaComponentes.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                        boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                ComponenteOrdem comp = (ComponenteOrdem) value;
                setText((index + 1) + ". " + comp.toString());
                
                // Cores diferentes para cada tipo
                if (!isSelected) {
                    switch (comp.getTipo()) {
                        case "TextField": setBackground(new Color(230, 240, 255)); break;
                        case "Button": setBackground(new Color(255, 240, 230)); break;
                        case "CheckBox": setBackground(new Color(240, 255, 230)); break;
                        case "Label": setBackground(new Color(255, 255, 230)); break;
                        case "ComboBox": setBackground(new Color(240, 230, 255)); break;
                        case "TextArea": setBackground(new Color(255, 230, 240)); break;
                        case "Slider": setBackground(new Color(230, 255, 255)); break;
                    }
                }
                return this;
            }
        });
        
        JScrollPane scrollLista = new JScrollPane(listaComponentes);
        scrollLista.setPreferredSize(new Dimension(400, 400));
        painelPrincipal.add(scrollLista, BorderLayout.CENTER);

        // Painel de botões de reordenação
        JPanel painelOrdenacao = new JPanel(new GridLayout(4, 1, 5, 5));
        painelOrdenacao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton moverCima = new JButton("↑ Move Up");
        JButton moverBaixo = new JButton("↓ Move Down");
        JButton moverTopo = new JButton("↑↑ Move to Top");
        JButton moverFundo = new JButton("↓↓ Move to Bottom");
        
        moverCima.addActionListener(e -> {
            int index = listaComponentes.getSelectedIndex();
            if (index > 0) {
                ComponenteOrdem comp = listModel.remove(index);
                listModel.add(index - 1, comp);
                listaComponentes.setSelectedIndex(index - 1);
                atualizarOrdemComponentes(listModel);
            }
        });
        
        moverBaixo.addActionListener(e -> {
            int index = listaComponentes.getSelectedIndex();
            if (index >= 0 && index < listModel.getSize() - 1) {
                ComponenteOrdem comp = listModel.remove(index);
                listModel.add(index + 1, comp);
                listaComponentes.setSelectedIndex(index + 1);
                atualizarOrdemComponentes(listModel);
            }
        });
        
        moverTopo.addActionListener(e -> {
            int index = listaComponentes.getSelectedIndex();
            if (index > 0) {
                ComponenteOrdem comp = listModel.remove(index);
                listModel.add(0, comp);
                listaComponentes.setSelectedIndex(0);
                atualizarOrdemComponentes(listModel);
            }
        });
        
        moverFundo.addActionListener(e -> {
            int index = listaComponentes.getSelectedIndex();
            if (index >= 0 && index < listModel.getSize() - 1) {
                ComponenteOrdem comp = listModel.remove(index);
                listModel.addElement(comp);
                listaComponentes.setSelectedIndex(listModel.getSize() - 1);
                atualizarOrdemComponentes(listModel);
            }
        });
        
        painelOrdenacao.add(moverTopo);
        painelOrdenacao.add(moverCima);
        painelOrdenacao.add(moverBaixo);
        painelOrdenacao.add(moverFundo);
        
        janelaOrdem.add(painelPrincipal, BorderLayout.CENTER);
        janelaOrdem.add(painelOrdenacao, BorderLayout.EAST);

        // Botões de ação
        JPanel painelBotoes = new JPanel();
        JButton aplicar = new JButton("Apply Order");
        JButton fechar = new JButton("Close");
        
        aplicar.addActionListener(e -> {
            atualizarOrdemComponentes(listModel);
            JOptionPane.showMessageDialog(janelaOrdem, "Component order updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });
        
        fechar.addActionListener(e -> janelaOrdem.dispose());
        
        painelBotoes.add(aplicar);
        painelBotoes.add(fechar);
        janelaOrdem.add(painelBotoes, BorderLayout.SOUTH);

        janelaOrdem.setLocationRelativeTo(this);
        janelaOrdem.setVisible(true);
    }
    
    private void atualizarOrdemComponentes(DefaultListModel<ComponenteOrdem> listModel) {
        ordemComponentes.clear();
        for (int i = 0; i < listModel.getSize(); i++) {
            ComponenteOrdem comp = listModel.getElementAt(i);
            comp.setOrdem(i);
            ordemComponentes.add(comp);
        }
    }

    private void abrirConfiguracaoListeners(java.util.List<String> nomesCaixas, java.util.List<String> nomesBotoes,
                                           java.util.List<String> nomesCheckboxes, java.util.List<String> nomesLabels,
                                           java.util.List<String> nomesComboBoxes, java.util.List<String> nomesTextAreas,
                                           java.util.List<String> nomesSliders, java.util.List<String> nomesListeners,
                                           java.util.List<String> tiposListenersTexto) {
        JDialog janelaConfig = new JDialog(this, "Configure Listeners", true);
        janelaConfig.setSize(600, 500);
        janelaConfig.setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        painelPrincipal.add(new JLabel("Select which listeners to attach to which components:"));
        painelPrincipal.add(Box.createVerticalStrut(10));

        listenersParaComponentes.clear();

        // Criar checkboxes para cada combinação listener-componente
        for (int i = 0; i < nomesListeners.size(); i++) {
            String listener = nomesListeners.get(i);
            String tipo = tiposListenersTexto.get(i);
            
            JPanel painelListener = new JPanel();
            painelListener.setBorder(BorderFactory.createTitledBorder(listener + " (" + tipo + ")"));
            painelListener.setLayout(new BoxLayout(painelListener, BoxLayout.Y_AXIS));

            listenersParaComponentes.put(listener, new HashSet<>());

            // Adicionar checkboxes para campos de texto (se aplicável ao tipo de listener)
            if (isListenerApplicableToTextField(tipo)) {
                for (String campo : nomesCaixas) {
                    JCheckBox check = new JCheckBox("Attach to text field: " + campo);
                    check.addActionListener(e -> {
                        if (check.isSelected()) {
                            listenersParaComponentes.get(listener).add(campo);
                        } else {
                            listenersParaComponentes.get(listener).remove(campo);
                        }
                    });
                    painelListener.add(check);
                }
            }

            // Adicionar checkboxes para botões
            if (isListenerApplicableToButton(tipo)) {
                for (String botao : nomesBotoes) {
                    JCheckBox check = new JCheckBox("Attach to button: " + botao);
                    check.addActionListener(e -> {
                        if (check.isSelected()) {
                            listenersParaComponentes.get(listener).add(botao);
                        } else {
                            listenersParaComponentes.get(listener).remove(botao);
                        }
                    });
                    painelListener.add(check);
                }
            }

            // Adicionar checkboxes para checkboxes
            if (isListenerApplicableToCheckbox(tipo)) {
                for (String checkbox : nomesCheckboxes) {
                    JCheckBox check = new JCheckBox("Attach to checkbox: " + checkbox);
                    check.addActionListener(e -> {
                        if (check.isSelected()) {
                            listenersParaComponentes.get(listener).add(checkbox);
                        } else {
                            listenersParaComponentes.get(listener).remove(checkbox);
                        }
                    });
                    painelListener.add(check);
                }
            }

            // Adicionar checkboxes para labels
            if (isListenerApplicableToLabel(tipo)) {
                for (String label : nomesLabels) {
                    JCheckBox check = new JCheckBox("Attach to label: " + label);
                    check.addActionListener(e -> {
                        if (check.isSelected()) {
                            listenersParaComponentes.get(listener).add(label);
                        } else {
                            listenersParaComponentes.get(listener).remove(label);
                        }
                    });
                    painelListener.add(check);
                }
            }

            // Adicionar checkboxes para combo boxes
            if (isListenerApplicableToComboBox(tipo)) {
                for (String comboBox : nomesComboBoxes) {
                    JCheckBox check = new JCheckBox("Attach to combo box: " + comboBox);
                    check.addActionListener(e -> {
                        if (check.isSelected()) {
                            listenersParaComponentes.get(listener).add(comboBox);
                        } else {
                            listenersParaComponentes.get(listener).remove(comboBox);
                        }
                    });
                    painelListener.add(check);
                }
            }

            // Adicionar checkboxes para text areas
            if (isListenerApplicableToTextArea(tipo)) {
                for (String textArea : nomesTextAreas) {
                    JCheckBox check = new JCheckBox("Attach to text area: " + textArea);
                    check.addActionListener(e -> {
                        if (check.isSelected()) {
                            listenersParaComponentes.get(listener).add(textArea);
                        } else {
                            listenersParaComponentes.get(listener).remove(textArea);
                        }
                    });
                    painelListener.add(check);
                }
            }

            // Adicionar checkboxes para sliders
            if (isListenerApplicableToSlider(tipo)) {
                for (String slider : nomesSliders) {
                    JCheckBox check = new JCheckBox("Attach to slider: " + slider);
                    check.addActionListener(e -> {
                        if (check.isSelected()) {
                            listenersParaComponentes.get(listener).add(slider);
                        } else {
                            listenersParaComponentes.get(listener).remove(slider);
                        }
                    });
                    painelListener.add(check);
                }
            }

            painelPrincipal.add(painelListener);
            painelPrincipal.add(Box.createVerticalStrut(10));
        }

        JScrollPane scroll = new JScrollPane(painelPrincipal);
        janelaConfig.add(scroll, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        JButton confirmar = new JButton("Generate Code");
        JButton cancelar = new JButton("Cancel");

        painelBotoes.add(confirmar);
        painelBotoes.add(cancelar);
        janelaConfig.add(painelBotoes, BorderLayout.SOUTH);

        confirmar.addActionListener(e -> {
            gerarCodigoJava(nomesCaixas, nomesBotoes, nomesCheckboxes, nomesLabels, nomesComboBoxes, nomesTextAreas, nomesSliders, nomesListeners, tiposListenersTexto);
            mostrarResultado(nomesCaixas, nomesBotoes, nomesCheckboxes, nomesLabels, nomesComboBoxes, nomesTextAreas, nomesSliders, nomesListeners);
            janelaConfig.dispose();
        });

        cancelar.addActionListener(e -> janelaConfig.dispose());

        janelaConfig.setLocationRelativeTo(this);
        janelaConfig.setVisible(true);
    }

    private boolean isListenerApplicableToTextField(String tipo) {
        return tipo.equals("KeyListener") || tipo.equals("FocusListener") || tipo.equals("MouseListener");
    }

    private boolean isListenerApplicableToButton(String tipo) {
        return tipo.equals("ActionListener") || tipo.equals("MouseListener") || tipo.equals("FocusListener");
    }

    private boolean isListenerApplicableToCheckbox(String tipo) {
        return tipo.equals("ActionListener") || tipo.equals("ItemListener") || tipo.equals("MouseListener") || tipo.equals("FocusListener");
    }

    private boolean isListenerApplicableToLabel(String tipo) {
        return tipo.equals("MouseListener") || tipo.equals("FocusListener");
    }

    private boolean isListenerApplicableToComboBox(String tipo) {
        return tipo.equals("ActionListener") || tipo.equals("ItemListener") || tipo.equals("MouseListener") || tipo.equals("FocusListener");
    }

    private boolean isListenerApplicableToTextArea(String tipo) {
        return tipo.equals("KeyListener") || tipo.equals("FocusListener") || tipo.equals("MouseListener");
    }

    private boolean isListenerApplicableToSlider(String tipo) {
        return tipo.equals("ChangeListener") || tipo.equals("MouseListener") || tipo.equals("FocusListener");
    }

    private void gerarCodigoJava(java.util.List<String> caixas, java.util.List<String> botoes, java.util.List<String> checkboxes,
                                java.util.List<String> labels, java.util.List<String> comboBoxes, java.util.List<String> textAreas,
                                java.util.List<String> sliders, java.util.List<String> listeners, java.util.List<String> tiposListeners) {
        StringBuilder codigo = new StringBuilder();
        codigo.append("import javax.swing.*;\n")
                .append("import java.awt.*;\n")
                .append("import java.awt.event.*;\n\n")
                .append("public class InterfaceGerada extends JFrame {\n");

        for (String caixa : caixas) {
            codigo.append("    private JTextField ").append(caixa).append(";\n");
        }
        for (String botao : botoes) {
            codigo.append("    private JButton ").append(botao).append(";\n");
        }
        for (String check : checkboxes) {
            codigo.append("    private JCheckBox ").append(check).append(";\n");
        }
        for (String label : labels) {
            codigo.append("    private JLabel ").append(label).append(";\n");
        }
        for (String comboBox : comboBoxes) {
            codigo.append("    private JComboBox<String> ").append(comboBox).append(";\n");
        }
        for (String textArea : textAreas) {
            codigo.append("    private JTextArea ").append(textArea).append(";\n");
        }
        for (String slider : sliders) {
            codigo.append("    private JSlider ").append(slider).append(";\n");
        }
        for (int i = 0; i < listeners.size(); i++) {
            String listener = listeners.get(i);
            codigo.append("    private ").append(listener).append(" ").append(listener.toLowerCase()).append(";\n");
        }

        codigo.append("\n    public InterfaceGerada() {\n")
                .append("        setTitle(\"Generated Interface\");\n")
                .append("        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n")
                .append("        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));\n\n");

        for (String caixa : caixas) {
            codigo.append("        ").append(caixa).append(" = new JTextField(20);\n");
        }
        for (String botao : botoes) {
            codigo.append("        ").append(botao).append(" = new JButton(\"").append(botao).append("\");\n");
        }
        for (String check : checkboxes) {
            codigo.append("        ").append(check).append(" = new JCheckBox(\"").append(check).append("\");\n");
        }
        for (String label : labels) {
            codigo.append("        ").append(label).append(" = new JLabel(\"").append(label).append("\");\n");
        }
        for (String comboBox : comboBoxes) {
            codigo.append("        ").append(comboBox).append(" = new JComboBox<>(new String[]{\"Option 1\", \"Option 2\", \"Option 3\"});\n");
        }
        for (String textArea : textAreas) {
            codigo.append("        ").append(textArea).append(" = new JTextArea(5, 20);\n");
        }
        for (String slider : sliders) {
            codigo.append("        ").append(slider).append(" = new JSlider(0, 100, 50);\n");
        }
        for (int i = 0; i < listeners.size(); i++) {
            String listener = listeners.get(i);
            codigo.append("        ").append(listener.toLowerCase()).append(" = new ").append(listener).append("();\n");
        }

        codigo.append("\n        JPanel panelCampos = new JPanel();\n")
                .append("        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));\n");

        // Usar ordem personalizada se definida, senão usar ordem padrão
        if (!ordemComponentes.isEmpty()) {
            // Ordenar componentes baseado na ordem definida pelo usuário
            ordemComponentes.sort((a, b) -> Integer.compare(a.getOrdem(), b.getOrdem()));
            
            for (ComponenteOrdem comp : ordemComponentes) {
                String nome = comp.getNome();
                String tipo = comp.getTipo();
                
                switch (tipo) {
                    case "TextField":
                        codigo.append("        JPanel panel").append(nome).append(" = new JPanel();\n")
                                .append("        panel").append(nome).append(".add(new JLabel(\"")
                                .append(nome.replace("_", " ")).append(":\"));\n")
                                .append("        panel").append(nome).append(".add(").append(nome).append(");\n")
                                .append("        panelCampos.add(panel").append(nome).append(");\n");
                        break;
                    case "Button":
                        // Botões serão adicionados no painel de botões no final
                        break;
                    case "CheckBox":
                        codigo.append("        panelCampos.add(").append(nome).append(");\n");
                        break;
                    case "Label":
                        codigo.append("        panelCampos.add(").append(nome).append(");\n");
                        break;
                    case "ComboBox":
                        codigo.append("        JPanel panel").append(nome).append(" = new JPanel();\n")
                                .append("        panel").append(nome).append(".add(new JLabel(\"")
                                .append(nome.replace("_", " ")).append(":\"));\n")
                                .append("        panel").append(nome).append(".add(").append(nome).append(");\n")
                                .append("        panelCampos.add(panel").append(nome).append(");\n");
                        break;
                    case "TextArea":
                        codigo.append("        JPanel panel").append(nome).append(" = new JPanel();\n")
                                .append("        panel").append(nome).append(".add(new JLabel(\"")
                                .append(nome.replace("_", " ")).append(":\"));\n")
                                .append("        panel").append(nome).append(".add(new JScrollPane(").append(nome).append("));\n")
                                .append("        panelCampos.add(panel").append(nome).append(");\n");
                        break;
                    case "Slider":
                        codigo.append("        JPanel panel").append(nome).append(" = new JPanel();\n")
                                .append("        panel").append(nome).append(".add(new JLabel(\"")
                                .append(nome.replace("_", " ")).append(":\"));\n")
                                .append("        panel").append(nome).append(".add(").append(nome).append(");\n")
                                .append("        panelCampos.add(panel").append(nome).append(");\n");
                        break;
                }
            }
        } else {
            // Ordem padrão (mantém código existente)
            for (String caixa : caixas) {
                codigo.append("        JPanel panel").append(caixa).append(" = new JPanel();\n")
                        .append("        panel").append(caixa).append(".add(new JLabel(\"")
                        .append(caixa.replace("_", " ")).append(":\"));\n")
                        .append("        panel").append(caixa).append(".add(").append(caixa).append(");\n")
                        .append("        panelCampos.add(panel").append(caixa).append(");\n");
            }

            for (String check : checkboxes) {
                codigo.append("        panelCampos.add(").append(check).append(");\n");
            }

            for (String label : labels) {
                codigo.append("        panelCampos.add(").append(label).append(");\n");
            }

            for (String comboBox : comboBoxes) {
                codigo.append("        JPanel panel").append(comboBox).append(" = new JPanel();\n")
                        .append("        panel").append(comboBox).append(".add(new JLabel(\"")
                        .append(comboBox.replace("_", " ")).append(":\"));\n")
                        .append("        panel").append(comboBox).append(".add(").append(comboBox).append(");\n")
                        .append("        panelCampos.add(panel").append(comboBox).append(");\n");
            }

            for (String textArea : textAreas) {
                codigo.append("        JPanel panel").append(textArea).append(" = new JPanel();\n")
                        .append("        panel").append(textArea).append(".add(new JLabel(\"")
                        .append(textArea.replace("_", " ")).append(":\"));\n")
                        .append("        panel").append(textArea).append(".add(new JScrollPane(").append(textArea).append("));\n")
                        .append("        panelCampos.add(panel").append(textArea).append(");\n");
            }

            for (String slider : sliders) {
                codigo.append("        JPanel panel").append(slider).append(" = new JPanel();\n")
                        .append("        panel").append(slider).append(".add(new JLabel(\"")
                        .append(slider.replace("_", " ")).append(":\"));\n")
                        .append("        panel").append(slider).append(".add(").append(slider).append(");\n")
                        .append("        panelCampos.add(panel").append(slider).append(");\n");
            }
        }

        codigo.append("        add(panelCampos);\n");

        // Adicionar listeners aos componentes baseado na configuração do usuário
        for (int i = 0; i < listeners.size(); i++) {
            String listener = listeners.get(i);
            String tipo = tiposListeners.get(i);
            Set<String> componentesAssociados = listenersParaComponentes.get(listener);
            
            if (componentesAssociados != null && !componentesAssociados.isEmpty()) {
                for (String componente : componentesAssociados) {
                    adicionarListenerAoComponente(codigo, componente, listener, tipo, caixas, botoes, checkboxes, labels, comboBoxes, textAreas, sliders);
                }
            }
        }

        if (!botoes.isEmpty()) {
            codigo.append("        JPanel panelBotoes = new JPanel();\n");
            for (String botao : botoes) {
                codigo.append("        panelBotoes.add(").append(botao).append(");\n");
            }
            codigo.append("        add(panelBotoes);\n");
        }

        codigo.append("        pack();\n")
                .append("        setLocationRelativeTo(null);\n")
                .append("    }\n\n");

        // Gerar classes listener com tipos específicos
        for (int i = 0; i < listeners.size(); i++) {
            String listener = listeners.get(i);
            String tipo = tiposListeners.get(i);
            gerarClasseListenerInterna(codigo, listener, tipo);
        }

        codigo.append("    public static void main(String[] args) {\n")
                .append("        SwingUtilities.invokeLater(() -> new InterfaceGerada().setVisible(true));\n")
                .append("    }\n}");

        try (FileWriter writer = new FileWriter("InterfaceGerada.java")) {
            writer.write(codigo.toString());
            System.out.println("✅ Java file with internal listener classes generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void adicionarListenerAoComponente(StringBuilder codigo, String componente, String listener, String tipo,
                                             java.util.List<String> caixas, java.util.List<String> botoes, java.util.List<String> checkboxes,
                                             java.util.List<String> labels, java.util.List<String> comboBoxes, 
                                             java.util.List<String> textAreas, java.util.List<String> sliders) {
        String metodoListener = getMetodoListener(tipo);
        codigo.append("        ").append(componente).append(".").append(metodoListener)
              .append("(").append(listener.toLowerCase()).append(");\n");
    }

    private String getMetodoListener(String tipo) {
        switch (tipo) {
            case "ActionListener": return "addActionListener";
            case "MouseListener": return "addMouseListener";
            case "KeyListener": return "addKeyListener";
            case "FocusListener": return "addFocusListener";
            case "ItemListener": return "addItemListener";
            case "ChangeListener": return "addChangeListener";
            case "ListSelectionListener": return "addListSelectionListener";
            default: return "addActionListener";
        }
    }

    private void gerarClasseListenerInterna(StringBuilder codigo, String listener, String tipo) {
        codigo.append("    // Classe listener para implementação futura\n")
              .append("    private class ").append(listener).append(" implements ").append(tipo).append(" {\n");

        switch (tipo) {
            case "ActionListener":
                codigo.append("        @Override\n")
                      .append("        public void actionPerformed(ActionEvent e) {\n")
                      .append("            // TODO: Implementar ação do listener\n")
                      .append("        }\n");
                break;
            case "MouseListener":
                codigo.append("        @Override\n")
                      .append("        public void mouseClicked(MouseEvent e) {\n")
                      .append("            // TODO: Implementar ação do mouse clicked\n")
                      .append("        }\n")
                      .append("        @Override\n")
                      .append("        public void mousePressed(MouseEvent e) {}\n")
                      .append("        @Override\n")
                      .append("        public void mouseReleased(MouseEvent e) {}\n")
                      .append("        @Override\n")
                      .append("        public void mouseEntered(MouseEvent e) {}\n")
                      .append("        @Override\n")
                      .append("        public void mouseExited(MouseEvent e) {}\n");
                break;
            case "KeyListener":
                codigo.append("        @Override\n")
                      .append("        public void keyTyped(KeyEvent e) {\n")
                      .append("            // TODO: Implementar ação do key typed\n")
                      .append("        }\n")
                      .append("        @Override\n")
                      .append("        public void keyPressed(KeyEvent e) {}\n")
                      .append("        @Override\n")
                      .append("        public void keyReleased(KeyEvent e) {}\n");
                break;
            case "FocusListener":
                codigo.append("        @Override\n")
                      .append("        public void focusGained(FocusEvent e) {\n")
                      .append("            // TODO: Implementar ação do focus gained\n")
                      .append("        }\n")
                      .append("        @Override\n")
                      .append("        public void focusLost(FocusEvent e) {}\n");
                break;
            case "ItemListener":
                codigo.append("        @Override\n")
                      .append("        public void itemStateChanged(ItemEvent e) {\n")
                      .append("            // TODO: Implementar ação do item state changed\n")
                      .append("        }\n");
                break;
            case "ChangeListener":
                codigo.append("        @Override\n")
                      .append("        public void stateChanged(ChangeEvent e) {\n")
                      .append("            // TODO: Implementar ação do state changed\n")
                      .append("        }\n");
                break;
            case "ListSelectionListener":
                codigo.append("        @Override\n")
                      .append("        public void valueChanged(ListSelectionEvent e) {\n")
                      .append("            // TODO: Implementar ação do value changed\n")
                      .append("        }\n");
                break;
        }

        codigo.append("    }\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BombaDeHidrogenio::new);
    }
}
