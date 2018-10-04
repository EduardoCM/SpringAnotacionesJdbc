package org.certificatic.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.certificatic.bean.Alumno;
import org.certificatic.dao.AlumnoDAO;
import org.certificatic.dao.AlumnoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	private static final Logger logger = 
			Logger.getLogger(AlumnoServiceImpl.class);
	
	@Autowired
	AlumnoDAO alumnoDao;

	@Override
	public boolean save(Alumno almno) {
          return   alumnoDao.save(almno);	 	
	}

	@Override
	public List<Alumno> findAll() {
		return alumnoDao.findAll();
	}

	@Override
	public Alumno findById(int id) {
		return alumnoDao.findById(id);
	}

	@Override
	public List<Alumno> findByNombre(String nombre) {
		return alumnoDao.findByNombre(nombre);
	}

	@Override
	public boolean update(Alumno alumno) {
		return alumnoDao.update(alumno);
	}

	@Override
	public boolean delete(int idAlumno) {
		return alumnoDao.delete(idAlumno);
	}
	

	
}
