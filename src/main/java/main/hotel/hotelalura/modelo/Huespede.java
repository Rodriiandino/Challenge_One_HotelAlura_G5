package main.hotel.hotelalura.modelo;


import main.hotel.hotelalura.utils.EntidadHotel;

public class Huespede implements EntidadHotel {
    private Integer id;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private String nacionalidad;
    private String telefono;
    private Integer id_reserva;

    public Huespede(String name, String lastName, String birthDay, String nationality, String number, Integer id_booking) {
        this.nombre = name;
        this.apellido = lastName;
        this.fecha_nacimiento = birthDay;
        this.nacionalidad = nationality;
        this.telefono = number;
        this.id_reserva = id_booking;
    }

    public Huespede(Integer id, String name, String lastName, String birthDay, String nationality, String number, Integer id_booking) {
        this.id = id;
        this.nombre = name;
        this.apellido = lastName;
        this.fecha_nacimiento = birthDay;
        this.nacionalidad = nationality;
        this.telefono = number;
        this.id_reserva = id_booking;
    }

    public Huespede(Integer id, String name, String lastName, String birthDay, String nationality, String number) {
        this.id = id;
        this.nombre = name;
        this.apellido = lastName;
        this.fecha_nacimiento = birthDay;
        this.nacionalidad = nationality;
        this.telefono = number;
    }

    @Override
    public String toString() {
        return "Huespede{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", id_reserva=" + id_reserva +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

}

