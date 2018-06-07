package br.com.gerenciadordeprocessos.dao;

import java.util.List;

public interface DaoBasico {

    public <T> boolean add(T obj);

    public <T> boolean update(T obj);

    public <T> boolean delete(T obj);
    
    public <T> T selectById(Long... id);

    public <R, T> R selectByName(T... type);

    public <T> List<T> selectAll();
}
