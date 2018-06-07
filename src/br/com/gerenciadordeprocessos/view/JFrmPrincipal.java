package br.com.gerenciadordeprocessos.view;

import br.com.gerenciadordeprocessos.report.GeracaoDeRelatorio;
import static br.com.gerenciadordeprocessos.util.ExibicaoDeMensagens.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JFrmPrincipal extends javax.swing.JFrame {

    public JFrmPrincipal() {
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JFrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    final String titulo = "Tela Principal";

    private void relogio() {
        try {
            Thread.sleep(1000);
            while (true) {
                LocalDateTime localDT = LocalDateTime.now();
                String formato = "EEEE, dd 'de' MMMM 'de' yyyy                        HH:mm:ss";
                String dateTime = localDT.format(DateTimeFormatter.ofPattern(formato, new Locale("pt", "BR")));

                lblDataHora.setText("                               " + dateTime);
            }
        } catch (InterruptedException e) {
            exibirMsg("Problema ao acionar a hora " + e.getMessage(), titulo, false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblDataAutor = new javax.swing.JToolBar();
        lblAutor = new javax.swing.JLabel();
        strDataAutor = new javax.swing.JToolBar.Separator();
        lblDataHora = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane();
        btnProcesso = new javax.swing.JButton();
        btnListarProcessos = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnImprimirRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Processos");
        setResizable(false);

        tblDataAutor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDataAutor.setRollover(true);
        tblDataAutor.setFont(new java.awt.Font("DejaVu Sans", 3, 12)); // NOI18N

        lblAutor.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        tblDataAutor.add(lblAutor);
        tblDataAutor.add(strDataAutor);

        lblDataHora.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        tblDataAutor.add(lblDataHora);

        desktopPane.setBackground(new java.awt.Color(240, 240, 240));
        desktopPane.setOpaque(false);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        btnProcesso.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        btnProcesso.setText("Processo");
        btnProcesso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessoActionPerformed(evt);
            }
        });

        btnListarProcessos.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        btnListarProcessos.setText("Listar processos");
        btnListarProcessos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnListarProcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProcessosActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        btnSair.setText("Sair do programa");
        btnSair.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnImprimirRelatorio.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        btnImprimirRelatorio.setText("Imprimir relatório de processos");
        btnImprimirRelatorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnImprimirRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblDataAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImprimirRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListarProcessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(desktopPane))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListarProcessos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimirRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(tblDataAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1316, 709));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessoActionPerformed
        JIFrmProcesso frame = new JIFrmProcesso();
        desktopPane.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_btnProcessoActionPerformed

    private void btnListarProcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProcessosActionPerformed
        JIFrmListar frame = new JIFrmListar();
        desktopPane.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_btnListarProcessosActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        if (msgEscolherOpcao("Deseja realmente finalizar", titulo)) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnImprimirRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirRelatorioActionPerformed
        Thread t1 = new Thread(() -> {
            GeracaoDeRelatorio.gerarRelatorioJaspersoftStudio("processos", null);
        }, "ThreadPraGerarRelatorio");
        t1.start();
    }//GEN-LAST:event_btnImprimirRelatorioActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        JFrmPrincipal p = new JFrmPrincipal();
        p.setVisible(true);
        
        Thread t1 = new Thread(() -> {
            p.relogio();
        });
        t1.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimirRelatorio;
    private javax.swing.JButton btnListarProcessos;
    private javax.swing.JButton btnProcesso;
    private javax.swing.JButton btnSair;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JToolBar.Separator strDataAutor;
    private javax.swing.JToolBar tblDataAutor;
    // End of variables declaration//GEN-END:variables

}
