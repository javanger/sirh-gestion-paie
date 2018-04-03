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
 * @author Axel B.
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
		String sql = "INSERT INTO `grade`(`code`, `nbHeuresBase`, `tauxBase`) VALUES (?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE `grade` SET `code`=?,`nbHeuresBase`=?,`tauxBase`=? WHERE CODE = ?";
		jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getCode());

	}

	@Override
	public List<Grade> lister() {

		List<Grade> grades = new ArrayList<Grade>();
		String sql = "SELECT * FROM grade";
		RowMapper<Grade> mapper = (ResultSet rs, int rowNum) -> {
			Grade g = new Grade();
			g.setCode(rs.getString("code"));
			g.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
			g.setTauxBase(rs.getBigDecimal("nbHeuresBase"));
			return g;

		};

		grades = jdbcTemplate.query(sql, mapper);
		return grades;
	}

	@Override
	public void supprimer(Grade grade) {

		String sql = "DELETE FROM grade WHERE CODE = ?";
		jdbcTemplate.update(sql, grade.getCode());

	}

}