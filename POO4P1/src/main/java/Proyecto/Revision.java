/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.util.Date;

/**
 *
 * @author chris
 */
public class Revision {
    private int codigorevision;
    private int cedula;
    private String placa;
    private Date fechaRevision;
    
    public Revision(int codigorevision, int cedula, String placa, Date fechaRevision) {
        this.codigorevision = codigorevision;
        this.cedula = cedula;
        this.placa = placa;
        this.fechaRevision = fechaRevision;
    }

    public int getCodigorevision() {
        return codigorevision;
    }

    public void setCodigorevision(int codigorevision) {
        this.codigorevision = codigorevision;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }
    
    
    
}
