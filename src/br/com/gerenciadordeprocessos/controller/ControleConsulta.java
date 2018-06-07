package br.com.gerenciadordeprocessos.controller;

import br.com.gerenciadordeprocessos.dao.DaoConsulta;


public class ControleConsulta implements ControleBasicoConsulta{
    
    @Override
    public <T> T listar(int opcao, String name, T type) {
        DaoConsulta daoC = new DaoConsulta();
        return daoC.listar(opcao, name, type);
    }
}
