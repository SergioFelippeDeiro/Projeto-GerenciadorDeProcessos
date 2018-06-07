package br.com.gerenciadordeprocessos.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Validacoes {

    static ResourceBundle msg = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));

    public static boolean validarNome(String numero, String tituloMsg) {
        try{
        Double.parseDouble(numero);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}
