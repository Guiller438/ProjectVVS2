package com.tuempresa.projectvvs2.modelo;


import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Tab(properties = "id, nombre, fechaNacimiento, nacionalidad")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    @Required
    private String nombre;


    @Column(length = 100)
    private String fechaNacimiento;

    @Column(length = 100)
    private String nacionalidad;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    @ListProperties("nombre")
    private List<Personaje> personajes;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }
}
