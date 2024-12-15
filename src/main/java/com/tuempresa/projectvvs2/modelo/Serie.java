package com.tuempresa.projectvvs2.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Tab(properties = "nombre, genero, anioEstreno, estadoEmision, calificacionPromedio")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    @Required
    private String nombre;

    @Column(length = 1000)
    @Stereotype("TEXT_AREA")
    private String sinopsis;

    @Column(length = 50)
    @Required
    private String genero;

    private int anioEstreno;

    @Column(length = 50)
    private String estadoEmision;

    @Stereotype("MONEY")
    private float calificacionPromedio;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    @ListProperties("numeroTemporada, anioLanzamiento")
    private List<Temporada> temporadas;

    @ManyToMany
    @JoinTable(
        name = "serie_personaje",
        joinColumns = @JoinColumn(name = "serie_id"),
        inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    @ListProperties("nombre")
    private List<Personaje> personajes;

    @ManyToMany
    @JoinTable(
        name = "serie_plataforma",
        joinColumns = @JoinColumn(name = "serie_id"),
        inverseJoinColumns = @JoinColumn(name = "plataforma_id")
    )
    @ListProperties("nombre, url")
    private List<Plataforma> plataformas;

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

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public String getEstadoEmision() {
        return estadoEmision;
    }

    public void setEstadoEmision(String estadoEmision) {
        this.estadoEmision = estadoEmision;
    }

    public float getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(float calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
}
