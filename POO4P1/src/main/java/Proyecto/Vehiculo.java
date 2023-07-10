
package Proyecto;

/**
 *
 * @author chris
 */
public class Vehiculo {
    private int dueno;
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private String chasis;
    private String color;
    public Vehiculo (int dueno, String placa, String marca,String modelo, int anio, String chasis, String color){
        this.dueno=dueno;
        this.placa=placa;
        this.marca=marca;
        this.modelo=modelo;
        this.anio=anio;
        this.chasis=chasis;
        this.color=color;
    }
    @Override
    public String toString(){
        return  "\nPlaca: " + placa +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nAño: " + anio +
                "\nChasis: " + chasis +
                "\nColor: " + color; 
    }    
    public int getDueno() {
        return dueno;
    }

    public void setDueno(int dueno) {
        this.dueno = dueno;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
}
