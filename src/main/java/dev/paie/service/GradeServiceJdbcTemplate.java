package dev.paie.service;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

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
		String sql = "insert into grade (Id, code, nbHeuresBase, tauxBase) values(?,?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
	}

	@Override
	public void mettreAJour(Grade grade) {
		String sqlUpdate = "update grade set code = ? where Id = ? ";
		jdbcTemplate.update(sqlUpdate,grade.getCode(), grade.getId());
		
	}

	@Override
	public List<Grade> lister() {
		RowMapper<Grade> mapper = (ResultSet rs, int rowNum) ->{
		Grade grade= new Grade();
		grade.setId(rs.getInt("Id"));
		grade.setCode(rs.getString("code"));
		grade.setNbHeuresBase(rs.getBigDecimal("nbheuresbase"));
		grade.setTauxBase(rs.getBigDecimal("tauxBase"));
		return grade;
		};
		return null;
	}

}
