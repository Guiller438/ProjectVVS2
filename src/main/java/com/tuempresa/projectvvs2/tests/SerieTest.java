package com.tuempresa.projectvvs2.tests;
import org.junit.*;
import org.openxava.tests.*;

import com.tuempresa.projectvvs2.modelo.*;


public class SerieTest extends ModuleTestBase {
	
	private Actor actor;

    public SerieTest(String NombrePrueba) {
        super("projectvvs2", "Personaje"); // Configuración del módulo y la entidad
    }
    
    @Before
    protected void setUp() throws Exception { // setUp() se ejecuta siempre antes de cada prueba
        super.setUp(); // Es necesario porque ModuleTestBase lo usa para inicializarse, JPA se inicializa aquí
        login("admin", "admin"); // Crea los datos usados en las pruebas
    }

   @Test
   public void testcrearActor() throws Exception {
	    System.out.println("Iniciando testcrearActor...");

	    execute("CRUD.new");
	    setValue("id", "2");
	    setValue("Nombre", "Julian");
	    setValue("fechanacimiento", "21/01/2024");
	    setValue("Nacionalidad", "Ecuatoriana");
	    execute("CRUD.save");

	    System.out.println("Datos guardados, verificando...");

	    assertValue("Nombre", "Julian");
	    assertValue("fechanacimiento", "21/01/2024");
	    assertValue("Nacionalidad", "Ecuatoriana");

	    System.out.println("Test completado.");
    }

    
}
