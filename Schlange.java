public class Schlange implements Functions{
    private Element erstes;
    private Element letztes;
    private class Element{
        public int wert;
        public Element naechstes;
        public Element(int wert){
            this.wert = wert;
        }
    }

    public void einfuegen(int wert){
        Element neu = new Element(wert);
        if(letztes == null){
            erstes = neu;
            letztes = neu;
        } else {
            letztes.naechstes = neu;
            letztes = neu;
        }
    }

    public int entfernen(){
        int out_wert = 0;
        if(erstes == letztes){
            erstes = null;
            letztes = null;
        } else {
            out_wert = erstes.wert;
            erstes = erstes.naechstes;
        }
        return out_wert;
    }
    public String ausgeben(){
        String output = "";
        Element akt = erstes;
        while(akt != null){
            output += Integer.toString(akt.wert);
            if(akt.naechstes != null){
                output += "->";
            }
            akt = akt.naechstes;
        }
        if(output == ""){
            return "-- leer --";
        } else {
            return output;
        }
    }

    public int gibLaenge(){
        int laenge = 0;
        Element akt = erstes;
        while(akt != null){
            laenge++;
            akt = akt.naechstes;
        }
        return laenge;
    }
}
