package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.util.GradeMapper;

/**
 * @author Emmanuel
 *
 */
@Service
public class GradeServiceJdbcTemplate implements IGradeService {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* (non-Javadoc)
	 * @see dev.paie.service.GradeService#sauvegarder(dev.paie.entite.Grade)
	 */
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO grade(code, nbHeuresBase, tauxBase) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());		
	}

	/* (non-Javadoc)
	 * @see dev.paie.service.GradeService#mettreAJour(dev.paie.entite.Grade)
	 */
	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE grade SET code = ? WHERE id = ?";
		jdbcTemplate.update(sql, grade.getCode(), grade.getId());	
	}

	/* (non-Javadoc)
	 * @see dev.paie.service.GradeService#lister()
	 */
	@Override
	public List<Grade> lister() {			
		String sql = "SELECT * FROM grade";	
		return jdbcTemplate.query(sql, new GradeMapper());
	}

	/* (non-Javadoc)
	 * @see dev.paie.service.GradeService#supprimer(dev.paie.entite.Grade)
	 */
	@Override
	public void supprimer(Grade grade) {
		String sql = "DELETE FROM grade WHERE code = ?";
		jdbcTemplate.update(sql, grade.getCode());		
	}

}
