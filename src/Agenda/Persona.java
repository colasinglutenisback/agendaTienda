package Agenda;

public class Persona {
    protected int id;
    protected String nombre;
    protected String apellidos;
    protected String email;
    protected int telefono1;
    protected int telefono2;
    
    protected Persona () {
        this.id=0;
        this.nombre="";
        this.apellidos="";
        this.email="";
        this.telefono1=0;
        this.telefono2=0;
    }
    
    protected Persona (int ident, String name, String surname, String mail, int tlf1, int tlf2) {
        this.id=ident;
        this.nombre=name;
        this.apellidos=surname;
        this.email=mail;
        this.telefono1=tlf1;
        this.telefono2=tlf2;
    }
    
    public void mostrarInfo() {
        String x;
        int temp;
        x = "| Id: " + this.id;
        if (x.length()<70) {
            temp=70-x.length();
            for (int i = 0; i < temp-1; i++) {
                x+=" ";
            }
            x+="|\n";
        }
        System.out.print(x);
        x = "| Nombre: " + this.nombre;
        if (x.length()<70) {
            temp=70-x.length();
            for (int i = 0; i < temp-1; i++) {
                x+=" ";
            }
            x+="|\n";
        }
        System.out.print(x);
        x = "| Apellidos: " + this.apellidos;
        if (x.length()<70) {
            temp=70-x.length();
            for (int i = 0; i < temp-1; i++) {
                x+=" ";
            }
            x+="|\n";
        }
        System.out.print(x);
        x = "| Email: " + this.email;
        if (x.length()<70) {
            temp=70-x.length();
            for (int i = 0; i < temp-1; i++) {
                x+=" ";
            }
            x+="|\n";
        }
        System.out.print(x);
        x = "| Teléfonos: " + this.telefono1 + ", " + this.telefono2;
        if (x.length()<70) {
            temp=70-x.length();
            for (int i = 0; i < temp-1; i++) {
                x+=" ";
            }
            x+="|\n";
        }
        System.out.print(x);
    }
    
    public void setId(int ident){
        this.id=ident;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNombre(String name){
        this.nombre=name;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setApellidos(String surname){
        this.apellidos=surname;
    }
    
    public String getApellidos(){
        return this.apellidos;
    }
    
    public void setEmail(String mail){
        this.email=mail;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setTelefono1(int tlf){
        this.telefono1=tlf;
    }
    
    public int getTelefono1(){
        return this.telefono1;
    }
    
    public void setTelefono2(int tlf){
        this.telefono2=tlf;
    }
    
    public int getTelefono2(){
        return this.telefono2;
    }
}