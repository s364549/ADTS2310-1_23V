package oslomet.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KundeRepository {

    @Autowired
    public JdbcTemplate db;

    public String lagreKunde(Kunde kunde) {
        String sql = "INSERT INTO Kunde (navn,adresse) VALUES(?,?)";
        try{
            db.update(sql,kunde.getNavn(),kunde.getAdresse());
            return "OK";
        }
        catch (Exception e){
            return "Feil";
        }
    }

    public List<Kunde> hentAlleKunder() {
        String sql = "SELECT * FROM Kunde";
        try{
            List<Kunde> alleKunder = db.query(sql,new BeanPropertyRowMapper(Kunde.class));
            return alleKunder;
        }
        catch (Exception e){
            return null;
        }
    }

    public Kunde hentEnKunde(int id) {
        String sql = "SELECT * FROM Kunde WHERE id=?";
        try{
            Kunde enKunde = db.queryForObject(sql,BeanPropertyRowMapper.newInstance(Kunde.class),id);
            return enKunde;
        }
        catch (Exception e){
            return null;
        }
    }

    public String endreEnKunde(Kunde kunde){
        String sql = "UPDATE Kunde SET navn=?,adresse=? where id=?";
        try{
            db.update(sql,kunde.getNavn(),kunde.getAdresse(),kunde.getId());
            return "OK";
        }
        catch (Exception e){
            return "Feil";
        }
    }

    public String slettEnKunde(int id) {
        String sql = "DELETE FROM Kunde WHERE id=?";
        try{
            db.update(sql,id);
            return "OK";
        }
        catch (Exception e){
            return "Feil;";
        }
    }

    public String slettAlleKunder () {
        String sql = "DELETE FROM Kunde";
        try{
            db.update(sql);
            return "OK";
        }
        catch (Exception e){
            return "Feil;";
        }
    }
}
