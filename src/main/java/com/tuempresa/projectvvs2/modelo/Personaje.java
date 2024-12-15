package com.tuempresa.projectvvs2.modelo;


import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Tab(properties = "nombre, actor.nombre, series.nombre")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    @Required
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    @DescriptionsList(descriptionProperties = "nombre, nacionalidad")
    private Actor actor;

    @ManyToMany(mappedBy = "personajes")
    @ListProperties("nombre, genero")
    private List<Serie> series;

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

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }
}
