import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Laberinto {
    
    Casilla Laberinto [][] ;
    Casilla casFinal = new Casilla();
    Casilla iniCamino = new Casilla();
    List<Casilla> camino = new ArrayList<Casilla>();
    List<Casilla> visitadas = new ArrayList<Casilla>();  
    
    

    public Laberinto(int hor,int ver){
        Laberinto  = new Casilla[hor][ver];
        for(int i=0;i<Laberinto.length;i++){
            for(int j=0;j<Laberinto[0].length;j++){
                Casilla cas = new Casilla (i,j);
                Laberinto[i][j] = cas;
            }
        }
        casFinal = casillaAleatoria();
        iniCamino = casillaAleatoria();
    }

    
    
    //Método para comprobar si la casilla en la que estamos se encuentra en el borde del tablero.
    public static int comprobarBordes(int mat[][], int i, int j) {
    	int opcion=-1;
    	//Primera fila.
    	if(i==0) {
    		if(j==0) {//Esquina superior izquierda.
    			opcion = 0;
    		}else if(j==mat[0].length-1) { //Esquina superior derecha.
    			opcion = 1;
    		}else opcion= 2; //Demás componentes de la primera fila.
    	}
    	//Última fila
    	else if(i==mat.length-1) {
    		if(j==0) { //Esquina inferior izquierda.
    			opcion = 3;
    		}else if(j==mat[0].length-1) { //Esquina inferior derecha.
    			opcion = 4;
    		}else opcion = 5; //Demás componentes de la última fila.
    	}
    	else if(j==0) {//Componentes de la primera columna que no hacen esquina.
    		opcion = 6;
    	}else opcion = 7; //Componentes de la ultima columna que o hacen esquina.
    	
    	return opcion; //Si retornamos -1 es que no nos encontramos en el borde del tablero.
    }
    
    //Método que retorna la siguiente casilla:
    public static int[] siguienteCasilla(int i,int j,int pared){
    	int siguiente[] = new int[2];
    	switch(pared) {
    		case 0:
    			siguiente[0]=--i;
    			siguiente[1]=j;
    			break;
    		case 1:
    			siguiente[0]=i;
    			siguiente[1]=++j;
    			break;
    		case 2:
    			siguiente[0]=++i;
    			siguiente[1]=j;
    			break;
    		case 3:
    			siguiente[0]=i;
    			siguiente[1]=--j;
    			break;
    		default:
    			System.out.println("holisssss");
    			
    	}
    	
    	return siguiente;
    }
    
    //Operaciones segun la posicion en la que se encuentre la casilla en la que vamos a operar.
    public static void posicion(int opcion) {
    	switch(opcion) {
    	case 0:
    		System.out.println("Esquina superior izquierda");
    		break;
    	case 1:
    		System.out.println("Esquina superior derecha");
    		break;
    	case 2:
    		System.out.println("borde superior");
    		break;
    	case 3:
    		System.out.println("Esquina inferior izquierda");
    		break;
    	case 4:
    		System.out.println("Esquina inferior derecha");
    		break;
    	case 5:
    		System.out.println("Borde inferior");
    		break;
    	case 6:
    		System.out.println("Borde izquierdo");
    		break;
    	case 7:
    		System.out.println("Borde derecho");
    		break;
    	default:
    		System.out.println("No pertenece al borde");
    	}
    }
    
    //Método para generar las posiciones de una casilla aleatoria.
    public Casilla casillaAleatoria() {
        Random r = new Random();
        int i = r.nextInt(Laberinto.length)+1;
        int j = r.nextInt(Laberinto[0].length)+1;
        if (Laberinto[i-1][j-1].getVisitado()==false){
            return Laberinto[i-1][j-1];
        }else
            return casillaAleatoria();
    }
    
}
