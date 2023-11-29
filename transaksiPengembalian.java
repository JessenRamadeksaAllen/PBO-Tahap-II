/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemperpustakaan;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author ASUS
 */
    public class transaksiPengembalian extends AnggotaPerpustakaan{
    private int idTransaksi;
    private int noAnggota;
    private int noISBN;
    private String tanggalPengembalian;
    private final Buku buku;
    public transaksiPengembalian(Buku buku){
        this.buku = buku;
    }
}


