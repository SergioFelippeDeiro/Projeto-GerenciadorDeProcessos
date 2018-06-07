package br.com.gerenciadordeprocessos.controller;

import br.com.gerenciadordeprocessos.dao.DaoBasico;
import java.util.List;

public class ControleGenerico<T> implements ControleBasico {

    private DaoBasico dao;

    public ControleGenerico(DaoBasico dao) {
        this.dao = dao;
    }

    public ControleGenerico() {
    }

    @Override
    public <T> int setManipular(T obj, char operacao) {
        int status = 2;
        if (dao instanceof DaoBasico) {
            switch (operacao) {
                case 'U':
                    status = (dao.update(obj) ? 1 : 0);
                    break;
                case 'D':
                    status = (dao.delete(obj) ? 1 : 0);
                    break;
                case 'S':
                    status = (dao.add(obj) ? 1 : 0);
            }
        }
        return status;
    }

    @Override
    public <T> T selectById(Long... id) {
        T obj = null;
        if (dao instanceof DaoBasico) {
            obj = dao.selectById(id);
        }
        return obj;
    }

    @Override
    public <R, T> R selectByName(T... type) {
        R retorno = null;
        if (dao instanceof DaoBasico) {
            retorno = dao.selectByName(type);
        }
        return retorno;
    }

    @Override
    public <T> List<T> selectAll() {
        List<T> lista;
        lista = null;
        if (dao instanceof DaoBasico) {
            lista = dao.selectAll();
        }
        return lista;
    }
}
