/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciadordeprocessos.controller;

/**
 *
 * @author CachaçaCarai
 */
public interface ControleBasicoConsulta {
    
    public <T> T listar(int id, String name, T type);
}
