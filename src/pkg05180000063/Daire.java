
package pkg05180000063;

public class Daire extends GeometrikNesne{
    private double yaricap;

    public Daire() {
        super();
        this.yaricap = 1.0;
    }

    public Daire(String etiket, Date date, double yaricap) {
        super(etiket, date);
        this.yaricap = yaricap;
    }

    public Daire(Daire aDaire) {
        super(aDaire.getEtiket(), aDaire.getDate());
        this.yaricap = aDaire.yaricap;
    }


    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        this.yaricap = yaricap;
    }

    @Override
    public String toString() {
        return super.toString() + "Daire{" +
                "yaricap=" + yaricap +
                '}';
    }

    @Override
    public double alanHesapla() {
        return Math.PI * yaricap * yaricap;
    }

    @Override
    public double cevreHesapla() {
        return 2 * Math.PI * yaricap;
    }

    @Override
    public int compareTo(Object o) {
        Daire aDaire = (Daire) o;

        if (yaricap > aDaire.yaricap) {
            return 1;
        }
        else if (yaricap == aDaire.yaricap) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
