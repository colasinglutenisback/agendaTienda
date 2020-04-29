package Agenda;

public class Usuario extends Persona {
    private String usuario;
    private String contraseña;
    
    public Usuario(){
        super();
        this.usuario="";
        this.contraseña="";
    }
    
    public Usuario(int ident, String name, String surname, String mail, int tlf1, int tlf2, String user, String passwd) {
        super(ident, name, surname, mail, tlf1, tlf2);
        this.usuario=user;
        this.contraseña=passwd;
    }
    
    public void login(){
        System.out.println("Se logea en el sitio web");
    }
    
    public void setUsuario(String user) {
        this.usuario=user;
    }
    
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setContraseña(String passwd) {
        this.contraseña=passwd;
    }
    
    public String getContraseña() {
        return this.contraseña;
    }
}