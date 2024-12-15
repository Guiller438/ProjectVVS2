package com.tuempresa.projectvvs2.tests;

import org.junit.*;
import org.openxava.tests.*;

public class SerieTest extends ModuleTestBase {

    public SerieTest(String NombrePrueba) {
        super("projectvvs2", "Personaje"); // Configuración del módulo y la entidad
    }

    @Before
    protected void setUp() throws Exception {
        super.setUp();
        login("admin", "admin");
    }

    // Prueba para actualizar un actor existente
    @Test
    public void testActualizarActor() throws Exception {
        System.out.println("Iniciando testActualizarActor...");

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
