package com.barriag.ohmslawcalculator3.entidades;

public class Formulas {
    private String id;
    private Integer voltaje;
    private Integer resistencia;
    private Integer corriente;
    private Integer potencia;
    private Integer resultado;

    public Formulas(String id, Integer voltaje, Integer resistencia, Integer corriente, Integer potencia, Integer resultado) {
        this.id = id;
        this.voltaje = voltaje;
        this.resistencia = resistencia;
        this.corriente= corriente;
        this.potencia = potencia;
        this.resultado = resultado;
    }

    public Formulas() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVoltaje() {
        return voltaje;

    }

    public void setVoltaje(Integer voltaje) {
        this.voltaje = voltaje;

    }

    public Integer getResistencia() {
        return resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    public Integer getCorriente() {
        return corriente;
    }

    public void setCorriente(Integer corriente) {
        this.corriente = corriente;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }
}

