public class Simulazione {
  public static void main(String[] args) {

    Ascensore ascensore = new Ascensore(6);
    Piano[] piani = new Piano[10];
    popolaPiani(piani);

    while(true) {

    }


  }

  public static void popolaPiani(Piano[] edificio) {
    for (Piano p : edificio) {
      if(Math.round(Math.random()) == 1)
        p.popolaPiano(2);
    }
  }

}
