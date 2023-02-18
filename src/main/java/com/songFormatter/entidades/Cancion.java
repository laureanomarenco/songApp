package com.songFormatter.entidades;

/**
 * Modelo de Cancion
 */
public class Cancion {
    private Integer idCancion;
    private Integer idUsuario;
    private Integer idAutor;

    private String titulo;
    private String detalles;
    private int anio;
    private String letra;


    public Cancion() {
    }

    public Cancion(Integer idCancion, Integer idUsuario, Integer idAutor, String titulo, String detalles, int anio, String letra) {
        this.idCancion = idCancion;
        this.idUsuario = idUsuario;
        this.idAutor = idAutor;
        this.titulo = titulo;
        this.detalles = detalles;
        this.anio = anio;
        this.letra = letra;
    }

    public Cancion(Integer idUsuario, Integer idAutor, String titulo, String detalles, int anio, String letra) {
        this.idUsuario = idUsuario;
        this.idAutor = idAutor;
        this.titulo = titulo;
        this.detalles = detalles;
        this.anio = anio;
        this.letra = letra;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}
