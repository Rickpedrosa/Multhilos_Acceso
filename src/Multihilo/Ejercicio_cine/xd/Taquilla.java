package Multihilo.Ejercicio_cine.xd;

import javafx.scene.control.RadioMenuItem;

import java.util.Random;

public class Taquilla implements Runnable {

    Cine cine;
    Random rndSala = new Random(5);
    Random rndCompraVenta = new Random(5);

    public Taquilla(Cine cine) {
        this.cine = new Cine();
    }


    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            try {
                compraVenta(cine.entradas);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void compraVenta(int[] entradas) {
        int numeroSala = rndSala.nextInt(6);
        switch (numeroSala) {
            case 0:
                synchronized (cine.sala1) {
                    switch (rndCompraVenta.nextInt(1)) {
                        case 0:
                            System.out.printf("Se ha empezado a comprar una entrada en la sala%d%n", numeroSala + 1);
                            System.out.printf("%s%n", comprarEntradas(entradas, numeroSala) ? String.format("Entrada vendida. Quedan %d entradas en la sala %d", entradas[numeroSala], numeroSala + 1) : String.format("no quedaban entradas a la venta en sala%d", numeroSala + 1));
                            break;
                        case 1:
                            System.out.println(String.format("Se ha empezado a devolver una entrada en la sala %d", numeroSala + 1));
                            System.out.printf("%s%n", devolverEntradas(entradas, numeroSala) ? String.format("Entrada devuelta. Quedan %d entradas en la sala %d", entradas[numeroSala], numeroSala + 1) : String.format("Todas las entradas vendidas en la sala %d", numeroSala + 1));
                            break;
                    }
                }
                break;
            case 1:
                synchronized (cine.sala2) {
                    switch (rndCompraVenta.nextInt()) {
                        case 0:
                            System.out.printf("Se ha empezado a comprar una entrada en la sala%d%n", numeroSala + 1);
                            System.out.printf("%s%n", comprarEntradas(entradas, numeroSala) ? String.format("Entrada vendida. Quedan %d entradas en la sala 1", entradas[numeroSala]) : String.format("no quedaban entradas a la venta en sala%d", numeroSala + 1));
                            break;
                        case 1:
                            System.out.println(String.format("Se ha empezado a devolver una entrada en la sala %d", numeroSala + 1));
                            System.out.printf("%s%n", devolverEntradas(entradas, numeroSala) ? String.format("Entrada devuelta. Quedan %d entradas en la sala %d", entradas[numeroSala], numeroSala + 1) : String.format("Todas las entradas vendidas en la sala %d", numeroSala + 1));
                            break;
                    }
                }
                break;
            case 2:

                synchronized (cine.sala3) {
                    switch (rndCompraVenta.nextInt()) {
                        case 0:
                            System.out.printf("Se ha empezado a comprar una entrada en la sala%d%n", numeroSala + 1);
                            System.out.printf("%s%n", comprarEntradas(entradas, numeroSala) ? String.format("Entrada vendida. Quedan %d entradas en la sala 1", entradas[numeroSala]) : String.format("no quedaban entradas a la venta en sala%d", numeroSala + 1));
                            break;
                        case 1:
                            System.out.println(String.format("Se ha empezado a devolver una entrada en la sala %d", numeroSala + 1));
                            System.out.printf("%s%n", devolverEntradas(entradas, numeroSala) ? String.format("Entrada devuelta. Quedan %d entradas en la sala %d", entradas[numeroSala], numeroSala + 1) : String.format("Todas las entradas vendidas en la sala %d", numeroSala + 1));
                            break;
                    }
                }
                break;
            case 3:

                synchronized (cine.sala4) {
                    switch (rndCompraVenta.nextInt()) {
                        case 0:
                            System.out.printf("Se ha empezado a comprar una entrada en la sala%d%n", numeroSala + 1);
                            System.out.printf("%s%n", comprarEntradas(entradas, numeroSala) ? String.format("Entrada vendida. Quedan %d entradas en la sala 1", entradas[numeroSala]) : String.format("no quedaban entradas a la venta en sala%d", numeroSala + 1));
                            break;
                        case 1:
                            System.out.println(String.format("Se ha empezado a devolver una entrada en la sala %d", numeroSala + 1));
                            System.out.printf("%s%n", devolverEntradas(entradas, numeroSala) ? String.format("Entrada devuelta. Quedan %d entradas en la sala %d", entradas[numeroSala], numeroSala + 1) : String.format("Todas las entradas vendidas en la sala %d", numeroSala + 1));
                            break;
                    }
                }
                break;
            case 4:
                synchronized (cine.sala5) {
                    switch (rndCompraVenta.nextInt()) {
                        case 0:
                            System.out.printf("Se ha empezado a comprar una entrada en la sala%d%n", numeroSala + 1);
                            System.out.printf("%s%n", comprarEntradas(entradas, numeroSala) ? String.format("Entrada vendida. Quedan %d entradas en la sala 1", entradas[numeroSala]) : String.format("no quedaban entradas a la venta en sala%d", numeroSala + 1));
                            break;
                        case 1:
                            System.out.println(String.format("Se ha empezado a devolver una entrada en la sala %d", numeroSala + 1));
                            System.out.printf("%s%n", devolverEntradas(entradas, numeroSala) ? String.format("Entrada devuelta. Quedan %d entradas en la sala %d", entradas[numeroSala], numeroSala + 1) : String.format("Todas las entradas vendidas en la sala %d", numeroSala + 1));
                            break;
                    }
                }
                break;
            case 5:
                synchronized (cine.sala6) {
                    switch (rndCompraVenta.nextInt()) {
                        case 0:
                            System.out.printf("Se ha empezado a comprar una entrada en la sala%d%n", numeroSala + 1);
                            System.out.printf("%s%n", comprarEntradas(entradas, numeroSala) ? String.format("Entrada vendida. Quedan %d entradas en la sala 1", entradas[numeroSala]) : String.format("no quedaban entradas a la venta en sala%d", numeroSala + 1));
                            break;
                        case 1:
                            System.out.println(String.format("Se ha empezado a devolver una entrada en la sala %d", numeroSala + 1));
                            System.out.printf("%s%n", devolverEntradas(entradas, numeroSala) ? String.format("Entrada devuelta. Quedan %d entradas en la sala %d", entradas[numeroSala], numeroSala + 1) : String.format("Todas las entradas vendidas en la sala %d", numeroSala + 1));
                            break;
                    }
                }
                break;
        }
    }

    private boolean comprarEntradas(int[] entradas, int numeroSala) {
        if (entradas[numeroSala] == 0) {
            return false;
        } else {
            entradas[numeroSala]--;
            return true;
        }
    }

    private boolean devolverEntradas(int[] entradas, int numeroSala) {
        if (entradas[numeroSala] == 300) {
            return false;
        } else {
            return true;
        }
    }
}

