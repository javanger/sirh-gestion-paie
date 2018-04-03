/**
 * 
 */
package dev.paie.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.dao.GradeMapper;
import dev.paie.entites.Grade;

/**
 * @author Kevin M.
 *
 */
@Service
public class GradeServiceJdbcTemplate implements GradeService {

	/** jdbcTemplate : JdbcTemplate */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Constructor
	 * 
	 */
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO grade (code, nb_heures_base, taux_base) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE grade SET code = ?, nb_heures_base = ?, taux_base = ? WHERE id = ?";
		jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());
	}

	@Override
	public List<Grade> lister() {
		String sql = "Select * from grade";
		return this.jdbcTemplate.query(sql, new GradeMapper());
	}

}
