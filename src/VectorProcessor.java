import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class VectorProcessor {
    private ArrayList<MyVector> vectors = new ArrayList<>();

    public void setVectors(int numOfVectors) {
        if (!vectors.isEmpty()) {
            vectors.clear();
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert vectors: ");
        for (int i = 0; i < numOfVectors; i++) {
            vectors.add(new MyVector(scan.next()));
        }
    }

    public ArrayList<MyVector> getVectors() {
        return vectors;
    }

    private void checkLengths() throws DifferentVectorsLengthsException{
        Iterator<MyVector> it = vectors.iterator();
        int compareLength = it.next().getLength();
        int counter = 0;

        while (it.hasNext()) {
            if (compareLength != it.next().getLength()) {
                throw new DifferentVectorsLengthsException("Vectors have different lengths.", vectors);
            }
            counter++;
        }
    }

    public MyVector addVectors() throws DifferentVectorsLengthsException {
        Iterator<MyVector> it = vectors.iterator();
        MyVector added = it.next();
        checkLengths();

        while(it.hasNext()) {
            added = added.add(it.next());
        }

        return added;
    }
}
