
public class NodeUtils {
 
    /**
     * Meetod peab tagastama t�isarvu, mis n�itab mitu korda esineb antud (alam)puus
     * n�idatud v��rtus. NB! V�rdlemiseks kasutada meetodit equals!
     */
    public static <T> int count(Node<T> tree, T value) {
        // TODO: kirjuta erindi viskamise asemele enda kood
        throw new UnsupportedOperationException();
    }
 
 
    /**
     * NB! See on raskem �lesanne. Enne selle �ritamist lahenda ja esita teised �lesanded �ra!
     *
     *
     * See meetod peab v�tma suluesituses s�nena antud puu ja tagastama vastava
     * puu andmestruktuuri. Tippudes oleva v��rtuse t��p on Integer.
     *
     * S�ne formaat on sama, nagu kirjeldatud Node.toString juures.
     *
     * N�ited
     *
     * Kui k�ivitada
     *
     *      puu = makeIntegerTree("(1, (2, _, (3, _, _)), (3, _, _))");
     *
     * siis puu.getLeft().getRight().getValue() peab tagastama 3
     * ja   puu.getRight().isLeaf() peab tagastama true
     * ja   NodeUtils.count(puu, 3) peab tagastama 2
     *
     */
    public static Node<Integer> parseIntegerTree(String s) {
        // TODO: kirjuta erindi viskamise asemele enda kood
        throw new UnsupportedOperationException();
    }
}