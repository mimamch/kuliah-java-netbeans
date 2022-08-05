/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Controller {
    Connection koneksi=null;
    Statement sta=null;
    
    public static Connection getController() {
        Connection konek=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            konek=DriverManager.getConnection("jdbc:mysql://localhost/toko_db", "root", "");
            Statement st=konek.createStatement();
           
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "Gagal terkoneksi karena" + a);
            a.printStackTrace();
        }
        
       return konek; 
    }
    
    public Controller() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi=DriverManager.getConnection("jdbc:mysql://localhost/toko_db", "root", "");
            sta=koneksi.createStatement();
            
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "Gagal terkoneksi karena" + a);
            a.printStackTrace();
        }
        
        
    }
    
    
    
    
    
    public void simpanPelanggan(Model_pelanggan pelanggan){
        try {
            
            String simpan = "INSERT INTO pelanggan VALUES "
                    + "('"+pelanggan.getKodePelanggan()+"',"
                    + "'"+pelanggan.getNamaPelanggan()+"',"
                    + "'"+pelanggan.noHp+"',"
                    + "'"+pelanggan.alamat+"')";
            sta = koneksi.createStatement();
            int save = sta.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan" + e);
            e.printStackTrace();
        }
    }
    
    public void simpanPengguna(Model_pengguna pengguna){
        
        try {
            
            String simpan = "INSERT INTO pengguna VALUES "
                     + "('"+pengguna.getNik()+"',"
                    + "'"+pengguna.getNamaLengkap()+"',"
                    + "'"+pengguna.getNoHp()+"',"
                    + "'"+pengguna.getJenisPengguna()+"',"
                    + "'"+pengguna.getUsername()+"',"
                    + "'"+pengguna.getPassword()+"')";
//           
            sta = koneksi.createStatement();
            int save = sta.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan" + e);
            e.printStackTrace();
        }
    }
    public void simpanBarang(Model_barang barang){
        
        try {
            
            String simpan = "INSERT INTO barang VALUES "
                     + "('"+barang.getKodeBarang()+"',"
                    + "'"+barang.getNamaBarang()+"',"
                    + "'"+barang.getHargaBarang()+"',"
                    + "'"+barang.getJumlahBarang()+"')";
//           
            sta = koneksi.createStatement();
            int save = sta.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan" + e);
            e.printStackTrace();
        }
    }
    
    public void ubahBarang(Model_barang barang){
        try {
            String simpan = "UPDATE barang SET namaBarang='"+barang.getNamaBarang()+"',"
                    + "hargaBarang = '"+barang.getHargaBarang()+"',"
                    + "jumlahBarang = '"+barang.getJumlahBarang()+"',"
                    + "WHERE kodeBarang = '"+barang.getKodeBarang()+"'";
            sta = koneksi.createStatement();
            int save = sta.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Berhasil Mengubah Data!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan" + e);
            e.printStackTrace();
        }
    }
    
    
    
}
