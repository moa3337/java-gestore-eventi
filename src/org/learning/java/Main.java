package org.learning.java;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Creazione ogetto Evento
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataEvento = LocalDate.parse("14/06/2023", formatter);
            // nome: concerto, data: dd/mm/yyyy, posti: 100
            Evento evento = new Evento("Concerto", dataEvento, 100);

            // Utilizzo metodi
            evento.prenota();
            evento.prenota();
            evento.disdici();

            // Stampa evento
            System.out.println(evento.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
