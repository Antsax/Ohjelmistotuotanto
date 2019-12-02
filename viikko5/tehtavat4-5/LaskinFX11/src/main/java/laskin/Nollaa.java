package laskin; 

public class Nollaa extends Komento {
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tulostekentta, syotekentta, nollaa, undo, sovellus);
     }

     @Override
     public void suorita() {
         super.edellinen = Integer.parseInt(tuloskentta.getText());
         tuloskentta.clear();
         syotekentta.clear();
         sovellus.nollaa();
         nollaa.disableProperty().set(true);
         undo.disableProperty().set(false);
     }

     @Override
     public void peru() {
         tuloskentta.setText( (String) super.edellinen);
         sovellus.plus(super.edellinen);
         syotekentta.clear();
         undo.disableProperty().set(true);
     }
}
