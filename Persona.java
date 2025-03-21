public class Persona 
{
  private int id;
  private int pianoDestinazione;
  private static int numero_persone = 0;

  public Persona() {
    this.id = ++numero_persone;
    this.pianoDestinazione = (int)(Math.random()*10+1);
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