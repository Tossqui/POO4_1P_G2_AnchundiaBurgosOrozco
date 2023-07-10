package Proyecto;

/**
 *
 * @author Thomas
 */
public abstract class Usuario {
    private int cedula;
    private String nombres;
    private int edad;
    private String correo;
    private String usuario;
    private String contrasena;
    private tipoPerfil perfil;
    
    
    public Usuario(int cedula, String nombres, int edad, String correo, String usuario, String contrasena, tipoPerfil perfil) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.perfil = perfil;
    }
    @Override
    public String toString(){
        return "Cédula: " + cedula +
                "\nNombres: " + nombres +
                "\nEdad: " + edad +
                "\nCorreo: " + correo +
                "\nUsuario: " + usuario +
                "\nContraseña: " + contrasena +
                "\nPerfil: " + perfil; 
    }    
    public void consultarMultas(){
        
    }

    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public tipoPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(tipoPerfil perfil) {
        this.perfil = perfil;
    }    
}
