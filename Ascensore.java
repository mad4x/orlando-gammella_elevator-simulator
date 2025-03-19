import java.util.ArrayList;

public class Ascensore
{
  private int pianocorrente;
  private int capienzamassima;
  private boolean porteAperte;
  private ArrayList<Persona> personeDentro; 

  public Ascensore(int capienzamassima) {
    this.pianocorrente = 0;
    this.capienzamassima = capienzamassima;
    this.porteAperte = false;
    personeDentro = new ArrayList<>();
  }

  public void salita() {
    pianocorrente++;
  }

  public void discesa() {
    capienzamassima--;
  }

  public void decidiDirezione() {

    switch (pianocorrente) {
      case 10: salita();
        return;
      case 0: discesa();
        return;
    }

    int salitori = 0;
    int discesori = 0;

    for(Persona p : personeDentro) {
      if(p.getPianoDestinazione() > pianocorrente)
        salitori++;
      else
        discesori++;
    }

    if (salitori >= discesori)
      salita();
    else
      discesa();
  }
}