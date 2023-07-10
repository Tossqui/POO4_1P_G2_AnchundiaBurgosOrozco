package Proyecto;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class Operador extends Usuario {
    private int sueldo;
    public Operador(int cedula, String nombres, int edad, String correo, String usuario, String contrasena, tipoPerfil perfil, int sueldo) {
        super(cedula, nombres, edad, correo, usuario, contrasena, perfil);
        this.sueldo = sueldo;
    }
    
    
    public void registroPago(){
        
        String mensaje = "REGISTRAR PAGO";
        int longitudMensaje = mensaje.length();
        System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
        System.out.println("| " + mensaje + " |");
        System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
        ArrayList<String> datosm = ManejoArchivos.LeeFichero("multas.txt");
        ArrayList<String> datosr = ManejoArchivos.LeeFichero("Revision.txt");
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.print("Ingrese su cedula: ");
            int cedula = sc.nextInt();
            sc.nextLine();
            System.out.println("Que desea pagar: ");
            System.out.println("1. Multas");
            System.out.println("2. Revision");
            System.out.println("3. Salir");
            opcion= sc.nextInt();
            switch (opcion) {
                case 1:
                    float suma1=0;
                    for (String linea: datosm){
                        String[] elementos = linea.trim().split(",");
                        int cedulam = Integer.parseInt(elementos[0]);
                        
                        if (cedula==cedulam){
                            float valorp= Float.parseFloat(elementos[3]);
                            suma1+=valorp;
                            
                        }else {
                            System.out.println("No registra multas");
                            opcion=3;
                            break;
                        }
                    }
                    if (suma1!=0){
                    int op1;
                    System.out.println("El valor a pagar es: $"+ suma1);
                    System.out.println("Que modo va a usar para pagar? \n1.Efectivo\n2.Tarjeta de credito");
                    op1=sc.nextInt();
                    sc.nextLine();
                    switch(op1){
                        case 1:
                            System.out.println("El valor a pagar es: $"+suma1);
                            int op2;
                            System.out.println("Desea proceder con el pago? \n1.Si\n2.No");
                            op2=sc.nextInt();
                            switch (op2){
                                case 1:
                                    Random random = new Random();
                                    int numeroAleatorio = random.nextInt(9000) + 1000;
                                    RegistroPago r1= new  RegistroPago(numeroAleatorio,cedula,suma1,'E',suma1,"MULTAS");
                                    ManejoArchivos.EscribirArchivo("RegistroPago.txt",numeroAleatorio+","+cedula+","+suma1+","+'E'+suma1+",MULTAS");
                                    opcion=3;
                                    break;
                                case 2:
                                    break;
                            } break;
                        case 2:
                            float suma2 = (float) (suma1*1.1);
                            System.out.println("El valor a pagar es: $"+suma2);
                            int op3;
                            System.out.println("Desea proceder con el pago? \n1.Si\n2.No");
                            op3=sc.nextInt();
                            switch (op3){
                                case 1:
                                    Random random = new Random();
                                    int numeroAleatorio = random.nextInt(9000) + 1000;
                                    RegistroPago r2= new  RegistroPago(numeroAleatorio,cedula,suma1,'E',suma1,"MULTAS");
                                    ManejoArchivos.EscribirArchivo("RegistroPago.txt",numeroAleatorio+","+cedula+","+suma1+","+'T'+suma2+",MULTAS");
                                    opcion=3;
                                    break;
                                case 2:
                                    break;
                           
                            }break;
                    }break;
                    }else {
                        break;
                    }
                case 2:
                    
                    float suma3=0;
                    for (String linea: datosr){
                        String[] elementos1 = linea.trim().split(",");
                        int cedular = Integer.parseInt(elementos1[1]);
                        
                        if (cedula==cedular){
                            float valorp= Float.parseFloat(elementos1[4]);
                            suma3+=valorp;
                            
                        }else {
                            System.out.println("No registra revisiones");
                            opcion=3;
                            break;
                        }
                    }
                    if(suma3!=0){
                    int op4;
                    System.out.println("El valor a pagar es: $"+ suma3);
                    System.out.println("Que modo va a usar para pagar? \n1.Efectivo\n2.Tarjeta de credito");
                    op4=sc.nextInt();
                    sc.nextLine();
                    switch(op4){
                        case 1:
                            System.out.println("El valor a pagar es: $"+suma3);
                            int op5;
                            System.out.println("Desea proceder con el pago? \n1.Si\n2.No");
                            op5=sc.nextInt();
                            switch (op5){
                                case 1:
                                    Random random = new Random();
                                    int numeroAleatorio = random.nextInt(9000) + 1000;
                                    RegistroPago r1= new  RegistroPago(numeroAleatorio,cedula,suma3,'E',suma3,"REVISION");
                                    ManejoArchivos.EscribirArchivo("RegistroPago.txt",numeroAleatorio+","+cedula+","+suma3+","+'E'+suma3+",REVISION");
                                    opcion=3;
                                    break;
                                case 2:
                                    break;
                            } break;
                        case 2:
                            float suma4 = (float) (suma3*1.1);
                            System.out.println("El valor a pagar es: $"+suma4);
                            int op6;
                            System.out.println("Desea proceder con el pago? \n1.Si\n2.No");
                            op6=sc.nextInt();
                            switch (op6){
                                case 1:
                                    Random random = new Random();
                                    int numeroAleatorio = random.nextInt(9000) + 1000;
                                    RegistroPago r2= new  RegistroPago(numeroAleatorio,cedula,suma4,'E',suma4,"REVISION");
                                    ManejoArchivos.EscribirArchivo("RegistroPago.txt",numeroAleatorio+","+cedula+","+suma3+","+'T'+","+suma4+",REVISION");
                                    opcion=3;
                                    break;
                                case 2:
                                    break;
                           
                            }break;
                    }
                    }else{
                        break;
                    }
                    
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
                     System.out.println();

        } while (opcion != 3);
        
    }
    
    @Override
    public void consultarMultas(){
        ArrayList<String> datosm = ManejoArchivos.LeeFichero("multas.txt");
        ArrayList<String> datos = ManejoArchivos.LeeFichero("usuarios.txt");
        for (String linea:datosm){
            String[] elementos = linea.trim().split(",");
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-mm-yyyy");
            Date fechainfra = null;
            int cedulam = Integer.parseInt(elementos[0]);
            try {
                  fechainfra = formatoFecha.parse(elementos[4]);

                } catch (ParseException ex) {
                  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            for (String linea1: datosm){
                String[] elementos1 = linea.trim().split(",");
                SimpleDateFormat formatoFecha1 = new SimpleDateFormat("dd-mm-yyyy");
                Date fechainfra1 = null;
            try {
                  fechainfra1 = formatoFecha.parse(elementos1[4]);

                } catch (ParseException ex) {
                  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                Calendar calendar1 = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar1.setTime(fechainfra);
                calendar2.setTime(fechainfra1);
                int mes1 = calendar1.get(Calendar.MONTH);
                int mes2 = calendar2.get(Calendar.MONTH);
                for (String linea2 :datos){
                    String[] elementos3 = linea2.trim().split(",");
                    int cedula = Integer.parseInt(elementos3[0]);
                    if(cedula==cedulam){
                        if(mes1==mes2){
                            DateFormatSymbols dfs = new DateFormatSymbols();
                            String[] nombresMeses = dfs.getMonths();
                            String nombreMes = nombresMeses[mes1];
                            System.out.println("Mes: "+nombreMes);
                            System.out.println("Conductores Multados");
                            System.out.println("CONDUCTOR|PLACA|INFRACCION|VALORINFRACCION|FECHA INFRACCION|FECHA NOTIFICACION|PUNTOS");
                            System.out.println(elementos3[1]+"|"+elementos[1]+"|"+elementos[2]+"|"+elementos[3]+"|"+elementos[4]+"|"+elementos[5]+"|"+elementos[6]);
                        }else{
                            break;
                        }
                    }
                    
                }break;
                
                    
                
            }
            
        }
    }
    
    public void consultarUsuarios(ArrayList<Usuario> usuarios){
        String mensaje = "CONSULTAR USUARIO";
        int longitudMensaje = mensaje.length();

        System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
        System.out.println("| " + mensaje + " |");
        System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
        for (Usuario u: usuarios){
            if (u instanceof Cliente){
                Cliente c = (Cliente) u;
                System.out.println(u.getNombres()+"| CLIENTE "+u.getPerfil()+"|"+c.getCedula());
            }else if(u instanceof Operador){
                Operador o = (Operador)u;
                System.out.println(u.getNombres()+"|"+u.getPerfil()+"|"+o.getSueldo());
            }
        }
        
    }
    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
}
