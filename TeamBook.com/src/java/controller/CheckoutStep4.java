/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Akun;
import model.BukuKeranjang;
import model.Keranjang;

/**
 *
 * @author moh.afifun
 */
public class CheckoutStep4 extends HttpServlet {

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
            out.println("<title>Servlet CheckoutStep4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutStep4 at " + request.getContextPath() + "</h1>");
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
        Keranjang keranjangTmp = (Keranjang) request.getSession().getAttribute("currentSessionCart");
        String namaKurir = (String) request.getSession().getAttribute("nama_kurir");
        String jenisPaket = (String) request.getSession().getAttribute("jenis_paket");
        String namaBank = (String) request.getSession().getAttribute("nama_bank");
        double biayaPaket = (double) request.getSession().getAttribute("biaya_paket");
        System.out.println(namaKurir);
        
        List<BukuKeranjang> bukuList = keranjangTmp.getItemsKeranjang();
        
        int kuantitasTotal = 0;
        double hargaItemTotal = 0;
        
        for(BukuKeranjang item : bukuList){
            kuantitasTotal = kuantitasTotal + item.getKuantitas();
            hargaItemTotal = (hargaItemTotal + item.getKuantitas() * item.getBuku().getHarga());
        }
        
        HttpSession session = request.getSession(true);
        session.setAttribute("biayapaket_total", biayaPaket*kuantitasTotal);
        session.setAttribute("harga_item_total", hargaItemTotal);
        request.setAttribute("list", bukuList);
        request.getRequestDispatcher("checkout-4.jsp").forward(request, response);
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
