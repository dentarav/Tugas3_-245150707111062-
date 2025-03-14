import java.util.Scanner;

class PengirimanBarang {
    private String namaPengirim;
    private String alamatTujuan;
    private double berat;
    private double biayaDasar;
    private static int jumlahPengirim = 0;

    public PengirimanBarang() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan nama pengirim: ");
        this.namaPengirim = input.nextLine();
        
        System.out.print("Masukkan alamat tujuan: ");
        this.alamatTujuan = input.nextLine();
        
        System.out.print("Masukkan berat barang (kg): ");
        this.berat = input.nextDouble();
        
        System.out.print("Masukkan biaya dasar pengiriman: Rp ");
        this.biayaDasar = input.nextDouble();

        jumlahPengirim++;
    }
    
    public PengirimanBarang(String namaPengirim, String alamatTujuan, double berat, double biayaDasar) {
        this.namaPengirim = namaPengirim;
        this.alamatTujuan = alamatTujuan;
        this.berat = berat;
        this.biayaDasar = biayaDasar;
        jumlahPengirim++;
    }
    
    public double hitungOngkir(double diskonPersen) {
        return biayaDasar - (biayaDasar * diskonPersen / 100);
    }
    
    public double hitungOngkir(double diskonPersen, double biayaTambahan) {
        return (biayaDasar - (biayaDasar * diskonPersen / 100)) + biayaTambahan;
    }
    
    public double hitungOngkir(int jarak) {
        if (jarak > 50) {
            return biayaDasar + (biayaDasar * 0.10);
        } else {
            return biayaDasar - (biayaDasar * 0.05);
        }
    }
    
    public static void displayInfoLogistik() {
        System.out.println("Perusahaan Logistik Speed - Pengiriman Aman dan Secepat Kilat");
    }
    public static int getJumlahPengirim() {
        return jumlahPengirim;
    }
    
    public void displayInfo() {
        System.out.println("Nama Pengirim: " + namaPengirim);
        System.out.println("Alamat Tujuan: " + alamatTujuan);
        System.out.println("Berat Benda: " + berat + " Kg");
        System.out.println("Biaya Dasar: Rp " + biayaDasar);
    }
}

public class manajemenbarang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        PengirimanBarang.displayInfoLogistik();
        System.out.println();

        System.out.println("Data Pengiriman (Default Constructor):");
        PengirimanBarang pengirimanDefault = new PengirimanBarang();
        pengirimanDefault.displayInfo();
        
        System.out.println("Ongkir dengan diskon 10%: Rp " + pengirimanDefault.hitungOngkir(10.0));
        System.out.println("Ongkir dengan diskon 10% dan biaya tambahan Rp 5000: Rp " + pengirimanDefault.hitungOngkir(10, 5000));
        System.out.println("Ongkir berdasarkan jarak 70 km: Rp " + pengirimanDefault.hitungOngkir(70));
        System.out.println("Ongkir berdasarkan jarak 35 km: Rp " + pengirimanDefault.hitungOngkir(35));
        
        PengirimanBarang pengirimanOverload = new PengirimanBarang("Agung", "Jl. Soekarno Hatta", 12.5, 70000);
        System.out.println("\nData Pengiriman (Overload Constructor):");
        pengirimanOverload.displayInfo();
        
        System.out.println("Ongkir dengan diskon 10%: Rp " + pengirimanOverload.hitungOngkir(10.0));
        System.out.println("Ongkir dengan diskon 10% dan biaya tambahan Rp 5000: Rp " + pengirimanOverload.hitungOngkir(10, 5000));
        System.out.println("Ongkir berdasarkan jarak 70 km: Rp " + pengirimanOverload.hitungOngkir(70));
        System.out.println("Ongkir berdasarkan jarak 35 km: Rp " + pengirimanOverload.hitungOngkir(35));
        
        System.out.println("\nJumlah Pengirim: " + PengirimanBarang.getJumlahPengirim());
    }
}

