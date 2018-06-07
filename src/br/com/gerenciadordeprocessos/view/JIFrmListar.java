package br.com.gerenciadordeprocessos.view;

import br.com.gerenciadordeprocessos.controller.ControleBasicoConsulta;
import br.com.gerenciadordeprocessos.controller.ControleConsulta;
import static br.com.gerenciadordeprocessos.util.ExibicaoDeMensagens.*;
import javax.swing.JTable;

public class JIFrmListar extends javax.swing.JInternalFrame {

    ControleBasicoConsulta controleC;

    public JIFrmListar() {
        this.controleC = new ControleConsulta();
        initComponents();

    }

    final String titulo = "Consultas";

    private void listar(int opcao) {
        txtProcurar.setText(txtProcurar.getText().toUpperCase());
        String autor = txtProcurar.getText();
        JTable tbl = controleC.listar(opcao, autor, tblProcessos);
        if (tbl == null) {
            exibirMsg("Inexistência de dados ", titulo, false);
            return;
        }
        tblProcessos.setModel(tbl.getModel());
    }

    private void retornar() {
        if (msgEscolherOpcao("Deseja Retornar?", titulo)) {
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgConsultas = new javax.swing.ButtonGroup();
        btnRetornar = new javax.swing.JButton();
        pnlListar = new javax.swing.JPanel();
        sclPane = new javax.swing.JScrollPane();
        tblProcessos = new javax.swing.JTable();
        cmbListarPor = new javax.swing.JComboBox<>();
        txtProcurar = new javax.swing.JTextField();
        lblListarPor = new javax.swing.JLabel();
        lblProcurar = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Listagem");
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

        btnRetornar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnRetornar.setText("Retornar");
        btnRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetornarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, -1, -1));

        pnlListar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Consultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 14))); // NOI18N

        tblProcessos.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        tblProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProcessos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProcessosMouseClicked(evt);
            }
        });
        sclPane.setViewportView(tblProcessos);

        javax.swing.GroupLayout pnlListarLayout = new javax.swing.GroupLayout(pnlListar);
        pnlListar.setLayout(pnlListarLayout);
        pnlListarLayout.setHorizontalGroup(
            pnlListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(pnlListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlListarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(sclPane, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlListarLayout.setVerticalGroup(
            pnlListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
            .addGroup(pnlListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlListarLayout.createSequentialGroup()
                    .addComponent(sclPane, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(pnlListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 420));

        cmbListarPor.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        cmbListarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma forma de listagem", "Quantidade de processos existentes", "Todos, ordenado por autores", "Autor", "Vara" }));
        cmbListarPor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbListarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListarPorActionPerformed(evt);
            }
        });
        getContentPane().add(cmbListarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 400, 30));

        txtProcurar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        txtProcurar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurarKeyReleased(evt);
            }
        });
        getContentPane().add(txtProcurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 400, 30));

        lblListarPor.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblListarPor.setText("Listar por");
        getContentPane().add(lblListarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, -1, 30));

        lblProcurar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblProcurar.setText("Procurar");
        getContentPane().add(lblProcurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, -1, 30));

        setBounds(0, 0, 980, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void txtProcurarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurarKeyReleased
        int listarPor = cmbListarPor.getSelectedIndex();
        int autor = 3;
        int vara = 4;
        if (listarPor == autor) {
            listar(autor);
            return;
        }
        listar(vara);
    }//GEN-LAST:event_txtProcurarKeyReleased

    private void btnRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetornarActionPerformed
        retornar();
    }//GEN-LAST:event_btnRetornarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        txtProcurar.setVisible(false);
        lblProcurar.setVisible(false);
        cmbListarPor.setSelectedIndex(0);
    }//GEN-LAST:event_formInternalFrameOpened

    private void cmbListarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListarPorActionPerformed
        if (cmbListarPor.getSelectedIndex() <= 0) {
            return;
        }
        int listarPor = cmbListarPor.getSelectedIndex();
        int autor = 3;
        int vara = 4;
        if (listarPor == autor || listarPor == vara) {
            txtProcurar.setVisible(true);
            lblProcurar.setText(cmbListarPor.getSelectedItem().toString());
            lblProcurar.setVisible(true);
        } else {
            txtProcurar.setVisible(false);
            lblProcurar.setVisible(false);
            int opcao = cmbListarPor.getSelectedIndex();
            listar(opcao);
        }
    }//GEN-LAST:event_cmbListarPorActionPerformed

    private void tblProcessosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProcessosMouseClicked
//abrir tela de processo com os dados da linha selecionada
    }//GEN-LAST:event_tblProcessosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgConsultas;
    private javax.swing.JButton btnRetornar;
    private javax.swing.JComboBox<String> cmbListarPor;
    private javax.swing.JLabel lblListarPor;
    private javax.swing.JLabel lblProcurar;
    private javax.swing.JPanel pnlListar;
    private javax.swing.JScrollPane sclPane;
    private javax.swing.JTable tblProcessos;
    private javax.swing.JTextField txtProcurar;
    // End of variables declaration//GEN-END:variables
}
