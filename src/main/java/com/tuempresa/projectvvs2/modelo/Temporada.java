package com.tuempresa.projectvvs2.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Tab(properties = "numeroTemporada, anioLanzamiento, serie.nombre")
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Required
    private int numeroTemporada;

    private int anioLanzamiento;

    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    @DescriptionsList(descriptionProperties = "nombre")
    private Serie serie;

    @OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL)
    @ListProperties("numeroEpisodio, titulo, fechaEmision")
    private List<Episodio> episodios;
    
    @Calculation("SUM(episodios.duracion)")
    @ReadOnly
    private int duracionTotal;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }
    
    public int getDuracionTotal() {
        return duracionTotal;
    }

}
