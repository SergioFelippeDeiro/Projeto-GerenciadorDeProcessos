package br.com.gerenciadordeprocessos.util;

import javax.swing.JOptionPane;

public class ExibicaoDeMensagens {
    public static boolean msgEscolherOpcao(String msg, String tituloMsg) {
        return (JOptionPane.showConfirmDialog(null, msg, tituloMsg, JOptionPane.YES_NO_OPTION) == 0);
    }

    public static void exibirMsg(String msg, String tituloMsg, boolean icone) {
        if (icone) {
            JOptionPane.showMessageDialog(null, msg, tituloMsg, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, msg, tituloMsg, JOptionPane.ERROR_MESSAGE);
        }
    }
}
