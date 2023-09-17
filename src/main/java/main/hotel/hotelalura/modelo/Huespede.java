package main.hotel.hotelalura.modelo;

public class Huespede {
    private Integer id;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private String nacionalidad;
    private String telefono;
    private Integer id_reserva;

    public Huespede(Integer id, String nombre, String apellido, String fecha_nacimiento, String nacionalidad, String telefono, Integer id_reserva) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.id_reserva = id_reserva;
    }

    public Huespede(String nombre, String apellido, String fecha_nacimiento, String nacionalidad, String telefono, Integer id_reserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.id_reserva = id_reserva;
    }

    public Huespede(Integer id, String nombre, String apellido, String fecha_nacimiento, String nacionalidad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
    }

    public Huespede(String nombre, String apellido, String fecha_nacimiento, String nacionalidad, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
    }

    public Huespede() {
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

    public void setFecha_nacimiento(String fecha_nacimiento){
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setNacionalidad(String nacionalidad){
        this.nacionalidad = nacionalidad;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setId_reserva(Integer id_reserva){
        this.id_reserva = id_reserva;
    }
}

