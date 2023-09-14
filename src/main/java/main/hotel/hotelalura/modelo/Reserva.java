package main.hotel.hotelalura.modelo;

public class Reserva {
    private Integer id;
    private String fecha_entrada;
    private String fecha_salida;
    private Double valor;
    private String forma_pago;

    public Reserva(Integer id, String fecha_entrada, String fecha_salida, Double valor, String forma_pago) {
        this.id = id;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
        this.forma_pago = forma_pago;
    }

    public Reserva(String fecha_entrada, String fecha_salida, Double valor, String forma_pago) {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
        this.forma_pago = forma_pago;
    }

    public Reserva(Integer id, String fecha_entrada, String fecha_salida, Double valor) {
        this.id = id;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
    }

    public Reserva(String fecha_entrada, String fecha_salida, Double valor) {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
    }

    public Reserva() {
    }

    public Integer getId() {
        return id;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }
}

