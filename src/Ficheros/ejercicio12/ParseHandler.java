package Ficheros.ejercicio12;

import Ficheros.Ejercicio8.Agenda;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ParseHandler extends DefaultHandler {

    private Agenda contacto = null;
    private boolean[] campos = new boolean[7];
    private List<Agenda> listaAgenda = null;
    private String localidad, prefijo;
    private ArrayList<String> coinType = new ArrayList<>();

    ParseHandler() {
    }

    List<Agenda> getListAgenda() {
        return listaAgenda;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("DatosAgenda")) {
            contacto = new Agenda();
            if (listaAgenda == null) {
                listaAgenda = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("nombre")) {
            campos[0] = true;
        } else if (qName.equalsIgnoreCase("tlf")) {
            campos[1] = true;
            prefijo = attributes.getValue("prefijo");
        } else if (qName.equalsIgnoreCase("dir")) {
            campos[2] = true;
            localidad = attributes.getValue("localidad");
        } else if (qName.equalsIgnoreCase("cp")) {
            campos[3] = true;
        } else if (qName.equalsIgnoreCase("fechanac")) {
            campos[4] = true;
        } else if (qName.equalsIgnoreCase("money")) {
            campos[5] = true;
            coinType.add(attributes.getValue("tipo"));
        } else if (qName.equalsIgnoreCase("cantidad")) {
            campos[6] = true;
        }
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud) {
        if (campos[0]) {
            contacto.setNombre(new String(ch, inicio, longitud));
            campos[0] = false;
        }
        if (campos[1]) {
            contacto.setTlf(Integer.parseInt(prefijo + new String(ch, inicio, longitud)));
            campos[1] = false;
        }
        if (campos[2]) {
            contacto.setDir("[" + localidad + "]" + new String(ch, inicio, longitud));
            campos[2] = false;
        }
        if (campos[3]) {
            contacto.setCp(Integer.parseInt(new String(ch, inicio, longitud)));
            campos[3] = false;
        }
        if (campos[4]) {
            contacto.setFechanac(new String(ch, inicio, longitud));
            campos[4] = false;
        }
        if (campos[5]) {
            contacto.setMoney(Boolean.getBoolean(new String(ch, inicio, longitud)));
            campos[5] = false;
        }
        if (campos[6]) {
            contacto.setCantidad(Float.parseFloat(new String(ch, inicio, longitud)));
            campos[6] = false;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("DatosAgenda")) {
            listaAgenda.add(contacto);
        }
    }

    String contactToString(Agenda contacto, int id) {
        String formato = "Contacto %d, Nombre: %s, Tlf: %d, Dir: %s, CP: %d, Fechanac: %s, DebeDinero: %b, Cantidad: %.2f%s\n";
        return String.format(formato, id, contacto.getNombre(), contacto.getTlf(), contacto.getDir(), contacto.getCp(),
                contacto.getFechanac(), contacto.getMoney(), contacto.getCantidad(), coinType.get(id - 1));
    }

}
