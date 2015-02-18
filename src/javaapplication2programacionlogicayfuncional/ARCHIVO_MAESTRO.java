package javaapplication2programacionlogicayfuncional;
//@author PARAMO
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class ARCHIVO_MAESTRO 
{
    //VARIABLES DE LA CLASE
    private String regla;
    private int tam_fijo = 15,
                long_act = 1,
                long_max = 1;
    //METODOS DE LA CLASE
    public void Escribir(String nombre) throws IOException
    {
        int n;
        StringBuffer buffer = null;
        System.out.println("ARCHIVO MAESTRO");
        RandomAccessFile archi = new RandomAccessFile(nombre, "rw");
        Scanner entrada = new Scanner(System.in);
        do
        {
            System.out.println("INGRESE UNA REGLA");
            regla = entrada.next().toLowerCase();
            buffer = new StringBuffer(regla);
            buffer.setLength(tam_fijo);
            archi.writeChars(buffer.toString());
            Num_Antecedentes(regla);
            System.out.println("¿Otro hecho?: SI=1; NO=0 ");
            n = entrada.nextInt();
        }while(n == 1);
        archi.close();
        System.out.println("EL ARCHIVO '" + nombre + "' se creo satisfactoriamente");
    }//Fin del metodo
    public void Eliminar(String nombre)
    {
        try 
        {
            File archivo = new File(nombre);
            if (!archivo.delete())
                throw new Exception("El archivo '" + nombre + "' no puede ser borrado.");
            else
                System.out.println("El archivo " + nombre + " fue eliminado satisfactoriamente.");
        } catch (Exception e){}
    }//Fin del metodo
    public void Leer_secuencial_maestro(String nombre) throws IOException
    {
        long ap_actual = 0,
             ap_final = 0;
        RandomAccessFile leer_archi = new RandomAccessFile(nombre, "r");
        System.out.println("LECTURA DEL ARCHIVO MAESTRO");
        while((ap_actual = leer_archi.getFilePointer()) != (ap_final = leer_archi.length()))
        {
            char reglas[] = new char[tam_fijo],
                 temp;
            for (int i=0 ; i<reglas.length ; i++) 
            {
                temp = leer_archi.readChar();
                reglas[i] = temp;
                if(temp == '^')
                    long_act++;
            }//Fin del ciclo
            if(long_act > long_max)
                this.long_max = long_act;
            long_act = 1;
            new String(reglas).replace('\0', ' ');
            System.out.println(reglas);
        }//Fin del ciclo
        leer_archi.close();
        System.out.println("Hay un máximo de: " + long_max + " antecedentes");
    }//Fin del metodo
    private void Num_Antecedentes(String regla)
    {
        char c;
        for (int i=0 ; i<regla.length(); i++) 
        {
            c = regla.charAt(i);
            if(c == '^')
                long_act++;
        }
        if(long_act > long_max)
            this.long_max = long_act;
        //System.out.println("Numero de antecedentes: " + long_act);
        long_act = 1;
    }
}//Fin de la clase