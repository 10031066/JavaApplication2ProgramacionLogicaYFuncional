package javaapplication2programacionlogicayfuncional;
/**
 *
 * @author Edgar
 */
public class Regla {
    int id;
    private boolean valor;
    private boolean visitado;
    String cosecuente;
    Regla antecedente[][];
    public Regla(String cosecuente,int i){
        this.id = i;
        this.cosecuente = cosecuente;
    }
    public void AgregaAntecedente(Regla[] reglas){//solo agrega 1 linea, es solamente para conjunciones
        this.antecedente[0]=reglas;
        
    }
    public void Verdadero(){
        valor=true;
        visitado=true;
    }
    public boolean Atras(){
        if(!visitado){
            visitado=true;
            boolean regresa=true;
            for(Regla temp:antecedente[0]){
                boolean temporal =temp.Atras();
                if(!temporal){
                    regresa=false;
                }
            }
            valor = regresa;
            return valor;
        }else{
            return valor;
        }
    }
}
