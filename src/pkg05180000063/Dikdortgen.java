
package pkg05180000063;

public class Dikdortgen extends GeometrikNesne{
    private double en;
    private double boy;

    public Dikdortgen() {
        super();
        this.en = 1.0;
        this.boy = 1.0;
    }

    public Dikdortgen(String etiket, Date date, double en, double boy) {
        super(etiket, date);
        this.en = en;
        this.boy = boy;
    }

    public Dikdortgen(Dikdortgen aDikdortgen) {
        super(aDikdortgen.getEtiket(), aDikdortgen.getDate());
        this.en = aDikdortgen.en;
        this.boy = aDikdortgen.boy;
    }

    public double getEn() {
        return en;
    }

    public void setEn(double en) {
        this.en = en;
    }

    public double getBoy() {
        return boy;
    }

    public void setBoy(double boy) {
        this.boy = boy;
    }


    @Override
    public String toString() {
        return super.toString() + "Dikdortgen{" +
                "en=" + en +
                ", boy=" + boy +
                '}';
    }


    @Override
    public double alanHesapla() {
        return en * boy;
    }

    @Override
    public double cevreHesapla() {
        return en + en + boy + boy;
    }

    @Override
    public int compareTo(Object o) {
        Dikdortgen aDikdortgen = (Dikdortgen) o;

        if (alanHesapla() > aDikdortgen.alanHesapla()) {
            return 1;
        }
        else if (alanHesapla() == aDikdortgen.alanHesapla()) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
