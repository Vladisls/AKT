/**
 * Klass on m�eldud kahendpuu tipu esitamiseks. T��biparameeter T m��rab, millist
 * t��pi v��rtust saab tipus hoida. V��rtuse k�simiseks on meetod getValue.
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
     * Tagastab true tippude korral, millel pole �htegi alampuud.
     */
    public boolean isLeaf() {
        return this.getLeftChild() == null && this.getRightChild() == null;
    }
 
 
    /**
     * Meetod peab tagastama true v�i false vastavalt sellele, kas antud (alam)puus
     * leidub n�idatud v��rtus. V�rdlemine toimub meetodi equals alusel.
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
     * Puu iga tipp on esitatud �marsulgudes antud kolmikuna, kus esimene
     * element on tipu v��rtus, teine element on vasak alluv ning kolmas on parem alluv.
     * Kui alluv puudub, siis on s�nes vastaval kohal allkriips.
     *
     * Komponentide vahel peab olema koma ja �ks t�hik.
     *
     * N�ited:
     * kui t on �hetipuline puu t��biga Node<Integer>,
     * mille tipu v��rtus on 3, siis t.toString() peab tagastama
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