package Ficheros.Ejercicio9;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Scanner;

class RandomAccessUtils {

    private Scanner teclado;
    private String strNombre, strDir, strFechanac, formato;
    private static final long LONGITUD_CONTACTO = 106;
    private int id, cp, tlf, falseLogicID, lastID;
    private float cantidad;
    private boolean debeDinero, noTaBorrao;
    private char dir[], fechanac[], nombre[];
    private File ficherOrigen;

    RandomAccessUtils() {
        ficherOrigen = new File("NuevoDirectorio/binaryRandom.dat");
        nombre = new char[14];
        fechanac = new char[10];
        dir = new char[20];
        teclado = new Scanner(System.in);
        formato = "Contacto %d; Nombre: %s; Teléfono: %d; " +
                "Dirección: %s; Código Postal: %d; Fecha de nacimiento: %s; ¿Debe dinero? %b; Cantidad: %.2f€;\n";
    }

    void requestCharContactByID() {
        try {
            System.out.print("Introduce el ID del contacto que buscas: ");
            int op = teclado.nextInt();

            RandomAccessFile randomFileLectura = getRandomAccess("r");
            long posicion = (op - 1) * LONGITUD_CONTACTO;
            if (posicion >= randomFileLectura.length()) {
                System.out.println("El empleado no existe\n");
            } else {
                randomFileLectura.seek(posicion);
                strNombre = readValueToString(randomFileLectura, nombre);

                id = randomFileLectura.readInt();
                noTaBorrao = randomFileLectura.readBoolean();

                tlf = randomFileLectura.readInt();
                strDir = readValueToString(randomFileLectura, dir);
                cp = randomFileLectura.readInt();
                strFechanac = readValueToString(randomFileLectura, fechanac);
                debeDinero = randomFileLectura.readBoolean();
                cantidad = randomFileLectura.readFloat();

                if (noTaBorrao) {
                    System.out.printf(formato, id, strNombre, tlf, strDir,
                            cp, strFechanac, debeDinero, cantidad);
                    System.out.println();
                } else {
                    System.out.println("Contacto no encontrado\n");
                }
            }
            randomFileLectura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void requestUTFContactByID() {
        try {
            System.out.print("Introduce el ID del contacto que buscas: ");
            int op = teclado.nextInt();

            RandomAccessFile randomFileLectura = getRandomAccess("r");
            long posicion = (op - 1) * LONGITUD_CONTACTO;
            if (posicion >= randomFileLectura.length()) {
                System.out.println("El empleado no existe\n");
            } else {
                randomFileLectura.seek(posicion);
                strNombre = randomFileLectura.readUTF();

                id = randomFileLectura.readInt();
                noTaBorrao = randomFileLectura.readBoolean();

                tlf = randomFileLectura.readInt();
                strDir = randomFileLectura.readUTF();
                cp = randomFileLectura.readInt();
                strFechanac = randomFileLectura.readUTF();
                debeDinero = randomFileLectura.readBoolean();
                cantidad = randomFileLectura.readFloat();

                if (noTaBorrao) {
                    System.out.printf(formato, id, formatStringToRead(strNombre), tlf, formatStringToRead(strDir),
                            cp, formatStringToRead(strFechanac), debeDinero, cantidad);
                    System.out.println();
                } else {
                    System.out.println("Contacto no encontrado\n");
                }
            }
            randomFileLectura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void requestAllCharContacts(boolean mostrar) {
        long pos = 0;
        try {
            RandomAccessFile randomFileLectura = getRandomAccess("r");
            try {
                do {
                    randomFileLectura.seek(pos);

                    strNombre = readValueToString(randomFileLectura, nombre);
                    id = randomFileLectura.readInt();
                    noTaBorrao = randomFileLectura.readBoolean();
                    tlf = randomFileLectura.readInt();
                    strDir = readValueToString(randomFileLectura, dir);
                    cp = randomFileLectura.readInt();
                    strFechanac = readValueToString(randomFileLectura, fechanac);
                    debeDinero = randomFileLectura.readBoolean();
                    cantidad = randomFileLectura.readFloat();

                    getLastIndex(id);
                    if (mostrar) {
                        if (id > 0 && noTaBorrao) {
                            System.out.printf(formato, id, strNombre, tlf, strDir,
                                    cp, strFechanac, debeDinero, cantidad);
                        }
                    }
                    pos += LONGITUD_CONTACTO;

                } while (randomFileLectura.getFilePointer() != randomFileLectura.length());
            } catch (EOFException ex) {
                System.out.println("Fin de lectura de contactos\n");
            }
            randomFileLectura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void requestAllUTFContacts(@SuppressWarnings("SameParameterValue") boolean mostrar) {
        long pos = 0;
        try {
            RandomAccessFile randomFileLectura = getRandomAccess("r");
            String nom, dir, fecha;
            try {
                do {
                    randomFileLectura.seek(pos);

                    nom = randomFileLectura.readUTF();
                    id = randomFileLectura.readInt();
                    noTaBorrao = randomFileLectura.readBoolean();
                    tlf = randomFileLectura.readInt();
                    dir = randomFileLectura.readUTF();
                    cp = randomFileLectura.readInt();
                    fecha = randomFileLectura.readUTF();
                    debeDinero = randomFileLectura.readBoolean();
                    cantidad = randomFileLectura.readFloat();

                    getLastIndex(id);
                    if (mostrar) {
                        if (id > 0 && noTaBorrao) {
                            System.out.printf(formato, id, formatStringToRead(nom), tlf, formatStringToRead(dir),
                                    cp, formatStringToRead(fecha), debeDinero, cantidad);
                        }
                    }
                    pos += LONGITUD_CONTACTO;

                } while (randomFileLectura.getFilePointer() != randomFileLectura.length());
            } catch (EOFException ex) {
                System.out.println("Fin de lectura de contactos\n");
            }
            randomFileLectura.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    private String readValueToString(RandomAccessFile f, @NotNull char[] arrayChar) throws IOException {
        char aux;
        for (int i = 0; i < arrayChar.length; i++) {
            aux = f.readChar();
            arrayChar[i] = aux;
        }
        return String.valueOf(arrayChar);
    }

    void logicalDeleteByID() {
        try {
            System.out.print("Introduce el ID del contacto para su borrado: ");
            int op = teclado.nextInt();

            long posicion = ((op - 1) * LONGITUD_CONTACTO) + 32;
            RandomAccessFile randomFileLecEscr = getRandomAccess("rw");
            if (posicion >= randomFileLecEscr.length()) {
                System.out.println("El empleado no existe\n");
            } else {
                randomFileLecEscr.seek(posicion);

                randomFileLecEscr.writeBoolean(false);
                System.out.printf("Contacto %d borrado por la gracia de Dios\n", op);
            }
            randomFileLecEscr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void modifyDebtsByID() {
        System.out.print("Introduce el ID del contacto para modificar su deuda: ");
        int op = teclado.nextInt();
        boolean esDeudor;
        float deuda;

        long posicion = ((op - 1) * LONGITUD_CONTACTO) + 101;
        RandomAccessFile randomFileLecEscr = getRandomAccess("rw");
        try {
            if (posicion >= randomFileLecEscr.length()) {
                System.out.println("El empleado no existe\n");
            } else {
                if (isContactTrueLogic(randomFileLecEscr, op)) {
                    randomFileLecEscr.seek(posicion);

                    esDeudor = randomFileLecEscr.readBoolean();
                    deuda = randomFileLecEscr.readFloat();
                    if (esDeudor) {
                        System.out.printf("El contacto %d tiene una deuda de %.2f€\n", op, deuda);
                        System.out.print("Cantidad que debe actualmente: ");

                        float cantidad = teclado.nextFloat();
                        System.out.println();

                        randomFileLecEscr.seek(posicion + 1);
                        randomFileLecEscr.writeFloat(cantidad);
                        System.out.printf("Deuda modificada de %.2f€ a %.2f€\n", deuda, cantidad);
                        if (cantidad == 0) {
                            randomFileLecEscr.seek(posicion);
                            randomFileLecEscr.writeBoolean(false);
                            System.out.printf("La deuda del Contacto %d ha sido saldada\n", op);
                        }
                    } else {
                        System.out.printf("El Contacto %d no era un moroso hasta ahora.\n", op);
                        System.out.printf("Cantidad que debe el contacto %d: ", op);

                        float cantidad = teclado.nextFloat();
                        System.out.println();

                        randomFileLecEscr.seek(posicion);
                        randomFileLecEscr.writeBoolean(true);
                        randomFileLecEscr.writeFloat(cantidad);
                        System.out.printf("El contacto %d es ahora un moroso que debe %.2f€\n", op, cantidad);
                    }
                } else {
                    System.out.println("El contacto no existe o fue borrado\n");
                }
                randomFileLecEscr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private RandomAccessFile getRandomAccess(String accessMode) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(ficherOrigen, accessMode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }

    private boolean isContactTrueLogic(@NotNull RandomAccessFile f, int id) {
        /*No hago el file.close() aquí porque se hace en el método donde se le llama*/
        boolean borrado = false;

        long posicion = ((id - 1) * LONGITUD_CONTACTO) + 32;
        try {
            if (posicion >= f.length()) {
                System.out.println("El empleado no existe\n");
            } else {
                f.seek(posicion);
                borrado = f.readBoolean();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return borrado;
    }

    private void addContactByCharsLastPosition() {
        RandomAccessFile file = getRandomAccess("rw");
        requestAllCharContacts(false);
        requestNewContact();
        StringBuffer buffNombre;
        StringBuffer buffDir;
        StringBuffer buffFecha_nac;

        try {
            file.seek(file.length());

            buffNombre = new StringBuffer(strNombre);
            buffNombre.setLength(14);
            file.writeChars(buffNombre.toString()); //nombre

            file.writeInt(lastID);
            file.writeBoolean(true);

            file.writeInt(tlf); //tlf

            buffDir = new StringBuffer(strDir);
            buffDir.setLength(20);
            file.writeChars(buffDir.toString()); //dir

            file.writeInt(cp); //cp

            buffFecha_nac = new StringBuffer(strFechanac);
            buffFecha_nac.setLength(10);
            file.writeChars(buffFecha_nac.toString()); //fecha_nacimiento

            file.writeBoolean(debeDinero); //money (debe dinero?)
            file.writeFloat(cantidad); //cantidad
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void addContactByUTFLastPosition() {
        RandomAccessFile file = getRandomAccess("rw");
        requestAllUTFContacts(true);
        requestNewContact();
        String nombre = utfConverter(strNombre, 14);
        String dir = utfConverter(strDir, 20);
        String nac = utfConverter(strFechanac, 10);
        try {
            file.seek(file.length());

            file.writeUTF(nombre);//nombre
            file.writeInt(lastID);
            file.writeBoolean(true);
            file.writeInt(tlf); //tlf
            file.writeUTF(dir);//dir
            file.writeInt(cp); //cp
            file.writeUTF(nac);//fecha_nacimiento
            file.writeBoolean(debeDinero); //money (debe dinero?)
            file.writeFloat(cantidad); //cantidad

            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void addContactByUTFFirstFreePos() {
        RandomAccessFile file = getRandomAccess("rw");
        requestNewContact();
        String nombre = utfConverter(strNombre, 14);
        String dir = utfConverter(strDir, 20);
        String nac = utfConverter(strFechanac, 10);
        try {
            file.seek(posOnLogicFalse());

            file.writeUTF(nombre);//nombre
            file.writeInt(lastID);
            file.writeBoolean(true);
            file.writeInt(tlf); //tlf
            file.writeUTF(dir);//dir
            file.writeInt(cp); //cp
            file.writeUTF(nac);//fecha_nacimiento
            file.writeBoolean(debeDinero); //money (debe dinero?)
            file.writeFloat(cantidad); //cantidad

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addContactByCharsFirstFreePos() {
        RandomAccessFile file = getRandomAccess("rw");
        StringBuffer buffNombre;
        StringBuffer buffDir;
        StringBuffer buffFecha_nac;
        requestNewContact();
        try {
            file.seek(posOnLogicFalse());

            buffNombre = new StringBuffer(strNombre);
            buffNombre.setLength(14);
            file.writeChars(buffNombre.toString()); //nombre

            file.writeInt(falseLogicID);
            file.writeBoolean(true);

            file.writeInt(tlf); //tlf

            buffDir = new StringBuffer(strDir);
            buffDir.setLength(20);
            file.writeChars(buffDir.toString()); //dir

            file.writeInt(cp); //cp

            buffFecha_nac = new StringBuffer(strFechanac);
            buffFecha_nac.setLength(10);
            file.writeChars(buffFecha_nac.toString()); //fecha_nacimiento

            file.writeBoolean(debeDinero); //money (debe dinero?)
            file.writeFloat(cantidad); //cantidad
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long posOnLogicFalse() {
        long pos = 28;
        boolean found = false;
        RandomAccessFile file = getRandomAccess("r");
        try {
            try {
                do {
                    file.seek(pos);
                    falseLogicID = file.readInt();
                    found = file.readBoolean();
                    pos += LONGITUD_CONTACTO;
                } while (found);
            } catch (EOFException ex) {
                System.out.println("No hay ningún contacto borrado lógicamente. Se añadirá al final del fichero.");
                falseLogicID++;
                pos = file.length();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!found) {
            pos = (pos - LONGITUD_CONTACTO) - 28;
        }
        /*Devolverá la posición donde debe empezar a reescribir el contacto. Si es el contacto 1
         * está borrado lógicamente, nos posicionará en 0*/
        return pos;
    }

    private void getLastIndex(int lastID) {
        this.lastID = lastID + 1;
    }

    private void requestNewContact() {
        System.out.print("Nombre: ");
        strNombre = teclado.next();
        System.out.print("Teléfono: ");
        tlf = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Dirección: ");
        strDir = teclado.nextLine();
        System.out.print("C.Postal: ");
        cp = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Fecha nacimiento: ");
        strFechanac = teclado.nextLine();
        System.out.print("¿Debo dinero?: ");
        debeDinero = teclado.nextBoolean();
        if (debeDinero) {
            System.out.print("Cantidad: ");
            cantidad = teclado.nextFloat();
        } else {
            cantidad = 0;
        }
    }

    void writeCharsContacts() {
        boolean startOrEnd;
        System.out.print("¿1era posición libre[true] o final de fichero[false]? -> ");
        startOrEnd = teclado.nextBoolean();
        if (startOrEnd) {
            addContactByCharsFirstFreePos();
        } else {
            addContactByCharsLastPosition();
        }
    }

    void writeUTFContacts() {
        boolean startOrEnd;
        System.out.print("¿1era posición libre[true] o final de fichero[false]? -> ");
        startOrEnd = teclado.nextBoolean();
        if (startOrEnd) {
            addContactByUTFFirstFreePos();
        } else {
            addContactByUTFLastPosition();
        }
    }

    void depurarFicheroWithChars() throws IOException {
        /*<----Utilizando el fichero original, copiar a otro fichero todos los contactos con el boolean lógico a true---->*/
        File ficheroCompacto = new File("NuevoDirectorio/binaryRandomCompacted.dat");
        RandomAccessFile ficheroToDepurar = new RandomAccessFile(ficheroCompacto, "rw");
        RandomAccessFile fileOrigen = getRandomAccess("r");
        StringBuffer buffNombre;
        StringBuffer buffDir;
        StringBuffer buffFecha_nac;

        long pos = 32;
        int vueltas = 1;
        /*<----Reordenar los ids de los contactos.---->*/
        try {
            do {
                fileOrigen.seek(pos);

                if (fileOrigen.readBoolean()) {
                    pos = pos - 32;
                    fileOrigen.seek(pos);

                    buffNombre = new StringBuffer(readValueToString(fileOrigen, nombre));
                    buffNombre.setLength(14);
                    ficheroToDepurar.writeChars(buffNombre.toString()); //nombre

                    fileOrigen.readInt(); /*Aunque no los utilice en la escritura, hay que declarar la lectura para que
                    no se pierdan los bytes y se pueda completar sin problemas*/
                    fileOrigen.readBoolean();

                    ficheroToDepurar.writeInt(vueltas);
                    ficheroToDepurar.writeBoolean(true);

                    ficheroToDepurar.writeInt(fileOrigen.readInt()); //tlf

                    buffDir = new StringBuffer(readValueToString(fileOrigen, dir));
                    buffDir.setLength(20);
                    ficheroToDepurar.writeChars(buffDir.toString()); //dir

                    ficheroToDepurar.writeInt(fileOrigen.readInt()); //cp

                    buffFecha_nac = new StringBuffer(readValueToString(fileOrigen, fechanac));
                    buffFecha_nac.setLength(10);
                    ficheroToDepurar.writeChars(buffFecha_nac.toString()); //fecha_nacimiento

                    ficheroToDepurar.writeBoolean(fileOrigen.readBoolean()); //money (debe dinero?)
                    ficheroToDepurar.writeFloat(fileOrigen.readFloat()); //cantidad

                    vueltas++;
                    System.out.println("Contacto copiado");
                    pos += LONGITUD_CONTACTO + 32;
                } else {
                    pos += LONGITUD_CONTACTO;
                }

            } while (fileOrigen.getFilePointer() != fileOrigen.length());
        } catch (EOFException ex) {
            System.out.println("Fin de copiado para compactación");
        }
        fileOrigen.close();
        ficheroToDepurar.close();
        System.out.println("Reordenación de IDs completada. Fichero compactado al 100%");

        /*<----Una vez copiado, borrar el fichero original. Renombrar el fichero nuevo como el anterior, exactamente igual---->*/
        System.out.println("El fichero original " + (ficherOrigen.delete() ? "ha sido borrado" : "no ha podido ser borrado"));
        System.out.println("El fichero " + (ficheroCompacto.renameTo(new File("NuevoDirectorio/binaryRandom.dat"))
                ? "ha sido renombrado" : "no ha podido ser renombrado"));
    }

    static String utfConverter(String cadena, int stringLength) {
        String stringFinal = cadena;
        int stringLengthFinal = ((stringLength * 2) - 2) - cadena.length();

        for (int i = 0; i < stringLengthFinal; i++) stringFinal = stringFinal.concat(" ");

        return stringFinal;
    }

    private String formatStringToRead(String cadena) {
        /*Al convertir en utf concatenamos espacios para llenar los bytes. A la hora de leer el valor,
         * también saldrán los espacios. Formatear el string de utf para que salga el valor sin espacios a la derecha*/
        char readValue;
        /*La condición a la hora de cortar sería encontrarse dos espacios, ya que si solo hay uno podría tratarse de
         * un nombre compuesto*/
        for (int i = 0; i < cadena.length(); i++) {
            readValue = cadena.charAt(i);
            if (Character.isWhitespace(readValue) && Character.isWhitespace(cadena.charAt(i + 1))) {
                return cadena.substring(0, i);
            }
        }
        return cadena;
    }
}
