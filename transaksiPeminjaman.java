package sistemperpustakaan;

import java.util.Date;
import java.time.LocalDate;

public class transaksiPeminjaman extends AnggotaPerpustakaan{
    private int idTransaksi;
    private int noAnggota;
    private int noISBN;
    private LocalDate tanggalPeminjaman;
    private LocalDate tenggatWaktu;
    private Buku buku;

    public transaksiPeminjaman(int idTransaksi, int noAnggota, int noISBN, LocalDate tanggalPeminjaman, LocalDate tenggatWaktu, Buku buku, int idAnggota, String nama, String alamat, String nomorAnggota) {
    //    super(idAnggota, nama, alamat, nomorAnggota);
        this.idTransaksi = idTransaksi;
        this.noAnggota = noAnggota;
        this.noISBN = noISBN;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tenggatWaktu = tenggatWaktu;
        this.buku = buku;
    }

    private transaksiPeminjaman(int idAnggota, String nama, String alamat, String nomorAnggota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getNoAnggota() {
        return noAnggota;
    }

    public void setNoAnggota(int noAnggota) {
        this.noAnggota = noAnggota;
    }

    public int getNoISBN() {
        return noISBN;
    }

    public void setNoISBN(int noISBN) {
        this.noISBN = noISBN;
    }

    public LocalDate getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public void setTanggalPeminjaman(LocalDate tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    public LocalDate getTenggatWaktu() {
        return tenggatWaktu;
    }

    public void setTenggatWaktu(LocalDate tenggatWaktu) {
        this.tenggatWaktu = tenggatWaktu;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }
    public void pinjamBuku(String judul) {
    boolean bisa = false;
    if (adm != null) {
        for (Buku v : adm.daftarbuku) {
            if (v.getJudul().contains(judul)) {
                riwayatPeminjaman.add(v);
                System.out.println("Sukses");
                v.setStatusKetersediaan("Tidak Ada");
                bisa = true;
            }
        }
    } else {
        System.out.println("Error: Objek admin (adm) bernilai null.");
        return;
    }

    if (!bisa) {
        System.out.println("Buku Tidak Ada");
    }
}



    public void catatanPeminjaman(){
        System.out.println("ID Transaksi: " + this.idTransaksi);
        System.out.println("Nomor anggota: " + this.noAnggota);
        System.out.println("Nomor ISBN: " + this.noISBN);
        System.out.println("Tanggal peminjaman: " + this.tanggalPeminjaman);
        System.out.println("Tanggal pengembalian: " + this.tenggatWaktu);

        System.out.println("Informasi buku:");
        System.out.println("ID buku: " + buku.getIdBuku());
        System.out.println("Judul: " + buku.getJudul());
        System.out.println("Nomor ISBN: " + buku.getNoISBN());
        System.out.println("Status ketersediaan: " + buku.getStatusKetersediaan());
    }
}
