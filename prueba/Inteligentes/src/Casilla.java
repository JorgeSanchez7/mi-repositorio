import java.util.ArrayList;
import java.util.List;

public class Casilla {
    
    int i;
    int j;
    boolean visitado;
    List<Boolean> Lados = new ArrayList<Boolean>();

    public Casilla (int i,int j){

        this.i = i;
        this.j = j;
        visitado=false;
        //[Norte,Este,Sur,Oeste]
        Lados.add(false); //Norte
        Lados.add(false); //Este
        Lados.add(false); //Sur
        Lados.add(false); //Oeste

    }

    public Casilla(){}

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }

    public boolean getVisitado(){
        return visitado;
    }


    public void setVisitado(boolean vis){
        this.visitado=vis;
    }

    public void quitarPared(int a){
        Lados.set(a,true);
    }

    @Override
    public String toString() {
        return "{ i : "+ i + 
        "\n j : "+ j +
        "\n Visitado : " + visitado + 
        "\n Posiciones: [ norte : " + Lados.get(0) + " | Este : " + Lados.get(1) + " | Sur : " + Lados.get(2) + " | Oeste : " + Lados.get(3)+" ]}";

    }
    
}
