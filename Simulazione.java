public class Simulazione {
  public static void main(String[] args) {

    int numeroPiani = 10;

    Ascensore ascensore = new Ascensore(6, numeroPiani);
    Piano[] piani = creaPiani(numeroPiani);


    while(true) {
      popolaPiani(piani, ascensore);

      while(personePresenti(piani)) {
        Piano pianoattuale = piani[ascensore.getPianoCorrente()];
        int lunghezzaCoda = pianoattuale.getLunghezzaCoda();

        if (controllaSeAprire(ascensore, pianoattuale)) {
          for (int i = 0; i < lunghezzaCoda
              && !ascensore.pieno(); i++) {

            ascensore.aggiungiPersona(pianoattuale.rimuoviPersonaCoda());
          }
          pianoattuale.reimpostaTasti();
        }
        ascensore.rimuoviPersoneArrivate();

        if(pianoattuale.vuoto()) {
          ascensore.rimuoviDaLista(pianoattuale.getNumeroPiano());
        }

        ascensore.chiudiPorte();
        ascensore.decidiDirezione();
      }
    }

  }

  public static boolean controllaSeAprire(Ascensore a, Piano p) {
    if (a.getSalendo() && p.getSalire()) {
      a.apriPorte();
      return true;
    }
    if (!a.getSalendo() && p.getScendere()) {
      a.apriPorte();
      return true;
    }
    return false;
  }

  public static boolean personePresenti(Piano[] piani) {
    for(Piano p : piani) {
      if(!p.getCodaPersone().isEmpty())
        return true;
    }

    return false;
  }

  //risolvere il passaggio costante di un Ascensore
  //questa funzione per ora fa le chiamate e tutto
  public static void popolaPiani(Piano[] edificio, Ascensore a) {
    for (Piano p : edificio) {
      if(Math.round(Math.random()) == 1)
        p.popolaPiano(2, a, p);
    }
  }

  public static Piano[] creaPiani(int n) {
    Piano[] piani = new Piano[n];
    for (int i = 0; i < n; i++) {
      piani[i] = new Piano(i);
    }

    return piani;
  }

}
