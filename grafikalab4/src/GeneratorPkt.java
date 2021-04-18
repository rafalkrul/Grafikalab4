import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GeneratorPkt {

    File plik = new File("kubek.txt");
    File plik2 = new File("kubekPoFormacie.txt");
    Scanner scanner = new Scanner(plik);
    BufferedWriter writer = new BufferedWriter(new FileWriter(plik2));
    Punkt[][] inputPoints = new Punkt[4][4];


    public GeneratorPkt() throws IOException {
    }

    static int newton (int n, int k)
    {
        if (k == 0 || k == n)
            return 1;
        else
            return newton(n-1, k-1) + newton(n-1, k);
    }

    static Double berstein(int m, int i, double v){
        return newton(m,i) * Math.pow(v,i) * Math.pow(1-v,m-i);
    }

    public void generowaniePunktow() throws IOException {
        double x,y,z;
        x=0.0;y=0.0;z=0.0;
        int iloscplaszczyzn = scanner.nextInt();
        writer.write("x, y, z"+System.lineSeparator());
        for(int p=0;p<iloscplaszczyzn;p++){

            for(int q=0;q<4;q++){
                for(int qq=0;qq<4;qq++){
                    double tempx = Double.parseDouble(scanner.next());
                    double tempy = Double.parseDouble(scanner.next());
                    double tempz = Double.parseDouble(scanner.next());
                    inputPoints[q][qq] = new Punkt(tempx,tempy,tempz);
                }
            }
            for(double v=0.0;v<=1.0;v+=0.01) {
                for(double w=0.0;w<=1.0;w+=0.01){
                    for (int i=0;i<4;i++){
                        for(int j=0; j<4 ;j++){
                            x += inputPoints[i][j].x * berstein(3,i,w) * berstein(3,j,v);
                            y += inputPoints[i][j].y * berstein(3,i,w) * berstein(3,j,v);
                            z += inputPoints[i][j].z * berstein(3,i,w) * berstein(3,j,v);
                        }
                    }
                    writer.write(x+","+y+","+z+System.lineSeparator());
                    x=0.0;y=0.0;z=0.0;
                }
            }
        }
        writer.close();


    }


}
