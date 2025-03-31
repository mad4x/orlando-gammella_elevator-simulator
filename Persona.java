public class Persona 
{
  private int id;
  private int pianoDestinazione;
  private static int numero_persone = 0;

  public Persona(int pianoAttuale) {
    this.id = ++numero_persone;
    int numero = pianoAttuale;
    while(numero == pianoAttuale)
      numero = (int)(Math.random()*10);
    this.pianoDestinazione = numero;
  }

  public int getId() { return id; }

  public int getPianoDestinazione() {
    return pianoDestinazione;
  }

  public void saliSuAscensore(Ascensore a) {
  }

  public void scendiDaAscensore(Ascensore a) {
  }
   
}