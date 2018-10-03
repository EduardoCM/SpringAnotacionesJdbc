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
	public void save(Alumno almno) {
             alumnoDao.save(almno);		
	}

	@Override
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Alumno alumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int idAlumno) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
}
