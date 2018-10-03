package org.certificatic.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.certificatic.bean.Alumno;
import org.certificatic.dao.AlumnoDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "spring-config.xml"})
@ContextConfiguration(locations = { "file:src/main/resources/spring-config.xml" })
public class AlumnoDAOTest {

	@Autowired
	AlumnoDAO alumnoDao;

	@Test
	public void testSave() {
		Alumno alumno = new Alumno();
		alumno.setNombre("EduardoJUnitDos");
		alumno.setApellido("CastilloJUnitDos");
		assertTrue(alumnoDao.save(alumno));
	}

	@Test
	public void testFindAll() {
		List<Alumno> alumnos = alumnoDao.findAll();
		assertTrue(alumnos.size() > 0);
	}

	@Test
	public void testFindById() {
		Alumno alumno = alumnoDao.findById(2);
		assertNotNull(alumno);
	}

	@Test
	public void testFindByNombre() {
		List<Alumno> alumnosNombre = alumnoDao.findByNombre("Eduardo");
		assertNotNull(alumnosNombre);
	}

	@Test
	public void testUpdateAlumno() {
		Alumno alumnoNew = new Alumno();
		alumnoNew.setIdAlumno(1);
		alumnoNew.setNombre("NombreActualizadoDos");
		alumnoNew.setApellido("ApellidoActualizadoDos");		
		assertTrue(alumnoDao.update(alumnoNew));
	}
	
	@Test
	public void testDeleteAlumno() {
	  alumnoDao.delete(8);	 
	}

}
