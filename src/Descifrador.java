import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Descifrador {





    public static void main(String[] args){
    //Declaración de variables
        //Separador espedifico del sistema operativo
        String slash=System.getProperty("os.name").startsWith("Windows")?"\\":"/";

        final char []arrayAbecedarioMayuscula = new char[]{
                'A', 'B', 'C','D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        };

        final char []arrayAbecedarioMinuscula = new char[]{
                'a', 'b', 'c','d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        };

        //Argumentos
        String nombreDelFichero=args[0];
        int key=Integer.valueOf(args[1]);
        //Archivo que hay que descifrar







        File archivo1 = new File("src"+slash+"datos"+slash+nombreDelFichero);
        if(args.length==2) {
            if (archivo1.exists()) {
                try {
                    int character='1';
                    int pos;

                    System.out.println("Starting");


                    FileReader frArchivo1 = new FileReader(archivo1);

                    //character agarra la primera letra, si no la hay agarra -1
                    character=frArchivo1.read();
                    while(character!=-1) {
                        ;
                        //Para cada caracter del archivo:
                        //
                        for (int i=0; i<arrayAbecedarioMayuscula.length-1;i++) {
                            if(arrayAbecedarioMayuscula[i]==(char)character){
                                System.out.print(arrayAbecedarioMayuscula[(i-key)%arrayAbecedarioMayuscula.length]);
                            }
                        }

                        for (int i=0; i<arrayAbecedarioMinuscula.length-1;i++) {
                            if(arrayAbecedarioMinuscula[i]==(char)character){
                                System.out.print(arrayAbecedarioMinuscula[(i-key)%arrayAbecedarioMayuscula.length]);
                            }
                        }



                        /////////////////////



                        character=frArchivo1.read();




                    }













                    //! Cierra el archivo
                    frArchivo1.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();


                }catch (IOException e){
                    e.printStackTrace();
                }
            } else {
                System.out.println("No se ha encontrado el archivo");
            }
        }else{
            System.out.println("Comprueba el número de argumentos");
        }




    }

}
