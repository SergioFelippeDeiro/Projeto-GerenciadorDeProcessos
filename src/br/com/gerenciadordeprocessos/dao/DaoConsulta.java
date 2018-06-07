package br.com.gerenciadordeprocessos.dao;

import static br.com.gerenciadordeprocessos.util.ExibicaoDeMensagens.exibirMsg;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class DaoConsulta {
    public <T> T listar(int opcao, String name, T type) {
        String sql = "";
        JTable tbl = null;
        switch (opcao) {
            case 1:
                sql = "select count(*) as 'QUANTIDADE DE PROCESSOS' from Processo";
                break;
            case 2:
                sql = "select Autor as 'AUTOR', Vara as 'VARA', NumeroProcesso as 'NÚMERO DO PROCESSO' from Processo order by Autor";
                break;
            case 3:
                sql = "Select Autor as 'AUTOR', NumeroProcesso as 'NÚMERO DO PROCESSO', Vara as 'VARA' "
                + "from Processo where Autor like ?";
                break;
            case 4: sql = "Select Vara as 'VARA', Autor as 'AUTOR', NumeroProcesso as 'NÚMERO DO PROCESSO' "
                    + "from Processo where Vara like ?";
        }
        try (PreparedStatement pS = DaoConexao.getConexao().prepareStatement(sql)) {
            if (opcao == 3 || opcao == 4) {
                pS.setString(1, "%" + name + "%");
            }
            try (ResultSet rS = pS.executeQuery()) {
                tbl = (JTable) type;
                tbl.setModel(DbUtils.resultSetToTableModel(rS));
            }
        } catch (SQLException e) {
            exibirMsg("problemas ao exibir os dados " + e.getMessage(), "Erro no DAO", true);
            Logger.getLogger(DaoConsulta.class.getName()).log(Level.SEVERE, null, e);
        }
        return (T) tbl;
    }
}