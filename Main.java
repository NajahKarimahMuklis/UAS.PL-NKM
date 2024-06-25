import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nMENCARI LUAS DAN KELILING TRAPESIUM");
        System.out.println("====================================");
        String namaFile = "src/trapesiumData.txt";
        String namaFile2 = "src/SortedKeliling.txt";
        List<Trapesium> trapezoid = new ArrayList<>();
        boolean isFirstLine = true;

        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                Trapesium p = new Trapesium(data[0], data[1], data[2]);
                trapezoid.add(p);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(trapezoid);

        for (int i = 0; i < trapezoid.size() - 1; i++) {
            for (int j = i + 1; j < trapezoid.size(); j++) {
                double keliling1 = trapezoid.get(i).hitungKeliling();
                double keliling2 = trapezoid.get(j).hitungKeliling();
                if (keliling1 > keliling2) {
                    Trapesium temp = trapezoid.get(i);
                    trapezoid.set(i, trapezoid.get(j));
                    trapezoid.set(j, temp);
                }
            }
        }
        System.out.println("\nKeliling yang sudah di sorting dari yang paling kecil ke yang paling besar: ");
        for (int i = 0; i < trapezoid.size(); i++) {
            Trapesium trapesium = trapezoid.get(i);
            System.out.println(trapesium.hitungKeliling());
            if (i < trapezoid.size() - 1) {
                System.out.print("");
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile2))) {
            for (Trapesium trapesium : trapezoid) {
                bw.write(String.valueOf(trapesium.hitungKeliling()));
                bw.newLine();
            }
            System.out.println("\nKeliling yang sudah diurutkan ditulis ke dalam file: " + namaFile2);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
