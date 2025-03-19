import java.util.ArrayList;

public class Ascensore
{
  private int pianocorrente;
  private int capienzamassima;
  private boolean porteAperte;
  
  private ArrayList<Persona> personeDentro; 

  public Ascensore(int pianocorrente, int capienzamassima)
  {
    this.pianocorrente = pianocorrente;
    this.capienzamassima = capienzamassima;
    this.porteAperte = false;
    personeDentro = new ArrayList<>;
  }

  public int getPianoCorrente()
  {
    return pianocorrente;
  }

  public int getCapienzaMassima() {
    return capienzamassima;
  }

  public void aggiungiPersona(Persona p)
  {
    if (porteAperte == true && personeDentro.size() <= capienzamassima)
    {

    }
    else
    {
      System.out.println("Porte Chiuse oppure capienza massima raggiunta");
    }
  }

  public void rimuoviPersoneArrivate()
  {
    if(porte aperte == true)
    {

    }
    else
    {

    }
  }

  @Override
  public String toString()
  {
    return "Numero Persone presenti nell'ascensore: " + Persona + "Piano Corrente: " + pianocorrente + "Capienza Massima: " + capienzamassima;
  }


}