package etec.sp.gov.br.atividadeavaliativafinal.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseMySQL implements Database{
    private Connection connection;
    @Override
    public Connection conectar(){
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/javabdr","root","");
            return this.connection;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
    }

    @Override
    public void desconectar() {
        try{
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE,null,ex);
        }


    }
}
