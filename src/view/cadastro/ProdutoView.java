package view.cadastro;

import dao.ProdutoDAO;
import dao.MarcaDAO;
import dao.UnidadeDAO;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.InternalFrameEvent;
import model.Marca;
import model.Produto;
import model.Unidade;
import util.UtilRelatorios;
import static view.cadastro.LoginView.emp;
import view.pesquisa.BuscaProduto;

/**
 *
 * @author Celso
 */
public class ProdutoView extends javax.swing.JInternalFrame {

    private final NumberFormat NF = NumberFormat.getNumberInstance();
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public static String pr = "";
    //public static String tb = "";

    private Produto obj = null;
    private ProdutoDAO dao = new ProdutoDAO();

    List<Marca> listMarca;
    MarcaDAO mDAO;
    List<Unidade> listUnidade;
    UnidadeDAO uDAO;

    /**
     * Creates new form ProdutoView
     */
    public ProdutoView() {
        initComponents();
        habilitarFormulario(false);
        UIManager.put("ComboBox.disabledForeground", Color.BLACK);

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            @Override
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                dispose();
                Menu.menuProduto.setEnabled(true);
                //Menu.btnCliente.setEnabled(true);
            }

            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfVlrCusto = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfCodBarras = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcbMarca = new javax.swing.JComboBox<>();
        jcbUnidade = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jtfVlrVenda = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jtfQuantidadeMin = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfQuantidade = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JFormattedTextField();
        jtfDataCadastro = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfDataCompra = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        chkServico = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("PRODUTOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Produtos"));

        jLabel1.setText("CÓDIGO.:");

        jLabel2.setText("DESCRIÇÃO.:");

        jtfNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfNome.setEnabled(false);
        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNomeKeyPressed(evt);
            }
        });

        jLabel3.setText("R$ CUSTO.:");

        jLabel4.setText("R$ VENDA.:");

        jtfVlrCusto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfVlrCusto.setEnabled(false);
        jtfVlrCusto.setValue(new Double(0));

        jLabel5.setText("MARCA.:");

        jtfCodBarras.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfCodBarras.setEnabled(false);

        jLabel6.setText("CÓDIGO BARRAS.:");

        jcbMarca.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jcbMarca.setEnabled(false);

        jcbUnidade.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jcbUnidade.setEnabled(false);

        jLabel7.setText("UNIDADE.:");

        jtfVlrVenda.setColumns(10);
        jtfVlrVenda.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfVlrVenda.setEnabled(false);
        jtfVlrVenda.setValue(new Double(0));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Zoom.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("ESTOQUE"));

        jtfQuantidadeMin.setEnabled(false);

        jLabel8.setText("Qtde min.:");

        jtfQuantidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfQuantidade.setEnabled(false);
        jtfQuantidade.setValue(new Double(0));

        jLabel9.setText("Qtde Atual.:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jtfQuantidadeMin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfQuantidadeMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtfCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfCodigo.setEnabled(false);
        jtfCodigo.setValue(new Double(0));

        jtfDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jtfDataCadastro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfDataCadastro.setEnabled(false);
        jtfDataCadastro.setValue(new Double(0));

        jLabel10.setText("CADASTRO.:");

        jtfDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jtfDataCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfDataCompra.setEnabled(false);
        jtfDataCompra.setValue(new Double(0));

        jLabel11.setText("ULTIMA COMPRA.:");

        jLabel12.setText("SERVIÇO.:");

        chkServico.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(chkServico))
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jcbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfDataCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfDataCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfCodBarras, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfVlrCusto)
                    .addComponent(jtfVlrVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkServico)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfVlrCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfVlrVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Produto", jPanel2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Histórico", jPanel3);

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Novo");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNovo.setFocusable(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovo.setMaximumSize(new java.awt.Dimension(92, 35));
        btnNovo.setPreferredSize(new java.awt.Dimension(70, 35));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovo);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalvar.setMaximumSize(new java.awt.Dimension(92, 35));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.setMaximumSize(new java.awt.Dimension(92, 35));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        obj = new Produto();
        jtfNome.requestFocus();
        jtfDataCadastro.setValue(new Date());
        habilitarFormulario(true);
        combo();
        pr = "Cadastrado";
    }//GEN-LAST:event_btnNovoActionPerformed

    private void combo() {
        mDAO = new MarcaDAO();
        uDAO = new UnidadeDAO();

        listMarca = mDAO.listarTodos(emp.getId());
        listUnidade = uDAO.listarTodos(emp.getId());

        jcbMarca.removeAllItems();
        for (Marca ma : listMarca) {
            jcbMarca.addItem(ma.getDescricao());
        }
        jcbUnidade.removeAllItems();
        for (Unidade uni : listUnidade) {
            jcbUnidade.addItem(uni.getSigla());

        }
        jcbMarca.setSelectedIndex(-1);
        jcbUnidade.setSelectedIndex(-1);
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validaCampos()) {
            if (!jtfCodigo.getText().equals("")) {
                //System.out.println("COD " + jtfCodigo.getText());
                obj.setId(Long.parseLong(jtfCodigo.getText()));
            }
            obj.setEmpresa(emp);
            obj.setDescricao(jtfNome.getText());
            obj.setVlrcusto(Double.parseDouble(jtfVlrCusto.getText().replace(',', '.')));
            obj.setVlrvenda(Double.parseDouble(jtfVlrVenda.getText().replace(',', '.')));
            obj.setQuantidade((Double) jtfQuantidade.getValue());
            obj.setMarca(listMarca.get(jcbMarca.getSelectedIndex()));
            obj.setUnidade(listUnidade.get(jcbUnidade.getSelectedIndex()));
            obj.setCodigobarras(jtfCodBarras.getText());
            obj.setDataCadastro(new Date());
            if (chkServico.isSelected()) {
                obj.setServico("S");
            } else {
                obj.setServico("N");
            }

            // if (obj.getId() == 0) {
            try {
                dao.salvar(obj);
                JOptionPane.showMessageDialog(this, "Produto " + pr + " Com Sucesso.! ");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao Cadastrar Produto.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //} else {
//                try {
//                    //dao.alterar(nota);
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(this, "Erro ao alterar a Nota.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
            //}
            habilitarFormulario(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void habilitarFormulario(boolean ativo) {
        jtfNome.setEnabled(ativo);
        jcbMarca.setEnabled(ativo);
        jcbUnidade.setEnabled(ativo);
        jtfCodBarras.setEnabled(ativo);
        chkServico.setEnabled(ativo);
        btnNovo.setEnabled(!ativo);
        btnSalvar.setEnabled(ativo);
        //btRemoverItem.setEnabled(ativo);
        //tbGradeItens.setEnabled(!ativo);
        if (!ativo) {
            limpaFormulario();
        }
    }

    private void limpaFormulario() {
        obj = null;
        jtfCodigo.setText(null);
        jtfNome.setText(null);
        jcbMarca.setSelectedItem(null);
        jcbUnidade.setSelectedItem(null);
        jtfVlrCusto.setValue(new Double(0));
        jtfCodBarras.setText("");
        jtfVlrVenda.setValue(new Double(0));
        jtfDataCadastro.setValue(null);
        jtfDataCompra.setValue(null);
        jtfQuantidade.setValue(new Double(0));
        chkServico.setSelected(false);
    }

    private boolean validaCampos() {
        if (!(jtfNome.getText().length() > 0 && jtfNome.getText() != null)) {
            JOptionPane.showMessageDialog(null, "Campo DESCRIÇÃO Deve ser Informado!", "Atenção", JOptionPane.WARNING_MESSAGE);
            jtfNome.requestFocus();
            return false;
        }
        if (!(jcbMarca.getSelectedItem() != null)) {
            JOptionPane.showMessageDialog(null, "Campo MARCA Deve ser Informado!", "Atenção", JOptionPane.WARNING_MESSAGE);
            jcbMarca.requestFocus();
            return false;
        }
        if (!(jcbUnidade.getSelectedItem() != null)) {
            JOptionPane.showMessageDialog(null, "Campo UNIDADE DE MEDIDA Deve ser Informado!", "Atenção", JOptionPane.WARNING_MESSAGE);
            jcbUnidade.requestFocus();
            return false;
        }
        return true;
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitarFormulario(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscaProduto busca = new BuscaProduto(this);
        busca.setLocationRelativeTo(null);
        busca.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyPressed
        jtfNome.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                toUpper(jtfNome);
            }

            public void toUpper(JTextField jt) {
                String s = jt.getText().toUpperCase();
                jt.setText(s);
            }
        });
    }//GEN-LAST:event_jtfNomeKeyPressed

    public void setProduto(Produto p) {
        obj = new Produto();
        //AQUI DATA FUNCIONA ASSIM
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        jtfDataCadastro.setText("");
        try {
            Date dtca = p.getDataCadastro();
            String dtcaFormatada = df.format(dtca);
            jtfDataCadastro.setText(dtcaFormatada);
        } catch (Exception e) {
        }
        jtfDataCompra.setText("");
        try {
            Date dtco = p.getDataultimaCompra();
            String dtcoFormatada = df.format(dtco);
            jtfDataCompra.setText(dtcoFormatada);
        } catch (Exception e) {
        }

        habilitarFormulario(true);
        jtfCodigo.setValue(p.getId());
        jtfNome.setText(p.getDescricao());
        if (p.getServico().equals("S")) {
            chkServico.setSelected(true);
        } else if (p.getServico().equals("N")) {
            chkServico.setSelected(false);
        }
        jtfVlrCusto.setText(new DecimalFormat("#,##0.00").format(p.getVlrcusto()));
        combo();
        jcbMarca.setSelectedItem(p.getMarca().getDescricao());
        jcbUnidade.setSelectedItem(p.getUnidade().getSigla());
        jtfCodBarras.setText(p.getCodigobarras());
        jtfVlrVenda.setText(new DecimalFormat("#,##0.00").format(p.getVlrvenda()));
        jtfQuantidade.setValue(p.getQuantidade());
        pr = "Alterado";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnNovo;
    public static javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkServico;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> jcbMarca;
    private javax.swing.JComboBox<String> jcbUnidade;
    private javax.swing.JTextField jtfCodBarras;
    private javax.swing.JFormattedTextField jtfCodigo;
    private javax.swing.JFormattedTextField jtfDataCadastro;
    private javax.swing.JFormattedTextField jtfDataCompra;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JFormattedTextField jtfQuantidade;
    private javax.swing.JFormattedTextField jtfQuantidadeMin;
    private javax.swing.JFormattedTextField jtfVlrCusto;
    private javax.swing.JFormattedTextField jtfVlrVenda;
    // End of variables declaration//GEN-END:variables
}
