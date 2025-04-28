
package pkg05180000063;

public abstract class GeometrikNesne implements Comparable {
    private String etiket;
    private Date date;

    public GeometrikNesne() {
        this.etiket = "İsimsiz";
        this.date = new Date();
    }

    public GeometrikNesne(String etiket, Date date) {
        this.etiket = etiket;
        this.date =  new Date(date);
    }

    public GeometrikNesne(GeometrikNesne aNesne) {
        this.etiket = aNesne.etiket;
        this.date = new Date(aNesne.date);
    }


    public String getEtiket() {
        return etiket;
    }

    public void setEtiket(String etiket) {
        this.etiket = etiket;
    }

    public Date getDate() {
        return new Date(this.date);
    }

    public void setDate(Date date) {
        this.date = new Date(date);
    }


    @Override
    public String toString() {
        return "GeometrikNesne{" +
                "etiket='" + etiket + '\'' +
                ", date=" + date +
                '}';
    }


    public abstract double alanHesapla();
    public abstract double cevreHesapla();
    @Override
    public abstract int compareTo(Object o);
}
