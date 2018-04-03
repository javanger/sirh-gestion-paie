package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	// TODO Auto-generated method stub
	
	String sql = "INSERT INTO sirh_paie (id,code,nbHeuresBase,tauxBase) VALUES(?,?,?,?)";
	jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
	
	
}
@Override
public void mettreAJour(Grade grade) {
	// TODO Auto-generated method stub
	
}
@Override
public List<Grade> lister() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Grade findGradeById(int id) {
	// TODO Auto-generated method stub
	return null;
}

}
