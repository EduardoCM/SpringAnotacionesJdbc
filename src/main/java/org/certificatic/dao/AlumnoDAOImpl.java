package org.certificatic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.certificatic.bean.Alumno;
import org.certificatic.bean.AlumnoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlumnoDAOImpl implements AlumnoDAO {

	private static final Logger logger = 
			Logger.getLogger(AlumnoDAOImpl.class);
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource); 
	}

	@Override
	public boolean save(Alumno almno) {
		String sqlInsert = "insert into alumno (nombre, apellido) values (:nombre, :apellido)";
		BeanPropertySqlParameterSource paramMap = 
				new BeanPropertySqlParameterSource(almno);
		return jdbcTemplate.update(sqlInsert, paramMap) == 1;
	}

	@Override
	public List<Alumno> findAll() {
		String sqlFindAll = "select * from alumno";
		return jdbcTemplate.query(sqlFindAll, new RowMapper<Alumno>() {
			@Override
			public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {
				Alumno alumno = new Alumno();
				alumno.setIdAlumno(rs.getInt("idAlumno"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellido(rs.getString("apellido"));
				return alumno;
			}
		});
	}

	@Override
	public Alumno findById(int id) {
		String sqlFindById = "select * from alumno where idAlumno = :idAlumno";
		return jdbcTemplate.queryForObject(sqlFindById, new MapSqlParameterSource("idAlumno", id), new AlumnoRowMapper());
	}

	@Override
	public List<Alumno> findByNombre(String nombre) {
	   String sqlFindByNombre = "select * from alumno where nombre = :nombre";
		return jdbcTemplate.query(sqlFindByNombre, new MapSqlParameterSource("nombre", nombre), new AlumnoRowMapper());
	}

	@Override
	public boolean update(Alumno alumno) {
		String sqlUpdate = "update Alumno set nombre=:nombre, apellido=:apellido where idAlumno = :idAlumno";
		return jdbcTemplate.update(sqlUpdate, new BeanPropertySqlParameterSource(alumno)) == 1;
	}

	@Override
	public boolean delete(int idAlumno) {
		String sqlDelete = "delete from Alumno where idAlumno = :idAlumno";
		return jdbcTemplate.update(sqlDelete, new MapSqlParameterSource("idAlumno", idAlumno)) == 1;
	}

	
	
	
	
	

}
