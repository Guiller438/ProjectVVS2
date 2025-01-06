package com.tuempresa.projectvvs2.tests;

import org.junit.*;
import org.openxava.tests.*;

public class SerieTest extends ModuleTestBase {

    public SerieTest() {
        super("projectvvs2", "Actor");
    }



    // Prueba para actualizar un actor existente
    @Test
    public void testCrearActor() throws Exception {
        System.out.println("Iniciando testActualizarActor...");
        
        login("admin", "admin");
        execute("CRUD.new");
        setValue("id", "");
        setValue("nombre", "Nicolas Cage");
        setValue("fechaNacimiento", "12/02/1978");
        setValue("nacionalidad", "Mexicano");
        execute("CRUD.save");

        System.out.println("Datos actualizados, verificando...");
        //execute("Mode.list");
        
        assertValue("nombre","");
       
        

        System.out.println("Test completado.");
    }

    
}
