// Burak Kızılay
// 05180000063
package pkg05180000063;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Dosya bulunamazsa exception fırlatılır.
        Scanner scanner = new Scanner(new FileInputStream("input.txt"));

        // GeometrikNesne tipinde array
        GeometrikNesne[] array = new GeometrikNesne[100];
        int nesneSay = 0;  // nesne sayısı ve index tutacak değişken

        // Gerekli referanslar sonradan atanmak üzere oluşturulur
        Daire ilkDaire = null, daire = null;
        Dikdortgen ilkDikdortgen = null, dikdortgen = null;
        Silindir ilkSilindir = null, silindir = null;

        while (scanner.hasNextLine()) {
            // tip ve etiket dosyadan okunur.
            // tip değerine göre iflere girilir ve nesne oluşturma işlemleri yapılır.
            // oluşturulan nesneler array'in unique bir indexine atılır ve nesneSay 1 arttırılır.
            // ilk başta null atadığımız ilk.. referansları ilk girdikleri yerde ilk oluşturulan objeyi göstericeklerdir.
            // daire, dikdortgen, silindir isimli değişkenler daha sonra copy constructor'a gönderilecektir, dolayısıyla sondan bir önceki değişkenler olurlar

            String tip = scanner.next();
            String etiket = scanner.next();
            if (tip.equals("daire")) {
                double yaricap = scanner.nextDouble();
                scanner.next();
                int ay = scanner.nextInt();
                int gun = scanner.nextInt();
                int yil = scanner.nextInt();
                daire = new Daire(etiket, new Date(ay, gun, yil), yaricap);
                array[nesneSay++] = daire;
                if (ilkDaire == null) {
                    ilkDaire = daire;
                }
            }
            else if (tip.equals("dikdortgen")) {
                double en = scanner.nextDouble();
                double boy = scanner.nextDouble();
                scanner.next();
                int ay = scanner.nextInt();
                int gun = scanner.nextInt();
                int yil = scanner.nextInt();
                dikdortgen = new Dikdortgen(etiket, new Date(ay, gun, yil), en, boy);
                array[nesneSay++] = dikdortgen;
                if (ilkDikdortgen == null) {
                    ilkDikdortgen = dikdortgen;
                }
            }
            else {
                double yaricap = scanner.nextDouble();
                double uzunluk = scanner.nextDouble();
                scanner.next();
                int ay = scanner.nextInt();
                int gun = scanner.nextInt();
                int yil = scanner.nextInt();
                silindir = new Silindir(etiket, new Date(ay, gun, yil), yaricap, uzunluk);
                array[nesneSay++] = silindir;
                if (ilkSilindir == null) {
                    ilkSilindir = silindir;
                }
            }

        }

        // daire, dikdortgen ve silindir sondan bir önceki değişkenlerdir
        // son değişkenler copy constructorlarla oluşturulur ve listeye atılır
        Daire sonDaire = new Daire(daire);
        array[nesneSay++] = sonDaire;
        Dikdortgen sonDikdortgen = new Dikdortgen(dikdortgen);
        array[nesneSay++] = sonDikdortgen;
        Silindir sonSilindir = new Silindir(silindir);
        array[nesneSay++] = sonSilindir;


        // Karşılaştırma işlemlerini yapmak üzere polymorfik yazılmış karsilastir methodu çağırılır
        karsilastir(ilkDaire, sonDaire);
        karsilastir(sonDaire, daire);

        karsilastir(ilkDikdortgen,sonDikdortgen);
        karsilastir(sonDikdortgen, dikdortgen);

        karsilastir(ilkSilindir, sonSilindir);
        karsilastir(sonSilindir, silindir);


        // Son istatistikleri hesaplamak amacıyla oluşturduğum değişkenler
        double minCevre = Double.MAX_VALUE, minAlan = Double.MAX_VALUE, minHacim = Double.MAX_VALUE;
        double maxCevre = 0, maxAlan = 0, maxHacim = 0;
        double toplamCevre = 0, toplamAlan = 0, toplamHacim = 0;
        int silindirSay = 0;

        // Döngü içerisinde toplam değişkenleri artar,
        // Objenin çevre, alan, hacim değerleri bunların minimum değişkenlerinden küçükse ve/veya
        // maksimum değişkenlerinden büyükse bu değişkenlerle değiştirilir
        for (int i = 0; i < nesneSay; i++) {
            GeometrikNesne obje = array[i];
            double objeCevresi = obje.cevreHesapla(), objeAlani = obje.alanHesapla();

            toplamCevre += objeCevresi;
            toplamAlan += objeAlani;
            if (objeCevresi > maxCevre) {
                maxCevre = objeCevresi;
            }
            if (objeCevresi < minCevre) {
                minCevre = objeCevresi;
            }
            if (objeAlani > maxAlan) {
                maxAlan = objeAlani;
            }
            if (objeAlani < minAlan) {
                minAlan = objeAlani;
            }

            if (obje instanceof Silindir) {
                double objeHacmi = ((Silindir) obje).hacimHesapla();
                toplamHacim += objeHacmi;
                silindirSay += 1;
                if (objeHacmi > maxHacim) {
                    maxHacim = objeHacmi;
                }
                if (objeHacmi < minHacim) {
                    minHacim = objeHacmi;
                }
            }
        }

        // Ortalama değerleri için toplam değişkenler nesne sayılarına bölünür.
        double cevreOrt = toplamCevre / nesneSay;
        double alanOrt = toplamAlan / nesneSay;
        double hacimOrt = toplamHacim / silindirSay;


        // Ekrana bastırmak için listeler oluşturulur
        double[] istatistikler = {cevreOrt, alanOrt, hacimOrt, minCevre, maxCevre, minAlan, maxAlan, minHacim, maxHacim};
        String[] ekranaBastirilacaklar = {"Çevre Ortalaması: ", "Alan Ortalaması: ", "Hacim Ortalaması: ", "En küçük çevre: ",
                "En büyük çevre: ", "En küçük alan: ", "En büyük alan: ", "En küçük hacim: ", "En büyük hacim: "};

        // İstatistikler ekrana bastırılır
        for (int i = 0; i < 9; i++) {
            System.out.println(ekranaBastirilacaklar[i] + istatistikler[i]);
        }


    }


    public static void polymorphicYazdir(GeometrikNesne geometrikNesne) {
        // polymorphicYazdir methodu, parametre olarak GeometrikNesne objesi alır.
        // Type casting yapmadan, geometrikNesne değişkeni üzerinden class'ların kendi methodlarını çağırır.
        // Obje silindirse ekrana hacim değeri de bastırılır.
        System.out.println(geometrikNesne);
        System.out.println("Çevresi: " + geometrikNesne.cevreHesapla());
        System.out.println("Alanı: " + geometrikNesne.alanHesapla());
        if (geometrikNesne instanceof Silindir) {
            System.out.println("Hacmi: " + ((Silindir)geometrikNesne).hacimHesapla());
        }
    }



    public static void karsilastir(GeometrikNesne geometrikNesne1, GeometrikNesne geometrikNesne2) {
        // karsilastir polymorphic bir methoddur.
        // parametre gelen GeometrikNesne hangi subclass'a aitse onun compareTo methodu çağırılır.
        int deger = geometrikNesne1.compareTo(geometrikNesne2);

        // Eşitlik değerlerine göre ekrana çıktılar bastırılır.
        switch (deger) {
            case 1:
                System.out.println(geometrikNesne1.getEtiket() + " > " + geometrikNesne2.getEtiket());
                break;
            case -1:
                System.out.println(geometrikNesne1.getEtiket() + " < " + geometrikNesne2.getEtiket());
                break;
            case 0:
                System.out.println(geometrikNesne1.getEtiket() + " = " + geometrikNesne2.getEtiket());
        }
    }
}
