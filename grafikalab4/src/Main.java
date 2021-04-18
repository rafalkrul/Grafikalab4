import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        GeneratorPkt pointsGeneration = new GeneratorPkt();
        Scanner scanner = pointsGeneration.scanner;
        BufferedWriter writer = pointsGeneration.writer;
        pointsGeneration.generowaniePunktow();
    }


}
