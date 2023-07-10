/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto;
import java.util.ArrayList;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Dario
 */
public class Main {
    static ArrayList<Usuario> usuariosRegistrados;
    static ArrayList<Usuario> usuarioActual;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        usuariosRegistrados = new ArrayList<>();
        usuarioActual=new ArrayList<>(); 
        cargarUsuarios();
        String mensaje = "Bienvenido al sistema";
        int longitudMensaje = mensaje.length();

        System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
        System.out.println("| " + mensaje + " |");
        System.out.println("+" + "-".repeat(longitudMensaje + 2) + "+");
        do{validarUsuario();
            if (usuarioActual.isEmpty()){
                System.out.println("Usuario o Contraseña incorrectos");
            }
        }while(usuarioActual.isEmpty());
        mostrarMenu(usuarioActual.get(0));  
    }
    public static void mostrarMenu(Usuario usuario){
        boolean salir=false;
        Scanner sc = new Scanner(System.in);
        int op;
        do{
            if (usuario instanceof Cliente){
            System.out.println("Bienvenido, cliente " + usuario.getNombres());
            System.out.println("Seleccione una opción:");
            System.out.println("1. Consultar Multas");
            System.out.println("2. Agendar Revisión técnica");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opcion: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    usuario.consultarMultas();
                    break;
                case 2:
                    ((Cliente) usuario).agendarRevision();
                    break;
                case 3:
                    System.out.println("SALIENDO DEL PROGRAMA");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }else if (usuario instanceof Operador){
            System.out.println("Bienvenido, operador " + usuario.getNombres());
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar pagos");
            System.out.println("2. Consultar multas clientes");
            System.out.println("3. Consultar usuarios");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opcion: ");
            op= sc.nextInt();
            switch (op) {
                case 1: 
                    ((Operador) usuario).registroPago();
                break;
                case 2: 
                    usuario.consultarMultas();
                    break;
                case 3: 
                    ((Operador) usuario).consultarUsuarios(usuariosRegistrados);
                    break;
                case 4:
                    System.out.println("SALIENDO DEL PROGRAMA");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
        }while(!salir);
    }
    public static void validarUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.print("USUARIO: ");
        String usuario = sc.nextLine();
        System.out.print("PASSWORD: ");
        String password = sc.nextLine();
        for (Usuario u: usuariosRegistrados){
            if ((u.getUsuario().equals(usuario)) && (u.getContrasena().equals(password))){
                if (u instanceof Cliente){
                    Usuario u1= new Cliente(u.getCedula(),u.getNombres(),u.getEdad(),u.getCorreo(),u.getUsuario(),u.getContrasena(),u.getPerfil(),((Cliente) u).getNumTarjeta(), ((Cliente) u).getPuntosLicencia(),((Cliente) u).getV(),((Cliente) u).getLmultas());
                    usuarioActual.add(u1);
                }else if(u instanceof Operador){
                    Usuario u2 = new Operador(u.getCedula(),u.getNombres(),u.getEdad(),u.getCorreo(),u.getUsuario(),u.getContrasena(),u.getPerfil(),((Operador) u).getSueldo());
                    usuarioActual.add(u2);
                }
            }
        }
    }
    public static void cargarUsuarios(){
        ArrayList<String> datos = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<String> datosc = ManejoArchivos.LeeFichero("clientes.txt");
        ArrayList<String> datoso = ManejoArchivos.LeeFichero("operadores.txt");
        ArrayList<String> datosv = ManejoArchivos.LeeFichero("vehiculos.txt");
        ArrayList<String> datosm = ManejoArchivos.LeeFichero("multas.txt");
        for (String linea :datos){
            tipoPerfil pf= tipoPerfil.INDEFINIDO;
            String[] elementos = linea.trim().split(",");
            String posPf= elementos[6];
            int cedula = Integer.parseInt(elementos[0]);
            switch (posPf){
                case "S":
                    pf=tipoPerfil.ESTANDAR;
                    break;
                case "E":
                    pf=tipoPerfil.ESTRELLA;
                    break;
                case "O":
                    pf=tipoPerfil.OPERADOR;
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        
            if (elementos[6].equals("S")||elementos[6].equals("E")){
                for (String linea2: datosc){
                    String[] elementos1 = linea2.trim().split(",");
                    int cedulac = Integer.parseInt(elementos1[0]);
                    BigInteger numero = new BigInteger(elementos1[1]);
                    if (cedula==cedulac){
                        for (String linea4:datosv){
                            String[] elementos4 = linea4.trim().split(",");
                            int cedulav = Integer.parseInt(elementos4[0]);
                            if (cedula==cedulav){
                                
                                Vehiculo v = new Vehiculo(cedulav,elementos4[1],elementos4[2],elementos4[3],Integer.parseInt(elementos4[4]),elementos4[5],elementos4[6]);
                                ArrayList<Multas> Lmultas= new ArrayList<>();
                                for (String linea5:datosm){
                                    String[] elementos5 = linea5.trim().split(",");
                                    int cedulam = Integer.parseInt(elementos5[0]);
                                    float valorp= Float.parseFloat(elementos5[3]);
                                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-mm-yyyy");
                                    Date fechainfra = null;
                                    Date fechanoti = null;
                                    try {
                                        fechainfra = formatoFecha.parse(elementos5[4]);

                                    } catch (ParseException ex) {
                                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    try {
                                        fechanoti = formatoFecha.parse(elementos5[5]);

                                    } catch (ParseException ex) {
                                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                    }if (cedula==cedulam){
                                        Multas m = new Multas(cedula,elementos5[1],elementos5[2],valorp,fechainfra,fechanoti,Integer.parseInt(elementos5[6]));
                                        Lmultas.add(m);
                                    }    
                                }
                                Cliente c = new Cliente(cedula,elementos[1],Integer.parseInt(elementos[2]),elementos[3],elementos[4],elementos[5],pf,numero,Integer.parseInt(elementos1[2]),v,Lmultas);
                                usuariosRegistrados.add(c);
                            }
                        }
                    }
                }
            } else if (elementos[6].equals("O")){
                for(String linea3 : datoso){
                    String[] elementos2 = linea3.trim().split(",");
                    int cedulao =Integer.parseInt(elementos2[0]);
                    if (cedula==cedulao){
                        Operador o = new Operador(cedula,elementos[1],Integer.parseInt(elementos[2]),elementos[3],elementos[4],elementos[5],pf,Integer.parseInt(elementos2[1]));
                        usuariosRegistrados.add(o);
                    }
                }
            }
        }
    }
}
