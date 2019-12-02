package laskin; 

public class Summa extends Komento {
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tulostekentta, syotekentta, nollaa, undo, sovellus);
     }

     @Override
     public void suorita() {
         super.edellinen = Integer.parseInt(syotekentta.getText());
         sovellus.plus(Integer.parseInt(syotekentta.getText()));
         tuloskentta.setText( (String) sovellus.tulos());
         syotekentta.clear();
         nollaa.disableProperty().set(false);
         undo.disableProperty().set(false);
     }

     @Override
     public void peru() {
         tuloskentta.setText( (String) super.edellinen);
         sovellus.miinus(super.edellinen);
         syotekentta.clear();
         undo.disableProperty().set(true);
     }
}
