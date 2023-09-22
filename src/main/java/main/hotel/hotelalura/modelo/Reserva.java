package main.hotel.hotelalura.modelo;

import main.hotel.hotelalura.utils.EntidadHotel;

public class Reserva implements EntidadHotel {
    private Integer id;
    private String fecha_entrada;
    private String fecha_salida;
    private Double valor;
    private String forma_pago;


    public Reserva(String fecha_entrada, String fecha_salida, Double valor, String forma_pago) {
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
        this.forma_pago = forma_pago;
    }

    public Reserva(Integer id, String fecha_entrada, String fecha_salida, Double valor, String forma_pago) {
        this.id = id;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.valor = valor;
        this.forma_pago = forma_pago;
    }


    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", fecha_entrada='" + fecha_entrada + '\'' +
                ", fecha_salida='" + fecha_salida + '\'' +
                ", valor=" + valor +
                ", forma_pago='" + forma_pago + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public Double getValor() {
        return valor;
    }

    public String getForma_pago() {
        return forma_pago;
    }

}

