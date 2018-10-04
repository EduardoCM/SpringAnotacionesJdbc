package org.certificatic.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.certificatic.bean.Alumno;
import org.certificatic.dao.AlumnoDAO;
import org.certificatic.dao.AlumnoDAOImpl;
import org.certificatic.service.AlumnoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/spring-config.xml" })
public class AlumnoDAOTest {
	
	private static final Logger logger = 
			Logger.getLogger(AlumnoDAOTest.class);

	@Autowired
	AlumnoService alumnoService;

	@Test
	public void testSave() {
		Alumno alumno = new Alumno();
		alumno.setNombre("EduardoService");
		alumno.setApellido("CastilloService");
		assertTrue(alumnoService.save(alumno)); 
	}

	@Test
	public void testFindAll() {
		List<Alumno> alumnos = alumnoService.findAll();
		assertTrue(alumnos.size() > 0);
	}

	@Test
	public void testFindById() {
		Alumno alumno = alumnoService.findById(1);
		logger.info(alumno);
		assertNotNull(alumno);
	}

	@Test
	public void testFindByNombre() {
		List<Alumno> alumnosNombre = alumnoService.findByNombre("Eduardo");
		assertNotNull(alumnosNombre);
	}

	@Test
	public void testUpdateAlumno() {
		Alumno alumnoNew = new Alumno();
		alumnoNew.setIdAlumno(1);
		alumnoNew.setNombre("NombreActualizadoDos");
		alumnoNew.setApellido("ApellidoActualizadoDos");		
		assertTrue(alumnoService.update(alumnoNew));
	}
	
	@Test
	public void testDeleteAlumno() {
		alumnoService.delete(4);	 
	}

}
