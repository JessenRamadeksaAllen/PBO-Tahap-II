package sistemperpustakaan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
public class SistemPerpustakaan {


    public static void main(String[] args) {
        Admin admin = new Admin(1, "Jayden");
        Scanner scanner = new Scanner(System.in);
        AnggotaPerpustakaan agt = new AnggotaPerpustakaan("Joseph", 1313, "Pagar Alam", admin);


        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Tambah Anggota");
            System.out.println("4. Lihat Anggota");
            System.out.println("5. Pinjam Buku");
            System.out.println("6. Cari Buku");
            System.out.println("7. Lihat Riwayat Peminjaman");
            System.out.println("8. Tampilkan Notifikasi");
            System.out.println("9. Kirim Notifikasi");
            System.out.println("10. Keluar");
            System.out.print("Pilih menu (1-10): ");

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judulBuku = scanner.nextLine();
                    admin.addBuku(admin.daftarbuku.size() + 1, judulBuku, "ISBN" + (admin.daftarbuku.size() + 1), "Tersedia");
                    break;
                case 2:
                    System.out.print("Masukkan judul buku yang akan dihapus: ");
                    String judulHapus = scanner.nextLine();
                    admin.hapusBuku(judulHapus);
                    break;
                case 3:
                    System.out.print("Masukkan nama anggota: ");
                    String namaAnggota = scanner.nextLine();
                    System.out.print("Masukkan nomor anggota: ");
                    int nomorAnggota = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan alamat anggota: ");
                    String alamatAnggota = scanner.nextLine();
                    admin.addAnggota(namaAnggota, nomorAnggota, alamatAnggota);
                    break;
                case 4:
                    admin.lihatAnggota();
                    break;
                case 5:
                    System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                    String judulPinjam = scanner.nextLine();

                    System.out.println("Pilih anggota untuk melakukan peminjaman:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }

                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaPinjam = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaPinjam >= 1 && nomorAnggotaPinjam <= admin.daftarAnggota.size()) {
                        AnggotaPerpustakaan anggota = admin.daftarAnggota.get(nomorAnggotaPinjam - 1);
                        anggota.pinjamBuku(judulPinjam);
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;
                case 6:
                    System.out.print("Masukkan judul buku yang ingin dicari: ");
                    String judulCari = scanner.nextLine();

                    System.out.println("Pilih anggota untuk melakukan pencarian:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }
                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaCari = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaCari >= 1 && nomorAnggotaCari <= admin.daftarAnggota.size()) {
                        AnggotaPerpustakaan anggotaCari = admin.daftarAnggota.get(nomorAnggotaCari - 1);
                        anggotaCari.cariBuku(judulCari);
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;
                case 7:
                    System.out.println("Pilih anggota untuk melihat riwayat peminjaman:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }
                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaRiwayat = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaRiwayat >= 1 && nomorAnggotaRiwayat <= admin.daftarAnggota.size()) {
                        AnggotaPerpustakaan anggotaRiwayat = admin.daftarAnggota.get(nomorAnggotaRiwayat - 1);
                        anggotaRiwayat.VieRiwayatPeminjaman();
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;
                case 8:
                    System.out.println("Pilih anggota untuk menampilkan notifikasi:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }
                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaNotif = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaNotif >= 1 && nomorAnggotaNotif <= admin.daftarAnggota.size()) {
                        AnggotaPerpustakaan anggotaNotif = admin.daftarAnggota.get(nomorAnggotaNotif - 1);
                        anggotaNotif.tampilkanNotifikasi();
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;
                case 9:
                    System.out.print("Masukkan ID Notifikasi: ");
                    int idNotif = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Pesan Notifikasi: ");
                    String pesanNotif = scanner.nextLine();

                    System.out.println("Pilih anggota untuk mengirim notifikasi:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }
                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaKirimNotif = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaKirimNotif >= 1 && nomorAnggotaKirimNotif <= admin.daftarAnggota.size()) {
                        AnggotaPerpustakaan anggotaKirimNotif = admin.daftarAnggota.get(nomorAnggotaKirimNotif - 1);
                        LocalDate timeStamp = LocalDate.now();
                        admin.kirimNotifikasi(anggotaKirimNotif, idNotif, anggotaKirimNotif.getNoAnggota(), pesanNotif, timeStamp);
                        System.out.println("Notifikasi berhasil dikirim.");
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;

                case 10:
                    System.out.println("Terima Kasih");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid. Pilih menu lain.");
                    break;
            }
        }
    }
}
