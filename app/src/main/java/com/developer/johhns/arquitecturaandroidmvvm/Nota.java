package com.developer.johhns.arquitecturaandroidmvvm;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notas")
public class Nota {

    @PrimaryKey( autoGenerate = true )
    private int    id ;

    private String titulo ;
    private String descripcion ;
    private int    prioridad ;

    public Nota(String titulo, String descripcion, int prioridad) {
        this.titulo      = titulo;
        this.descripcion = descripcion;
        this.prioridad   = prioridad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
