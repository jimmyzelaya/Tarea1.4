package com.aplication.tarea4.tablas;

public class Empleados
{
    private Integer id;
    private String nombres;
    private String descripcion;
    private byte[] foto;


    public Empleados()
    {
        // Constructor Vacio
    }

    public Empleados(Integer id, String nombres, String descripcion, byte[] foto) {
        this.id = id;
        this.nombres = nombres;
        this.descripcion = descripcion;
        this.foto = foto;
    }

//Get
    public Integer getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

//Set
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setDescripcion(String apellidos) {
        this.descripcion = apellidos;
    }

//Get Set Foto
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getFoto() {
        return foto;
    }
}
