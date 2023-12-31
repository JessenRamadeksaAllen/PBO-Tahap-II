package sistemperpustakaan;

import java.util.ArrayList;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Admin {
    private int idAdmin;
    private String nama;

    public Admin(int idAdmin, String nama) {
        this.idAdmin = idAdmin;
        this.nama = nama;
    }
    ArrayList<AnggotaPerpustakaan> daftarAnggota = new ArrayList<>();
    ArrayList<Buku> daftarbuku = new ArrayList<>();

    
    public void addBuku(int idBuku, String judul, String noISBN, String statusKetersediaan){
        Buku buku = new Buku(idBuku, judul, noISBN, statusKetersediaan);
        daftarbuku.add(buku);
        System.out.println("Berhasil Menambah Buku " + judul);
    }
    
    public void hapusBuku(String judul) {
    Iterator<Buku> iterator = daftarbuku.iterator();
    while (iterator.hasNext()) {
        Buku buku = iterator.next();
        if (buku.getJudul().contains(judul)) {
            iterator.remove();  // Safely remove the current element
            System.out.println("Berhasil Menghapus Buku " + judul);
            System.out.println(" ");
        }
    }
}
    public void addAnggota(String nama, int noAnggota, String alamat){
        AnggotaPerpustakaan a = new AnggotaPerpustakaan(nama, noAnggota, alamat);
        daftarAnggota.add(a);
    }
    
    public void lihatAnggota(){
        StringBuilder daftar = new StringBuilder();
        System.out.println("\nDaftar Anggota Perpus");
        for(AnggotaPerpustakaan v : daftarAnggota){
            daftar.append("Nama : " + v.getNama());
            daftar.append("\nNomor : " + v.getNoAnggota());
            daftar.append("\nAlamat : " + v.getAlamat() + "\n\n");
            System.out.println(daftar.toString());
        }
    }

    public void kirimNotifikasi(AnggotaPerpustakaan anggota, int idNotif, int noAnggota, String pesan, LocalDate now) {
        Notifikasi notifikasi = new Notifikasi(idNotif, noAnggota, pesan, now);
        anggota.notif.add(notifikasi);
    }

    public void kirimNotifikasi(AnggotaPerpustakaan anggota, int idNotif, int noAnggota, String pesan, LocalDate now, transaksiPeminjaman transaksi) {
        Notifikasi notifikasi = new Notifikasi(idNotif, noAnggota, pesan, now, transaksi);
        anggota.notif.add(notifikasi);
    }

    public void kembalikanBuku(String judul) {
        for (AnggotaPerpustakaan anggota : daftarAnggota) {
            if (anggota.riwayatPeminjaman.size() > 0) {
                for (Buku buku : anggota.riwayatPeminjaman) {
                    if (buku.getJudul().equals(judul)) {
                        buku.setStatusKetersediaan("Tersedia");
                        anggota.riwayatPeminjaman.remove(buku);
                        System.out.println("Berhasil Mengembalikan Buku " + judul);
                        return;  // Keluar dari metode setelah menemukan dan mengembalikan buku
                    }
                }
            }
        }
        System.out.println("Buku " + judul + " tidak ditemukan dalam riwayat peminjaman.");
    }



}
    

