package Proyecto;
import java.util.Date;
/**
 *
 * @author chris
 */
public class Multas {
    private int cedula;
    private String matricula;
    private String infraccion;
    private float valorpagar;
    private Date fechainfraccion;
    private Date fechanotificacion;
    private int puntos;
    

   

    
    public Multas (int cedula, String matricula,String infraccion, float valorpagar, Date fechainfraccion,Date fechanotificacion,int puntos){
        this.cedula=cedula;
        this.matricula=matricula;
        this.infraccion= infraccion;
        this.valorpagar=valorpagar;
        this.fechainfraccion=fechainfraccion;
        this.fechanotificacion=fechanotificacion;
        this.puntos=puntos;
    }
    @Override
    public String toString(){
        return  "\nMatricula : " + matricula +
                "\nInfraccion : " + infraccion +
                "\nValor a pagar: " + valorpagar +
                "\nFecha de infraccion: " + fechainfraccion +
                "\nFecha de notificacion: " + fechanotificacion +
                "\nPuntos: " + puntos; 
    }    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(String infraccion) {
        this.infraccion = infraccion;
    }

    public float getValorpagar() {
        return valorpagar;
    }

    public void setValorpagar(float valorpagar) {
        this.valorpagar = valorpagar;
    }

    public Date getFechainfraccion() {
        return fechainfraccion;
    }

    public void setFechainfraccion(Date fechainfraccion) {
        this.fechainfraccion = fechainfraccion;
    }

    public Date getFechanotificacion() {
        return fechanotificacion;
    }

    public void setFechanotificacion(Date fechanotificacion) {
        this.fechanotificacion = fechanotificacion;
    }

    public int getPuntos() {
        return puntos;
    }
     public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
}
