import java.io.*;

public class Descifrador {

    public static void main(String[] args){

        //Separador espedifico del sistema operativo
        final String slash = System.getProperty("os.name").startsWith("Windows") ? "\\" : "/";


        final char[] arrayAbecedarioMayuscula = new char[]{
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        };

        final char[] arrayAbecedarioMinuscula = new char[]{
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        };

        if (args.length == 2 ) {//Hacen falta 2 argumentos y un fichero con extensión
            if(args[0].contains(".")){
                //Argumentos
                final String nombreDelFichero = args[0];    //Nombre del fichero que hay que descifrar
                final int key = Integer.parseInt(args[1]);  //Clave


                //Separa el nombre del fichero de la extensión.   archivo  .txt
                final String nombreDelFichroSinExtension = nombreDelFichero.substring(0, nombreDelFichero.lastIndexOf("."));
                final String extensionDelFichero = nombreDelFichero.contains(".")?nombreDelFichero.substring(nombreDelFichero.lastIndexOf(".")):"";


                //Archivo que hay que descifrar
                final File archivo1 = new File("src" + slash + "datos" + slash + nombreDelFichero);
                //Archivo nuevo que almacena el resultado
                final File archivoNuevo1 = new File("src" + slash + "datos" + slash + nombreDelFichroSinExtension + ".nuevo" + extensionDelFichero);


                if (archivo1.exists() && archivoNuevo1.exists() ) {

                    try {
                        FileReader frArchivo1 = new FileReader(archivo1);
                        FileWriter fwArchivoNuevo1 = new FileWriter(archivoNuevo1);


                        int character = frArchivo1.read();
                        boolean isLetter;//Almacena en cada vuelta del siguiente while si el character que maneja es una letra o no
                        while (character != -1) {
                            isLetter = false;
                            //Para cada caracter del archivo:
                            //
                            for (int i = 0; i < arrayAbecedarioMayuscula.length; i++) {

                                if (key < 0) {
                                    if (arrayAbecedarioMayuscula[i] == (char) character) {
                                        fwArchivoNuevo1.write(arrayAbecedarioMayuscula[(i + key) % arrayAbecedarioMayuscula.length]);
                                        isLetter = true;
                                    }

                                    if (arrayAbecedarioMinuscula[i] == (char) character) {
                                        fwArchivoNuevo1.write(arrayAbecedarioMinuscula[(i + key) % arrayAbecedarioMinuscula.length]);
                                        isLetter = true;
                                    }

                                }


                            }

                            if (key > 0) {
                                for (int i = 0; i < arrayAbecedarioMinuscula.length; i++) {
                                    if (key > 0) {
                                        if (arrayAbecedarioMinuscula[i] == (char) character) {
                                            fwArchivoNuevo1.write(arrayAbecedarioMinuscula[(i + key) % arrayAbecedarioMinuscula.length]);
                                            isLetter = true;
                                        }
                                        if (arrayAbecedarioMayuscula[i] == (char) character) {
                                            fwArchivoNuevo1.write(arrayAbecedarioMayuscula[(i + key) % arrayAbecedarioMayuscula.length]);
                                            isLetter = true;


                                        }

                                    }


                                }
                            }


                            if (!isLetter || key == 0) {//Si no es una letra imprime el carácter directamente
                                fwArchivoNuevo1.write((char) character);
                            }
                            character = frArchivo1.read();
                        }//FIN DEL WHILE

                        //! Cierra el archivo
                        frArchivo1.close();
                        //Escribe el resultado en el fichero

                        fwArchivoNuevo1.close();    //Cierra el FileWriter y se escriben los cambios en el fichero.
                    } catch (IOException e) {//Fin del try
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No se ha encontrado el archivo");
                }

            } else {
                System.out.println("falta extension");
            }


        }else{System.out.println("Debes proporcionar una extensión al fichero");}
    }

}