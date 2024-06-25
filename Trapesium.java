public class Trapesium {

    public double sisiSejajar1;
    public double sisiSejajar2;
    public double tinggi;

    Trapesium(String sisiSejajar1, String sisiSejajar2, String tinggi){
        this.sisiSejajar1 = Double.parseDouble(sisiSejajar1);
        this.sisiSejajar2 = Double.parseDouble(sisiSejajar2);
        this.tinggi = Double.parseDouble(tinggi);
    }
    public double hitungLuas(){
        return (this.sisiSejajar1 + this.sisiSejajar2) * 0.5 * this.tinggi;
    }
    public double hitungKeliling() {
        double sisiMiring = Math.sqrt(Math.pow(tinggi, 2) + Math.pow((sisiSejajar1 - sisiSejajar2) / 2, 2));
        double keliling = sisiSejajar1 + sisiSejajar2 + 2 * sisiMiring;
        return keliling;
    }
    public String toString() {
        return "(Luas Trapesium: " + this.hitungLuas() + " & Kelilingnya adalah " + this.hitungKeliling() + ")";
    }
}

