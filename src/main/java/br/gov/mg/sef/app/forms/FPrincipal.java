/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.gov.mg.sef.app.forms;

import br.gov.mg.sef.app.factory.MockData;
import br.gov.mg.sef.app.model.Operacao;
import br.gov.mg.sef.app.model.Produto;
import br.gov.mg.sef.app.util.RegrasCalculo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wagner.borges
 */
public class FPrincipal extends javax.swing.JFrame {

    private String data = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    private DecimalFormat decimalFormat = new DecimalFormat("#,##0.##");
    private List<Operacao> listaOperacoes = new ArrayList<>();

    /**
     * Creates new form FPrincipal
     */
    public FPrincipal() {
        aplicaLookAndFeel();
        JFrame.setDefaultLookAndFeelDecorated(true);
        initComponents();
        abrirMaximizado();
        carregaCombos();

        inicializarComponentes();
    }

    public void inicializarComponentes() {

        jTextFieldDataOperacao.setText(data);
        jComboBoxNotas.addItem("");

        jTableOperacoes.getColumnModel().getColumn(0).setCellRenderer(rendererAlinhaCentralizado);
        jTableOperacoes.getColumnModel().getColumn(1).setCellRenderer(rendererAlinhaCentralizado);
        jTableOperacoes.getColumnModel().getColumn(2).setCellRenderer(rendererAlinhaCentralizado);
        jTableOperacoes.getColumnModel().getColumn(3).setCellRenderer(rendererAlinhaCentralizado);

        jTableOperacoes.getColumnModel().getColumn(4).setCellRenderer(rendererAlinhaDireita);
        jTableOperacoes.getColumnModel().getColumn(5).setCellRenderer(rendererAlinhaCentralizado);
        jTableOperacoes.getColumnModel().getColumn(6).setCellRenderer(rendererAlinhaDireita);
        jTableOperacoes.getColumnModel().getColumn(7).setCellRenderer(rendererAlinhaDireitaVermelho);
        jTableOperacoes.getColumnModel().getColumn(8).setCellRenderer(rendererAlinhaDireitaVermelho);
        jTableOperacoes.getColumnModel().getColumn(9).setCellRenderer(rendererAlinhaDireitaVermelho);
        jTableOperacoes.getColumnModel().getColumn(10).setCellRenderer(rendererAlinhaDireita);

        jTableApuracaoContribuinteA.getColumnModel().getColumn(1).setCellRenderer(rendererAlinhaDireitaAzul);
        jTableApuracaoContribuinteA.getColumnModel().getColumn(2).setCellRenderer(rendererAlinhaDireitaVermelho);

        jTableApuracaoContribuinteB.getColumnModel().getColumn(1).setCellRenderer(rendererAlinhaDireitaAzul);
        jTableApuracaoContribuinteB.getColumnModel().getColumn(2).setCellRenderer(rendererAlinhaDireitaVermelho);

        jTableOperacoesContribuinteA.getColumnModel().getColumn(0).setCellRenderer(rendererAlinhaCentralizado); //Data
        jTableOperacoesContribuinteA.getColumnModel().getColumn(1).setCellRenderer(rendererAlinhaCentralizado); //Chave
        jTableOperacoesContribuinteA.getColumnModel().getColumn(2).setCellRenderer(rendererAlinhaDireitaVermelho); //valor do imposto
        jTableOperacoesContribuinteA.getColumnModel().getColumn(3).setCellRenderer(rendererAlinhaDireitaVermelho); // retido por split
        jTableOperacoesContribuinteA.getColumnModel().getColumn(4).setCellRenderer(rendererAlinhaDireitaAzul); // a apriopriar
        jTableOperacoesContribuinteA.getColumnModel().getColumn(5).setCellRenderer(rendererAlinhaDireitaAzul); // apropriado
        jTableOperacoesContribuinteA.getColumnModel().getColumn(6).setCellRenderer(rendererDebitoCredito); //Credito/debito/isencao
        jTableOperacoesContribuinteA.getColumnModel().getColumn(7).setCellRenderer(rendererAlinhaDireitaVermelho); //saldo a liquidar
        jTableOperacoesContribuinteA.getColumnModel().getColumn(8).setCellRenderer(rendererFormaLiquidacao); //forma liquidação
        jTableOperacoesContribuinteA.getColumnModel().getColumn(9).setCellRenderer(rendererAlinhaCentralizadoNegrito); //redução

        jTableOperacoesContribuinteB.getColumnModel().getColumn(0).setCellRenderer(rendererAlinhaCentralizado); //Data
        jTableOperacoesContribuinteB.getColumnModel().getColumn(1).setCellRenderer(rendererAlinhaCentralizado); //Chave
        jTableOperacoesContribuinteB.getColumnModel().getColumn(2).setCellRenderer(rendererAlinhaDireitaVermelho); //valor do imposto
        jTableOperacoesContribuinteB.getColumnModel().getColumn(3).setCellRenderer(rendererAlinhaDireitaVermelho); // retido por split
        jTableOperacoesContribuinteB.getColumnModel().getColumn(4).setCellRenderer(rendererAlinhaDireitaAzul); // a apriopriar
        jTableOperacoesContribuinteB.getColumnModel().getColumn(5).setCellRenderer(rendererAlinhaDireitaAzul); // apropriado
        jTableOperacoesContribuinteB.getColumnModel().getColumn(6).setCellRenderer(rendererDebitoCredito); //Credito/debito/isencao
        jTableOperacoesContribuinteB.getColumnModel().getColumn(7).setCellRenderer(rendererAlinhaDireitaVermelho); //saldo a liquidar
        jTableOperacoesContribuinteB.getColumnModel().getColumn(8).setCellRenderer(rendererFormaLiquidacao); //forma liquidação
        jTableOperacoesContribuinteB.getColumnModel().getColumn(9).setCellRenderer(rendererAlinhaCentralizadoNegrito); //redução

    }

    public void abrirMaximizado() {
        //setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }

    public void carregaCombos() {
        jComboBoxUfEmitente.removeAllItems();
        jComboBoxUfDestinatario.removeAllItems();
        jComboBoxMunicipioConsumidorFinal.removeAll();

        jComboBoxUfEmitente.addItem("");
        jComboBoxUfDestinatario.addItem("");
        jComboBoxUfConsumidorFinal.addItem("");

        for (String item : MockData.getMockData()) {
            jComboBoxUfEmitente.addItem(item);
        }

        for (String item : MockData.getMockData()) {
            jComboBoxUfDestinatario.addItem(item);
        }

        for (String item : MockData.getMockData()) {
            jComboBoxUfConsumidorFinal.addItem(item);
        }
    }

    public void aplicaLookAndFeel() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelOperacoes = new javax.swing.JPanel();
        jPanelContribuinteA = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCnpjEmitente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldRazaoSocial = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxUfEmitente = new javax.swing.JComboBox<>();
        jComboBoxMunicipioEmitente = new javax.swing.JComboBox<>();
        jPanelContribuinteB = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldCnpjDestinatario = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldRazaoSocialDestinatario = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxUfDestinatario = new javax.swing.JComboBox<>();
        jComboBoxMunicipioDestinatario = new javax.swing.JComboBox<>();
        jPanelConsumidorFinal = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldCnpjConsumidorFinal = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldNomeConsumidorFinal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxUfConsumidorFinal = new javax.swing.JComboBox<>();
        jComboBoxMunicipioConsumidorFinal = new javax.swing.JComboBox<>();
        jRadioButton9 = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        jTextFieldCodigoProduto = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldDescricaoProduto = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOperacoes = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldDataOperacao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jRadioButtonReducaoZero = new javax.swing.JRadioButton();
        jRadioButtonReducao30 = new javax.swing.JRadioButton();
        jRadioButtonReducao60 = new javax.swing.JRadioButton();
        jRadioButtonReducao100 = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        jRadioButtonSemSplit = new javax.swing.JRadioButton();
        jRadioButtonSplitInteligente = new javax.swing.JRadioButton();
        jRadioButtonSplitSimplificado = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jRadioButtonAB = new javax.swing.JRadioButton();
        jRadioButtonBA = new javax.swing.JRadioButton();
        jRadioButtonBC = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jRadioButtonOperacaoIsenta = new javax.swing.JRadioButton();
        jRadioButtonCreditoPresumido = new javax.swing.JRadioButton();
        jRadioButtonDiferimento = new javax.swing.JRadioButton();
        jTextFieldPercentualCreditoPresumido = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jRadioButtonOperacaoNormal = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanelInformacoesApuracao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOperacoesContribuinteA = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableOperacoesContribuinteB = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jComboBoxContribuinte = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jTextFieldValorAvulso = new javax.swing.JTextField();
        jComboBoxNotas = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jTextFieldDataPagamentoAvulsos = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableApuracaoContribuinteA = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jLabelSaldoContribuinteA = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableApuracaoContribuinteB = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        jLabelSaldoContribuinteB = new javax.swing.JLabel();
        jPanelComiteGestor = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableArrecadacaoEstados = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableArrecadacaoMunicipios = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableCashback = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableApuracoes = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jPanelReparticao = new javax.swing.JPanel();
        jPanelConfiguracoes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldAliquotaUf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAliquotaMunicipio = new javax.swing.JTextField();
        jTextFieldAliquotaUniao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAliquotaIbs = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldAliquotaIvaDual = new javax.swing.JTextField();
        jTextFieldAliquotaCbs = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldAliquotaSplitSimplificado = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldAliquotaCashBack = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Apuração do IBS/CBS - Demo");

        jPanelContribuinteA.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contribuinte A"));

        jLabel10.setText("CNPJ");

        jTextFieldCnpjEmitente.setText("90.564.055/0001-17");

        jLabel11.setText("Razão Social");

        jTextFieldRazaoSocial.setText("Fabricante do Melhor do Mundo");

        jLabel12.setText("UF*");

        jLabel13.setText("Município*");

        jComboBoxUfEmitente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxUfEmitenteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelContribuinteALayout = new javax.swing.GroupLayout(jPanelContribuinteA);
        jPanelContribuinteA.setLayout(jPanelContribuinteALayout);
        jPanelContribuinteALayout.setHorizontalGroup(
            jPanelContribuinteALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContribuinteALayout.createSequentialGroup()
                .addGroup(jPanelContribuinteALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContribuinteALayout.createSequentialGroup()
                        .addComponent(jTextFieldCnpjEmitente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContribuinteALayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContribuinteALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContribuinteALayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContribuinteALayout.createSequentialGroup()
                        .addComponent(jComboBoxUfEmitente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMunicipioEmitente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanelContribuinteALayout.setVerticalGroup(
            jPanelContribuinteALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContribuinteALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContribuinteALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContribuinteALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCnpjEmitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxUfEmitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMunicipioEmitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanelContribuinteB.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contribuinte B"));

        jLabel14.setText("CNPJ");

        jTextFieldCnpjDestinatario.setText("76.672.422/0001-75");

        jLabel15.setText("Razão Social");

        jTextFieldRazaoSocialDestinatario.setText("Varejista do Melhor do Mundo");

        jLabel16.setText("UF*");

        jLabel17.setText("Município*");

        jComboBoxUfDestinatario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxUfDestinatarioItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelContribuinteBLayout = new javax.swing.GroupLayout(jPanelContribuinteB);
        jPanelContribuinteB.setLayout(jPanelContribuinteBLayout);
        jPanelContribuinteBLayout.setHorizontalGroup(
            jPanelContribuinteBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContribuinteBLayout.createSequentialGroup()
                .addGroup(jPanelContribuinteBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContribuinteBLayout.createSequentialGroup()
                        .addComponent(jTextFieldCnpjDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldRazaoSocialDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContribuinteBLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContribuinteBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContribuinteBLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContribuinteBLayout.createSequentialGroup()
                        .addComponent(jComboBoxUfDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMunicipioDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanelContribuinteBLayout.setVerticalGroup(
            jPanelContribuinteBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContribuinteBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContribuinteBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContribuinteBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCnpjDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRazaoSocialDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxUfDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMunicipioDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelConsumidorFinal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Consumidor Final"));

        jLabel18.setText("CPF");

        jTextFieldCnpjConsumidorFinal.setText("576.867.950-20");

        jLabel19.setText("Nome");

        jTextFieldNomeConsumidorFinal.setText("Torcedor do Melhor do Mundo");
        jTextFieldNomeConsumidorFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeConsumidorFinalActionPerformed(evt);
            }
        });

        jLabel20.setText("UF*");

        jLabel21.setText("Município*");

        jComboBoxUfConsumidorFinal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxUfConsumidorFinalItemStateChanged(evt);
            }
        });

        jRadioButton9.setText("Baixa Renda");
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsumidorFinalLayout = new javax.swing.GroupLayout(jPanelConsumidorFinal);
        jPanelConsumidorFinal.setLayout(jPanelConsumidorFinalLayout);
        jPanelConsumidorFinalLayout.setHorizontalGroup(
            jPanelConsumidorFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsumidorFinalLayout.createSequentialGroup()
                .addGroup(jPanelConsumidorFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConsumidorFinalLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelConsumidorFinalLayout.createSequentialGroup()
                        .addComponent(jTextFieldCnpjConsumidorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeConsumidorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanelConsumidorFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConsumidorFinalLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelConsumidorFinalLayout.createSequentialGroup()
                        .addComponent(jComboBoxUfConsumidorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMunicipioConsumidorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jRadioButton9)
        );
        jPanelConsumidorFinalLayout.setVerticalGroup(
            jPanelConsumidorFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsumidorFinalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConsumidorFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConsumidorFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCnpjConsumidorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeConsumidorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxUfConsumidorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMunicipioConsumidorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton9)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Operações com Mercadoria")));

        jTextFieldCodigoProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextFieldCodigoProduto.setForeground(new java.awt.Color(0, 0, 204));
        jTextFieldCodigoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoProdutoFocusLost(evt);
            }
        });

        jLabel22.setText("Código do Produto*");

        jTextFieldDescricaoProduto.setEditable(false);
        jTextFieldDescricaoProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextFieldDescricaoProduto.setForeground(new java.awt.Color(0, 0, 204));

        jLabel23.setText("Descrição do Produto");

        jLabel24.setText("Valor");

        jTextFieldValor.setEditable(false);
        jTextFieldValor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextFieldValor.setForeground(new java.awt.Color(0, 0, 204));

        jLabel25.setText("Quantidade*");

        jTextFieldQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextFieldQuantidade.setForeground(new java.awt.Color(0, 0, 204));
        jTextFieldQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldQuantidadeFocusLost(evt);
            }
        });

        jLabel26.setText("Total");

        jTextFieldTotal.setEditable(false);
        jTextFieldTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextFieldTotal.setForeground(new java.awt.Color(0, 0, 204));

        jTableOperacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Operação", "Chave da NF-e", "Código Produto", "Descrição", "Valor", "Quantidade", "Subtotal", "IBS", "CBS", "IVA Dual", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableOperacoes);

        jLabel27.setText("Data Operação*");

        jTextFieldDataOperacao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextFieldDataOperacao.setForeground(new java.awt.Color(0, 0, 204));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jTextFieldCodigoProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDescricaoProduto)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel23)
                                .addGap(0, 566, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jTextFieldDataOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldDescricaoProduto)
                    .addComponent(jTextFieldValor)
                    .addComponent(jTextFieldQuantidade)
                    .addComponent(jTextFieldTotal)
                    .addComponent(jTextFieldDataOperacao)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodigoProduto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Regime Favorecido com Redução de Alíquota"));

        buttonGroup2.add(jRadioButtonReducaoZero);
        jRadioButtonReducaoZero.setSelected(true);
        jRadioButtonReducaoZero.setText("0%");

        buttonGroup2.add(jRadioButtonReducao30);
        jRadioButtonReducao30.setText("30%");

        buttonGroup2.add(jRadioButtonReducao60);
        jRadioButtonReducao60.setText("60%");

        buttonGroup2.add(jRadioButtonReducao100);
        jRadioButtonReducao100.setText("100%");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jRadioButtonReducaoZero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonReducao30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonReducao60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonReducao100)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonReducaoZero)
                    .addComponent(jRadioButtonReducao30)
                    .addComponent(jRadioButtonReducao60)
                    .addComponent(jRadioButtonReducao100))
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Split Payment")));

        buttonGroup1.add(jRadioButtonSemSplit);
        jRadioButtonSemSplit.setText("Sem Split");

        buttonGroup1.add(jRadioButtonSplitInteligente);
        jRadioButtonSplitInteligente.setSelected(true);
        jRadioButtonSplitInteligente.setText("Split Inteligente");

        buttonGroup1.add(jRadioButtonSplitSimplificado);
        jRadioButtonSplitSimplificado.setText("Split Simplificado");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonSemSplit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonSplitInteligente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonSplitSimplificado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSemSplit)
                    .addComponent(jRadioButtonSplitInteligente)
                    .addComponent(jRadioButtonSplitSimplificado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()), "Sentido da Operação"));

        buttonGroup3.add(jRadioButtonAB);
        jRadioButtonAB.setText("Contribuinte A ---> Contribuinte B");
        jRadioButtonAB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonABStateChanged(evt);
            }
        });
        jRadioButtonAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonABActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButtonBA);
        jRadioButtonBA.setText("Contribuinte B ---> Contribuinte A");
        jRadioButtonBA.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonBAStateChanged(evt);
            }
        });
        jRadioButtonBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBAActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButtonBC);
        jRadioButtonBC.setText("Contribuinte B ---> Consumidor Final");
        jRadioButtonBC.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonBCStateChanged(evt);
            }
        });
        jRadioButtonBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBCActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel30.setBackground(new java.awt.Color(204, 255, 204));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("ENTRADA");

        jLabel31.setBackground(new java.awt.Color(255, 255, 204));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("SAÍDA");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jRadioButtonBC)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jRadioButtonAB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jRadioButtonBA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonAB)
                        .addComponent(jLabel31))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonBA)
                        .addComponent(jLabel30))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Outras Informações")));

        buttonGroup4.add(jRadioButtonOperacaoIsenta);
        jRadioButtonOperacaoIsenta.setText("Operação Isenta");

        buttonGroup4.add(jRadioButtonCreditoPresumido);
        jRadioButtonCreditoPresumido.setText("Crédito Presumido");
        jRadioButtonCreditoPresumido.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonCreditoPresumidoStateChanged(evt);
            }
        });

        buttonGroup4.add(jRadioButtonDiferimento);
        jRadioButtonDiferimento.setText("Diferimento");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("%");

        buttonGroup4.add(jRadioButtonOperacaoNormal);
        jRadioButtonOperacaoNormal.setSelected(true);
        jRadioButtonOperacaoNormal.setText("Normal");
        jRadioButtonOperacaoNormal.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jRadioButtonOperacaoNormalVetoableChange(evt);
            }
        });

        buttonGroup4.add(jRadioButton2);
        jRadioButton2.setText("Isenção com Manutenção do Crédito");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jRadioButtonOperacaoIsenta)
                        .addGap(34, 34, 34)
                        .addComponent(jRadioButtonDiferimento))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jRadioButtonCreditoPresumido)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPercentualCreditoPresumido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(39, 39, 39)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButtonOperacaoNormal))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonOperacaoIsenta)
                    .addComponent(jRadioButtonDiferimento)
                    .addComponent(jRadioButtonOperacaoNormal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCreditoPresumido)
                    .addComponent(jTextFieldPercentualCreditoPresumido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jRadioButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelOperacoesLayout = new javax.swing.GroupLayout(jPanelOperacoes);
        jPanelOperacoes.setLayout(jPanelOperacoesLayout);
        jPanelOperacoesLayout.setHorizontalGroup(
            jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelOperacoesLayout.createSequentialGroup()
                        .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelConsumidorFinal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelContribuinteA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelContribuinteB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanelOperacoesLayout.setVerticalGroup(
            jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelContribuinteA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelContribuinteB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOperacoesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOperacoesLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanelConsumidorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Operações com Mercadorias e Serviços", new javax.swing.ImageIcon(getClass().getResource("/imagens/operacoes.png")), jPanelOperacoes); // NOI18N

        jTableOperacoesContribuinteA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Chave NF-e", "Valor do Imposto", "Retido Split", "Crédito a Apropriar", "Crédito Apropriado", "C/D/I", "Saldo a Liquidar", "Forma Liquidação", "Redução Aliq."
            }
        ));
        jScrollPane2.setViewportView(jTableOperacoesContribuinteA);

        jTableOperacoesContribuinteB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Chave NF-e", "Valor do Imposto", "Retido Split", "Crédito a Apropriar", "Crédito Apropriado", "C/D/I", "Saldo a Liquidar", "Forma Liquidação", "Redução Aliq."
            }
        ));
        jScrollPane3.setViewportView(jTableOperacoesContribuinteB);

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setText("Operações do Contribuinte A");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setText("Operações do Contribuinte B");

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()), "Recolhimentos Avulsos"));

        jLabel39.setText("Contribuinte");

        jComboBoxContribuinte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contribuinte A", "Contribuinte B" }));

        jLabel40.setText("Valor");

        jLabel41.setText("Vincular Nota");

        jLabel42.setText("Data");

        jButton2.setText("Recolher");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxContribuinte, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldValorAvulso, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jTextFieldDataPagamentoAvulsos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxContribuinte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorAvulso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDataPagamentoAvulsos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelInformacoesApuracaoLayout = new javax.swing.GroupLayout(jPanelInformacoesApuracao);
        jPanelInformacoesApuracao.setLayout(jPanelInformacoesApuracaoLayout);
        jPanelInformacoesApuracaoLayout.setHorizontalGroup(
            jPanelInformacoesApuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformacoesApuracaoLayout.createSequentialGroup()
                .addGroup(jPanelInformacoesApuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInformacoesApuracaoLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesApuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInformacoesApuracaoLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelInformacoesApuracaoLayout.createSequentialGroup()
                                .addGap(570, 570, 570)
                                .addComponent(jLabel32))
                            .addGroup(jPanelInformacoesApuracaoLayout.createSequentialGroup()
                                .addGap(569, 569, 569)
                                .addComponent(jLabel33)))
                        .addGap(0, 454, Short.MAX_VALUE))
                    .addGroup(jPanelInformacoesApuracaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelInformacoesApuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        jPanelInformacoesApuracaoLayout.setVerticalGroup(
            jPanelInformacoesApuracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesApuracaoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Informações para Apuração - IPA", new javax.swing.ImageIcon(getClass().getResource("/imagens/nfe.png")), jPanelInformacoesApuracao); // NOI18N

        jPanel18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Apuração do Contribuinte A", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTableApuracaoContribuinteA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Crédito", "Débito"
            }
        ));
        jScrollPane6.setViewportView(jTableApuracaoContribuinteA);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setText("Saldo do Período........... :");

        jLabelSaldoContribuinteA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelSaldoContribuinteA.setForeground(new java.awt.Color(0, 0, 255));
        jLabelSaldoContribuinteA.setText("0,00");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSaldoContribuinteA, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabelSaldoContribuinteA))
                .addContainerGap())
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Apuração do Contribuinte B", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTableApuracaoContribuinteB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Crédito", "Débito"
            }
        ));
        jScrollPane7.setViewportView(jTableApuracaoContribuinteB);

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setText("Saldo do Período........... :");

        jLabelSaldoContribuinteB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelSaldoContribuinteB.setForeground(new java.awt.Color(0, 0, 255));
        jLabelSaldoContribuinteB.setText("0,00");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSaldoContribuinteB, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabelSaldoContribuinteB))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(308, 308, 308))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(275, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Apuração", new javax.swing.ImageIcon(getClass().getResource("/imagens/calc.png")), jPanel18); // NOI18N

        jTableArrecadacaoEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Período Referência", "UF", "Arrecadação"
            }
        ));
        jScrollPane8.setViewportView(jTableArrecadacaoEstados);

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setText("Arrecadação dos Estados");

        jTableArrecadacaoMunicipios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Período de Referência", "Município", "Arrecadação"
            }
        ));
        jScrollPane4.setViewportView(jTableArrecadacaoMunicipios);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setText("Arrecadação dos Municípios");

        jTableCashback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "DF-e", "CPF", "Chashback"
            }
        ));
        jScrollPane5.setViewportView(jTableCashback);

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Cashback");

        jTableApuracoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Período Referência", "Contribuinte", "Crédito", "Débito", "Saldo", "Recolhimento"
            }
        ));
        jScrollPane9.setViewportView(jTableApuracoes);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setText("Apurações");

        javax.swing.GroupLayout jPanelComiteGestorLayout = new javax.swing.GroupLayout(jPanelComiteGestor);
        jPanelComiteGestor.setLayout(jPanelComiteGestorLayout);
        jPanelComiteGestorLayout.setHorizontalGroup(
            jPanelComiteGestorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComiteGestorLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel35)
                .addGap(240, 240, 240)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(236, 236, 236))
            .addGroup(jPanelComiteGestorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelComiteGestorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelComiteGestorLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(jPanelComiteGestorLayout.createSequentialGroup()
                .addGap(641, 641, 641)
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelComiteGestorLayout.setVerticalGroup(
            jPanelComiteGestorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelComiteGestorLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanelComiteGestorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelComiteGestorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Comitê Gestor", new javax.swing.ImageIcon(getClass().getResource("/imagens/comite-gestor.png")), jPanelComiteGestor); // NOI18N

        javax.swing.GroupLayout jPanelReparticaoLayout = new javax.swing.GroupLayout(jPanelReparticao);
        jPanelReparticao.setLayout(jPanelReparticaoLayout);
        jPanelReparticaoLayout.setHorizontalGroup(
            jPanelReparticaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1396, Short.MAX_VALUE)
        );
        jPanelReparticaoLayout.setVerticalGroup(
            jPanelReparticaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Repartição de Receita", new javax.swing.ImageIcon(getClass().getResource("/imagens/reparticao-receita.png")), jPanelReparticao); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Configurações de Alíquotas"));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Alíquotas IBS/CBS"));

        jLabel1.setText("Alíquota UF %");

        jTextFieldAliquotaUf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAliquotaUf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAliquotaUf.setText("18");
        jTextFieldAliquotaUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAliquotaUfActionPerformed(evt);
            }
        });

        jLabel2.setText("Alíquota Município %");

        jTextFieldAliquotaMunicipio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAliquotaMunicipio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAliquotaMunicipio.setText("5");
        jTextFieldAliquotaMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAliquotaMunicipioActionPerformed(evt);
            }
        });

        jTextFieldAliquotaUniao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAliquotaUniao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAliquotaUniao.setText("7");

        jLabel3.setText("Alíquota União %");

        jTextFieldAliquotaIbs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAliquotaIbs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAliquotaIbs.setText("23");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("IBS %");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("CBS %");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("IVA Dual %");

        jTextFieldAliquotaIvaDual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAliquotaIvaDual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAliquotaIvaDual.setText("30");

        jTextFieldAliquotaCbs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAliquotaCbs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAliquotaCbs.setText("7");

        jLabel7.setText("+");

        jLabel8.setText("=");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldAliquotaIbs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldAliquotaUf, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAliquotaMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTextFieldAliquotaCbs, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldAliquotaUniao, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldAliquotaIvaDual, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldAliquotaMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldAliquotaUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldAliquotaUniao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldAliquotaIbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldAliquotaIvaDual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldAliquotaCbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(jLabel7))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Alíquota Split Simplificado"));

        jLabel9.setText("Alíquota %");

        jTextFieldAliquotaSplitSimplificado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAliquotaSplitSimplificado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAliquotaSplitSimplificado.setText("4");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldAliquotaSplitSimplificado, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAliquotaSplitSimplificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Outras Configurações"));

        jLabel28.setText("Alíquota Cashback %");

        jTextFieldAliquotaCashBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextFieldAliquotaCashBack.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldAliquotaCashBack.setText("2");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jTextFieldAliquotaCashBack, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(368, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAliquotaCashBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sef-mg.png"))); // NOI18N

        javax.swing.GroupLayout jPanelConfiguracoesLayout = new javax.swing.GroupLayout(jPanelConfiguracoes);
        jPanelConfiguracoes.setLayout(jPanelConfiguracoesLayout);
        jPanelConfiguracoesLayout.setHorizontalGroup(
            jPanelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracoesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelConfiguracoesLayout.createSequentialGroup()
                .addGap(516, 516, 516)
                .addComponent(jLabel34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelConfiguracoesLayout.setVerticalGroup(
            jPanelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfiguracoesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(jLabel34)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Configurações Gerais", new javax.swing.ImageIcon(getClass().getResource("/imagens/settings.png")), jPanelConfiguracoes); // NOI18N

        jMenu1.setMnemonic('C');
        jMenu1.setText("Cadastros");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Configurações");
        jMenuBar1.add(jMenu3);

        jMenu4.setMnemonic('A');
        jMenu4.setText("Ajuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAliquotaUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAliquotaUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAliquotaUfActionPerformed

    private void jTextFieldAliquotaMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAliquotaMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAliquotaMunicipioActionPerformed

    private void jComboBoxUfEmitenteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUfEmitenteItemStateChanged
        String item = (String) jComboBoxUfEmitente.getSelectedItem();
        jComboBoxMunicipioEmitente.removeAllItems();

        if (item.equals("MG")) {

            jComboBoxMunicipioDestinatario.addItem("Belo Horizonte");
            jComboBoxMunicipioEmitente.addItem("Betim");
            jComboBoxMunicipioEmitente.addItem("Contagem");
            jComboBoxMunicipioEmitente.addItem("Uberlândia");
        }

        if (item.equals("SP")) {
            jComboBoxMunicipioEmitente.addItem("São Paulo");
            jComboBoxMunicipioEmitente.addItem("São Caetano");
            jComboBoxMunicipioEmitente.addItem("Santos");
            jComboBoxMunicipioEmitente.addItem("Santo André");
        }

    }//GEN-LAST:event_jComboBoxUfEmitenteItemStateChanged

    private void jComboBoxUfDestinatarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUfDestinatarioItemStateChanged
        // TODO add your handling code here:

        String item = (String) jComboBoxUfDestinatario.getSelectedItem();
        jComboBoxMunicipioDestinatario.removeAllItems();

        if (item.equals("MG")) {

            jComboBoxMunicipioDestinatario.addItem("Belo Horizonte");
            jComboBoxMunicipioDestinatario.addItem("Betim");
            jComboBoxMunicipioDestinatario.addItem("Contagem");
            jComboBoxMunicipioDestinatario.addItem("Uberlândia");
        }

        if (item.equals("SP")) {
            jComboBoxMunicipioDestinatario.addItem("São Paulo");
            jComboBoxMunicipioDestinatario.addItem("São Caetano");
            jComboBoxMunicipioDestinatario.addItem("Santos");
            jComboBoxMunicipioDestinatario.addItem("Santo André");
        }

    }//GEN-LAST:event_jComboBoxUfDestinatarioItemStateChanged

    private void jComboBoxUfConsumidorFinalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUfConsumidorFinalItemStateChanged

        String item = (String) jComboBoxUfConsumidorFinal.getSelectedItem();
        jComboBoxMunicipioConsumidorFinal.removeAllItems();

        if (item.equals("MG")) {

            jComboBoxMunicipioConsumidorFinal.addItem("Belo Horizonte");
            jComboBoxMunicipioConsumidorFinal.addItem("Betim");
            jComboBoxMunicipioConsumidorFinal.addItem("Contagem");
            jComboBoxMunicipioConsumidorFinal.addItem("Uberlândia");
        }

        if (item.equals("SP")) {
            jComboBoxMunicipioConsumidorFinal.addItem("São Paulo");
            jComboBoxMunicipioConsumidorFinal.addItem("São Caetano");
            jComboBoxMunicipioConsumidorFinal.addItem("Santos");
            jComboBoxMunicipioConsumidorFinal.addItem("Santo André");
        }
    }//GEN-LAST:event_jComboBoxUfConsumidorFinalItemStateChanged

    private void jTextFieldCodigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoProdutoFocusLost
        String codigo = jTextFieldCodigoProduto.getText();

        if (!codigo.equals("")) {
            int codigoInt = Integer.parseInt(codigo);

            var produto = Produto.getProduto(codigoInt);

            jTextFieldDescricaoProduto.setText(produto.getDescricao());
            jTextFieldValor.setText(Double.toString(produto.getValor()));
        }

    }//GEN-LAST:event_jTextFieldCodigoProdutoFocusLost

    private void jTextFieldNomeConsumidorFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeConsumidorFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeConsumidorFinalActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void jRadioButtonABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonABActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonABActionPerformed

    private void jRadioButtonBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonBAActionPerformed

    private void jRadioButtonBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonBCActionPerformed

    private void jTextFieldQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeFocusLost
        String qtd = jTextFieldQuantidade.getText();
        String vlr = jTextFieldValor.getText();

        double quantidade = Double.parseDouble(qtd);
        double valor = Double.parseDouble(vlr);
        double total = quantidade * valor;

        jTextFieldTotal.setText(Double.toString(total));
    }//GEN-LAST:event_jTextFieldQuantidadeFocusLost

    public void calculoRegraGeral() {
        DefaultTableModel model = (DefaultTableModel) jTableOperacoes.getModel();
        Vector linha = new Vector();
        String chave = "";

        Operacao operacao = new Operacao();

        RegrasCalculo regrasCalculo = new RegrasCalculo(
                jTextFieldAliquotaIbs.getText(),
                jTextFieldAliquotaCbs.getText(),
                jTextFieldAliquotaIvaDual.getText(), jTextFieldTotal.getText());

        int codigoProduto = Integer.parseInt(jTextFieldCodigoProduto.getText());
        var produto = Produto.getProduto(codigoProduto);

        linha.add(jTextFieldDataOperacao.getText());
        chave = "CH" + Calendar.getInstance().getTimeInMillis();
        jComboBoxNotas.addItem(chave);
        linha.add(chave);
        linha.add(jTextFieldCodigoProduto.getText());
        linha.add(produto);
        linha.add(jTextFieldValor.getText());
        linha.add(jTextFieldQuantidade.getText());

        double subTotal = Double.parseDouble(jTextFieldTotal.getText());

        linha.add(decimalFormat.format(subTotal));

        if (jRadioButtonOperacaoNormal.isSelected() && jRadioButtonReducaoZero.isSelected()) {
            regrasCalculo.calcularImpostoSemReducao();
            linha.add(decimalFormat.format(regrasCalculo.getValorIbs()));
            linha.add(decimalFormat.format(regrasCalculo.getValorCbs()));
            linha.add(decimalFormat.format(regrasCalculo.getValorIva()));
            linha.add(decimalFormat.format(regrasCalculo.getValorTotal()));

            //imposto com redução de alíquota
        } else if (jRadioButtonReducao30.isSelected()
                || jRadioButtonReducao60.isSelected()
                || jRadioButtonReducao100.isSelected()) {

            double reducao;
            if (jRadioButtonReducao30.isSelected()) {
                reducao = 30;
                operacao.setReducaoAliquota("30%");
            } else if (jRadioButtonReducao60.isSelected()) {
                reducao = 60;
                operacao.setReducaoAliquota("60%");
            } else {
                reducao = 100;
                operacao.setReducaoAliquota("100%");
            }

            regrasCalculo.calcularImpostoComReducao(reducao);

            linha.add(decimalFormat.format(regrasCalculo.getValorIbs()));
            linha.add(decimalFormat.format(regrasCalculo.getValorCbs()));
            linha.add(decimalFormat.format(regrasCalculo.getValorIva()));
            linha.add(decimalFormat.format(regrasCalculo.getValorTotal()));
        }

        model.addRow(linha);

        //registrar operação       
        operacao.setIbs(regrasCalculo.getValorIbs());
        operacao.setCbs(regrasCalculo.getValorCbs());
        operacao.setIva(regrasCalculo.getValorIva());
        operacao.setChave(chave);
        operacao.setPeriodoRefencia(jTextFieldDataOperacao.getText().substring(3,
                jTextFieldDataOperacao.getText().length()));

        operacao.setDataOperacao(jTextFieldDataOperacao.getText());

        if (jRadioButtonSplitInteligente.isSelected()) {
            operacao.setSplitInteligente(true);
            operacao.setSemSplit(false);
            operacao.setSplitSimplificado(false);
            operacao.setValorIbsRetidoPorSplitSimplificado(operacao.getIbs());
        }

        if (jRadioButtonSplitSimplificado.isSelected()) {
            operacao.setSplitInteligente(false);
            operacao.setSemSplit(false);
            operacao.setSplitSimplificado(true);
            operacao.setAliquotaSplitSimplificado(Double.parseDouble(jTextFieldAliquotaSplitSimplificado.getText()));
            operacao.setValorIbsRetidoPorSplitSimplificado(regrasCalculo.calcularRetencaoComSplitSimplificado(operacao.getAliquotaSplitSimplificado()));
        }

        if (jRadioButtonSemSplit.isSelected()) {
            operacao.setSplitInteligente(false);
            operacao.setSemSplit(true);
            operacao.setSplitSimplificado(false);
        }

        if (jRadioButtonSplitInteligente.isSelected()) {
            operacao.setSplitInteligente(true);
            operacao.setSemSplit(false);
            operacao.setSplitSimplificado(false);
        }

        if (jRadioButtonAB.isSelected()) {
            operacao.setOrigem("Contribuinte A");
            operacao.setDestino("Contribuinte B");

        } else if (jRadioButtonBA.isSelected()) {
            operacao.setOrigem("Contribuinte B");
            operacao.setDestino("Contribuinte A");

        } else {
            operacao.setOrigem("Contribuinte B");
            operacao.setDestino("Consumidor Final");
        }

        if (jRadioButtonAB.isSelected()) {
            registrarOperacaoAB(operacao);
        } else if (jRadioButtonBC.isSelected()) {
            registrarOperacaoBC(operacao);
        } else {
            registrarOperacaoBA(operacao);
        }

        listaOperacoes.add(operacao);

        regrasCalculo.realizarApuracao(listaOperacoes);

        //Alimentar tabelas de apuração
        DefaultTableModel modelA = (DefaultTableModel) jTableApuracaoContribuinteA.getModel();

        for (Vector line : regrasCalculo.getListaOperacoesContribuinteA()) {
            modelA.addRow(line);
        }

        DefaultTableModel modelB = (DefaultTableModel) jTableApuracaoContribuinteB.getModel();

        for (Vector line : regrasCalculo.getListaOperacoesContribuinteB()) {
            modelB.addRow(line);
        }

        double saldoContribuinteA = regrasCalculo.calcularSaldoPeriodo(modelA);
        double saldoContribuinteB = regrasCalculo.calcularSaldoPeriodo(modelB);

        jLabelSaldoContribuinteA.setText(decimalFormat.format(saldoContribuinteA));
        jLabelSaldoContribuinteB.setText(decimalFormat.format(saldoContribuinteB));

        if (saldoContribuinteA > 0) {
            jLabelSaldoContribuinteA.setForeground(Color.RED);
        } else {
            jLabelSaldoContribuinteA.setForeground(Color.BLUE);
        }

        if (saldoContribuinteB > 0) {
            jLabelSaldoContribuinteB.setForeground(Color.RED);
        } else {
            jLabelSaldoContribuinteB.setForeground(Color.BLUE);
        }
    }

    /**
     * Registrar as operações no IPA - Informações para Apuração
     *
     * @param operacao
     */
    public void registrarOperacaoAB(Operacao operacao) {
        DefaultTableModel modelContribuinteA = (DefaultTableModel) jTableOperacoesContribuinteA.getModel();
        DefaultTableModel modelContribuinteB = (DefaultTableModel) jTableOperacoesContribuinteB.getModel();

        Vector linhaContribuinteA = new Vector();
        linhaContribuinteA.add(operacao.getDataOperacao());
        linhaContribuinteA.add(operacao.getChave());
        linhaContribuinteA.add(decimalFormat.format(operacao.getIbs()));

        Vector linhaContribuinteB = new Vector();
        linhaContribuinteB.add(operacao.getDataOperacao());
        linhaContribuinteB.add(operacao.getChave());

        if (operacao.isSplitInteligente()) {
            linhaContribuinteB.add(decimalFormat.format(operacao.getIbs()));
            linhaContribuinteB.add("-");
            linhaContribuinteB.add(decimalFormat.format(0));
            linhaContribuinteB.add(decimalFormat.format(operacao.getIbs()));
            linhaContribuinteB.add("CRÉDITO");
            linhaContribuinteB.add("-");
            linhaContribuinteB.add("-");
            linhaContribuinteB.add(operacao.getReducaoAliquota());

            linhaContribuinteA.add(decimalFormat.format(operacao.getIbs()));
            linhaContribuinteA.add("-");
            linhaContribuinteA.add("-");
            linhaContribuinteA.add("DÉBITO");
            linhaContribuinteA.add(0);

            linhaContribuinteA.add("SI");
            linhaContribuinteA.add(operacao.getReducaoAliquota());

        } else if (operacao.isSemSplit()) {
            linhaContribuinteB.add(decimalFormat.format(operacao.getIbs()));
            linhaContribuinteB.add("-");
            linhaContribuinteB.add(decimalFormat.format(operacao.getIbs()));
            linhaContribuinteB.add("-");
            linhaContribuinteB.add("CRÉDITO");
            linhaContribuinteB.add("-");
            linhaContribuinteB.add("-");
            linhaContribuinteB.add(operacao.getReducaoAliquota());

            linhaContribuinteA.add(decimalFormat.format(0));
            linhaContribuinteA.add("-");
            linhaContribuinteA.add("-");
            linhaContribuinteA.add("DÉBITO");
            linhaContribuinteA.add(decimalFormat.format(operacao.getIbs()));

            linhaContribuinteA.add("SS");
            linhaContribuinteA.add(operacao.getReducaoAliquota());
        } else {

        }

        linhaContribuinteB.add("-");
        linhaContribuinteB.add("-");

        modelContribuinteA.addRow(linhaContribuinteA);
        modelContribuinteB.addRow(linhaContribuinteB);
    }

    public void registrarOperacaoBC(Operacao operacao) {
        DefaultTableModel modelContribuinteB = (DefaultTableModel) jTableOperacoesContribuinteB.getModel();

        Vector linhaContribuinteB = new Vector();

        linhaContribuinteB.add(operacao.getDataOperacao());
        linhaContribuinteB.add(operacao.getChave());
        linhaContribuinteB.add(decimalFormat.format(operacao.getIbs()));

        linhaContribuinteB.add(decimalFormat.format(operacao.getValorIbsRetidoPorSplitSimplificado()));

        linhaContribuinteB.add("-");
        linhaContribuinteB.add("-");
        linhaContribuinteB.add("DÉBITO");

        if (operacao.isSplitInteligente()) {
            linhaContribuinteB.add("0");
            linhaContribuinteB.add("SI");
            linhaContribuinteB.add("-");
        } else if (operacao.isSemSplit()) {
            linhaContribuinteB.add(operacao.getIbs());
            linhaContribuinteB.add("SS");
            linhaContribuinteB.add("-");
        } else {
            double saldoLiquidar = operacao.getIbs() - operacao.getValorIbsRetidoPorSplitSimplificado();
            linhaContribuinteB.add(decimalFormat.format(saldoLiquidar));
            linhaContribuinteB.add("SP");
            linhaContribuinteB.add("-");
        }

        linhaContribuinteB.add(operacao.getIbs());
        modelContribuinteB.addRow(linhaContribuinteB);

    }

    public void registrarOperacaoBA(Operacao operacao) {
        DefaultTableModel modelContribuinteA = (DefaultTableModel) jTableOperacoesContribuinteA.getModel();
        DefaultTableModel modelContribuinteB = (DefaultTableModel) jTableOperacoesContribuinteB.getModel();

        Vector linhaContribuinteB = new Vector();
        linhaContribuinteB.add(operacao.getDataOperacao());
        linhaContribuinteB.add(operacao.getChave());
        linhaContribuinteB.add(decimalFormat.format(operacao.getIbs()));

        Vector linhaContribuinteA = new Vector();
        linhaContribuinteA.add(operacao.getDataOperacao());
        linhaContribuinteA.add(operacao.getChave());

        if (operacao.isSplitInteligente()) {
            linhaContribuinteA.add(decimalFormat.format(operacao.getIbs()));
            linhaContribuinteA.add("-");
            linhaContribuinteA.add(decimalFormat.format(0));
            linhaContribuinteA.add(decimalFormat.format(operacao.getIbs()));
            linhaContribuinteA.add("CRÉDITO");
            linhaContribuinteA.add("-");
            linhaContribuinteA.add("-");

            linhaContribuinteB.add(decimalFormat.format(operacao.getIbs()));
            linhaContribuinteB.add("-");
            linhaContribuinteB.add("-");
            linhaContribuinteB.add("DÉBITO");
            linhaContribuinteB.add(0);

            linhaContribuinteB.add("SI");

        } else if (operacao.isSemSplit()) {
            linhaContribuinteA.add(decimalFormat.format(operacao.getIbs()));
            linhaContribuinteA.add("-");
            linhaContribuinteA.add(decimalFormat.format(operacao.getIbs()));
            linhaContribuinteA.add("-");
            linhaContribuinteA.add("CRÉDITO");
            linhaContribuinteA.add("-");
            linhaContribuinteA.add("-");

            linhaContribuinteB.add(decimalFormat.format(0));
            linhaContribuinteB.add("-");
            linhaContribuinteB.add("-");
            linhaContribuinteB.add("DÉBITO");
            linhaContribuinteB.add(decimalFormat.format(operacao.getIbs()));

            linhaContribuinteB.add("SS");
        } else {

        }

        linhaContribuinteA.add("-");
        linhaContribuinteA.add("-");

        modelContribuinteB.addRow(linhaContribuinteB);
        modelContribuinteA.addRow(linhaContribuinteA);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jRadioButtonAB.isSelected() || jRadioButtonBA.isSelected()) {
            if (jComboBoxMunicipioDestinatario.getSelectedItem() == null
                    || jComboBoxMunicipioEmitente.getSelectedItem() == null
                    || jComboBoxUfEmitente.getSelectedItem() == null
                    || jComboBoxUfDestinatario.getSelectedItem() == null) {

                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios *");

                return;
            }
        }

        if (jRadioButtonBC.isSelected()) {
            if (jComboBoxMunicipioDestinatario.getSelectedItem() == null
                    || jComboBoxMunicipioConsumidorFinal.getSelectedItem() == null
                    || jComboBoxUfConsumidorFinal.getSelectedItem() == null
                    || jComboBoxUfDestinatario.getSelectedItem() == null) {

                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios *");

                return;
            }
        }

        if (!jRadioButtonAB.isSelected()
                && !jRadioButtonBA.isSelected()
                && !jRadioButtonBC.isSelected()) {

            JOptionPane.showMessageDialog(this, "Marque em qual sentido se deu a operação!");
            return;
        }

        if (jTextFieldCodigoProduto.getText().equals("") || jTextFieldDescricaoProduto.getText().equals("")
                || jTextFieldDataOperacao.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!");

            return;
        }

        if (jRadioButtonCreditoPresumido.isSelected()) {
            if (jTextFieldPercentualCreditoPresumido.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Preencha o percentual do Crédito Presumido!");

                return;
            }
        }

        calculoRegraGeral();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButtonABStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonABStateChanged

        if (jRadioButtonAB.isSelected()) {
            jPanelContribuinteA.setBackground(new java.awt.Color(255, 255, 204));
            jPanelContribuinteB.setBackground(new java.awt.Color(204, 255, 204));
            jPanelConsumidorFinal.setBackground(new java.awt.Color(242, 242, 242));
        }
    }//GEN-LAST:event_jRadioButtonABStateChanged

    private void jRadioButtonBAStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonBAStateChanged
        if (jRadioButtonBA.isSelected()) {
            jPanelContribuinteB.setBackground(new java.awt.Color(255, 255, 204));
            jPanelContribuinteA.setBackground(new java.awt.Color(204, 255, 204));
            jPanelConsumidorFinal.setBackground(new java.awt.Color(242, 242, 242));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonBAStateChanged

    private void jRadioButtonBCStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonBCStateChanged
        if (jRadioButtonBC.isSelected()) {
            jPanelContribuinteB.setBackground(new java.awt.Color(255, 255, 204));
            jPanelConsumidorFinal.setBackground(new java.awt.Color(204, 255, 204));
            jPanelContribuinteA.setBackground(new java.awt.Color(242, 242, 242));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonBCStateChanged

    private void jRadioButtonCreditoPresumidoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonCreditoPresumidoStateChanged

    }//GEN-LAST:event_jRadioButtonCreditoPresumidoStateChanged

    private void jRadioButtonOperacaoNormalVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jRadioButtonOperacaoNormalVetoableChange

    }//GEN-LAST:event_jRadioButtonOperacaoNormalVetoableChange
    DefaultTableCellRenderer rendererDebitoCredito = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String str = (String) value;
            if ("CRÉDITO".equals(str)) {
                c.setForeground(Color.BLUE);
                c.setFont(c.getFont().deriveFont(Font.BOLD));

            } else {
                c.setForeground(Color.RED);
                c.setFont(c.getFont().deriveFont(Font.BOLD));
            }
            this.setHorizontalAlignment(CENTER);
            return c;
        }
    };

    DefaultTableCellRenderer rendererFormaLiquidacao = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            String str = (String) value;
            if ("SI".equals(str)) {
                c.setForeground(Color.BLUE);
                c.setFont(c.getFont().deriveFont(Font.BOLD));

            } else if ("SS".equals(str)) {
                c.setForeground(Color.RED);
                c.setFont(c.getFont().deriveFont(Font.BOLD));
            } else if ("SP".equals(str)) {
                c.setForeground(Color.ORANGE);
                c.setFont(c.getFont().deriveFont(Font.BOLD));
            }
            this.setHorizontalAlignment(CENTER);
            return c;
        }
    };

    DefaultTableCellRenderer rendererAlinhaDireita = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            this.setHorizontalAlignment(RIGHT);
            return c;
        }
    };

    DefaultTableCellRenderer rendererAlinhaDireitaAzul = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            c.setForeground(Color.BLUE);
            c.setFont(c.getFont().deriveFont(Font.BOLD));
            this.setHorizontalAlignment(RIGHT);
            return c;
        }
    };

    DefaultTableCellRenderer rendererAlinhaDireitaVermelho = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            c.setForeground(Color.RED);
            c.setFont(c.getFont().deriveFont(Font.BOLD));
            this.setHorizontalAlignment(RIGHT);
            return c;
        }
    };

    DefaultTableCellRenderer rendererAlinhaCentralizado = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            this.setHorizontalAlignment(CENTER);
            return c;
        }
    };

    DefaultTableCellRenderer rendererAlinhaCentralizadoNegrito = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            c.setFont(c.getFont().deriveFont(Font.BOLD));
            this.setHorizontalAlignment(CENTER);
            return c;
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxContribuinte;
    private javax.swing.JComboBox<String> jComboBoxMunicipioConsumidorFinal;
    private javax.swing.JComboBox<String> jComboBoxMunicipioDestinatario;
    private javax.swing.JComboBox<String> jComboBoxMunicipioEmitente;
    private javax.swing.JComboBox<String> jComboBoxNotas;
    private javax.swing.JComboBox<String> jComboBoxUfConsumidorFinal;
    private javax.swing.JComboBox<String> jComboBoxUfDestinatario;
    private javax.swing.JComboBox<String> jComboBoxUfEmitente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSaldoContribuinteA;
    private javax.swing.JLabel jLabelSaldoContribuinteB;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelComiteGestor;
    private javax.swing.JPanel jPanelConfiguracoes;
    private javax.swing.JPanel jPanelConsumidorFinal;
    private javax.swing.JPanel jPanelContribuinteA;
    private javax.swing.JPanel jPanelContribuinteB;
    private javax.swing.JPanel jPanelInformacoesApuracao;
    private javax.swing.JPanel jPanelOperacoes;
    private javax.swing.JPanel jPanelReparticao;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JRadioButton jRadioButtonAB;
    private javax.swing.JRadioButton jRadioButtonBA;
    private javax.swing.JRadioButton jRadioButtonBC;
    private javax.swing.JRadioButton jRadioButtonCreditoPresumido;
    private javax.swing.JRadioButton jRadioButtonDiferimento;
    private javax.swing.JRadioButton jRadioButtonOperacaoIsenta;
    private javax.swing.JRadioButton jRadioButtonOperacaoNormal;
    private javax.swing.JRadioButton jRadioButtonReducao100;
    private javax.swing.JRadioButton jRadioButtonReducao30;
    private javax.swing.JRadioButton jRadioButtonReducao60;
    private javax.swing.JRadioButton jRadioButtonReducaoZero;
    private javax.swing.JRadioButton jRadioButtonSemSplit;
    private javax.swing.JRadioButton jRadioButtonSplitInteligente;
    private javax.swing.JRadioButton jRadioButtonSplitSimplificado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableApuracaoContribuinteA;
    private javax.swing.JTable jTableApuracaoContribuinteB;
    private javax.swing.JTable jTableApuracoes;
    private javax.swing.JTable jTableArrecadacaoEstados;
    private javax.swing.JTable jTableArrecadacaoMunicipios;
    private javax.swing.JTable jTableCashback;
    private javax.swing.JTable jTableOperacoes;
    private javax.swing.JTable jTableOperacoesContribuinteA;
    private javax.swing.JTable jTableOperacoesContribuinteB;
    private javax.swing.JTextField jTextFieldAliquotaCashBack;
    private javax.swing.JTextField jTextFieldAliquotaCbs;
    private javax.swing.JTextField jTextFieldAliquotaIbs;
    private javax.swing.JTextField jTextFieldAliquotaIvaDual;
    private javax.swing.JTextField jTextFieldAliquotaMunicipio;
    private javax.swing.JTextField jTextFieldAliquotaSplitSimplificado;
    private javax.swing.JTextField jTextFieldAliquotaUf;
    private javax.swing.JTextField jTextFieldAliquotaUniao;
    private javax.swing.JTextField jTextFieldCnpjConsumidorFinal;
    private javax.swing.JTextField jTextFieldCnpjDestinatario;
    private javax.swing.JTextField jTextFieldCnpjEmitente;
    private javax.swing.JTextField jTextFieldCodigoProduto;
    private javax.swing.JTextField jTextFieldDataOperacao;
    private javax.swing.JTextField jTextFieldDataPagamentoAvulsos;
    private javax.swing.JTextField jTextFieldDescricaoProduto;
    private javax.swing.JTextField jTextFieldNomeConsumidorFinal;
    private javax.swing.JTextField jTextFieldPercentualCreditoPresumido;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldRazaoSocial;
    private javax.swing.JTextField jTextFieldRazaoSocialDestinatario;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldValorAvulso;
    // End of variables declaration//GEN-END:variables
}
