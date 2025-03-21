import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ascensore
{
  private int pianocorrente;
  private int capienzamassima;
  private boolean porteAperte;
  private ArrayList<Persona> personeDentro;
  private Queue chiamate;

  public Ascensore(int capienzamassima) {
    this.pianocorrente = 0;
    this.capienzamassima = capienzamassima;
    this.porteAperte = false;
    personeDentro = new ArrayList<Persona>();
    chiamate = new LinkedList<Integer>();
  }

  public void setPianocorrente(int pianocorrente) {
    this.pianocorrente = pianocorrente;
  }

  public int getPianoCorrente() {
    return pianocorrente;
  }

  public int getCapienzaMassima() {
    return capienzamassima;
  }



  public void chiudiPorte() {
    porteAperte = false;
    System.out.println("Le porte vengono chiuse...");
  }

  public void apriPorte() {
    porteAperte = true;
    System.out.println("Le porte vengono aperte...");
  }

  public void riceviChiamata(int piano) {
    if (!chiamate.contains(piano)) {}
      chiamate.offer(piano);
  }



  public boolean vuoto() {
    return personeDentro.isEmpty();
  }

  public void salita() {
    chiudiPorte();
    pianocorrente++;
    System.out.println("L'ascensore sale al piano " + pianocorrente);
  }

  public void discesa() {
    chiudiPorte();
    pianocorrente--;
    System.out.println("L'ascensore scende al piano " + pianocorrente);
  }

  public void aggiungiPersona(Persona p) {
    if (personeDentro.size() < capienzamassima)
      personeDentro.add(p);
  }

  public void aggiungiPrenotazione(int p) {
    chiamate.offer(p);
  }

  public void rimuoviPersoneArrivate()
  {
    apriPorte();
    for (Persona p : this.personeDentro) {
      if(p.getPianoDestinazione() == this.pianocorrente) {
        personeDentro.remove(p);
        System.out.println(p.getId() + " è uscito dall'ascensore.");
      }
    }
  }

  @Override
  public String toString()
  {
    return "Numero Persone presenti nell'ascensore: " + personeDentro.size() + "\nPiano Corrente: " + pianocorrente + "\nCapienza Massima: " + capienzamassima;
  }


}