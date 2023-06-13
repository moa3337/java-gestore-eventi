package org.learning.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int postiTot;
    private int postiPrenot;

    // Costruttore
    public Evento(String titolo, LocalDate data, int postiTot) throws Exception {
        // Controllo che la data non sia già passata
        LocalDate currentDate = LocalDate.now();
        if (data.isBefore(currentDate)) {
            throw new Exception("La data dell'evento è già passata");
        }

        // Controllo che il numero di posti sia positivo
        if (postiTot <= 0) {
            throw new Exception("Il numero di posti devve essere positivo!");
        }

        this.titolo = titolo;
        this.data = data;
        this.postiTot = postiTot;
        this.postiPrenot = 0;
    }

    // Getter e setter titolo
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    // Getter e setter data
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) throws Exception {
        // Controllo che la data non sia già passata
        LocalDate currentDate = LocalDate.now();
        if (data.isBefore(currentDate)) {
            throw new Exception("La data dell'evento è già passata");
        }
        this.data = data;
    }

    // Getter postiTot
    public int getPostiTot() {
        return postiTot;
    }
    // Getter postiPrenot
    public int getPostiPrenot() {
        return postiPrenot;
    }

    // Metodo prenota
    public void prenota() throws Exception {
        // Controllo che l'evento non si già passato
        LocalDate currentDate = LocalDate.now();
        if (data.isBefore(currentDate)) {
            throw new Exception("L'evento è già passato");
        }

        // Controllo se ci sono posti disponibili
        if (postiPrenot >= postiTot) {
            throw new Exception("Non ci sono posti disponibili per questo evento!");
        }
        postiPrenot++;
    }

    // Metodo disdici
    public void disdici() throws Exception {
        // Controllo che l'evento non sia gà passato
        LocalDate currentDate = LocalDate.now();
        if (data.isBefore(currentDate)) {
            throw new Exception("l'evento è già passato");
        }

        // Controllo se ci sono prenotaioni da cancellare
        if (postiPrenot <= 0) {
            throw new Exception("Non ci sono prenotazioni da cancellare per questo evento");
        }
        postiPrenot--;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + "-" + titolo;
    }
}
