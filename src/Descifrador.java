import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Descifrador {
    //El separador que usa el sistema operativo para los archivos
    /*public static String slash(){
        String slash="/";
        if(System.getProperty("os.name").startsWith("Windows")) slash="\\";
        return slash;
    }*/




    public static void main(String[] args) {
        //Separador del sistema operativo
        String slash=System.getProperty("os.name").startsWith("Windows")?"\\":"/";
        boolean fileExists=true;
        final char arrayAbecedarioMayuscula[] = new char[]{
                'A', 'B', 'C','D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        };

        final char arrayAbecedarioMinuscula[] = new char[]{
                'a', 'b', 'c','d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        };

        //Argumentos
        String nombreDelFichero=args[0];
        int key=Integer.valueOf(args[1]);



        //Archivo que hay que descifrar


        try {
            File archivo1 = new File("src"+slash+"datos"+nombreDelFichero);
            FileReader frArchivo1 = new FileReader(archivo1);
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo");
            fileExists=false;


        }finally {
            if(fileExists){

            }
        }


    }

}
