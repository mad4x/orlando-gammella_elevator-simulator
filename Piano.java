import java.util.Queue;
import java.util.LinkedList;

public class Piano {
    private int numeroPiano;
    private Queue<Persona> codaPersone;
    private boolean salire;
    private boolean scendere;

    Piano(int numeroPiano) {
        codaPersone = new LinkedList<Persona>();
        this.numeroPiano = numeroPiano;
        this.salire = false;
        this.scendere = false;
    }

    public Queue getCodaPersone() { return codaPersone; }
    public boolean vuoto() { return codaPersone.isEmpty(); }
    public int getNumeroPiano() { return numeroPiano; }
    public boolean getSalire() { return salire; }
    public boolean getScendere() { return scendere; }
    public int getLunghezzaCoda() { return codaPersone.size(); }

    //aggiungi persona al piano e chiama ascensore se non ancora chiamato
    public void aggiungiPersonaCoda(Persona p, Ascensore a) {
        codaPersone.offer(p);
        if(p.getPianoDestinazione() > numeroPiano && !salire)
            premiSalita(a);
        else if(p.getPianoDestinazione() < numeroPiano && !scendere)
            premiDiscesa(a);
    }

    public Persona rimuoviPersonaCoda() {
        return (Persona) codaPersone.poll();
    }
    public Persona controllaProssimo() { return codaPersone.peek(); }
    public void rendiPrimoUltimo() { codaPersone.offer(codaPersone.poll()); }

    public void popolaPiano(int persone, Ascensore a, Piano p) {
        for(int i = 0; i < persone; i++) {
            aggiungiPersonaCoda(new Persona(p.getNumeroPiano()), a);
        }
    }

    public void premiSalita(Ascensore a) {
        salire = true;
        a.aggiungiSalita(numeroPiano);
        System.out.println("Chiamata una salita al piano " + this.numeroPiano);
    }

    public void premiDiscesa(Ascensore a) {
        scendere = true;
        a.aggiungiDiscesa(numeroPiano);
        System.out.println("Chiamata una discesa al piano " + this.numeroPiano);
    }

    //potrebbe sostituire premi salita e premi discesa
    public void reimpostaTasti() {
        if(codaPersone.isEmpty()) {
            salire = false;
            scendere = false;
            return;
        }

        for (Persona p : codaPersone) {
           if(p.getPianoDestinazione() > numeroPiano)
               salire = true;
           if(p.getPianoDestinazione() < numeroPiano)
               scendere = true;
        }
    }

    @Override
    public String toString() {
        return "Piano: " + numeroPiano + "\n" +
                "Persone in coda: " + codaPersone;
    }


}
