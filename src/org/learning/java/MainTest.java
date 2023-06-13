package org.learning.java;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainTest {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Creazione ogetto Concerto
        String titoloConcerto = "Concerto prova";
        LocalDate dataConcerto = LocalDate.of(2023, 9, 10);
        int postiTot = 100;
        LocalTime oraConcerto = LocalTime.of(18, 30);
        BigDecimal prezzoConcerto = new BigDecimal("19.90");

        Concerto concerto = new Concerto(titoloConcerto, dataConcerto, postiTot, oraConcerto, prezzoConcerto);

        // Test metodi Concerto
        System.out.println("Data ora concerto: " + concerto.getFormattedDataOra());
        System.out.println("Prezzo concerto: " + concerto.getFormattedPrezzo());
        System.out.println("Informazioni concerto: " + concerto.toString());


        // Chiedo d'inserire parametri evento
        System.out.println("Inserisci il titolo dell'evento: ");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci data evento (dd/MM/yyyy): ");
        String dataString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataEvento = LocalDate.parse(dataString, formatter);

        System.out.println("Inserisci numero posti disponibili: ");
        int postiTot = scanner.nextInt();

        // Creo oggetto Evento con i dati dell'utente
        try {
            Evento evento = new Evento(titolo, dataEvento, postiTot);

            // Chiedo numero prenotazioni da effettuare
            System.out.println("Vuoi effettura delle prenotazioni? (si/no): ");
            scanner.nextLine();
            String risposta = scanner.nextLine();
            if (risposta.equalsIgnoreCase("si")) {
                System.out.println("Quante prenotazioni vuoi effettuare? ");
                int numPrenotazioni = scanner.nextInt();

                // Creo prenotazioni richieste con ciclo for
                // per creare il numero richiesto di prenotazioni
                for (int i = 0; i < numPrenotazioni; i++) {
                    try {
                        evento.prenota();
                        System.out.println("Prenotazione effettuata con sucesso");
                    } catch (Exception e) {
                        System.out.println("Impossibile effettuare la prenotazione: " + e.getMessage());
                    }
                }
            }

            // Stampo numero posti prenotati e disponibili
            System.out.println("Posti prenotati: " + evento.getPostiPrenot());
            System.out.println("Posti disponibili: "
                    + (evento.getPostiTot() - evento.getPostiPrenot()));

            // Chiedo se si vuole disdire posti
            System.out.println("Vuoi disdire dei posti? (si/no): ");
            scanner.nextLine();
            risposta = scanner.nextLine();
            if (risposta.equalsIgnoreCase("si")) {
                System.out.println("Quanti posti vuoi disdire? ");
                int numDisdette = scanner.nextInt();

                // Ciclo for per effettuare le disdette richieste
                for (int i = 0; i < numDisdette; i++) {
                    try {
                        evento.disdici();
                        System.out.println("Disdetta effettua con sucesso");
                    } catch (Exception e) {
                        System.out.println("Impossibile effettuare la disdetta: "
                                + e.getMessage());
                    }
                }
            }

            // Stampo i nuovi posti prenotati/disponibili dopo le disdette
            System.out.println("Posti prenotati: " + evento.getPostiPrenot());
            System.out.println("Posti disponibili: "
                    + (evento.getPostiTot() - evento.getPostiPrenot()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
