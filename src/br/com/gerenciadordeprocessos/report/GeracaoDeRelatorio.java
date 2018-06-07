package br.com.gerenciadordeprocessos.report;

import br.com.gerenciadordeprocessos.dao.DaoConexao;
import static br.com.gerenciadordeprocessos.util.ExibicaoDeMensagens.exibirMsg;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.view.save.JRPdfSaveContributor;

public class GeracaoDeRelatorio {

    public static void gerarRelatorioJaspersoftStudio(String classePraFazerRelatorio, String chavePrimaria) {
        String caminho = null;
        //procurar o diretorio usando file
        try (Connection conexao = DaoConexao.getConexao()) {
            caminho = "reports\\" + classePraFazerRelatorio + ".jasper";
            JasperPrint print;
            if (chavePrimaria == null) {
                print = JasperFillManager.fillReport(caminho, null, conexao);
            } else {
                Map<String, Object> map = new HashMap();
                map.put("chavePrimaria", Integer.parseInt(chavePrimaria));
                print = JasperFillManager.fillReport(caminho, map, conexao);
            }
            JasperViewer.viewReport(print, true);
        } catch (SQLException | JRException e) {
            exibirMsg(e.getMessage(), "Erro ao gerar o relatório", true);
            exibirMsg(caminho, "", true);
            Logger.getLogger(GeracaoDeRelatorio.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static void pdf(){
//        JRPdfSaveContributor pdf = new JRPdfSaveContributor(Locale.ITALY, resBundle);
/*Exception in thread "AWT-EventQueue-0" java.lang.NoClassDefFoundError: com/lowagie/text/DocumentException
	at net.sf.jasperreports.view.save.JRPdfSaveContributor.save(JRPdfSaveContributor.java:116)
	at net.sf.jasperreports.swing.JRViewerToolbar.btnSaveActionPerformed(JRViewerToolbar.java:406)*/
/**/
    }
}
