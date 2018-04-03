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

		String sql = "INSERT INTO grade (id,code,nbHeuresBase,tauxBase) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(),
				nouveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade) {

		String sqlUpdate = "UPDATE grade SET code = ?, nbHeuresBase = ?, tauxBase = ? WHERE id = ? ";
		jdbcTemplate.update(sqlUpdate, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());

	}

	@Override
	public List<Grade> lister() {
		// TODO Auto-generated method stub
		List<Grade> grades = new ArrayList<Grade>();
		RowMapper<Grade> mapper = (ResultSet rs, int rowNum) -> {
			Grade g = new Grade();
			g.setId(rs.getInt("id"));
			g.setCode(rs.getString("code"));
			g.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
			g.setTauxBase(rs.getBigDecimal("tauxBase"));
			return g;
		};
		String sql = "SELECT * FROM grade";

		grades = this.jdbcTemplate.query(sql, mapper);
		return grades;
	}

	@Override
	public Grade findGradeByCode(String code) {
		Grade grade = null;

		for (Grade g : this.lister()) {
			if (g.getCode().equals(code))
				grade = g;
		}

		return grade;

	}

	@Override
	public void deleteGrade(String code) {
		// TODO Auto-generated method stub
		String sqlUpdate = "DELETE FROM grade WHERE code = ?";
		jdbcTemplate.update(sqlUpdate, code);
		
		
		
	}
	
	
}
