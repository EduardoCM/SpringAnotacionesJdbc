package org.certificatic.dao;

import java.util.List;

import org.certificatic.bean.Alumno;

public interface AlumnoDAO {
	
	public boolean save(Alumno almno);
	public List<Alumno> findAll();
	public Alumno findById(int id);
	public List<Alumno> findByNombre(String nombre);
	public boolean update(Alumno alumno);
	public boolean delete(int idAlumno);
	
	
	

}
