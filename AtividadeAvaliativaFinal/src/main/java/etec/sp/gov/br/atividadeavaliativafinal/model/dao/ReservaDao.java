package etec.sp.gov.br.atividadeavaliativafinal.model.dao;

import etec.sp.gov.br.atividadeavaliativafinal.model.Reserva;
import etec.sp.gov.br.atividadeavaliativafinal.model.database.DatabaseMySQL;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaDao {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public Boolean inserir (Reserva reserva){
        String sql = "INSERT INTO reserva( numeroSala, curso, disciplina, professor, data, horarioEntrada, horarioSaida, informatica, turno) VALUES (?,?,?,?,?,?,?,?,?);";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, reserva.getNumeroSala());
            stmt.setString(2, reserva.getCurso());
            stmt.setString(3, reserva.getDisciplina());
            stmt.setString(4,reserva.getProfessor());
            stmt.setString(5, reserva.getData());
            stmt.setString(6, reserva.getHoraEntrada());
            stmt.setString(7, reserva.getHoraSaida());
            stmt.setBoolean(8, reserva.getInformatica());
            stmt.setString(9, reserva.getTurno());
            stmt.execute();

            return true;

        }catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    public Reserva getReservaById(int id){
        String sql = "SELECT * FROM reserva WHERE id = ?";
        Reserva retorno = new Reserva();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()){
                retorno.setId(resultado.getInt("id"));
                retorno.setNumeroSala(resultado.getString("numeroSala"));
                retorno.setCurso(resultado.getString("curso"));
                retorno.setDisciplina(resultado.getString("disciplina"));
                retorno.setProfessor(resultado.getString("professor"));
                retorno.setData(resultado.getString("data"));
                retorno.setHoraEntrada(resultado.getString("horaEntrada"));
                retorno.setHoraSaida(resultado.getString("horaSaida"));
                retorno.setInformatica(resultado.getBoolean("informatica"));
                retorno.setTurno(resultado.getString("turno"));

            }

        }catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return retorno;
    }

    public Boolean delete (int id){
        String sql = "DELETE FROM reserva WHERE id = ? ";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.executeUpdate();
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
