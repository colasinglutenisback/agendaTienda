package Agenda;
import java.util.*;
import utilidades.Utilidades;

public class Menu {
    private int seleccion;
    private int seleccion2;
    private int seleccion3;
    private int seleccion4;
    private int seleccion5;
    private int seleccion6;
    public  String a = "+--------------------------------------------------------------------+\n";
    private String b = "|                 Sesión iniciada como administrador                 |\n";
    private String c = "|     Seleccione lo que desea hacer:                                 |\n"
                    +  "|   1-Crear nuevo cliente                                            |\n"
                    +  "|   2-Crear nuevo proveedor                                          |\n"
                    +  "|   3-Crear nuevo usuario                                            |\n"
                    +  "|   4-Ver información de persona                                     |\n"
                    +  "|   5-Actualizar información de persona                              |\n"
                    +  "|   6-Eliminar persona de la agenda                                  |\n"
                    +  "|   0-Salir                                                          |\n";
    private String d = "|     ¿Va a introducir los datos ahora?                              |\n";
    private String e = "|   1-Si                                                             |\n"
                    +  "|   2-No                                                             |\n"
                    +  "|   0-Cancelar creación                                              |\n";
    private String f = "|   Seleccione la persona que desea ver (-1 para cancelar):          |\n"
                    +  "|                                                                    |\n";
    private String g = "|   Seleccione la persona que desea modificar (-1 para cancelar):    |\n"
                    +  "|                                                                    |\n";
    private String h = "|   Seleccione el dato que desea modificar:                          |\n"
                    +  "|                                                                    |\n";
    private String i = "|   1-Id                                                             |\n"
                    +  "|   2-Nombre                                                         |\n"
                    +  "|   3-Apellidos                                                      |\n"
                    +  "|   4-E-mail                                                         |\n"
                    +  "|   5-Teléfono fijo                                                  |\n"
                    +  "|   6-Teléfono móvil                                                 |\n";
    private String j = "|   7-Nif                                                            |\n"
                    +  "|   8-Nº cliente                                                     |\n"
                    +  "|   0-Terminar                                                       |\n";
    private String k = "|   7-Nif                                                            |\n"
                    +  "|   8-Nº proveedor                                                   |\n"
                    +  "|   0-Terminar                                                       |\n";
    private String l = "|   7-Usuario                                                        |\n"
                    +  "|   8-Contraseña                                                     |\n"
                    +  "|   0-Terminar                                                       |\n";
    private String m = "|     Seleccione a quién desea eliminar (-1 para cancelar):          |\n";
    
    public void mostrarMenu () {
        System.out.print(a + b + a + c + a);
        this.seleccion = Utilidades.leerInt("Selección");
    }
    
    public void mostrarMenu2 () {
        System.out.print(a + d + a + e + a);
        this.seleccion2 = Utilidades.leerInt("Selección");
    }
    
    public void mostrarMenu3 (Persona[] P) {
        System.out.print(a + f);
        for (int l = 0; l < P.length; l++) {
            String x = ("| " + (l+1) + "- " + P[l].id + ", " + P[l].nombre + " " + P[l].apellidos);
            if (x.length()<50) {
                int temp = 70-x.length();
                for (int m = 0; m < temp-1; m++) {
                    x+=" ";
                }
                x+="|\n";
            }
            System.out.print(x);
        }
        this.seleccion3=Utilidades.leerInt("Selección");
        System.out.println(a);
    }
    
    public void mostrarMenu4 (Persona[] P) {
        System.out.print(a + g);
        for (int l = 0; l < P.length; l++) {
            String x = ("| " + (l+1) + "- " + P[l].id + ", " + P[l].nombre + " " + P[l].apellidos);
            if (x.length()<70) {
                int temp = 70-x.length();
                for (int m = 0; m < temp-1; m++) {
                    x+=" ";
                }
                x+="|\n";
            }
            System.out.print(x);
        }
        this.seleccion4=Utilidades.leerInt("Selección");
        System.out.println(a);
    }
    
    public void mostrarMenu5 (Persona[] P, int index) {
        System.out.print(a + h + i);
        if (P[index] instanceof Cliente)
            System.out.print(j + a);
        else if (P[index] instanceof Proveedor)
            System.out.print(k + a);
        else if (P[index] instanceof Usuario)
            System.out.print(l + a);
        this.seleccion5=Utilidades.leerInt("Selección");
    }
    
    public void mostrarMenu6 (Persona[] P) {
        System.out.print(a + m + a);
        for (int l = 0; l < P.length; l++) {
            String x = ("| " + (l+1) + "- " + P[l].id + ", " + P[l].nombre + " " + P[l].apellidos);
            if (x.length()<70) {
                int temp = 70-x.length();
                for (int m = 0; m < temp-1; m++) {
                    x+=" ";
                }
                x+="|\n";
            }
            System.out.print(x);
        }
        this.seleccion6=Utilidades.leerInt("Selección");
        System.out.println(a);
    }
    
    public int getSeleccion () {
        return this.seleccion;
    }
    
    public int getSeleccion2 () {
        return this.seleccion2;
    }
    
    public int getSeleccion3 () {
        return this.seleccion3;
    }
    
    public int getSeleccion4 () {
        return this.seleccion4;
    }
    
    public int getSeleccion5 () {
        return this.seleccion5;
    }
    
    public int getSeleccion6 () {
        return this.seleccion6;
    }
}