/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AkunDAO;
import dao.KeranjangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Akun;
import model.Keranjang;

/**
 *
 * @author moh.afifun
 */
public class Register extends HttpServlet {

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
            out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
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
        
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
        
        String nama = request.getParameter("nama");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String provinsi = request.getParameter("provinsi");
        String kota = request.getParameter("kota");
        String kodePos = request.getParameter("kode_pos");
        String alamat_default = request.getParameter("alamat_default");
        String alamat_shipping = request.getParameter("alamat_shipping");
        
        
        Akun acc = new Akun();
        acc.setNama(nama);
        acc.setEmail(email);
        acc.setPassword(password);
        acc.setPhone(phone);
        acc.setProvinsi(provinsi);
        acc.setKota(kota);
        acc.setKodePos(kodePos);
        acc.setAlamatDefault(alamat_default);
        acc.setAlamatShipping(alamat_shipping);
        
        AkunDAO dao = new AkunDAO();
        KeranjangDAO daoK = new KeranjangDAO();
        
        try {
            if(dao.add(acc)){
                Keranjang newKr = new Keranjang();
                newKr.setIdAkun(dao.getAkunByEmail(acc.getEmail()).getId());
                daoK.add(newKr);
                request.getRequestDispatcher("success.jsp").forward(request, response);
            }
            else {
                request.setAttribute("notifikasi", "email sudah digunakan!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
