package org.learning.java;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            // Creazione ogetto Evento
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataEvento = sdf.parse("14/06/2023");
            // nome: concerto, data: dd/mm/yyyy, posti: 100
            Evento evento = new Evento("Concerto", dataEvento, 100);

            // Utilizzo metodi
            evento.prenota();
            evento.prenota();
            evento.disdici();

            // Stampa evento
            System.out.println(evento.toString());
        } catch (ParseException e) {
            System.out.println("Errore nell'inserimento della data!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
