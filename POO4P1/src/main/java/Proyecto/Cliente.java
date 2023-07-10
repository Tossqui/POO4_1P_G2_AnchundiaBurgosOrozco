package Proyecto;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas
 */
public class Cliente extends Usuario {
    private int puntosLicencia;
    private BigInteger numTarjeta;
    private Vehiculo v;
    private ArrayList<Multas> lmultas;



    public Cliente(int cedula, String nombres, int edad, String correo, String usuario, String contrasena, tipoPerfil perfil, BigInteger numTarjeta, int puntosLicencia,Vehiculo v,ArrayList<Multas> lmultas) {
        super(cedula, nombres, edad, correo, usuario, contrasena, perfil);
        this.numTarjeta = numTarjeta;
        this.puntosLicencia = puntosLicencia;
        this.v=v;
        this.lmultas=lmultas;
    }
    public void agendarRevision(){
       Scanner sc = new Scanner(System.in);
       Usuario u= this;
       String mensaje = "AGENDAR REVISION";
       int longitudMensaje = mensaje.length();
       System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
       System.out.println("| " + mensaje + " |");
       System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
        System.out.print("Ingrese la placa: ");
        
        String placa= sc.nextLine();
        if(placa.equals(this.v.getPlaca())){
            if(this.lmultas.isEmpty()){
                System.out.println("No tiene multas");
                System.out.println("Horarios Disponibles");
                int cantidadCitas = 20;
                List<Date> listaCitas = new ArrayList<>();
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, 4);
                calendar.set(Calendar.HOUR_OF_DAY, 9);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                for (int i = 0; i < cantidadCitas; i++) {
                    Date cita = calendar.getTime();
                    listaCitas.add(cita);
                    calendar.add(Calendar.MINUTE, 30);
                }
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
                for (Date fechaHora : listaCitas) {
                    String citaFormateada = formato.format(fechaHora);
                    String horaFormateada = formatoHora.format(fechaHora);
                    System.out.println((listaCitas.indexOf(fechaHora)+1)+"."+citaFormateada+" "+horaFormateada);
                }
                System.out.print("Eliga horario de Revision: ");
                int resp= sc.nextInt()-1;
                sc.nextLine();
                String fechaF = formato.format(listaCitas.get(resp));
                String horaF = formatoHora.format(listaCitas.get(resp));
                
                System.out.println(u.getNombres()+", "+"se ha agendado su cita para el: "+ fechaF+" a las: "+horaF);
                double saldo;
                if (u.getPerfil()==tipoPerfil.ESTRELLA){
                    saldo= 150*0.8;
                }else{
                    int puntosPerdidos= 30-this.puntosLicencia;
                    saldo=150+(puntosPerdidos*10);
                }
                System.out.println("El valor a pagar es de: $"+ saldo);
                System.out.println("PUEDE PAGAR SU CITA 24 HORAS ANTES DE LA CITA");
                System.out.println("DE LO CONTRARIO LA CITA SE CANCELARA");
                Random random = new Random();
                int numeroAleatorio = random.nextInt(9000) + 1000;
                Date fechaR = null;
                try {
                    fechaR = formato.parse(fechaF);

                    } catch (ParseException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                Revision r= new Revision(numeroAleatorio,u.getCedula(),this.v.getPlaca(),fechaR);
                ManejoArchivos.EscribirArchivo("Revision.txt", numeroAleatorio+","+u.getCedula()+","+this.v.getPlaca()+","+fechaF+","+saldo);
                
            }else{
                System.out.println("Tiene multas pendientes, no puede agendar revision");
            }
        }else{
            System.out.println("Placa incorrecta \nVOLVIENDO A MENU");
        }
    
    
    }
    
    
    @Override
    public void consultarMultas(){
        Scanner sc = new Scanner(System.in);
        int op;
        do{
            System.out.println("Que desea ingresar:(1/2/3)");
            System.out.println("1. Cedula");
            System.out.println("2. Numero Placa");
            System.out.println("3. Salir");
             op = sc.nextInt();
             sc.nextLine();
            switch(op){
                case(1):
                    System.out.println("Ingrese el numero de cedula: ");
                    int cedula=Integer.parseInt(sc.nextLine());
                    Usuario u=this;
                    float suma1 = 0;
                    if(cedula==u.getCedula()){
                        String mensaje = "DETALLE DE MULTAS";
                        int longitudMensaje = mensaje.length();

                        System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
                        System.out.println("| " + mensaje + " |");
                        System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
                        if(this.lmultas.isEmpty()){
                            System.out.println("NADA");
                        }else{
                        System.out.println("CEDULA|MATRICULA|INFRACCION|VALOR PAGAR| FECHA DE INFRACCION|FECHA DE NOTIFICACION| PUNTOS");
                        for(Multas m: this.lmultas){
                            System.out.println(m.getCedula()+"|"+m.getMatricula()+"|"+m.getInfraccion()+"|"+m.getValorpagar()+"|"+m.getFechainfraccion()+"|"+m.getFechanotificacion()+"|"+m.getPuntos());
                            suma1+=m.getValorpagar();
                        }
                        System.out.println("El valor total a pagar es: $"+suma1);
                        System.out.println("PARA PAGAR PUEDE ACERCARSE A LA AGENCIA MAS CERCANA");
                        
                        }
                    }
                    break;
                case(2):
                   System.out.println("Ingrese la PLACA: ");
                   String placa= sc.nextLine();
                   float suma =0;
                   
                   if (placa.equals(this.v.getPlaca())){
                        String mensaje = "DETALLE DE MULTAS";
                        int longitudMensaje = mensaje.length();

                        System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
                        System.out.println("| " + mensaje + " |");
                        System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
                        if(this.lmultas.isEmpty()){
                            System.out.println("No registra multa.");
                        }else{
                        System.out.println("CEDULA|MATRICULA|INFRACCION|VALOR PAGAR| FECHA DE INFRACCION|FECHA DE NOTIFICACION| PUNTOS");
                        for(Multas m: this.lmultas){
                            System.out.println(m.getCedula()+"|"+m.getMatricula()+"|"+m.getInfraccion()+"|"+m.getValorpagar()+"|"+m.getFechainfraccion()+"|"+m.getFechanotificacion()+"|"+m.getPuntos());
                            suma+=m.getValorpagar();
                        }
                            System.out.println("El valor total a pagar es: $"+suma);
                            System.out.println("PARA PAGAR PUEDE ACERCARSE A LA AGENCIA MAS CERCANA");
                        }
                        
                   }
                case(3):
                    System.out.println("REGRESANDO AL MENU");
            }   
            
        }while(op!=3);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        
        return super.toString()+ "\nNumero tarjeta: "+numTarjeta+"\npuntosLicencia: "+puntosLicencia+"\nVehiculo"+v+"\nMultas: " + lmultas;
        
    }
    public ArrayList<Multas> getLmultas() {
        return lmultas;
    }

    public void setLmultas(ArrayList<Multas> lmultas) {
        this.lmultas = lmultas;
    }
    public Vehiculo getV() {
        return v;
    }

    public void setV(Vehiculo v) {
        this.v = v;
    }
    public int getPuntosLicencia() {
        return puntosLicencia;
    }

    public void setPuntosLicencia(int puntosLicencia) {
        this.puntosLicencia = puntosLicencia;
    }

    public BigInteger getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(BigInteger numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
    
    
}
