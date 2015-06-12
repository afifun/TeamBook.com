/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BukuDAO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Akun;
import model.Buku;



/**
 *
 * @author moh.afifun
 */
@MultipartConfig
public class AddBook extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddBook</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddBook at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        Akun temp = (Akun) request.getSession().getAttribute("currentSessionUser");
		if(temp == null || !temp.getIsAdmin()){
			String site = "Login" ;
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		}
                request.setAttribute("buku", true);
        request.getRequestDispatcher("addBook.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        
        Akun temp = (Akun) request.getSession().getAttribute("currentSessionUser");
		if(temp == null || !temp.getIsAdmin()){
			String site = "Login" ;
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		}
                
        BukuDAO dao = new BukuDAO();
        String judul = request.getParameter("judul");
        Date tanggal_terbit  = Date.valueOf(request.getParameter("tanggal_terbit"));
        String kategori = request.getParameter("kategori");
        String isbn = request.getParameter("isbn");
        String deskripsi = request.getParameter("deskripsi");
        String harga = request.getParameter("harga");
        String pengarang = request.getParameter("pengarang");
        String penerbit = request.getParameter("penerbit");
        String stok = request.getParameter("stok");
        String berat = request.getParameter("berat");
        
        InputStream filecontent = null;
        
        System.out.println(judul);

        Part filePart = request.getPart("gambar");
        
        System.out.println("gambar : " + filePart);
        if (filePart.getSize() > 0) {
            filecontent = filePart.getInputStream();
        } else {
            filecontent = new FileInputStream("default.jpg");
        }
        
        Buku bk = new Buku();
        bk.setJudul(judul);
        bk.setPublishDate(tanggal_terbit);
        bk.setDeskripsi(deskripsi);
        bk.setHarga(Double.parseDouble(harga));
        bk.setKategori(kategori);
        bk.setIsbn(isbn);
        bk.setPenerbit(penerbit);
        bk.setAuthor(pengarang);
        bk.setBerat(Double.parseDouble(berat));
        bk.setStok(Integer.parseInt(stok));
        bk.setGambar("images/buku/" + isbn + ".jpg");
        
        if(dao.add(bk,filecontent)){
            request.setAttribute("buku", true);
            request.setAttribute("notifikasi1", "Sukses! Buku berhasil ditambahkan");
        }
        else {
            request.setAttribute("buku", true);
            request.setAttribute("notifikasi2", "Gagal! Buku gagal ditambahkan");
        }
        request.getRequestDispatcher("addBook.jsp").forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
