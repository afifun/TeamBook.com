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
public class EditBook extends HttpServlet {

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
            out.println("<title>Servlet EditBook</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditBook at " + request.getContextPath() + "</h1>");
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
        
        String id = request.getParameter("id");
        
        BukuDAO dao = new BukuDAO();
        
        try {
            Buku buku = dao.getBuku(id);
            System.out.println(id);
            request.setAttribute("buku", true);
            request.setAttribute("bukuobj", buku);
            request.getRequestDispatcher("editBook.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
		if(temp == null || !temp.isIsAdmin()){
			String site = "Login" ;
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		}
                
        BukuDAO dao = new BukuDAO();
        String id = request.getParameter("id");
        String judul = request.getParameter("judul");
        String kategori = request.getParameter("kategori");
        String isbn = request.getParameter("isbn");
        String deskripsi = request.getParameter("deskripsi");
        String harga = request.getParameter("harga");
        InputStream filecontent = null;
        
        System.out.println(judul);

        Part filePart = request.getPart("gambar");
        
        System.out.println("gambar : " + filePart);
        
        if(filePart != null){
            if (filePart.getSize() > 0) {
                filecontent = filePart.getInputStream();
            } 
        }
        
        Buku bk = new Buku();
        bk.setId(id);
        bk.setJudul(judul);
        bk.setDeskripsi(deskripsi);
        bk.setHarga(harga);
        bk.setKategori(kategori);
        bk.setIsbn(isbn);
        bk.setGambar(filecontent);
        
        try {
            if(dao.update(bk)){
                request.setAttribute("buku", true);
                request.setAttribute("notifikasi", "Sukses! Buku berhasil diubah");
            }
            else {
                request.setAttribute("buku", true);
                request.setAttribute("notifikasi", "Gagal! Buku gagal diubah");
            }
            request.getRequestDispatcher("editBook.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
