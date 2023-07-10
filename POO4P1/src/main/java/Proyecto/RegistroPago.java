/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author chris
 */
public class RegistroPago {
    private int codigoPago;
    private int cedula;
    private float valorPagar;
    private char modoPago;
    private float valorfinal;
    private String razonPago;

    public RegistroPago(int codigoPago, int cedula, float valorPagar, char modoPago, float valorfinal, String razonPago) {
        this.codigoPago = codigoPago;
        this.cedula = cedula;
        this.valorPagar = valorPagar;
        this.modoPago = modoPago;
        this.valorfinal = valorfinal;
        this.razonPago = razonPago;
    }

    public int getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(int codigoPago) {
        this.codigoPago = codigoPago;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public float getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(float valorPagar) {
        this.valorPagar = valorPagar;
    }

    public char getModoPago() {
        return modoPago;
    }

    public void setModoPago(char modoPago) {
        this.modoPago = modoPago;
    }

    public float getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(float valorfinal) {
        this.valorfinal = valorfinal;
    }

    public String getRazonPago() {
        return razonPago;
    }

    public void setRazonPago(String razonPago) {
        this.razonPago = razonPago;
    }
    
    
}
