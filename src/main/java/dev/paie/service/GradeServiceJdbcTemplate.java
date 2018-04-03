package dev.paie.service;

import java.math.BigDecimal;
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
	private List<Grade> listeGrade = new ArrayList<Grade>();
	
	

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		
		String sql = "INSERT INTO grade (code, nbheurebase, tauxbase) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
		
		
		
		
		
	}

	@Override
	public void mettreAJour(Grade grade, String code) {
		String sql = "UPDATE grade SET (code=?, nbheurebase=?, tauxbase=?) WHERE code=?";
		jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), code);
		

	}

	@Override
	public List<Grade> lister() {
		
		RowMapper<Grade> mapper = (ResultSet rs, int rowNum) -> {
			Grade g = new Grade();
			
			g.setId(rs.getInt("id"));
			g.setCode(rs.getString("code"));
			g.setNbHeuresBase(new BigDecimal(rs.getString("nbheurebase")));
			g.setTauxBase(new BigDecimal(rs.getString("tauxbase")));
			return g;
			};
		String sql = "SELECT * FROM GRADE";
		listeGrade = jdbcTemplate.query(sql,mapper);

		return listeGrade;
	}

}
