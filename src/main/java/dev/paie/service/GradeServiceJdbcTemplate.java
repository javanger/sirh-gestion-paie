package dev.paie.service;


import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeServiceInterface {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO Grade (CODE, nbHeureBase, tauxBase) VALUES(?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade, String code) {
		String sqlUpdate = "UPDATE Grade SET CODE = ? , nbHeureBase = ? , tauxBase = ? WHERE CODE = ?";
		jdbcTemplate.update(sqlUpdate, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), code);

	}

	@Override
	public List<Grade> lister() {
		
		RowMapper<Grade> mapper = (ResultSet rs, int rowNum) -> {
			Grade g = new Grade();
			g.setId(rs.getInt("ID"));
			g.setCode(rs.getString("CODE"));
			g.setNbHeuresBase(new BigDecimal(rs.getString("nbHeureBase")));
			g.setTauxBase(new BigDecimal(rs.getString("tauxBase")));
			
			return g;
		};
		
		String sql= "Select * FROM Grade";
		
		return this.jdbcTemplate.query(sql, mapper);
	}

	@Override
	public Grade findGradeByCode(String code) {
		Grade grade = null;
		
		for(Grade g : this.lister()){
			if(g.getCode().equals(code))
				grade=g;
		}
		
		return grade;
	}

}