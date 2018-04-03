/**
 * 
 */
package dev.paie.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.util.PaieUtils;

/**
 * @author GOBERT Guillaume
 *
 */
@Service
public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO grade (CODE,NB_HEURES_BASE,TAUX_BASE) VALUES(?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());	
	}

	@Override
	public void mettreAJour(Grade grade) {
		String sqlUpdate = "UPDATE grade SET NB_HEURES_BASE = ?, TAUX_BASE = ? WHERE CODE = ?";
		jdbcTemplate.update(sqlUpdate, grade.getNbHeuresBase(), grade.getTauxBase(),grade.getCode() );
	}

	@Override
	public List<Grade> lister() {
		List<Grade> lesGrades = new ArrayList<>();
		RowMapper<Grade> mapper = (ResultSet rs, int rowNum) -> {
			Grade g = new Grade();
			g.setId(rs.getInt("ID"));
			g.setCode(rs.getString("CODE"));
			g.setNbHeuresBase(rs.getBigDecimal("NB_HEURES_BASE"));
			g.setTauxBase(rs.getBigDecimal("TAUX_BASE"));
			return g;			
		};
		String sql = "SELECT * FROM grade";
		return lesGrades = jdbcTemplate.query(sql, mapper);
	}

	@Override
	public void supprimer(Grade supprimerGrade) {		
		String sqlDelete = "DELETE FROM grade WHERE CODE= ?";
		jdbcTemplate.update(sqlDelete, supprimerGrade.getCode() );
	}
}
