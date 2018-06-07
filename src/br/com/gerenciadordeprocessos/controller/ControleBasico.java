package br.com.gerenciadordeprocessos.controller;

import java.util.List;

public interface ControleBasico {

    public <T> int setManipular(T obj, char operacao);

    public <T> T selectById(Long... id);

    public <R, T> R selectByName(T... type);

    public <T> List<T> selectAll();
}
