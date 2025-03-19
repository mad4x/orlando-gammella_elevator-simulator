import java.util.Queue;
import java.util.LinkedList;

public class Piano {
    int numeroPiano;
    Queue codaPersone;

    Piano(int numeroPiano) {
        codaPersone = new LinkedList<Persona>;
        this.numeroPiano = numeroPiano;
    }

    void aggiungiPersonaCoda(Persona p) {
        codaPersone.offer(p);
    }

    Persona rimuoviPersonaCoda() {
        return (Persona) codaPersone.poll();
    }

    @Override
    public String toString() {
        return "Piano: " + numeroPiano + "\n" +
                "Persone in coda: " + codaPersone;
    }


}
