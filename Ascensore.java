import java.util.ArrayList;

public class Ascensore
{
  private int pianocorrente;
  private int capienzamassima;
  private boolean porteAperte;
  private ArrayList<Persona> personeDentro;
  private ArrayList<Integer> salite;
  private ArrayList<Integer> discese;
  private boolean salendo;


  public Ascensore(int capienzamassima) {
    this.pianocorrente = 0;
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


  public void chiudiPorte() {
    porteAperte = false;
    System.out.println("Le porte vengono chiuse...");
  }

  public void apriPorte() {
    porteAperte = true;
    System.out.println("Le porte vengono aperte...");
  }


  public boolean vuoto() {
    return personeDentro.isEmpty();
  }

  public void aggiungiSalita(int piano) {
    if(!salite.contains(piano))
      salite.add(piano);
  }

  public void aggiungiDiscesa(int piano) {
    if(!discese.contains(piano))
      discese.add(piano);
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

  public void decidiDirezione() {
    if(salendo)
      if(!salite.isEmpty())
        salita();
      else
        salendo = false;
    else if(!discese.isEmpty())
      discesa();
    else
      salendo = true;
  }

  public void aggiungiPersona(Persona p) {
    if (personeDentro.size() < capienzamassima)
      personeDentro.add(p);
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