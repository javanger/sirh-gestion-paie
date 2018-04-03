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

/**
 * @author Alexis Darcy
 *
 */
@Service
public class GradeServiceJdbcTemplate implements GradeService {

	/**jdbcTemplate : JdbcTemplate*/
	private JdbcTemplate jdbcTemplate;

	/** Constructeur
	 * @param dataSource
	 */
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO GRADE (CODE, NB_HEURES_BASE, TAUX_BASE) VALUES (?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE GRADE SET NB_HEURES_BASE = ? , TAUX_BASE = ? WHERE CODE = ?";
		jdbcTemplate.update(sql, grade.getNbHeuresBase(), grade.getTauxBase(), grade.getCode());
	}
	
	@Override
	public void supprimer(Grade grade) {
		String sql = "DELETE FROM GRADE WHERE CODE = ?";
		jdbcTemplate.update(sql, grade.getCode());
	}

	@Override
	public List<Grade> lister() 
	{
		List<Grade> listGrade = new ArrayList<Grade>();
		
		String sql = "SELECT * FROM GRADE";
		
		RowMapper<Grade> mapper = (ResultSet rs, int rowNum) -> {   
			Grade g = new Grade();   
			g.setId(rs.getInt("ID"));   
			g.setCode(rs.getString("CODE"));   
			g.setNbHeuresBase(rs.getBigDecimal("NB_HEURES_BASE"));   
			g.setTauxBase(rs.getBigDecimal("TAUX_BASE"));   
			return g; 
		};
		
		listGrade = jdbcTemplate.query(sql, mapper);
		
		return listGrade;
	}
}