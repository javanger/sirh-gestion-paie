/**
 * 
 */
package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.paie.service.GradeService#sauvegarder(dev.paie.entite.Grade)
	 */
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.paie.service.GradeService#mettreAJour(dev.paie.entite.Grade)
	 */
	@Override
	public void mettreAJour(Grade grade) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dev.paie.service.GradeService#lister()
	 */
	@Override
	public List<Grade> lister() {
		// TODO Auto-generated method stub
		return null;
	}
}