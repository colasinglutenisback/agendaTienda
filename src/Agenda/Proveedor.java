package Agenda;

public class Proveedor extends Persona {
    private String nif;
    private int nProveedor;
    
    public Proveedor(){
        super();
        this.nif="";
        this.nProveedor=0;
    }
    
    public Proveedor(int ident, String name, String surname, String mail, int tlf1, int tlf2, String dni, int noprov) {
        super(ident, name, surname, mail, tlf1, tlf2);
        this.nif=dni;
        this.nProveedor=noprov;
    }
    
    public void vender(){
        System.out.println("Realiza una venta.");
    }
    
    public void setNif(String dni) {
        this.nif=dni;
    }
    
    public String getNif() {
        return this.nif;
    }
    
    public void setNProveedor(int nocli) {
        this.nProveedor=nocli;
    }
    
    public int getNProveedor() {
        return this.nProveedor;
    }
}