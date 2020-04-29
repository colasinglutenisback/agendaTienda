package utilidades;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Utilidades {
    
    public static int getRandom(int max, int min){
        Random rnd = new Random();
        return rnd.nextInt((max-min)+1)+min;
    }
    
    public static String leerString (String quepide) {
        Scanner kb = new Scanner(System.in);
        System.out.print(quepide + ": ");
        return kb.nextLine();
    }
    
    public static int leerInt (String quepide) {
        int temp=0;
        Scanner kb = new Scanner(System.in);
        System.out.print(quepide + ": ");
        try {
            temp=kb.nextInt();
        }
        catch (Exception ex) {
            System.out.println("Ha ocurrido algún error al leer el dato.");
            temp=leerInt(quepide);
        }
        finally {
            return temp;
        }/*
        int temp=0;
        boolean cent = false;
        Scanner kb = new Scanner(System.in);
        System.out.print(quepide + ": ");
        do {
            if (kb.hasNextInt()) {
                temp=kb.nextInt();
                cent = true;
            }
        } while (cent);
            return temp;*/
    }
    
    public static String verificaExpresionRegular(String ER, String texto){
        String temp="";
        Pattern ver = Pattern.compile(ER);
        Matcher rap = ver.matcher(texto);
        if (rap.find())
            if (rap.group().length() != 0)
                temp = rap.group().trim();
        return temp;
    }
}