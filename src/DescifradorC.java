
public class DescifradorC {
    String mensaje;
    char letra;
    int key;
    int pos;
    boolean mayuscula;

    final char arrayAbecedario[] = new char[]{
            'A', 'B', 'C','D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
    };

    final char arrayAbecedarioMinuscula[] = new char[]{
            'a', 'b', 'c','d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
    };



        /*
        //Recorre el abecedario para averiguar la posición de la letra que hay que descifrar.(PARA MAYUSCULAS)
        for(int i=0;i<arrayAbecedario.length;i++){
            if(letra==arrayAbecedario[i]){

            }
        }

        //Recorre el abecedario en minuscula
        for(int i=0;i<arrayAbecedarioMinuscula.length;i++){
            if(letra==arrayAbecedarioMinuscula[i]){
            }
        }
        */

}
