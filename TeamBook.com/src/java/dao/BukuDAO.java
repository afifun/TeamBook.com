/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author moh.afifun
 */
import connection.ConnectionManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Akun;
import model.Buku;

public class BukuDAO {

    static Connection currentCon = null;
    static ConnectionManager con = null;
    static ResultSet rs = null;
    String propertiesFileName = "config.properties";
    Properties properti = null;

    public BukuDAO() throws IOException {
        con = new ConnectionManager();
        currentCon = con.getConnection();
    }

    public boolean create(Buku buku) throws IOException, SQLException {

        con = new ConnectionManager();
        currentCon = con.getConnection();

        boolean isSucces = false;

        String judul = buku.getJudul();
        String kategori = buku.getKategori();
        String isbn = buku.getIsbn();
        String deskripsi = buku.getDeskripsi();
        String harga = buku.getHarga();
        InputStream filecontent = buku.getGambar();

        PreparedStatement psmt = null;

        String query = "insert into buku values(?,?,?,?,?,?,?)";

        psmt = currentCon.prepareStatement(query);

        psmt.setString(1, null);

        psmt.setString(2, isbn);
        System.out.println("isbn : " + isbn);

        psmt.setString(3, judul);
        System.out.println("judul : " + judul);

        psmt.setString(4, kategori);
        System.out.println("kategori : " + kategori);

        psmt.setString(5, deskripsi);
        System.out.println("deskripsi : " + deskripsi);

        psmt.setString(6, "images/" + isbn + ".jpg");

        psmt.setString(7, harga);
        System.out.println("harga : " + harga);

        int rowsUpdate = psmt.executeUpdate();

        if (rowsUpdate > 0) {

            OutputStream outputStream = new FileOutputStream(new File("C:/Users/moh.afifun/Documents/GitHub/TeamBook.com/TeamBook.com/web/images/" + isbn + ".jpg"));

            int read = 0;
            byte[] bytes = new byte[2048];

            while ((read = filecontent.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            if (filecontent != null) {
                try {
                    // outputStream.flush();
                    filecontent.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            isSucces = true;
        } else {
            System.out.println("GAK MASUK WOI");
        }
        return isSucces;

    }

    public boolean update(Buku buku) throws IOException, SQLException {

        Statement stmt = null;

        boolean isSucces = false;
        int update;
        String id = buku.getId();
        String judul = buku.getJudul();
        String kategori = buku.getKategori();
        String isbn = buku.getIsbn();
        String deskripsi = buku.getDeskripsi();
        String harga = buku.getHarga();
        String gambar = buku.getGambarPath();
        InputStream filecontent = buku.getGambar();

        PreparedStatement psmt = null;

        String query = "update buku set isbn = '" + isbn + "', judul = '" + judul + "', kategori = '" + kategori + "', deskripsi = '" + deskripsi + "', harga = '" + harga + "' where id ='" + id + "'";
        psmt = currentCon.prepareStatement(query);
        
        System.out.println("gambar : " + gambar);
        
        System.out.println("isbn : " + isbn);

        System.out.println("judul : " + judul);

        System.out.println("kategori : " + kategori);

        System.out.println("deskripsi : " + deskripsi);

        System.out.println("harga : " + harga);

        int rowsUpdate = psmt.executeUpdate();

        if (rowsUpdate > 0 && filecontent != null) {
            
            File f = new File("C:/Users/moh.afifun/Documents/GitHub/TeamBook.com/TeamBook.com/web/images/buku/" + isbn + ".jpg");

            Boolean flag = false;
            
            if (f.exists()) {
                flag = f.delete();
            }
                        
            OutputStream outputStream = new FileOutputStream(new File("C:/Users/moh.afifun/Documents/GitHub/TeamBook.com/TeamBook.com/web/images/buku/" + isbn + ".jpg"));

            int read = 0;
            byte[] bytes = new byte[2048];
            
                while ((read = filecontent.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }

                try {
                    // outputStream.flush();
                    filecontent.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            
            String query2 = "update buku set gambar = '" + "images/buku/" + isbn + ".jpg'" +  "' where id ='" + id + "'";
            psmt = currentCon.prepareStatement(query);
            psmt.executeUpdate();
            
            isSucces = true;
        } else {
            System.out.println("GAK MASUK WOI");
        }
        return isSucces;

    }

    public List<Buku> getAllListBuku() throws IOException, SQLException {
        con = new ConnectionManager();
        currentCon = con.getConnection();

        String query = "select * from buku";

        PreparedStatement psmt = currentCon.prepareStatement(query);

        ResultSet rs = psmt.executeQuery();

        List<Buku> list = new ArrayList();

        while (rs.next()) {
            Buku buku = new Buku();
            buku.setId(rs.getString("id"));
            buku.setJudul(rs.getString("judul"));
            buku.setHarga(rs.getString("harga"));
            buku.setDeskripsi(rs.getString("deskripsi"));
            buku.setIsbn(rs.getString("isbn"));
            buku.setKategori(rs.getString("kategori"));
            buku.setGambarPath(rs.getString("gambar"));

            list.add(buku);
        }
        return list;
    }

    public boolean delete(String isbn) throws SQLException {

        boolean isSucces = false;

        Statement stmt = null;
        String query = "DELETE FROM buku where isbn = " + isbn;

        stmt = currentCon.createStatement();
        int rowsUpdate = stmt.executeUpdate(query);
        if (rowsUpdate > 0) {
            isSucces = true;
        }

        return isSucces;
    }
    
    
    public List<Buku> getListBuku(List<Integer> id) throws IOException, SQLException {
        
        List<Buku> list = new ArrayList();
        for (Integer id1 : id) {
            list.add(getBuku(""+id1)); 
        }
        return list;
    }
    
    public Buku getBuku(String id) throws SQLException, IOException {
        boolean isSucces = false;

        con = new ConnectionManager();
        currentCon = con.getConnection();

        String query = "select * from buku where id = " + id;

        PreparedStatement psmt = currentCon.prepareStatement(query);

        ResultSet rs = psmt.executeQuery();

        List<Buku> list = new ArrayList();

        while (rs.next()) {
            Buku buku = new Buku();
            buku.setId(rs.getString("id"));
            buku.setJudul(rs.getString("judul"));
            buku.setHarga(rs.getString("harga"));
            buku.setDeskripsi(rs.getString("deskripsi"));
            buku.setIsbn(rs.getString("isbn"));
            buku.setKategori(rs.getString("kategori"));
            buku.setGambarPath(rs.getString("gambar"));
            System.out.println("gamabarku : " + rs.getString("gambar"));
            list.add(buku);

        }
        return list.get(0);
    }

}
