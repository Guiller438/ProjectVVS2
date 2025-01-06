package com.tuempresa.projectvvs2.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.junit.Test;
import org.junit.jupiter.api.*;

class ActorTest {
	
    @Before
    protected void setUp() throws Exception {
        super.setUp();
        login("admin", "admin");
    }

	
	 @Test
	    public void testActualizarActor() throws Exception {
	        System.out.println("Iniciando testActualizarActor...");
	        
	        login("admin", "admin");
	        execute("CRUD.new");
	        setValue("id", "3");
	        setValue("Nombre", "Ana");
	        setValue("fechanacimiento", "15/05/1990");
	        setValue("Nacionalidad", "Argentina");
	        execute("CRUD.save");

	        System.out.println("Datos guardados, actualizando...");

	        execute("CRUD.refresh");
	        setValue("Nombre", "Ana Maria");
	        execute("CRUD.save");

	        System.out.println("Datos actualizados, verificando...");

	        assertValue("Nombre", "Ana Maria");

	        System.out.println("Test completado.");
	    }

	    // Prueba para eliminar un actor existente
	    @Test
	    public void testEliminarActor() throws Exception {
	        System.out.println("Iniciando testEliminarActor...");
	        
	        login("admin", "admin");
	        execute("CRUD.new");
	        setValue("id", "4");
	        setValue("Nombre", "Carlos");
	        setValue("fechanacimiento", "10/10/1985");
	        setValue("Nacionalidad", "Colombiana");
	        execute("CRUD.save");

	        System.out.println("Datos guardados, eliminando...");

	        execute("CRUD.delete");

	        System.out.println("Datos eliminados, verificando...");

	        execute("CRUD.refresh");
	        assertMessage("No existe el registro");

	        System.out.println("Test completado.");
	    }

	    // Prueba para buscar un actor por nombre
	    @Test
	    public void testBuscarActor() throws Exception {
	        System.out.println("Iniciando testBuscarActor...");
	        
	        login("admin", "admin");
	        execute("CRUD.new");
	        setValue("id", "5");
	        setValue("Nombre", "Luis");
	        setValue("fechanacimiento", "02/02/1992");
	        setValue("Nacionalidad", "Peruana");
	        execute("CRUD.save");

	        System.out.println("Datos guardados, buscando...");

	        execute("List.search");
	        setValue("Nombre", "Luis");
	        execute("List.search");

	        assertValueInList(0, 1, "Luis");

	        System.out.println("Test completado.");
	    }

	    // Prueba para validar un campo obligatorio
	    @Test
	    public void testValidarCampoObligatorio() throws Exception {
	        System.out.println("Iniciando testValidarCampoObligatorio...");
	        
	        login("admin", "admin");
	        execute("CRUD.new");
	        setValue("id", "6");
	        setValue("Nombre", ""); // Dejamos el nombre vacío para probar validación
	        setValue("fechanacimiento", "12/12/2000");
	        setValue("Nacionalidad", "Chilena");
	        execute("CRUD.save");

	        System.out.println("Verificando mensaje de error por campo obligatorio...");

	        assertError("El campo Nombre es obligatorio");

	        System.out.println("Test completado.");
	    }
}
