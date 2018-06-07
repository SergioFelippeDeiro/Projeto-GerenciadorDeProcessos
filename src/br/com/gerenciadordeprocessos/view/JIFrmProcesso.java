package br.com.gerenciadordeprocessos.view;

import br.com.gerenciadordeprocessos.controller.ControleBasico;
import br.com.gerenciadordeprocessos.controller.ControleGenerico;
import br.com.gerenciadordeprocessos.dao.DaoProcesso;
import br.com.gerenciadordeprocessos.model.Processo;
import static br.com.gerenciadordeprocessos.util.ExibicaoDeMensagens.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class JIFrmProcesso extends javax.swing.JInternalFrame {

    ControleBasico controleP;

    public JIFrmProcesso() {
        this.controleP = new ControleGenerico(new DaoProcesso());
        initComponents();
    }
    final String tituloMsg = "Funcionario";

    private void limpar() {
        tblProcessos.clearSelection();
        txtAutor.setText("");
        JFormattedTextField ftd[] = {ftdNumeroProcesso1, ftdNumeroProcesso2, ftdNumeroProcesso3};
        for(JFormattedTextField f : ftd)
            f.setText("");
        txtNumeroProcesso4.setText("");
        txtaVara.setText("");
        lblCampoId.setText("");
        cmbMudarNumeroProcesso.setSelectedIndex(1);
        mudarFormatoNumeroProcesso(1);
        txtProcurarAutor.setText("");
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnIncluir.setEnabled(true);
        txtAutor.requestFocusInWindow();
    }

    private void mudarFormatoNumeroProcesso(int cmb) {
        String formato = null;
        try {
            List<JFormattedTextField> ftd = Arrays.asList(ftdNumeroProcesso1, ftdNumeroProcesso1, ftdNumeroProcesso2, ftdNumeroProcesso3);
            switch (cmb) {
                case 1:
                    ftdNumeroProcesso2.setVisible(false);
                    ftdNumeroProcesso3.setVisible(false);
                    txtNumeroProcesso4.setVisible(false);
                    ftdNumeroProcesso1.setVisible(true);
                    formato = "#######-##.####.#.##.####";
                    break;
                case 2:
                    ftdNumeroProcesso1.setVisible(false);
                    ftdNumeroProcesso3.setVisible(false);
                    txtNumeroProcesso4.setVisible(false);
                    ftdNumeroProcesso2.setVisible(true);
                    formato = "####.###.######-#";
                    break;
                case 3:
                    ftdNumeroProcesso2.setVisible(false);
                    ftdNumeroProcesso1.setVisible(false);
                    txtNumeroProcesso4.setVisible(false);
                    ftdNumeroProcesso3.setVisible(true);
                    formato = "####.#####-#";
                    break;
                case 4:
                    ftdNumeroProcesso2.setVisible(false);
                    ftdNumeroProcesso3.setVisible(false);
                    ftdNumeroProcesso1.setVisible(false);
                    txtNumeroProcesso4.setVisible(true);
            }
            if (ftd.stream().noneMatch(f -> f.isVisible())) {
                txtNumeroProcesso4.setText("");
                return;
            }
            for (JFormattedTextField f : ftd) {
                if (f.isVisible()) {
                    f.setText("");
                    f.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(formato)));
                }
            }

        } catch (ParseException ex) {
            exibirMsg(ex.getMessage(), tituloMsg, false);
            Logger.getLogger(JIFrmProcesso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void incluirProcessoNaTabela() {
        int linha = tblProcessos.getSelectedRow();

        lblCampoId.setText(tblProcessos.getModel().getValueAt(linha, 0).toString());
        txtAutor.setText(tblProcessos.getModel().getValueAt(linha, 1).toString());
        txtaVara.setText(tblProcessos.getModel().getValueAt(linha, 3).toString());

        String numero = tblProcessos.getModel().getValueAt(linha, 2).toString();
        String formato[] = {
            "",
            "[0-9]{7}-[0-9]{2}.[0-9]{4}.[0-9].[0-9]{2}.[0-9]{4}",
            "[0-9]{4}.[0-9]{3}.[0-9]{6}-[0-9]",
            "[0-9]{4}.[0-9]{5}-[0-9]"};
        if (numero.matches(formato[1])) {
            cmbMudarNumeroProcesso.setSelectedIndex(1);
            ftdNumeroProcesso1.setText(numero);
        } else if (numero.matches(formato[2])) {
            cmbMudarNumeroProcesso.setSelectedIndex(2);
            ftdNumeroProcesso2.setText(numero);
        } else if (numero.matches(formato[3])) {
            cmbMudarNumeroProcesso.setSelectedIndex(3);
            ftdNumeroProcesso3.setText(numero);
        } else {
            cmbMudarNumeroProcesso.setSelectedIndex(4);
            txtNumeroProcesso4.setText(numero);
        }

        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnIncluir.setEnabled(false);
    }

    public Processo incluirProcessoNaClasse() {
        Processo p = new Processo();
        p.setAutor(txtAutor.getText());
        JFormattedTextField ftd[] = {ftdNumeroProcesso1, ftdNumeroProcesso2, ftdNumeroProcesso3};
        for (JFormattedTextField f : ftd) {
            if (f.isVisible()) {
                p.setNumeroProcesso(f.getText());
                break;
            }
        }
        if (txtNumeroProcesso4.isVisible()) {
            p.setNumeroProcesso(txtNumeroProcesso4.getText());
        }
        p.setVara(txtaVara.getText());

        return p;
    }

    public void procurarProcesso(String autor) {
        JTable tbl = controleP.selectByName(autor, tblProcessos);
        tblProcessos.setModel(tbl.getModel());
    }

    public boolean validarCamposIncluir() {
        if (ftdNumeroProcesso1.getText().isEmpty() || txtaVara.getText().isEmpty()) {
            exibirMsg("Preecha todos os campos", tituloMsg, false);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBotoes = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnRetornar = new javax.swing.JButton();
        lblCampoId = new javax.swing.JLabel();
        lblProcurarAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblVara = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcessos = new javax.swing.JTable();
        lblNumeroProcesso = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaVara = new javax.swing.JTextArea();
        txtProcurarAutor = new javax.swing.JTextField();
        lblAutor1 = new javax.swing.JLabel();
        cmbMudarNumeroProcesso = new javax.swing.JComboBox<>();
        ftdNumeroProcesso1 = new javax.swing.JFormattedTextField();
        ftdNumeroProcesso3 = new javax.swing.JFormattedTextField();
        ftdNumeroProcesso2 = new javax.swing.JFormattedTextField();
        txtNumeroProcesso4 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Funcionário");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnIncluir.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnRetornar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnRetornar.setText("Retornar");
        btnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRetornar)
                .addGap(56, 56, 56))
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRetornar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIncluir))
                .addContainerGap())
        );

        getContentPane().add(pnlBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 470, -1));

        lblCampoId.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCampoId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblCampoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 100, 30));

        lblProcurarAutor.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblProcurarAutor.setText("Procurar autor");
        getContentPane().add(lblProcurarAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 30));

        txtAutor.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        txtAutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAutor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAutorFocusLost(evt);
            }
        });
        getContentPane().add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 590, 30));

        lblVara.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblVara.setText("Vara");
        getContentPane().add(lblVara, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, 30));

        tblProcessos.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        tblProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProcessos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProcessosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProcessos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 750, 210));

        lblNumeroProcesso.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblNumeroProcesso.setText("Número do processo");
        getContentPane().add(lblNumeroProcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, 30));

        lblId.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, 30));

        txtaVara.setColumns(20);
        txtaVara.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        txtaVara.setRows(5);
        txtaVara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtaVara.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtaVaraFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(txtaVara);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 590, 90));

        txtProcurarAutor.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        txtProcurarAutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtProcurarAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurarAutorKeyReleased(evt);
            }
        });
        getContentPane().add(txtProcurarAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 340, 30));

        lblAutor1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblAutor1.setText("Autor");
        getContentPane().add(lblAutor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, 30));

        cmbMudarNumeroProcesso.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        cmbMudarNumeroProcesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione para mudar o formato do número do processo", "#######-##.####.#.##.####", "####.###.######-#", "####.#####-#", "Sem formato", " ", " " }));
        cmbMudarNumeroProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMudarNumeroProcessoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMudarNumeroProcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 350, 30));

        ftdNumeroProcesso1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            ftdNumeroProcesso1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftdNumeroProcesso1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        getContentPane().add(ftdNumeroProcesso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 220, 30));

        ftdNumeroProcesso3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            ftdNumeroProcesso3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftdNumeroProcesso3.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        getContentPane().add(ftdNumeroProcesso3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 220, 30));

        ftdNumeroProcesso2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            ftdNumeroProcesso2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftdNumeroProcesso2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        getContentPane().add(ftdNumeroProcesso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 220, 30));

        txtNumeroProcesso4.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        txtNumeroProcesso4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNumeroProcesso4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroProcesso4FocusLost(evt);
            }
        });
        getContentPane().add(txtNumeroProcesso4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 220, 30));

        setBounds(0, 0, 811, 623);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        try {
            if (!validarCamposIncluir()) {
                return;
            }
            Processo p = incluirProcessoNaClasse();
            int status;
            if (btnIncluir.isEnabled()) {
                status = controleP.setManipular(p, 'S');
                switch (status) {
                    case 0:
                        exibirMsg("Problemas ao cadastrar o processo de " + txtAutor.getText()
                                + " no banco de dados", tituloMsg, false);
                        break;
                    case 1:
                        exibirMsg("O processo de " + txtAutor.getText()
                                + " foi cadastrado com sucesso", tituloMsg, true);
                        btnIncluir.setEnabled(false);
                        btnAlterar.setEnabled(true);
                        btnExcluir.setEnabled(true);
                        return;
                }
            } else {
                p.setId(Long.parseLong(lblCampoId.getText()));
                status = controleP.setManipular(p, 'U');
                switch (status) {
                    case 0:
                        exibirMsg("Problemas ao atualizar o processo de " + txtAutor.getText()
                                + " no banco de dados", tituloMsg, false);
                        break;
                    case 1:
                        exibirMsg("O processo de " + txtAutor.getText()
                                + " foi atualizado com sucesso", tituloMsg, true);
                        return;
                }
            }
            btnIncluir.setEnabled(false);
        } catch (RuntimeException e) {
            exibirMsg("Error: " + e.getMessage(), tituloMsg, false);
            Logger.getLogger(JIFrmProcesso.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        btnIncluirActionPerformed(evt);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (!msgEscolherOpcao("Deseja remover?", tituloMsg)) {
            return;
        }
        Processo p = new Processo();
        p.setId(Long.parseLong(lblCampoId.getText()));
        int status = controleP.setManipular(p, 'D');
        if (status == 1) {
            exibirMsg("O processo de " + txtAutor.getText()
                    + " foi removido com sucesso", tituloMsg, true);
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
            btnIncluir.setEnabled(true);
        } else {
            exibirMsg("Problemas ao remover o processo de " + txtAutor.getText()
                    + " do banco de dados", tituloMsg, false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetornarActionPerformed
        // TODO add your handling code here:
        if (msgEscolherOpcao("Deseja retornar?", tituloMsg)) {
            dispose();
        }
    }//GEN-LAST:event_btnRetornarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        limpar();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtProcurarAutorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurarAutorKeyReleased
        procurarProcesso(txtProcurarAutor.getText());
    }//GEN-LAST:event_txtProcurarAutorKeyReleased

    private void tblProcessosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProcessosMouseClicked
        incluirProcessoNaTabela();
    }//GEN-LAST:event_tblProcessosMouseClicked

    private void txtAutorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAutorFocusLost
        txtAutor.setText(txtAutor.getText().toUpperCase());
    }//GEN-LAST:event_txtAutorFocusLost

    private void txtaVaraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtaVaraFocusLost
        txtaVara.setText(txtaVara.getText().toUpperCase());
    }//GEN-LAST:event_txtaVaraFocusLost

    private void cmbMudarNumeroProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMudarNumeroProcessoActionPerformed
        int cmb = cmbMudarNumeroProcesso.getSelectedIndex();
        if (cmb < 0) {
            return;
        }
        mudarFormatoNumeroProcesso(cmb);
    }//GEN-LAST:event_cmbMudarNumeroProcessoActionPerformed

    private void txtNumeroProcesso4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroProcesso4FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroProcesso4FocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnRetornar;
    private javax.swing.JComboBox<String> cmbMudarNumeroProcesso;
    private javax.swing.JFormattedTextField ftdNumeroProcesso1;
    private javax.swing.JFormattedTextField ftdNumeroProcesso2;
    private javax.swing.JFormattedTextField ftdNumeroProcesso3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAutor1;
    private javax.swing.JLabel lblCampoId;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNumeroProcesso;
    private javax.swing.JLabel lblProcurarAutor;
    private javax.swing.JLabel lblVara;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JTable tblProcessos;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtNumeroProcesso4;
    private javax.swing.JTextField txtProcurarAutor;
    private javax.swing.JTextArea txtaVara;
    // End of variables declaration//GEN-END:variables
}
