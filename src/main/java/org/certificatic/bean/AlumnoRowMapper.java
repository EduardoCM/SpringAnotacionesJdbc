package org.certificatic.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AlumnoRowMapper implements RowMapper<Alumno> {

	@Override
	public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {
		Alumno alumno = new Alumno();
		alumno.setIdAlumno(rs.getInt("idAlumno"));
		alumno.setNombre(rs.getString("nombre"));
		alumno.setApellido(rs.getString("apellido"));
		return alumno;
	}

}
