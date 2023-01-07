import java.util.ArrayList;

public class MyVector {
    private ArrayList<Integer> vector = new ArrayList<>();

    public MyVector() {}
    public MyVector(String vectorString) {
        String[] values = vectorString.split(",");
        for (String s : values) {
            try {
                Integer value = Integer.parseInt(s);
                vector.add(value);
            } catch (NumberFormatException ignored) {
            }
        }
    }
    public int getLength() {
        return vector.size();
    }

    @Override
    public String toString() {
        String vectorString = "[";
        int i = 0;
        for (Integer value: vector) {
            vectorString = vectorString + value.toString();
            if (++i != vector.size()) {
                vectorString = vectorString + ", ";
            }
        }
        vectorString = vectorString + "]";
        return vectorString;
    }

    public MyVector add(MyVector other) {
        MyVector temp = new MyVector();

        for (int i = 0; i < this.getLength(); i++) {
            temp.vector.add(this.vector.get(i) + other.vector.get(i));
        }

        return temp;
    }
}
