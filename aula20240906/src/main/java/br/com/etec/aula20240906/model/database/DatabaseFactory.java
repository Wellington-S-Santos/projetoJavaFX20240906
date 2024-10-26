package br.com.etec.aula20240906.model.database;

import br.com.etec.aula20240906.model.Cliente;

public class DatabaseFactory {
    //classe do tipo static não precisa instanciar.
    //classe do tipo final outra classe não pode herdar dela, ou seja, não pode terv classes filhas.
    public static Database getDatabase(String nome) {
        if (nome.equals("postgreesql")){
            return new DatabasePostgreeSQL();
        }else {
            return new DatabaseMySQL();

        }
    }

}
