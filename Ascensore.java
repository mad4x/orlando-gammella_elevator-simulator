import java.util.ArrayList;

public class Ascensore
{
  private int pianocorrente;
  private int capienzamassima;
  private boolean porteAperte;
  
  private ArrayList<Persona> personeDentro; 

  public Ascensore(int pianocorrente, int capienzamassima);
  {
    this.pianocorrente = pianocorrente;
    this.capienzamassima = capienzamassima;
    this.porteAperte = porteAperte;
    personeDentro = new ArrayList<>;
  }

}