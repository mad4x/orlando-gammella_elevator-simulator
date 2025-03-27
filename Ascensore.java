import java.util.ArrayList;
import java.util.Iterator;

public class Ascensore
{
  private int pianocorrente;
  private int numeroPiani;
  private int capienzamassima;
  private boolean porteAperte;
  private ArrayList<Persona> personeDentro;
  private ArrayList<Integer> salite;
  private ArrayList<Integer> discese;
  private boolean salendo;


  public Ascensore(int capienzamassima, int numeroPiani) {
    this.pianocorrente = 0;
    this.numeroPiani = numeroPiani;
    this.capienzamassima = capienzamassima;
    this.porteAperte = false;
    personeDentro = new ArrayList<Persona>();
    salite = new ArrayList<Integer>();
    discese = new ArrayList<Integer>();
    salendo = true;
  }

  public int getPianoCorrente() {
    return pianocorrente;
  }
  public int getCapienzaMassima() {
    return capienzamassima;
  }
  public boolean getSalendo() { return salendo; }


  public void chiudiPorte() {
    if (porteAperte) {
      porteAperte = false;
      System.out.println("Le porte vengono chiuse...");
    }
  }

  public void apriPorte() {
    if (!porteAperte) {
      porteAperte = true;
      System.out.println("Le porte vengono aperte...");
    }
  }


  public boolean vuoto() {
    return personeDentro.isEmpty();
  }
  public boolean pieno() { return personeDentro.size() == capienzamassima; }


  public void aggiungiSalita(int piano) {
    if(!salite.contains(piano))
      salite.add(piano);
  }

  public void rimuoviSalita(int n) {
    if (salite.contains(n))
      salite.remove(Integer.valueOf(n));
  }

  public void aggiungiDiscesa(int piano) {
    if(!discese.contains(piano))
      discese.add(piano);
  }

  public void rimuoviDiscesa(int n) {
    if (discese.contains(n))
      discese.remove(Integer.valueOf(n));
  }

  public void rimuoviDaLista(int n) {
    rimuoviSalita(n);
    rimuoviDiscesa(n);
  }


  public void salita() {
    pianocorrente++;
    System.out.println("L'ascensore sale al piano " + pianocorrente);
  }

  public void discesa() {
    pianocorrente--;
    System.out.println("L'ascensore scende al piano " + pianocorrente);
  }

  public void decidiDirezione() {
    if(salendo)
      if((!salite.isEmpty() || devoSalire())
          && !(pianocorrente == numeroPiani-1))
        salita();
      else
        salendo = false;

    else
      if((!discese.isEmpty() || devoScendere())
          && !(pianocorrente == 0))
        discesa();
      else
        salendo = true;
  }

  public void aggiungiPersona(Persona p) {
    if (personeDentro.size() < capienzamassima) {
      personeDentro.add(p);
      System.out.println(p.getId() + " è salito sull'ascensore.");
    }
  }

  public void rimuoviPersoneArrivate() {
    Iterator<Persona> iterator = this.personeDentro.iterator();

    while (iterator.hasNext()) {
      Persona p = iterator.next();
      if (p.getPianoDestinazione() == this.pianocorrente) {
        iterator.remove();
        System.out.println(p.getId() + " è uscito dall'ascensore.");
      }
    }

  }


  public boolean devoSalire() {
    for(Persona p : personeDentro) {
      if(p.getPianoDestinazione() > pianocorrente)
        return true;
    }

    return false;
  }

  public boolean devoScendere() {
    for(Persona p : personeDentro) {
      if(p.getPianoDestinazione() < pianocorrente)
        return true;
    }

    return false;
  }

  @Override
  public String toString()
  {
    return "Numero Persone presenti nell'ascensore: " + personeDentro.size() + "\nPiano Corrente: " + pianocorrente + "\nCapienza Massima: " + capienzamassima;
  }


}