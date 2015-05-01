/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BukuCheckoutDAO;
import dao.CheckoutDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Akun;
import model.BukuCheckout;
import model.BukuKeranjang;
import model.Checkout;
import model.Keranjang;

/**
 *
 * @author moh.afifun
 */
public class UserCheckout extends HttpServlet {

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
            out.println("<title>Servlet UserCheckout</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserCheckout at " + request.getContextPath() + "</h1>");
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
        double biayaPaketTotal = (double) request.getSession().getAttribute("biayapaket_total");
        
        Calendar cal = Calendar.getInstance();
        java.util.Date date = cal.getTime();
        
        String token = "" + temp.getId()  + (int) cal.getTimeInMillis();
        
        CheckoutDAO dao = new CheckoutDAO();
        BukuCheckoutDAO daoBC = new BukuCheckoutDAO();
        
        Checkout newCk = new Checkout();
        newCk.setId(Long.parseLong(token));
        newCk.setBank(namaBank);
        newCk.setIdAkun(temp.getId());
        newCk.setStatus(1);
        newCk.setBiayaPengiriman(biayaPaketTotal);
        newCk.setNamaKurir(namaKurir);
        newCk.setJenisPaket(jenisPaket);
        newCk.setTanggal(date);
        
        dao.add(newCk);
        
        
        List<BukuKeranjang> bukuList = keranjangTmp.getItemsKeranjang();
        
        for(BukuKeranjang item : bukuList){
            BukuCheckout newBC = new BukuCheckout();
            newBC.setIdBuku(item.getIdBuku());
            newBC.setIdOrder(Integer.parseInt(token));
            newBC.setKuantitas(item.getKuantitas());
            daoBC.add(newBC);
        }
        
        request.getRequestDispatcher("success-checkout.jsp").forward(request, response);
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
        processRequest(request, response);
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
