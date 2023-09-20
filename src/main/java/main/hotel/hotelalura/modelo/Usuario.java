package main.hotel.hotelalura.modelo;

public class Usuario {
    private Integer id;
    private String nombre;
    private String nombre_usuario;
    private String apellido;
    private String email;
    private String password;

    public Usuario(String nombre, String apellido, String email, String nombre_usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
    }

    public Usuario(String nombre_usuario, String email, String password) {
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
