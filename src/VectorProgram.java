import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VectorProgram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("How many vectors would you like to insert?");

        while(!scan.hasNextInt()) {
            System.out.println("Wrong input. Enter Integer.");
            scan.next();
        }
        int numOfVectors = scan.nextInt();

        VectorProcessor vectorProcessor = new VectorProcessor();
        MyVector added;

        vectorProcessor.setVectors(numOfVectors);
        ArrayList<MyVector> vectors = vectorProcessor.getVectors();

        do {
            try {
                added = vectorProcessor.addVectors();
                break;
            } catch (DifferentVectorsLengthsException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getLengths().get(0) * e.getLengths().get(1));
                vectorProcessor.setVectors(numOfVectors);
                vectors = vectorProcessor.getVectors();
            }
        } while(true);

        fileHandler.writeToFile(added.toString());
        fileHandler.close();
    }
}