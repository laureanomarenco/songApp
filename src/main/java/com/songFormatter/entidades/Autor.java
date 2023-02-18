package com.songFormatter.entidades;

public class Autor {
    private Integer idAutor;
    private String nombre;
    private String img;
    private String resumen;
    private String detalle;

    public Autor() {
    }

    public Autor(String nombre, String img, String resumen, String detalle) {
        this.nombre = nombre;
        this.img = img;
        this.resumen = resumen;
        this.detalle = detalle;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", img='" + img + '\'' +
                ", resumen='" + resumen + '\'' +
                ", detalle='" + detalle + '\'' +
                '}';
    }
}
