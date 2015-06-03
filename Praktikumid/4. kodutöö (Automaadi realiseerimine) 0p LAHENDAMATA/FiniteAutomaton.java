public class FiniteAutomaton {
    /**
     * Selle meetodiga annab automaadi koostaja teada, millised olekud automaadis
     * esinevad. isAcceptingState utleb, kas tegemist on loppolekuga.
     */
    public void addState(Integer stateId, boolean isAcceptingState) {
 
    }
 
    /**
     * Selle meetodiga maaratakse algolek. Voib eeldada, et eelnevalt on see olek
     * automaati lisatud.
     */
    public void setStartState(Integer id) {
 
    }
 
    /**
     * Selle meetodiga lisatakse uus uleminek. Epsilon-ulemineku korral on label==null.
     * Voib eeldada, et olekud fromState ja toState on juba eelnevalt lisatud.
     */
    public void addTransition(Integer fromState, Character label, Integer toState) {
 
    }
 
    /**
     * See meetod peab utlema, kas automaat tunneb ara naidatud sisendi.
     */
    public boolean accepts(String input) {
        return false;
    }
 
    /**
     * Seda meetodit ei hinnata ja seda ei pea muutma, aga labikukkunud testide korral
     * antakse sulle automaadi kirjelduseks just selle meetodi tagastusvaartus.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}