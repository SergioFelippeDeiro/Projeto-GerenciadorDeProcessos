package br.com.gerenciadordeprocessos.dao;

import br.com.gerenciadordeprocessos.model.Processo;
import static br.com.gerenciadordeprocessos.util.ExibicaoDeMensagens.exibirMsg;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class DaoProcesso implements DaoBasico {

    @Override
    public <T> boolean add(T obj) {
        boolean result = true;
        Processo p;
        String sql = "Insert into Processo"
                + "(NumeroProcesso, Autor, Vara) values(?, ?, ?)";

        try (PreparedStatement pS = DaoConexao.getConexao().prepareStatement(sql)) {
            p = (Processo) obj;
            pS.setString(1, p.getNumeroProcesso());
            pS.setString(2, p.getAutor());
            pS.setString(3, p.getVara());
            pS.executeUpdate();
        } catch (SQLException e) {
            exibirMsg("Error: " + e.getMessage(), "Erro no DAO", false);
            Logger.getLogger(DaoProcesso.class.getName()).log(Level.SEVERE, null, e);
            result = false;
        }
        return result;
    }

    @Override
    public <T> boolean update(T obj) {
        boolean result = true;
        Processo p;
        String sql = "Update Processo set NumeroProcesso = ?, Autor = ?,"
                + "Vara = ? where Id = ?";

        try (PreparedStatement pS = DaoConexao.getConexao().prepareStatement(sql)) {
            p = (Processo) obj;
            pS.setString(1, p.getNumeroProcesso());
            pS.setString(2, p.getAutor());
            pS.setString(3, p.getVara());
            pS.setLong(4, p.getId());
            pS.executeUpdate();
        } catch (SQLException e) {
            exibirMsg("Error: " + e.getMessage(), "Erro no DAO", false);
            Logger.getLogger(DaoProcesso.class.getName()).log(Level.SEVERE, null, e);
            result = false;
        }
        return result;
    }

    @Override
    public <T> boolean delete(T obj) {
        boolean result = true;
        Processo p;
        String sql = "Delete from Processo where Id = ?";

        try (PreparedStatement pS = DaoConexao.getConexao().prepareStatement(sql)) {
            p = (Processo) obj;
            pS.setLong(1, p.getId());
            pS.executeUpdate();
        } catch (SQLException e) {
            exibirMsg("Error: " + e.getMessage(), "Erro no DAO", false);
            Logger.getLogger(DaoProcesso.class.getName()).log(Level.SEVERE, null, e);
            result = false;
        }
        return result;
    }

    @Override
    public <T> T selectById(Long... id) {
        String sql = "Select * from Processo where Id = ?";
        Processo p = null;

        try (PreparedStatement pS = DaoConexao.getConexao().prepareStatement(sql)) {
            pS.setLong(1, id[0]);
            try (ResultSet rS = pS.executeQuery()) {
                if (rS.next()) {
                    p = new Processo();
                    p.setId(rS.getLong("Id"));
                    p.setNumeroProcesso(rS.getString("NumeroProcesso"));
                    p.setAutor(rS.getString("Autor"));
                    p.setVara(rS.getString("Vara"));
                }
            }
        } catch (SQLException e) {
            exibirMsg("Error: " + e.getMessage(), "Erro no DAO", false);
            Logger.getLogger(DaoProcesso.class.getName()).log(Level.SEVERE, null, e);
        }
        return (T) p;
    }

    @Override
    public <R, T> R selectByName(T... type) {
        String sql = "Select Id as 'ID', Autor as 'AUTOR', NumeroProcesso as 'NÚMERO DO PROCESSO', Vara as VARA "
                + " from Processo where Autor like ?";
        JTable tblProcesso = null;
        
        try (PreparedStatement pS = DaoConexao.getConexao().prepareStatement(sql)) {
            String txtAutor = (String) type[0];
            String txt = "%" + txtAutor + "%";
            pS.setString(1,  txt);
            try (ResultSet rS = pS.executeQuery()) {
                tblProcesso = (JTable) type[1];
                tblProcesso.setModel(DbUtils.resultSetToTableModel(rS));
            }
        } catch (SQLException e) {
            exibirMsg("Error: " + e.getMessage(), "Erro no DAO", false);
            Logger.getLogger(DaoProcesso.class.getName()).log(Level.SEVERE, null, e);
        }
        return (R) tblProcesso;
    }
    
    @Override
    public <T> List<T> selectAll() {
        String sql = "Select * from Processo";
        List<Object> lista = null;
        Processo obj;

        try (PreparedStatement pS = DaoConexao.getConexao().prepareStatement(sql);
                ResultSet rS = pS.executeQuery(sql)) {
            if (rS != null) {
                lista = new ArrayList<>();
                while (rS.next()) {
                    obj = selectById(rS.getLong("Id"));
                    lista.add(obj);
                }
            }
        } catch (SQLException e) {
            exibirMsg("Error: " + e.getMessage(), "Erro no DAO", false);
            Logger.getLogger(DaoProcesso.class.getName()).log(Level.SEVERE, null, e);
        }
        return (List<T>) lista;
    }
}
