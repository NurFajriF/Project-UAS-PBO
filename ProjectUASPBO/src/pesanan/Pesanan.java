/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pesanan;

/**
 *
 * @author Asus
 */
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import roti.Manis;
import roti.Tawar;
import roti.Pizza;
public class Pesanan {
    private double hargaManis = 0;
    private double hargaTawar = 0;
    private double hargaPizza = 0;
    
    //memformat nominal harga ke format Rupiah
    public String currencyID(double nominal){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format((double)nominal);
    }
    
    //menampilkan pilihan menu roti untuk dipesan dengan input Scanner
    public void printMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("=======================================================");
        System.out.println("=================Toko Roti Ray Bakery==================");
        System.out.println("=======================================================\n");
        System.out.println("Daftar Roti:");
        System.out.println("1. Roti Manis");
        System.out.println("2. Roti Tawar Sandwich");
        System.out.println("3. Roti Pizza\n");
        System.out.print("Masukkan pesanan:");
        int jenisRoti = input.nextInt();
        
        switch (jenisRoti) {
            case 1:
                Manis m = new Manis();
                System.out.println("Varian 1 = filling keju dan coklat serta topping coklat");
                System.out.println("Varian 2 = filling red bean serta topping krim vanilla");
                System.out.println("Varian 3 = filling keju dan sosis");
                System.out.print("Pilih varian:");
                int varianManis = input.nextInt();
                m.setVarian(varianManis);
                System.out.print("Jumlah pesan: ");
                int jumlahPesanManis = input.nextInt();
                m.jumlahPesan(jumlahPesanManis);
                System.out.println("Bahan untuk roti manis varian " + varianManis + " sebanyak "+ jumlahPesanManis);
                m.hitungBeratBahan();
                //System.out.println("total harga bahan untuk 47 = "+ this.currencyID(m.hargaBahan()));
                System.out.println("total harga bahan per pcs = "+ this.currencyID(m.totalHargaBahanPcs()));
                System.out.println("total harga bahan untuk " + jumlahPesanManis + " = "+ this.currencyID(m.totalHargaBahan()));
                System.out.println("harga filling = "+ this.currencyID(m.hitungHargaFilling(varianManis)));
                System.out.println("harga topping = "+ this.currencyID(m.hitungHargaTopping(varianManis)));
                System.out.println("harga pokok pcs = "+ this.currencyID(m.hitungHargaPcs()));
                System.out.println("harga jual pcs = "+ this.currencyID(m.hargaJualPcs()));
                hargaManis = m.hargaJualPcs() * jumlahPesanManis;
                System.out.println("Total harga: " + this.currencyID(hargaManis));
                break;
            case 2:
                Tawar t = new Tawar();
                System.out.println("Varian 1 = sandwich dengan filling coklat");
                System.out.println("Varian 2 = sandwich dengan filling keju");
                System.out.println("Pilih varian:");
                int varianTawar = input.nextInt();
                t.setVarian(varianTawar);
                System.out.println("Jumlah pesan: ");
                int jumlahPesanTawar = input.nextInt();
                t.jumlahPesan(jumlahPesanTawar);
                System.out.println("Bahan untuk roti tawar varian " + varianTawar + " sebanyak "+ jumlahPesanTawar);
                t.hitungBeratBahan();
                //System.out.println("total harga bahan 5 = "+ this.currencyID(t.hargaBahan()));
                System.out.println("total harga bahan per pcs = "+ this.currencyID(t.totalHargaBahanPcs()));
                System.out.println("total harga bahan untuk " + jumlahPesanTawar + " = "+ this.currencyID(t.totalHargaBahan()));
                System.out.println("harga filling = "+ this.currencyID(t.hitungHargaFilling(varianTawar)));
                System.out.println("harga pokok pcs = "+ this.currencyID(t.hitungHargaPcs()));
                System.out.println("harga jual pcs = "+ this.currencyID(t.hargaJualPcs()));
                hargaTawar = t.hargaJualPcs() * jumlahPesanTawar;
                System.out.println("Total harga: " + this.currencyID(hargaTawar));
                break;
            case 3:
                Pizza p = new Pizza();
                System.out.println("Varian 1 = pizza dengan topping Keju, Bawang Bombay, Sosis dan Smoke Beef yang gurih");
                System.out.println("Pilih varian:");
                int varianPizza = input.nextInt();
                p.setVarian(varianPizza);
                System.out.println("Jumlah pesan: ");
                int jumlahPesanPizza = input.nextInt();
                p.jumlahPesan(jumlahPesanPizza);
                System.out.println("Bahan untuk roti pizza varian " + varianPizza + " sebanyak "+ jumlahPesanPizza);
                p.hitungBeratBahan();
                //System.out.println("total harga bahan untuk 10 = "+ this.currencyID(p.hargaBahan()));
                System.out.println("total harga bahan per pcs = "+ this.currencyID(p.totalHargaBahanPcs()));
                System.out.println("total harga bahan untuk " + jumlahPesanPizza + " = "+ this.currencyID(p.totalHargaBahan()));
                System.out.println("harga filling = "+ this.currencyID(p.hitungHargaTopping(varianPizza)));
                System.out.println("harga pokok pcs = "+ this.currencyID(p.hitungHargaPcs()));
                System.out.println("harga jual pcs = "+ this.currencyID(p.hargaJualPcs()));
                hargaPizza = p.hargaJualPcs() * jumlahPesanPizza;
                System.out.println("Total harga: " + this.currencyID(hargaPizza));
                break;
            default:
                System.out.println("Pilihan yang Anda masukkan tidak tersedia");
                break;
        }
        
        System.out.println("Pilih roti lain?(y/n)");
        char tambah = input.next().charAt(0);
        if(tambah =='y'){
            this.printMenu();
        }else{
            double totalHarga = hargaManis + hargaTawar + hargaPizza;
            System.out.println("Total Harga: " + this.currencyID(totalHarga) );
        }
    }
    
    
    //jika langsung assign untuk menampilkan rincian dari jumlah pesanan masing-masing roti    
    public void pesanManis1(int jumlahPesanan){
        Manis m1 = new Manis();
        m1.setVarian(1);
        m1.jumlahPesan(jumlahPesanan);
        System.out.println("Bahan untuk roti manis varian 1 sebanyak "+ jumlahPesanan);
        m1.hitungBeratBahan();
        System.out.println("total harga bahan per pcs = "+ this.currencyID(m1.totalHargaBahanPcs()));
        System.out.println("total harga bahan untuk " + jumlahPesanan + " = "+ this.currencyID(m1.totalHargaBahan()));
        System.out.println("harga filling = "+ this.currencyID(m1.hitungHargaFilling(1)));
        System.out.println("harga topping = "+ this.currencyID(m1.hitungHargaTopping(1)));
        System.out.println("harga pokok pcs = "+ this.currencyID(m1.hitungHargaPcs()));
        System.out.println("harga jual pcs = "+ this.currencyID(m1.hargaJualPcs()));
        double hargaManisM1 = m1.hargaJualPcs() * jumlahPesanan;
        System.out.println("Total harga: " + this.currencyID(hargaManisM1)+"\n");
    }
    
    public void pesanManis2(int jumlahPesanan){
        Manis m2 = new Manis();
        m2.setVarian(2);
        m2.jumlahPesan(jumlahPesanan);
        System.out.println("\nBahan untuk roti manis varian 2 sebanyak "+ jumlahPesanan);
        m2.hitungBeratBahan();
        System.out.println("total harga bahan per pcs = "+ this.currencyID(m2.totalHargaBahanPcs()));
        System.out.println("total harga bahan untuk " + jumlahPesanan + " = "+ this.currencyID(m2.totalHargaBahan()));
        System.out.println("harga filling = "+ this.currencyID(m2.hitungHargaFilling(2)));
        System.out.println("harga topping = "+ this.currencyID(m2.hitungHargaTopping(2)));
        System.out.println("harga pokok pcs = "+ this.currencyID(m2.hitungHargaPcs()));
        System.out.println("harga jual pcs = "+ this.currencyID(m2.hargaJualPcs()));
        double hargaManisM2 = m2.hargaJualPcs() * jumlahPesanan;
        System.out.println("Total harga: " + this.currencyID(hargaManisM2)+"\n");
    }
    
    public void pesanManis3(int jumlahPesanan){
        Manis m3 = new Manis();
        m3.setVarian(3);
        m3.jumlahPesan(jumlahPesanan);
        System.out.println("\nBahan untuk roti manis varian 3 sebanyak "+ jumlahPesanan);
        m3.hitungBeratBahan();
        System.out.println("total harga bahan per pcs = "+ this.currencyID(m3.totalHargaBahanPcs()));
        System.out.println("total harga bahan untuk " + jumlahPesanan + " = "+ this.currencyID(m3.totalHargaBahan()));
        System.out.println("harga filling = "+ this.currencyID(m3.hitungHargaFilling(3)));
        System.out.println("harga topping = "+ this.currencyID(m3.hitungHargaTopping(3)));
        System.out.println("harga pokok pcs = "+ this.currencyID(m3.hitungHargaPcs()));
        System.out.println("harga jual pcs = "+ this.currencyID(m3.hargaJualPcs()));
        double hargaManisM3 = m3.hargaJualPcs() * jumlahPesanan;
        System.out.println("Total harga: " + this.currencyID(hargaManisM3)+"\n");
    }
    
    public void pesanTawar1(int jumlahPesanan){
        Tawar t1 = new Tawar();
        t1.setVarian(1);
        t1.jumlahPesan(jumlahPesanan);
        System.out.println("\nBahan untuk roti tawar varian 1 sebanyak "+ jumlahPesanan );
        t1.hitungBeratBahan();
        System.out.println("total harga bahan per pcs = "+ this.currencyID(t1.totalHargaBahanPcs()));
        System.out.println("total harga bahan untuk " + jumlahPesanan + " = "+ this.currencyID(t1.totalHargaBahan()));
        System.out.println("harga filling = "+ this.currencyID(t1.hitungHargaFilling(1)));
        System.out.println("harga pokok pcs = "+ this.currencyID(t1.hitungHargaPcs()));
        System.out.println("harga jual pcs = "+ this.currencyID(t1.hargaJualPcs()));
        double hargaTawarT1 = t1.hargaJualPcs() * jumlahPesanan;
        System.out.println("Total harga: " + this.currencyID(hargaTawarT1));
    }
    
    public void pesanTawar2(int jumlahPesanan){
        Tawar t2 = new Tawar();
        t2.setVarian(2);
        t2.jumlahPesan(jumlahPesanan);
        System.out.println("\nBahan untuk roti tawar varian 2 sebanyak "+ jumlahPesanan );
        t2.hitungBeratBahan();
        System.out.println("total harga bahan per pcs = "+ this.currencyID(t2.totalHargaBahanPcs()));
        System.out.println("total harga bahan untuk " + jumlahPesanan + " = "+ this.currencyID(t2.totalHargaBahan()));
        System.out.println("harga filling = "+ this.currencyID(t2.hitungHargaFilling(2)));
        System.out.println("harga pokok pcs = "+ this.currencyID(t2.hitungHargaPcs()));
        System.out.println("harga jual pcs = "+ this.currencyID(t2.hargaJualPcs()));
        double hargaTawarT2 = t2.hargaJualPcs() * jumlahPesanan;
        System.out.println("Total harga: " + this.currencyID(hargaTawarT2));
    }
    
    public void pesanPizza1(int jumlahPesanan){
        Pizza p1 = new Pizza();
        p1.setVarian(1);
        p1.jumlahPesan(jumlahPesanan);
        System.out.println("\nBahan untuk roti pizza varian 1 sebanyak "+ jumlahPesanan);
        p1.hitungBeratBahan();
        System.out.println("total harga bahan per pcs = "+ this.currencyID(p1.totalHargaBahanPcs()));
        System.out.println("total harga bahan untuk " + jumlahPesanan + " = "+ this.currencyID(p1.totalHargaBahan()));
        System.out.println("harga filling = "+ this.currencyID(p1.hitungHargaTopping(1)));
        System.out.println("harga pokok pcs = "+ this.currencyID(p1.hitungHargaPcs()));
        System.out.println("harga jual pcs = "+ this.currencyID(p1.hargaJualPcs()));
        double hargaPizzaP1 = p1.hargaJualPcs() * jumlahPesanan;
        System.out.println("Total harga: " + this.currencyID(hargaPizzaP1));
    }
}
