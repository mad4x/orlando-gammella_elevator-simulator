import java.util.Queue;
import java.util.LinkedList;

public class Piano {
    int numeroPiano;
    Queue codaPersone;

    Piano(int numeroPiano) {
        codaPersone = new LinkedList<Persona>();
        this.numeroPiano = numeroPiano;
    }



    //aggiungi persona al piano e chiama ascensore se non ancora chiamato
    void aggiungiPersonaCoda(Persona p) {

    }

    Persona rimuoviPersonaCoda() {
        return (Persona) codaPersone.poll();
    }

    public void popolaPiano(int persone) {
        for(int i = 0; i < persone; i++) {
            codaPersone.offer(new Persona());
        }
    }

    public void chiamaAscensore(int destinazione, Ascensore a) {
        a.riceviChiamata(destinazione);
    }

    @Override
    public String toString() {
        return "Piano: " + numeroPiano + "\n" +
                "Persone in coda: " + codaPersone;
    }


}
