import java.util.Map;
 
public class FormulaUtils {
 
    /**
     * parseFormula peab tagastama sõnena antud lausearvutuse valemile
     * vastava andmestruktuuri.
     *
     * Süntaktiliselt mittekorrektsete valemite korral tuleb visata erind.
     */
    public static Formula parseFormula(String formula) {
        throw new UnsupportedOperationException();
    }
 
    /**
     * moveNegations peab tagastama uue valemi, kus kõik eitused on
     * viidud vahetult lausemuutujate ette järgmiste reeglite põhjal:
     *
     *  ¬(¬F)  === F
     *  ¬(F&G) === ¬F∨¬G
     *  ¬(F∨G) === ¬F&¬G
     *  ¬(F→G) === F&¬G
     *  ¬(F↔G) === F↔¬G
     * 
     *  Näiteks valemile ¬(A∨B&(¬(¬C))) peab moveNegations andma vastu valemi ¬A&(¬B∨¬C).
     * 
     *  NB! Antud reeglites tähistavad F ja G suvalisi valemeid, mitte tingimata
     *  ainult lausemuutujaid.
     * 
     *  NB! Kuigi eitusi saaks sisse viia ka teisiti, tuleks praegu kasutada
     *  just neid teisendusi.
     * 
     *  NB! See ülesanne pole nii tähtis, kui parseFormula, seega ära jäta selle kodutöö
     *  põhiosa tegemata pelgalt selle pärast, et moveNegations tundub liiga keeruline.
     *  (Tegelikult on see palju lihtsam, kui esmapilgul paistab.)
     */
    public static Formula moveNegations(Formula valem) {
        throw new UnsupportedOperationException();
    }
 
}
 
 
/**
 * Klassi Formula ei ole vaja muuta
 * (aga tõenäoliselt tahad luua sellele konkreetseid alamklasse).
 *
 * Soovi korral võid siia ka meetodeid juurde lisada.
 */
abstract class Formula {
    /**
     * Konkreetsete valemi puhul peab toString andma valemi tavapärasel
     * infikssel kujul, aga nii, et kõigi binaarsete tehete ümber on sulud
     * ja eituste ning lausemuutujate ümber (vahetult) sulge ei ole.
     * Näiteks valemile A∨B&(¬(¬C)) vastava Formula korral peaks toString-i
     * tulemus olema "(A∨(B&¬¬C))"; valemi A&B&C&D puhul peab tulemus olema
     * "(((A&B)&C)&D)".
     *
     * Tulemus ei tohi sisaldada tühikuid.
     */
    @Override
    abstract public String toString();
 
 
    /**
     * Konkreetsetes alamklassides peab equals tagastama true parajasti siis,
     * kui argumendiks on Formula, millel on täpselt sama struktuur
     * (sh. muutujanimed), nagu sellel valemil.
     */
    @Override
    abstract public boolean equals(Object obj);
 
    /**
     * Konkreetsetes alamkassides peab evaluate tagastama valemi väärtuse
     * näidatud väärtustusel.
     *
     * Kui mõne muutuja väärtus puudub, siis tuleb visata erind
     * (seda ka siis, kui valemi väärtus selle muutuja väärtusest ei sõltu).
     */
    abstract public boolean evaluate(Map<Character, Boolean> variableValues);
}