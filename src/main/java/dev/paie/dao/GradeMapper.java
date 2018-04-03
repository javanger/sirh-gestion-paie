/**
 * 
 */
package dev.paie.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entites.Grade;

/**
 * @author Kevin M.
 *
 */
public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet res, int rowNum) throws SQLException {
		Grade grade = new Grade();
		grade.setCode(res.getString("code"));
		grade.setId(res.getInt("id"));
		grade.setNbHeuresBase(res.getBigDecimal("nb_heures_base"));
		grade.setTauxBase(res.getBigDecimal("taux_base"));
		return grade;
	}

}
