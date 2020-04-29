package Agenda;

public class Cliente extends Persona {
    private String nif;
    private int nCliente;
    
    public Cliente(){
        super();
        this.nif="";
        this.nCliente=0;
    }
    
    public Cliente(int ident, String name, String surname, String mail, int tlf1, int tlf2, String dni, int nocli) {
        super(ident, name, surname, mail, tlf1, tlf2);
        this.nif=dni;
        this.nCliente=nocli;
    }
    
    public void comprar(){
        System.out.println("Realiza una compra.");
    }
    
    public void setNif(String dni) {
        this.nif=dni;
    }
    
    public String getNif() {
        return this.nif;
    }
    
    public void setNCliente(int nocli) {
        this.nCliente=nocli;
    }
    
    public int getNCliente() {
        return this.nCliente;
    }
}