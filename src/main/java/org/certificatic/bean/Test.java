package org.certificatic.bean;

import org.apache.log4j.Logger;
import org.certificatic.service.AlumnoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	private static final Logger logger = 
			Logger.getLogger(Test.class);
	
	
	public static void main(String[] args) {
		
	ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("spring-config.xml");
		
		AlumnoService alumnoService = (AlumnoService) appContext.getBean("alumnoServiceImpl");

		Alumno alumno = new Alumno();
		alumno.setNombre("EduardoDos");
		alumno.setApellido("CastilloDos");
		
		alumnoService.save(alumno);
		
		
		((ClassPathXmlApplicationContext)appContext).close();
	}

}










