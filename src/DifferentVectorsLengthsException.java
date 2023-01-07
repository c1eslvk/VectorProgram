import java.lang.reflect.Array;
import java.util.ArrayList;

public class DifferentVectorsLengthsException extends Exception {
    private ArrayList<Integer> lengths = new ArrayList<>();

    public DifferentVectorsLengthsException(String message, ArrayList<MyVector> vectors) {
        super(message);
        for (MyVector v: vectors) {
            lengths.add(v.getLength());
        }
    }

    public ArrayList<Integer> getLengths() {
        return lengths;
    }

}