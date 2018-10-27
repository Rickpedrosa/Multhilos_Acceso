package Ficheros.Ejercicio9;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Scanner;

public class RandomMenu {

    private Scanner teclado;
    private String strNombre, strDir, strFechanac, formato;
    private static final long LONGITUD_CONTACTO = 106;
    private int id, cp, tlf;
    private float cantidad;
    private boolean debeDinero, noTaBorrao;
    private char dir[], fechanac[], nombre[];
    private int lastID;
    private long lastPos;
    private File ficherOrigen;

    public static void main(String[] args) {
        RandomMenu r = new RandomMenu();
    }

    private RandomMenu() {
        ficherOrigen = new File("E:\\2dam\\prog_movil\\IdeaProjects\\MA\\NuevoDirectorio\\binaryRandom.dat");
        nombre = new char[14];
        fechanac = new char[10];
        dir = new char[20];
        teclado = new Scanner(System.in);
        formato = "Contacto %d; Nombre: %s; Teléfono: %d; " +
                "Dirección: %s; Código Postal: %d; Fecha de nacimiento: %s; ¿Debe dinero? %b; Cantidad: %.2f€;\n";
        initApp();
    }

    private void initApp() {
        if (ficherOrigen.exists()) {
            menu();
        } else {
            ToCopyRandomFile.copyFiletoRandomFile();
            initApp();
        }
    }

    public void menu() {
        System.out.println("****************MENÚ***************");
        System.out.println("1. Consultar todos los contactos");
        System.out.println("2. Consultar contacto por ID");
        System.out.println("3. Añadir nuevo contacto");
        System.out.println("4. Borrar contacto por ID");
        System.out.println("5. Modificar deudas por ID");
        System.out.println("6. Compactación del fichero");
        System.out.println("7. Borrar fichero de origen");
        System.out.println("0. Salir");
        System.out.println("**********************************\n");

        System.out.print("Escribe el número del menú: ");
        int op = teclado.nextInt();
        switch (op) {
            //Hacer dos versiones: con writeChars y writeUTF
            case 0:
                System.exit(0);
                break;
            case 1:
                consultarContactos(true);
                menu();
                break;
            case 2:
                consultarContactosPorID();
                menu();
                break;
            case 3:
                //Añadir contacto 1)Por el final 2)Primera pos libre
                System.out.println("En construcción");
                charsOrUTFUltPos();
                menu();
                break;
            case 4:
                borradoLogicoPorID();
                menu();
                break;
            case 5:
                modificarDeudasPorID();
                menu();
                break;
            case 6:
                //Compactación del fichero
                System.out.println("En construcción");
                System.out.println(posOnLogicFalse());
                menu();
                break;
            case 7:
                //noinspection ResultOfMethodCallIgnored
                ficherOrigen.delete();
                System.out.println("Fichero borrado");
                System.exit(0);
                break;
        }
    }

    private void consultarContactosPorID() {
        try {
            System.out.print("Introduce el ID del contacto que buscas: ");
            int op = teclado.nextInt();

            RandomAccessFile randomFileLectura = getRandomAccess("r");
            long posicion = (op - 1) * LONGITUD_CONTACTO;
            if (posicion >= randomFileLectura.length()) {
                System.out.println("El empleado no existe\n");
            } else {
                randomFileLectura.seek(posicion);

                id = randomFileLectura.readInt();
                noTaBorrao = randomFileLectura.readBoolean();

                strNombre = readValueToString(randomFileLectura, nombre);
                tlf = randomFileLectura.readInt();
                strDir = readValueToString(randomFileLectura, dir);
                cp = randomFileLectura.readInt();
                strFechanac = readValueToString(randomFileLectura, fechanac);
                debeDinero = randomFileLectura.readBoolean();
                cantidad = randomFileLectura.readFloat();

                if (noTaBorrao) {
                    System.out.printf(formato, id, strNombre, tlf, strDir, cp, strFechanac, debeDinero, cantidad);
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

    private void consultarContactos(boolean mostrar) {
        long pos = 0;
        try {
            RandomAccessFile randomFileLectura = getRandomAccess("r");
            try {
                do {
                    randomFileLectura.seek(pos);

                    id = randomFileLectura.readInt();
                    noTaBorrao = randomFileLectura.readBoolean();
                    strNombre = readValueToString(randomFileLectura, nombre);
                    tlf = randomFileLectura.readInt();
                    strDir = readValueToString(randomFileLectura, dir);
                    cp = randomFileLectura.readInt();
                    strFechanac = readValueToString(randomFileLectura, fechanac);
                    debeDinero = randomFileLectura.readBoolean();
                    cantidad = randomFileLectura.readFloat();

                    getLastIndex(id);
                    if (mostrar) {
                        if (id > 0 && noTaBorrao) {
                            System.out.printf(formato, id, strNombre, tlf, strDir, cp, strFechanac, debeDinero, cantidad);
                        }
                    }
                    pos += LONGITUD_CONTACTO;
                    getLastPos(pos);

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

    private void borradoLogicoPorID() {
        try {
            System.out.print("Introduce el ID del contacto para su borrado: ");
            int op = teclado.nextInt();

            long posicion = ((op - 1) * LONGITUD_CONTACTO) + 4;
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

    private void modificarDeudasPorID() {
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
                if (isContactoTrueLogic(randomFileLecEscr, op)) {
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

    private boolean isContactoTrueLogic(@NotNull RandomAccessFile f, int id) {
        /*No hago el file.close() aquí porque se hace en el método donde se le llama*/
        boolean borrado = false;

        long posicion = ((id - 1) * LONGITUD_CONTACTO) + 4;
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

    private void addContatoPorCharsUltPos() {
        RandomAccessFile file = getRandomAccess("rw");
        consultarContactos(false);
        solicitarContacto();
        StringBuffer buffNombre;
        StringBuffer buffDir;
        StringBuffer buffFecha_nac;

        try {
            file.seek(lastPos);
            file.writeInt(lastID);
            file.writeBoolean(true);

            buffNombre = new StringBuffer(strNombre);
            buffNombre.setLength(14);
            file.writeChars(buffNombre.toString()); //nombre

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

    private void addContatoPorCharsFirstFreePos() {
        //1.Recorrer el fichero hasta encontrar un "noTaBorrao" en false, es decir, el contacto esta borrado logicamente
        //Si lo encuentra debe posicionarse al principio (Ej: si el contacto 1 estuviera borrado, se colocaria en la posicion 0)
        //Si no lo encuentra debe posicionarse al final del fichero


    }

    private long posOnLogicFalse() {
        long pos = 4;
        boolean found;
        consultarContactos(false);

        RandomAccessFile file = getRandomAccess("r");
        try {
            try {
                do {
                    file.seek(pos);
                    found = file.readBoolean();

                    pos += LONGITUD_CONTACTO;
                } while (found);
            } catch (EOFException ex) {
                System.out.println("No hay ningún contacto borrado lógicamente");
                return lastPos;
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pos;
    }

    private void getLastIndex(int lastID) {
        this.lastID = lastID + 1;
    }

    private void getLastPos(long pos) {
        this.lastPos = pos;
    }

    private void solicitarContacto() {
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

    private void charsOrUTFUltPos() {
        System.out.print("¿Quieres añadir el contacto con Chars[true] o UTF[false]? -> ");
        boolean elec = teclado.nextBoolean();
        if (elec) {
            addContatoPorCharsUltPos();
        }
    }

}
