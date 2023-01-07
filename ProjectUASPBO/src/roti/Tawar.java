/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roti;

/**
 *
 * @author Asus
 */
import fillingtopping.Filling;
import fillingtopping.Topping;
public class Tawar extends Roti implements Filling{
    //atribut jumlah roti yang akan dipesan
    private int jumlahPesanan ;
    //atribut constant untuk perbandingan 1 roti tawar dengan resep untuk 5 roti tawar pada soal
    public final double RASIO_TAWAR = 1.0 / 5;
    private int varian = 0;
    //atribut adonan roti manis
    private double beratAdonanPcs = 400;
    private double totalBeratAdonan = 2065;
    
    //atribut berat bahan adonan roti manis
    private double bTepungTerigu = 1000;
    private double bGulaPasir = 125;
    private double bButter = 100;
    private double bRagi = 20;
    private double bSusuBubuk = 250;
    private double bSusuCair = 200;
    private double bTelur = 70;
    private double bEsBatu = 300;
    
    //atribut berat bahan per kemasan
    private double bkTepungTerigu = 1000;
    private double bkGulaPasir= 1000;
    private double bkButter= 500;
    private double bkRagi= 11;
    private double bkSusuBubuk= 1000;
    private double bkSusuCair= 1000;
    private double bkTelur= 1000;
    private double bkEsBatu= 1000;
    
    //atribut berat bahan per kemasan
    private double hTepungTerigu = 40000;
    private double hGulaPasir= 25000;
    private double hButter= 23000;
    private double hRagi= 5000;
    private double hSusuBubuk= 39000;
    private double hSusuCair= 24000;
    private double hTelur= 23000;
    private double hEsbatu= 2000;
    
    //atribut berat filling dan topping per pcs roti
    private double bKeju = 80;
    private double bCokelat = 80;
    
    //atribut berat kemasan filling dan topping
    private double bkKeju = 250;
    private double bkCokelat = 500;
    
    //atribut harga filling dan topping per kemasan
    private double hargaFilling = 0;
    private double hKeju = 31000;
    private double hCokelat = 29000;
    
    //menghitung perolehan roti dari total berat adonan
    @Override
    public double perolehanRoti(){
        double banyakroti = Math.round(totalBeratAdonan / beratAdonanPcs);
        return banyakroti;
    }    
    
    //untuk menentukan jumlah roti yang akan dipesan oleh pelanggan
    @Override
    public double jumlahPesan(int a) {
        this.jumlahPesanan = a;
        return jumlahPesanan;
    }
    
    //rasio menentukan banyak bahan
    @Override
    public double rasio() {
        double rasio = this.jumlahPesanan / this.perolehanRoti();
        return rasio;
    }
    
    //menghitung berat setiap bahan yang dibutuhkan berdasarkan jumlah pesanan
    @Override
    public void hitungBeratBahan(){
        System.out.println("=======================================================");
        System.out.println("Tepung Terigu untuk "+ jumlahPesanan + " = " + this.bTepungTerigu*this.rasio() + " gram" +" seharga "+(hTepungTerigu*this.rasio()));
        System.out.println("Gula Pasir untuk "+ jumlahPesanan + " = " + this.bGulaPasir*this.rasio() + " gram");
        System.out.println("Butter untuk "+ jumlahPesanan + " = " + this.bButter*this.rasio() + " gram");
        System.out.println("Ragi untuk "+ jumlahPesanan + " = " + this.bRagi*this.rasio() + " gram");
        System.out.println("Susu bubuk untuk "+ jumlahPesanan + " = " + this.bSusuBubuk*this.rasio() + " gram");
        System.out.println("Susu cair untuk "+ jumlahPesanan + " = " + this.bSusuCair*this.rasio() + " gram");
        System.out.println("Telur untuk "+ jumlahPesanan + " = " + this.bTelur*this.rasio() + " gram");
        System.out.println("Es batu untuk "+ jumlahPesanan + " = " + this.bEsBatu*this.rasio() + " gram");
        System.out.println("=======================================================\n");
    }
    
    //menghitung total berat bahan untuk adonan
    @Override
    public double totalBeratBahan() {
        double totalberat = (bTepungTerigu * this.rasio()) + (bGulaPasir * this.rasio()) + (bButter * this.rasio()) +(bRagi * this.rasio()) + 
                            (bSusuBubuk * this.rasio()) + (bSusuCair * this.rasio()) + (bTelur * this.rasio()) + (bEsBatu * this.rasio());
        return totalberat;
    }
    
    //menghitung total harga bahan yang digunakan untuk 47 pcs
    @Override
    public double hargaBahan() {
        double hargaBahan = (bTepungTerigu / bkTepungTerigu * hTepungTerigu) + (bGulaPasir / bkGulaPasir * hGulaPasir) + 
                (bButter / bkButter * hButter) + (bRagi / bkRagi * hRagi) + (bSusuBubuk / bkSusuBubuk  * hSusuBubuk ) + 
                (bSusuCair / bkSusuCair * hSusuCair) + (bTelur / bkTelur * hTelur) + (bEsBatu / bkEsBatu * hEsbatu);
        return hargaBahan;
    }
    
    public double totalHargaBahanPcs(){
        double totalHargaBahanPcs = RASIO_TAWAR * this.hargaBahan();
        return totalHargaBahanPcs;
    }
    
    //menghitung total harga untuk jumlah pesanan 
    @Override
    public double totalHargaBahan() {
        double totalHarga = this.hargaBahan() * this.rasio();
        return totalHarga; 
    }
    
    //setter dan getter untuk varian
    public int getVarian() {
        return varian;
    }

    public void setVarian(int varian) {
        if(varian > 0 && varian < 3){
           this.varian = varian;
           
       }else{
           System.out.println("Pilihan yang Anda masukkan tidak tersedia");
           System.exit(0);
       }
    }
    
    //menghitung harga filling roti
    @Override
    public double hitungHargaFilling(int varian){
        if(varian == 1){
            this.hargaFilling = bCokelat / bkCokelat * hCokelat;
        }else if(varian == 2){
            this.hargaFilling = bKeju / bkKeju * hKeju;
        }else{
            System.out.println("Input yang Anda masukkan salah");
        }
        
        return hargaFilling;
    }
    
    //menghitung harga pokok roti per pcs 
    @Override
    public double hitungHargaPcs() {
        double hargaPcs = this.totalHargaBahanPcs() + this.hitungHargaFilling(varian);
        return hargaPcs;
    }
    
    //menghitung harga jual roti per pcs
    @Override
    public double hargaJualPcs(){
        double hargaJualPcs = Math.round(this.hitungHargaPcs() * 1.5);
        return hargaJualPcs;
    }
}
