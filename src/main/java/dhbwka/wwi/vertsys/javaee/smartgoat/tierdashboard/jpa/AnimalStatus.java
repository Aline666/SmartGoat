
package dhbwka.wwi.vertsys.javaee.smartgoat.tierdashboard.jpa;

/**
 *
 * @author laurahetzel
 */
    
 
    
    public enum AnimalStatus {
    GeradeEingetroffen, KeineInteressenten, Interessenten, adoptiert;

    /**
     * Bezeichnung ermitteln
     *
     * @return Bezeichnung
     */
    public String getLabel() {
        switch (this) {
            case GeradeEingetroffen:
                return "Gerade Eingetroffen";
            case KeineInteressenten:
                return "Es gibt im Moment keine Interessenten";
            case Interessenten:
                return "Es sind Interessenten sind vorhanden";
            case adoptiert:
                return "Erfolgreich adoptiert";
         
            default:
                return this.toString();
        }
    

}


    
}
