public class Simulazione {
  public static void main(String[] args) {

    Ascensore ascensore = new Ascensore(6);
    Piano[] piani = creaPiani(10);
    popolaPiani(piani, ascensore);

    while(true) {

    }


  }

  //risolvere il passaggio costante di un Ascensore
  //questa funzione per ora fa le chiamate e tutto
  public static void popolaPiani(Piano[] edificio, Ascensore a) {
    for (Piano p : edificio) {
      if(Math.round(Math.random()) == 1)
        p.popolaPiano(2, a);
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
