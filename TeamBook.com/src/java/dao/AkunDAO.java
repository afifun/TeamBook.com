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
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Akun;
import model.Keranjang;

public class AkunDAO {
	static Connection currentCon = null;
	static ConnectionManager con = null;
	static ResultSet rs = null;
	String propertiesFileName = "config.properties";
	Properties properti = null;
	
	public AkunDAO() throws IOException {
		con = new ConnectionManager();
		currentCon = con.getConnection();
//		properti = new Properties();
//		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
//		properti.load(inputStream);		
	}

	public Akun login(Akun acc) throws Exception {
		Statement stmt = null;
		String email = acc.getEmail();
		String password = acc.getPassword();		
		con = new ConnectionManager();
		currentCon = con.getConnection();
		String query;

		query = "select * from akun where email='" + email
				+ "' AND password='" + password + "'";

		stmt = currentCon.createStatement();
		rs = stmt.executeQuery(query);
		boolean exist = rs.next();
                
                if (!exist) {
			acc.setValid(false);
		} else {
			
                        acc = acc.load(rs);
                        acc.setValid(true);
                        
			System.out.println(rs.getString(4)+" MASUK GA SIH");
		}
		return acc;
	}
	
	public boolean delete(String id) throws SQLException {

		boolean isSucces = false;

		Statement stmt = null;
		String query = "DELETE FROM account where id = " + id;
		
		stmt = currentCon.createStatement();
		int rowsUpdate = stmt.executeUpdate(query);
		if (rowsUpdate > 0) {
			isSucces = true;
		}

		return isSucces;
	}

	
	public Akun getInfoAkun(String id) throws Exception {

		Statement stmt = null;
		ResultSet rs = null;

		Akun akun = new Akun();

		String query = "Select * from akun where id = " + id;
		stmt = currentCon.createStatement();

		rs = stmt.executeQuery(query);
		boolean exist = rs.next();

		if (exist) {
			akun = Akun.load(rs);
		}
		stmt.close();

		return akun;
	}

	public boolean create(Akun acc) throws Exception {
            
		con = new ConnectionManager();
		currentCon = con.getConnection();

		boolean isSucces = false;
		String nama = acc.getNama();
		String password = acc.getPassword();
                String email = acc.getEmail();
                boolean isAdmin = acc.isIsAdmin();
                
                if(!cekEmail(email)){
                    PreparedStatement psmt = null;

                    String query = "insert into akun values(?,?,?,?,?)";

                    psmt = currentCon.prepareStatement(query);

                    psmt.setString(1, null);
                    psmt.setString(2, nama);
                    psmt.setString(3, password);
                    psmt.setString(4, email);
                    if (isAdmin){
                       psmt.setString(5, "1"); 
                    }
                    else {
                       psmt.setString(5, "0");
                    }


                    int rowsUpdate = psmt.executeUpdate();

                    if (rowsUpdate > 0) {
                            KeranjangDAO dao = new KeranjangDAO();
                            Keranjang kr = new Keranjang();
                            kr.setIdAkun(getAkunId(email, nama));
                            dao.create(kr);
                            isSucces = true;
                    } else {
                            System.out.println("GAK MASUK WOI");
                    }
		
                }
                return isSucces;
        }
        
        public boolean cekEmail(String email) throws IOException, SQLException{
            con = new ConnectionManager();
            currentCon = con.getConnection();

            String query = "select * from akun where email='" + email +"'";

            PreparedStatement psmt = currentCon.prepareStatement(query);

            ResultSet rs = psmt.executeQuery();
            
            return rs.first();
        }
        
        public String getAkunId(String email, String nama) throws IOException, SQLException{
            String id = null;
            
            con = new ConnectionManager();
            currentCon = con.getConnection();
            
            String query = "select * from akun where email='" + email +"'";
            
            PreparedStatement psmt = currentCon.prepareStatement(query);
            ResultSet rs = psmt.executeQuery();
            System.out.println("print : " + rs.next());
            
            rs.first();
            id = rs.getString("id");
            
            return id;
        }
       
	public List<Akun> selectAllAkun() throws Exception {
		List<Akun> list = new ArrayList<Akun>();
		ResultSet rs = null;
		Statement stmt = null;

		String query = "Select * from account where role='donatur' ORDER BY id DESC";
		stmt = currentCon.createStatement();

		rs = stmt.executeQuery(query);
		while (rs.next()) {
			Akun acc = new Akun();
			// set fields of c
			acc = Akun.load(rs);
			list.add(acc);
		}

		if (rs != null)
			rs.close();

		stmt.close();
		return list;

	}
	
//	public boolean update(Akun akun) throws SQLException, IOException {
//		
//		Statement stmt = null;
//
//		boolean isSucces = false;
//		int update;
//		String id = akun.getId();		
//		String namaDonatur = akun.getNamaDonatur();
//		String password = akun.getPassword();
//		String username = akun.getUsername();	
//					
//		
//		String query = "update account set username = '" + username + "', password = '" + password + "', namaDonatur = '" + namaDonatur + "' where id ='" + id + "'";
//		
//		stmt = currentCon.createStatement();
//
//		update = stmt.executeUpdate(query);	
//
//		stmt.close();
//		
//		if(update > 0){
//			isSucces = true;
//		}		
//		
//		return isSucces;
//	}
//	
//	public boolean isDuplicateUsername(String username) throws SQLException{
//		Statement stmt = null;
//		ResultSet rs;
//		
//		String query = "select * from account where username = '" + username +"'";
//		stmt = currentCon.createStatement();
//		rs = stmt.executeQuery(query);
//		if(rs.next()) return true;
//		else return false;
//	}
//	
//	public ArrayList<Program> getProgramByDonatur(String donatur) throws SQLException{
//		ArrayList<Program> listProgram = new ArrayList<Program>();
//		
//		Statement stmt = null;
//		ResultSet rs;
//		
//		String query = "select * from program where donatur like '%" + donatur +"%'";
//		stmt = currentCon.createStatement();
//		rs = stmt.executeQuery(query);
//		while(rs.next()){
//			Program pgm = Program.load(rs);
//			listProgram.add(pgm);
//		}
//		
//		return listProgram;
//	}

    public List<Akun> getAllListAkun() throws IOException, SQLException {
        
        con = new ConnectionManager();
        currentCon = con.getConnection();
        
        String query = "select * from akun";
        
        PreparedStatement psmt = currentCon.prepareStatement(query);
        
        ResultSet rs = psmt.executeQuery();
        
        List<Akun> list = new ArrayList();
        
        while(rs.next()){
            Akun akun = new Akun();
            akun.setNama(rs.getString("nama"));
            akun.setPassword(rs.getString("password"));
            akun.setEmail(rs.getString("email"));
            
            if(rs.getString("isAdmin").equals("1")){
                akun.setIsAdmin(true);
            }
            else {
                akun.setIsAdmin(false);
            }
            
            list.add(akun);
            
        }    
        return list;
        }
}

