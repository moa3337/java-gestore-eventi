package org.learning.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int postiTot, LocalTime ora, BigDecimal prezzo) throws Exception {
        super(titolo, data, postiTot);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    // Getter/Setter ora
    public LocalTime getOra() {
        return ora;
    }
    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    // Getter/Setter prezzo
    public BigDecimal getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getFormattedDataOra() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return getData().format(formatter) + " " + ora.format(formatter);
    }

    public String getFormattedPrezzo() {
        return prezzo.toString() + "€";
    }

    @Override
    public String toString() {
        return getFormattedDataOra() + "-"
                + getTitolo() + "-"
                + getFormattedPrezzo();
    }
}
