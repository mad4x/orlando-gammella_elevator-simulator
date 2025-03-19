public class Persona 
{
   private int id;
   private int pianoDestinazione;

    public Persona(int id, int pianoDestinazione);
   {
     this.id = id;
     this.pianoDestinazione = pianoDestinazione;
   }

   public void saliSuAscensore(Ascensore a)
   {
        a.faiSalire(this);
   }

   public void scendiDaAscensore(Ascensore a)
   {
        a.faiScendere(this);
   }
   
}