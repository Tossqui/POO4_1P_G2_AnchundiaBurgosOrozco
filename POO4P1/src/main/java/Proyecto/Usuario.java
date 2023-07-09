package Proyecto;

/**
 *
 * @author chris
 */
public abstract class Usuario {
    private int cedula;
    private String nombres;
    private String apellidos;
    private int edad;
    private String correo;
    private String usuario;
    private String contrasena;
    private tipoPerfil perfil;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
