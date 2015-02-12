/**
 * Klass on mõeldud kahendpuu tipu esitamiseks. Tüübiparameeter T määrab, millist
 * tüüpi väärtust saab tipus hoida. Väärtuse küsimiseks on meetod getValue.
 *
 */
public class Node<T> {
	
	final public T value;
    final public Node<T> leftChild;
    final public Node<T> rightChild;
    
	public Node(T value, Node<T> leftChild, Node<T> rightChild) {
    		this.value = value;
    		this.leftChild = leftChild;
    		this.rightChild = rightChild;
    		
    }
 
    public T getValue() {
        return this.value;
    }
 
    /**
     * Tagastab vasaku alampuu. Selle puudumisel tagastab null-i.
     */
    public Node<T> getLeftChild() {
        return this.leftChild;
    }
 
    public Node<T> getRightChild() {
    	return this.rightChild;
    };
 
    /**
     * Tagastab true tippude korral, millel pole ühtegi alampuud.
     */
    public boolean isLeaf() {
        return this.getLeftChild() == null && this.getRightChild() == null;
    }
 
 
    /**
     * Meetod peab tagastama true või false vastavalt sellele, kas antud (alam)puus
     * leidub näidatud väärtus. Võrdlemine toimub meetodi equals alusel.
     */
    public boolean contains(T value) {
        if (this.getValue().equals(value)){
        	return true;
        } else {
        	return (this.getLeftChild() == null)? this.getLeftChild().contains(value) : false 
        			|| (this.getRightChild() == null)? this.getRightChild().contains(value) : false ;
        }
    }
 
    /**
     * toString peab tagastama puu suluesituse.
     *
     * Formaat:
     * Puu iga tipp on esitatud ümarsulgudes antud kolmikuna, kus esimene
     * element on tipu väärtus, teine element on vasak alluv ning kolmas on parem alluv.
     * Kui alluv puudub, siis on sõnes vastaval kohal allkriips.
     *
     * Komponentide vahel peab olema koma ja üks tühik.
     *
     * Näited:
     * kui t on ühetipuline puu tüübiga Node<Integer>,
     * mille tipu väärtus on 3, siis t.toString() peab tagastama
     * "(3, _, _)"
     * 
     * 
     * Kui t on selline puu:
     *      1
     *     / \
     *    /   \
     *   2    -44
     *    \
     *     3
     * 
     * siis t.toString() peab tagastama
     *
     * "(1, (2, _, (3, _, _)), (-44, _, _))"
     */
    @Override
    public String toString() {
        return "(" + this.getValue() + "," + ( (this.getLeftChild() != null)? this.getLeftChild().toString() : "_" ) + "," + ( (this.getRightChild() != null)? this.getRightChild().toString() : "_" ) + ")";
         	
    }
 
    /**
     * Soovi korral implementeeri ka meetodid equals ja hashCode
     */
}