package javaapplication2programacionlogicayfuncional;
//@author PARAMO
import java.io.IOException;
import javax.swing.JOptionPane;
public class MENU 
{
    //OBJETOS DE CLASE
    ARCHIVO_MAESTRO archivo = new ARCHIVO_MAESTRO();
    //VARIABLES DE LA CLASE
    private String nombre = "";
    //METODOS DE LA CLASE
    public void MENU() throws IOException
    {
        Nombre_Archivo();
        Mostrar_Menu();
    }//Fin del constructor de la clase
    private void Nombre_Archivo()
    {
        do
        {
            nombre = JOptionPane.showInputDialog("INGRESE EL NOMBRE DEL ARCHIVO CON EL QUE VA A TRABAJAR").toLowerCase();
        }while(nombre.length() == 0);
    }//Fin del metodo
    private void Mostrar_Menu() throws IOException
    {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "ARCHIVO ACTUAL DE TRABAJO: " + nombre + "\n\n"
                + "ELIJA UNA DE LAS SIGUIENTES OPCIONES:\n\n"
                + "0: CAMBIAR ARCHIVO DE TRABAJO\n"
                + "1: CREAR BASE DE CONOCIMIENTOS.\n"
                + "2: MODIFICAR BASE DE CONOCIMIENTOS.\n"
                + "3: ELIMINAR BASE DE CONOCIMIENTOS.\n"
                + "4: LEER BASE DE CONOCIMIENTOS (SECUENCIAL).\n"
                + "5: LEER BASE DE CONOCIMIENTOS (SECUENCIAL ALEATORIA).\n"
                + "6: BUSCAR META EN BASE DE CONOCIMIENTOS.\n"
                + "7: SALIR"));
        Evaluar(opcion);
    }//Fin del metodo
    private void Evaluar(int opcion) throws IOException
    {   
        switch(opcion)
        {
            case 0://ARCHIVO ACTUAL
                Nombre_Archivo();
                break;
            case 1://CREAR BC
                archivo.Escribir(nombre);
                break;
            case 2://MODIFICAR BC
                break;
            case 3://ELIMINAR BC
                archivo.Eliminar(nombre);
                break;
            case 4://LEER BC SECUENCIAL
                archivo.Leer_secuencial_maestro(nombre);
                break;
            case 5://LEER BC
                break;
            case 6://BUSCAR META BC
                break;
            case 7://SALIR
                System.exit(0);
                break;
            default://OTRA OPCION NO PREVISTA
                JOptionPane.showMessageDialog(null, "Error: Parámetro invalido");
                break;
        }//Fin del switch
        Mostrar_Menu();
    }//Fin del metodo
}//Fin de la clase