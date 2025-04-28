
package pkg05180000063;

public class Silindir extends GeometrikNesne{
    private double yaricap;
    private double uzunluk;

    public Silindir() {
        super();
        this.yaricap = 1.0;
        this.uzunluk = 1.0;
    }

    public Silindir(String etiket, Date date, double yaricap, double uzunluk) {
        super(etiket, date);
        this.yaricap = yaricap;
        this.uzunluk = uzunluk;
    }

    public Silindir(Silindir aSilindir) {
        super(aSilindir.getEtiket(), aSilindir.getDate());
        this.yaricap = aSilindir.yaricap;
        this.uzunluk = aSilindir.uzunluk;
    }

    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }

    public double getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(double uzunluk) {
        this.uzunluk = uzunluk;
    }


    @Override
    public String toString() {
        return super.toString() + "Silindir{" +
                "yaricap=" + yaricap +
                ", uzunluk=" + uzunluk +
                '}';
    }

    @Override
    public double alanHesapla() {
        return (2 * Math.PI * yaricap) * (yaricap + uzunluk);
    }

    @Override
    public double cevreHesapla() {
        return (2 * 2 * yaricap * Math.PI) + (2 * uzunluk);
    }

    @Override
    public int compareTo(Object o) {
        Silindir aSilindir = (Silindir) o;
        if (hacimHesapla() > aSilindir.hacimHesapla()) {
            return 1;
        }
        else if (hacimHesapla() == aSilindir.hacimHesapla()) {
            return 0;
        }
        else {
            return -1;
        }
    }

    public double hacimHesapla() {
        return Math.PI * yaricap * yaricap * uzunluk;
    }

}
