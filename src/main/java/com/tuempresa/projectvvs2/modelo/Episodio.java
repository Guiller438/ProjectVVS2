package com.tuempresa.projectvvs2.modelo;


import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Tab(properties = "numeroEpisodio, titulo, sinopsis, duracion, fechaEmision, temporada.numeroTemporada")
public class Episodio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Required
    private int numeroEpisodio;

    @Column(length = 100)
    @Required
    private String titulo;

    @Column(length = 1000)
    @Stereotype("TEXT_AREA")
    private String sinopsis;

    @Required
    
    private int duracion; // Duración en minutos

    @Stereotype("DATETIME")
    @Required
    private Date fechaEmision;

    @ManyToOne
    @JoinColumn(name = "temporada_id", nullable = false)
    @DescriptionsList(descriptionProperties = "numeroTemporada, serie.nombre")
    private Temporada temporada;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }
}
