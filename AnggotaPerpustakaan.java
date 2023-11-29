package sistemperpustakaan;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class AnggotaPerpustakaan extends SistemPerpustakaan{
   private String nama;
        private int noAnggota;
        private String alamat;
        ArrayList<Buku> riwayatPeminjaman = new ArrayList<>();
        private Admin adm;
        ArrayList<Notifikasi> notif = new ArrayList<>();
        
    public AnggotaPerpustakaan(String nama, int noAnggota, String alamat, Admin adm) {
        this.nama = nama;
        this.noAnggota = noAnggota;
        this.alamat = alamat;
        this.adm = adm;
        adm.daftarAnggota.add(this);
    }

    public AnggotaPerpustakaan(String nama, int noAnggota, String alamat) {
        this.nama = nama;
        this.noAnggota = noAnggota;
        this.alamat = alamat;
    }

    public AnggotaPerpustakaan() {
    }

    
    public void pinjamBuku(String judul){
        boolean bisa = false;
        for(Buku v : adm.daftarbuku){
            if(v.getJudul().contains(judul)){
               riwayatPeminjaman.add(v);
                System.out.println("Sukses");
                v.setStatusKetersediaan("Tidak Ada");
                bisa = true;
            }
        }
        if(!bisa){
            System.out.println("Buku Tidak Ada");
            bisa = false;
        }
    }
    
    public void cariBuku(String Judul){
        boolean ditemukan =false;
        for(Buku v : adm.daftarbuku){
            if(v.getJudul().contains(Judul)){
                System.out.println("Buku " + v.getJudul() +" " + v.getStatusKetersediaan());
                ditemukan = true;
            }
        }
        if(!ditemukan){
            System.out.println(Judul + " Buku Tidak Ditemukan\n");
            ditemukan = false;
        }
    }
    
    public void VieRiwayatPeminjaman(){
        StringBuilder daftarP = new StringBuilder();
        System.out.println("\nDaftar Peminjaman Buku Anggota " + this.nama);
        daftarP.append("Buku : ");
        for(Buku v : riwayatPeminjaman){
            daftarP.append(v.getJudul() + ", ");
        }
        System.out.println(daftarP.toString());
    }

    public void tampilkanNotifikasi(){
        System.out.println("Berikut Keterangan Peminjaman : ");
        for (Notifikasi notifikasi : notif) {
            System.out.println(notifikasi.getPesan());

            transaksiPeminjaman transaksi = notifikasi.getTransaksi();
            if (transaksi != null) {
                transaksi.catatanPeminjaman();
            }
        }

    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoAnggota(int noAnggota) {
        this.noAnggota = noAnggota;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public int getNoAnggota() {
        return noAnggota;
    }

    public String getAlamat() {
        return alamat;
    }

   
        
}       
