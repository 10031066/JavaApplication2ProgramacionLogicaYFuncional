package javaapplication2programacionlogicayfuncional;
/**
 *
 * @author Edgar
 */
public class Regla {
    int id;
    String cosecuente;
    Regla antecedente[][];
    public Regla(String cosecuente,int i){
        this.id = i;
        this.cosecuente = cosecuente;
    }
    public void AgregaAntecedente(Regla[] reglas){//solo agrega 1 linea, es solamente para conjunciones
        this.antecedente[0]=reglas;

    }
    private void Conjuncion(){
        
        
    }
    
}
