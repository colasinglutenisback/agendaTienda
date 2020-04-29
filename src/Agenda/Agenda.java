package Agenda;
import utilidades.Utilidades;

public class Agenda {
    
    public Agenda() {
        Persona[] Person = new Persona[7];
        Person[0] =  new Cliente(1, "Pedro", "Gutierrez Perez", "pegupe@gmail.com", 922222222, 922222223, "7129323A", 1);
        Person[1] =  new Cliente(2, "Juan", "Martinez Sanchez", "jumasa@gmail.com", 922222224, 922222225, "7639323B", 2);
        Person[2] =  new Proveedor(3, "Antonio", "Gomez Gomez", "angogo@gmail.com", 922222226, 922222227, "7749323C", 1);
        Person[3] =  new Proveedor(4, "María", "Lopez Marín", "maloma@gmail.com", 922222228, 922222229, "7167323D", 2);
        Person[4] =  new Usuario(5, "Luisa", "Ramirez Núñez", "luranu@gmail.com", 922222230, 922222231, "luisita85", "miperroskip85");
        Person[5] =  new Usuario(6, "Diana", "Paz García", "dipaga@gmail.com", 922222232, 922222233, "dianauser", "migatoPelusa95");
        Person[7] =  new Cliente();
        Person = inicio(Person);
    }
    
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
    }
    
    private Persona[] inicio(Persona[] Person) {
        Menu menu = new Menu();
        do {
            menu.mostrarMenu();
            switch(menu.getSeleccion()) {
                case 1: 
                case 2:
                case 3: Person = newPersona(Person, menu.getSeleccion()); break;
                case 4: mostrarTodo(Person); break;
                case 5: modificarDato(Person); break;
                case 6: Person = deletePersona(Person); break;
                case 0: break;
                default: break;
            }
        } while(menu.getSeleccion()!=0);
        return Person;
    }
    
    private Persona[] newPersona(Persona[] P, int sel) { //create
        Persona[] Pe = new Persona[P.length+1];
        Menu menu = new Menu();
        for (int i = 0; i < P.length; i++)
            Pe[i]=P[i];
        switch (sel) {
            case 1:
                Pe[Pe.length-1]=new Cliente();
                do {
                    menu.mostrarMenu2();
                    if (menu.getSeleccion2()==1)
                        this.datosCliente(Pe, Pe.length-1);
                    else if (menu.getSeleccion2()==0) {
                        Pe = new Persona[P.length];
                        Pe=P;
                    }
                } while (menu.getSeleccion2()!=1&menu.getSeleccion2()!=2&menu.getSeleccion2()!=0);
                break;
            case 2:
                Pe[Pe.length-1]=new Proveedor();
                do {
                    menu.mostrarMenu2();
                    if (menu.getSeleccion2()==1)
                        this.datosProveedor(Pe, Pe.length-1);
                    else if (menu.getSeleccion2()==0) {
                        Pe = new Persona[P.length];
                        Pe=P;
                    }
                } while (menu.getSeleccion2()!=1&menu.getSeleccion2()!=2&menu.getSeleccion2()!=0);
                break;
            case 3:
                Pe[Pe.length-1]=new Usuario();
                do {
                    menu.mostrarMenu2();
                    if (menu.getSeleccion2()==1)
                        this.datosUsuario(Pe, Pe.length-1);
                    else if (menu.getSeleccion2()==0) {
                        Pe = new Persona[P.length];
                        Pe=P;
                    }
                } while (menu.getSeleccion2()!=1&menu.getSeleccion2()!=2&menu.getSeleccion2()!=0);
                break;
        }
        return Pe;
    }
    
    private void mostrarTodo(Persona[] P) { //read
        String x;
        int index, temp;
        Menu menu = new Menu();
        menu.mostrarMenu3(P);
        do {
            index = menu.getSeleccion3()-1;
        } while ((index<0&index!=-2)|index>P.length-1);
        if (index!=-2) {
            System.out.print(menu.a);
            P[index].mostrarInfo();
        if (P[index] instanceof Cliente) {
            x = "| NIF: " + ((Cliente)P[index]).getNif();
            if (x.length()<70) {
                temp=70-x.length();
                for (int i = 0; i < temp-1; i++) {
                    x+=" ";
                }
                x+="|\n";
            }
            System.out.print(x);
            x = "| Nº cliente: " + ((Cliente)P[index]).getNCliente();
            if (x.length()<70) {
                temp=70-x.length();
                for (int i = 0; i < temp-1; i++) {
                    x+=" ";
                }
                x+="|\n";
            }
            System.out.print(x);
        }
        else if (P[index] instanceof Proveedor) {
            x = "| NIF: " + ((Proveedor)P[index]).getNif();
            if (x.length()<70) {
                temp=70-x.length();
                for (int i = 0; i < temp-1; i++) {
                    x+=" ";
                }
                x+="|\n";
            }
            System.out.print(x);
            x = "| Nº proveedor: " + ((Proveedor)P[index]).getNProveedor();
            if (x.length()<70) {
                temp=70-x.length();
                for (int i = 0; i < temp-1; i++) {
                    x+=" ";
                }
                x+="|\n";
            }
            System.out.print(x);
        }
        else if (P[index] instanceof Usuario) {
            x = "| Usuario: " + ((Usuario)P[index]).getUsuario();
            if (x.length()<70) {
                temp=70-x.length();
                for (int i = 0; i < temp-1; i++) {
                    x+=" ";
                }
                x+="|\n";
            }
            System.out.print(x);
            x = "| Contraseña: " + ((Usuario)P[index]).getContraseña();
            if (x.length()<70) {
                temp=70-x.length();
                for (int i = 0; i < temp-1; i++) {
                    x+=" ";
                }
                x+="|\n";
            }
            System.out.print(x);
        }
            System.out.println(menu.a);
        }
    }
    
    private void modificarDato (Persona[] P) { //update
        Menu menu = new Menu();
        do {
            menu.mostrarMenu4(P);
        } while ((menu.getSeleccion4()<1&menu.getSeleccion4()!=-1)|menu.getSeleccion4()>P.length);
        int persona = menu.getSeleccion4()-1;
        if (persona!=-2) {
            do {
                do {
                    menu.mostrarMenu5(P, persona);
                } while (menu.getSeleccion5()<0|menu.getSeleccion5()>8);
            int dato = menu.getSeleccion5();
            switch(dato) {
                case 1: actualizarId(P, persona); break;
                case 2: actualizarNombre(P, persona); break;
                case 3: actualizarApellidos(P, persona); break;
                case 4: actualizarEmail(P, persona); break;
                case 5: actualizarTelefono1(P, persona); break;
                case 6: actualizarTelefono2(P, persona); break;
                case 7:
                    if (P[persona] instanceof Cliente)
                        actualizarNif(P, persona);
                    else if (P[persona] instanceof Proveedor)
                        actualizarNif(P, persona);
                    else if (P[persona] instanceof Usuario)
                        actualizarUsuario(P, persona);
                    break;
                case 8:
                    if (P[persona] instanceof Cliente)
                        actualizarNCliente(P, persona);
                    else if (P[persona] instanceof Proveedor)
                        actualizarNProveedor(P, persona);
                    else if (P[persona] instanceof Usuario)
                        actualizarContraseña(P, persona);
                    break;
            }
        } while (menu.getSeleccion5()!=0);
        }
        
    }
    
    private Persona[] deletePersona(Persona[] P) { //delete
        Persona[] Pe;
        int sel=0;
        Menu menu = new Menu();
        menu.mostrarMenu6(P);
        do {
            sel = menu.getSeleccion6();
        } while ((sel<1&sel!=-1)|sel>P.length);
        if (sel!=-1) {
            Pe = new Persona[P.length-1];
            if (sel>1&sel<P.length) {
                for (int i = 0; i < sel-1; i++)
                    Pe[i]=P[i];
                for (int i = sel; i < P.length; i++)
                    Pe[i-1]=P[i];
            }
            else if (sel==1){
                for (int i = 1; i < P.length; i++)
                    Pe[i-1]=P[i];
            }
            else if(sel==P.length){
                for (int i = 0; i < P.length-1; i++)
                    Pe[i]=P[i];
            }
            else if(sel==0) {
                Pe = new Persona[P.length];
                for (int i = 0; i < P.length; i++) {
                    Pe[i]=P[i];
                }
            }
        }
        else {
            Pe = P;
        }
        return Pe;
    }
    
    private void datosCliente (Persona[] P, int index) {
        datosPersona(P, index);
        actualizarNif(P, index);
        actualizarNCliente(P, index);
    }
    
    private void datosProveedor (Persona[] P, int index) {
        datosPersona(P, index);
        actualizarNif(P, index);
        actualizarNProveedor(P, index);
    }
    
    private void datosUsuario (Persona[] P, int index) {
        datosPersona(P, index);
        actualizarUsuario(P, index);
        actualizarContraseña(P, index);
    }
    
    private void datosPersona(Persona[] P, int index) {
        actualizarId(P, index);
        actualizarNombre(P, index);
        actualizarApellidos(P, index);
        actualizarEmail(P, index);
        actualizarTelefono1(P, index);
        actualizarTelefono2(P, index);
    }
    
    private void actualizarId(Persona[] P, int index) {
        int centinela=1, temp;
        do {
            temp = Utilidades.leerInt("Id(-1 para cancelar)");
            if (temp==-1)
                    break;
            else if (temp<1) {
                System.out.println("El id introducido no es válido.");
                centinela=0;
            }
            else {
                for (Persona P1 : P) {
                    if (P1.getId() == temp) {
                        System.out.println("El id introducido ya está en uso.");
                        centinela=0;
                        break;
                    } else {
                        centinela=1;
                    }
                }
            }
        } while (temp!=-1&centinela!=1);
        if (temp!=-1)
            P[index].setId(temp);
    }
    
    private void actualizarNombre(Persona[] P, int index) {
        String temp;
        int centinela=1;
        do {
            temp = Utilidades.leerString("Nombre(-1 para cancelar)");
            if (!temp.equals("-1")) {
                temp = Utilidades.verificaExpresionRegular("[A-Za-z]+(\\'?[A-Za-z]+)?(\\s\\w+(\\'?\\w+)?)?", temp);
                if (temp.length()==0) {
                    System.out.println("Nombre no válido, intente de nuevo.");
                    centinela=0;
                }
                else
                    centinela=1;
            }
        } while (!temp.equals("-1")&centinela!=1);
        if (!temp.equals("-1"))
            P[index].setNombre(temp);
    }
    
    private void actualizarApellidos(Persona[] P, int index) {
        String temp;
        int centinela=1;
        do {
            temp = Utilidades.leerString("Apellidos(-1 para cancelar)");
            if (!temp.equals("-1")) {
                temp = Utilidades.verificaExpresionRegular("[A-Za-z]+(\\-[A-Za-z]+)?\\s[A-Za-z]+(\\-[A-Za-z]+)?", temp);
                if (temp.length()==0) {
                    System.out.println("Apellidos no válidos, intente de nuevo.");
                    centinela=0;
                }
                else
                    centinela=1;
            }
        } while (!temp.equals("-1")&centinela!=1);
        if (!temp.equals("-1"))
            P[index].setApellidos(temp);
    }
    
    private void actualizarEmail(Persona[] P, int index) {
        String temp;
        int centinela=1;
        do {
            temp = Utilidades.leerString("E-mail(-1 para cancelar)");
            if (!temp.equals("-1")) {
                temp = Utilidades.verificaExpresionRegular("\\w[\\w\\-\\_]{1,30}\\w@[a-z]{1,15}\\.[a-z]{1,5}", temp);
                if (temp.length()==0) {
                    System.out.println("E-mail no válido, intente de nuevo.");
                    centinela=0;
                }
                else
                    centinela=1;
            }
        } while (!temp.equals("-1")&centinela!=1);
        if (!temp.equals("-1"))
            P[index].setEmail(temp);
    }
    
    private void actualizarTelefono1(Persona[] P, int index) {
        int centinela=1;
        String temp;
        do {
            temp =  Utilidades.leerString("Número teléfono fijo(-1 para cancelar)");
            if (!temp.equals("-1")) {
                temp = Utilidades.verificaExpresionRegular("[9|8]\\d{8}", temp);
                if (temp.length()==0) {
                    System.out.println("Error al leer teléfono.");
                    centinela=0;
                }
                else
                    centinela=1;
            }
        } while (!temp.equals("-1")&centinela!=1);
        if (!temp.equals("-1"))
            P[index].setTelefono1(Integer.valueOf(temp));
    }
    
    private void actualizarTelefono2(Persona[] P, int index) {
        int centinela=1;
        String temp;
        do {
            temp =  Utilidades.leerString("Número teléfono móvil(-1 para cancelar)");
            if (!temp.equals("-1")) {
                temp = Utilidades.verificaExpresionRegular("[7|6]\\d{8}", temp);
                if (temp.length()==0) {
                    System.out.println("Error al leer teléfono.");
                    centinela=0;
                }
                else
                    centinela=1;
            }
        } while (!temp.equals("-1")&centinela!=1);
        if (!temp.equals("-1"))
            P[index].setTelefono2(Integer.valueOf(temp));
    }
    
    private void actualizarNif (Persona[] P, int index) {
        String temp;
        int centinela=1;
        do {
            temp = Utilidades.leerString("NIF(-1 para cancelar)");
            if (!temp.equals("-1")) {
                temp = Utilidades.verificaExpresionRegular("(\\d{8}[\\s|\\-]?[A-Z])|([A-Z][\\s|\\-]?\\d{7}[\\s|\\-]?[A-Z])", temp);
                if (temp.length()==0) {
                    System.out.println("NIF no válido, intente de nuevo.");
                    centinela=0;
                }
                else {
                    if (P[index] instanceof Cliente) {
                        for (Persona P1 : P) {
                            if (P1 instanceof Cliente) {
                                if (((Cliente) P1).getNif().equals(temp)) {
                                    System.out.println("El NIF introducido ya está en uso.");
                                    centinela=0;
                                    break;
                                } else { 
                                    centinela=1;
                                }
                            }
                        }
                    }
                    else if (P[index] instanceof Proveedor) {
                        for (Persona P1 : P) {
                            if (P1 instanceof Proveedor) {
                                if (((Cliente) P1).getNif().equals(temp)) {
                                    System.out.println("El NIF introducido ya está en uso.");
                                    centinela=0;
                                    break;
                                } else { 
                                    centinela=1;
                                }
                            }
                        }
                    }
                }
            }
        } while (!temp.equals("-1")&centinela!=1);
        if (!temp.equals("-1")) {
            if (P[index] instanceof Cliente)
                ((Cliente)P[index]).setNif(temp);
            else if (P[index] instanceof Proveedor)
                ((Proveedor)P[index]).setNif(temp);
        }
    }
    
    private void actualizarNCliente(Persona[] P, int index) {
        int centinela=1, temp;
        do {
            temp = Utilidades.leerInt("Nº cliente(-1 para cancelar)");
            if (temp<-1|temp==0) {
                    System.out.println("El nº cliente introducido no es válido.");
                    centinela=0;
            }
            else if (temp>-1) {
                for (int i = 0; i < P.length; i++) {
                    if (P[i] instanceof Cliente) {
                        if (((Cliente)P[i]).getNCliente()==temp) {
                            System.out.println("El nº cliente introducido ya está en uso.");
                            centinela=0;
                            break;
                        }
                        else
                            centinela=1;
                        if (centinela==0)
                            break;
                    }
                }
            }
        } while (temp!=-1&centinela!=1);
        if (temp!=-1)
            ((Cliente)P[index]).setNCliente(temp);
    }
    
    private void actualizarNProveedor(Persona[] P, int index) {
        int centinela=1, temp;
        do {
            temp = Utilidades.leerInt("Nº proveedor(-1 para cancelar)");
            if (temp<-1|temp==0) {
                    System.out.println("El nº proveedor introducido no es válido.");
                    centinela=0;
            }
            else if (temp>-1) {
                for (Persona P1 : P) {
                    if (P1 instanceof Proveedor) {
                        if (((Proveedor) P1).getNProveedor() == temp) {
                            System.out.println("El nº proveedor introducido ya está en uso.");
                            centinela=0;
                            break;
                        } else {
                            centinela=1;
                        }
                    }
                }
            }
        } while (temp!=-1&centinela!=1);
        if (temp!=-1)
            ((Proveedor)P[index]).setNProveedor(temp);
    }
    
    private void actualizarUsuario (Persona[] P, int index) {
        String temp;
        int centinela=1;
        do {
            temp = Utilidades.leerString("Usuario(-1 para cancelar)");
            if (!temp.equals("-1")) {
                temp = Utilidades.verificaExpresionRegular("\\w{6,20}", temp);
                if (temp.length()==0) {
                    System.out.println("El nombre de usuario debe contener entre 6 y 20 caracteres, intente de nuevo.");
                    centinela=0;
                }
                else {
                    for (Persona P1 : P) {
                        if (P1 instanceof Usuario) {
                            if (((Usuario) P1).getUsuario().equals(temp)) {
                                System.out.println("El nombre de usuario introducido ya está en uso.");
                                centinela=0;
                                break;
                            } else { 
                                centinela=1;
                            }
                        }
                    }
                }
            }
        } while (!temp.equals("-1")&centinela!=1);
        if (!temp.equals("-1")) {
            ((Usuario)P[index]).setUsuario(temp);
        }
    }
    
    private void actualizarContraseña (Persona[] P, int index) {
        String temp;
        int centinela=1;
        do {
            temp = Utilidades.leerString("Contraseña(-1 para cancelar)");
            if (!temp.equals("-1")) {
                temp = Utilidades.verificaExpresionRegular("\\w{8,16}", temp);
                if (temp.length()==0) {
                    System.out.println("La contraseña debe contener entre 8 y 16 caracteres, intente de nuevo.");
                    centinela=0;
                }
            }
        } while (!temp.equals("-1")&centinela!=1);
        if (!temp.equals("-1")) {
            ((Usuario)P[index]).setContraseña(temp);
        }
    }
}