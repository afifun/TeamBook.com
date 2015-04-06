package dao;

/**
 *
 * @author moh.afifun
 */
import connection.ConnectionManager;
import static dao.AkunDAO.con;
import static dao.BukuDAO.con;
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
import model.BukuKeranjang;
import model.Keranjang;

public class KeranjangDAO {

    static Connection currentCon = null;
    static ConnectionManager con = null;
    static ResultSet rs = null;
    String propertiesFileName = "config.properties";
    Properties properti = null;

    public KeranjangDAO() throws IOException {
        con = new ConnectionManager();
        currentCon = con.getConnection();
    }

    public boolean create(Keranjang kr) throws IOException, SQLException {

        con = new ConnectionManager();
        currentCon = con.getConnection();

        boolean isSucces = false;

        String idAkun = kr.getIdAkun();

        PreparedStatement psmt = null;

        String query = "insert into keranjang values(?,?)";

        psmt = currentCon.prepareStatement(query);

        psmt.setString(1, null);

        psmt.setString(2, idAkun);

        int rowsUpdate = psmt.executeUpdate();

        if (rowsUpdate > 0) {

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
            
            File f = new File("C:/Users/moh.afifun/Documents/GitHub/TeamBook.com/TeamBook.com/web/images/" + isbn + ".jpg");

            Boolean flag = false;
            
            if (f.exists()) {
                flag = f.delete();
            }
                        
            OutputStream outputStream = new FileOutputStream(new File("C:/Users/moh.afifun/Documents/GitHub/TeamBook.com/TeamBook.com/web/images/" + isbn + ".jpg"));

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
            
            String query2 = "update buku set gambar = '" + "images/" + isbn + ".jpg'" +  "' where id ='" + id + "'";
            psmt = currentCon.prepareStatement(query);
            psmt.executeUpdate();
            
            isSucces = true;
        } else {
            System.out.println("GAK MASUK WOI");
        }
        return isSucces;

    }
    
    public Keranjang getKeranjang(String akunId) throws IOException, SQLException{
            String id = null;
            
            con = new ConnectionManager();
            currentCon = con.getConnection();
            
            String query = "select * from keranjang where id_akun=" + akunId;
            
            PreparedStatement psmt = currentCon.prepareStatement(query);
            ResultSet rs = psmt.executeQuery();
            System.out.println("print : " + rs.next());
            
            rs.first();
            id = rs.getString("id_keranjang");
            
            Keranjang kr = new Keranjang();
            kr.setIdAkun(akunId);
            kr.setIdKeranjang(id);
            
            return kr;
        }
    
    public boolean addItem(String idbuku, String idKeranjang) throws IOException, SQLException{
        con = new ConnectionManager();
        currentCon = con.getConnection();
        
        boolean success = false;
        int kuantitas = cekBuku(idbuku);
        PreparedStatement psmt = null;
        if(kuantitas > 0){
            String query = "update buku_keranjang set kuantitas=" + (kuantitas+1) + 
                    " where id_buku="+ idbuku + " and id_keranjang=" + idKeranjang;
            psmt = currentCon.prepareStatement(query);
        }
        else {
            String query = "insert into buku_keranjang values (?,?,?,?)";
            psmt = currentCon.prepareStatement(query);
            int id_buku;
            
            psmt.setString(1, null);
            psmt.setString(2, idbuku);
            psmt.setString(3, idKeranjang);
            psmt.setString(4, "1");
        }
        
        
        if(psmt.executeUpdate() > 0){
            success = true;
        }
        return success;
    }
    
    
    public int cekBuku(String id) throws IOException, SQLException{
            con = new ConnectionManager();
            currentCon = con.getConnection();

            String query = "select * from buku_keranjang where id_buku=" + id;

            PreparedStatement psmt = currentCon.prepareStatement(query);

            ResultSet rs = psmt.executeQuery();
            
            
            if (!rs.first()){
                return 0;
            }
            else {
                return  rs.getInt("kuantitas");
            }
    }
    
    

    public List<Integer> getAllIdBuku(String idKeranjang) throws IOException, SQLException {
        con = new ConnectionManager();
        currentCon = con.getConnection();

        String query = "select * from buku_keranjang where id_keranjang=" + idKeranjang;

        PreparedStatement psmt = currentCon.prepareStatement(query);

        ResultSet rs = psmt.executeQuery();

        List<Integer> list = new ArrayList();

        while (rs.next()) {
            list.add(rs.getInt("id_buku"));
        }
        return list;
    }
    
    
    public List<BukuKeranjang> getItemKeranjang(String idKeranjang) throws IOException, SQLException{
        List<BukuKeranjang> list = new ArrayList();
        BukuDAO dao = new BukuDAO();
        List<Buku> listBuku = dao.getListBuku(getAllIdBuku(idKeranjang));
        for (Buku buku : listBuku) {
            BukuKeranjang bk = new BukuKeranjang();
            bk.setBuku(buku);
            bk.setKeranjang(getKeranjang(idKeranjang));
            bk.setKuantitas("" + getKuantitas(idKeranjang, buku.getId()));
            
            list.add(bk);
        }
        return list;
    }
    
    public int getKuantitas(String idKeranjang, String idBuku) throws IOException, SQLException{
        con = new ConnectionManager();
        currentCon = con.getConnection();

        String query = "select * from buku_keranjang where id_keranjang=" + idKeranjang +" and id_buku=" + idBuku;

        PreparedStatement psmt = currentCon.prepareStatement(query);

        ResultSet rs = psmt.executeQuery();
        rs.first();
        int result = rs.getInt("kuantitas");
        
        return result;
    }
    public boolean delete(String id) throws SQLException {

        boolean isSucces = false;

        Statement stmt = null;
        String query = "DELETE FROM buku_keranjang where id_buku = " + id;

        stmt = currentCon.createStatement();
        int rowsUpdate = stmt.executeUpdate(query);
        if (rowsUpdate > 0) {
            isSucces = true;
        }

        return isSucces;
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
