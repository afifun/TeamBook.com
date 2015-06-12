/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AkunDAO;
import dao.BuktiTransferDAO;
import dao.BukuCheckoutDAO;
import dao.CheckoutDAO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Akun;
import model.BuktiTransfer;
import model.BukuCheckout;
import model.Checkout;

/**
 *
 * @author moh.afifun
 */

@MultipartConfig
public class Konfirmasi extends HttpServlet {

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
            out.println("<title>Servlet Konfirmasi</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Konfirmasi at " + request.getContextPath() + "</h1>");
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
        System.out.println(temp);
        if(temp == null){
            String site = "Login" ;
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
        }
        String IDOrder = request.getParameter("IDOrder");
        request.setAttribute("IDOrder", IDOrder);
        request.getRequestDispatcher("konfirmasi.jsp").forward(request, response);
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
        Akun tempe = (Akun) request.getSession().getAttribute("currentSessionUser");
        if(tempe == null){
            String site = "Login" ;
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
        }
        else {
            String IDOrder = request.getParameter("id_order");
        BuktiTransfer bt = new BuktiTransfer();
        bt.setIdCheckout(Long.parseLong(IDOrder));
        bt.setGambarPath("images/bukti_transfer/" + IDOrder + ".jpg");
        
        BuktiTransferDAO dao = new BuktiTransferDAO();
        CheckoutDAO daoC = new CheckoutDAO();
        AkunDAO daoAkun = new AkunDAO();
        BukuCheckoutDAO daoBC = new BukuCheckoutDAO();
        
        
        InputStream filecontent = null;
        Part filePart = request.getPart("bukti_transfer");
        
        if (filePart.getSize() > 0) {
            filecontent = filePart.getInputStream();
        } else {
            filecontent = new FileInputStream("default.jpg");
        }
        
        if(dao.add(bt, filecontent)){
            Checkout co = daoC.getCheckout(IDOrder);
            Akun temp = daoAkun.getAkun("" + co.getIdAkun());
            co.setStatus(2);
            daoC.update(co);
            response.sendRedirect("ListCheckout?id="+temp.getId());
        }
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

    private static String kirim(java.lang.String waktu, java.lang.String namaBarang, java.lang.String paket, java.lang.String link, java.lang.String alamattujuan, java.lang.String alamatasal, java.lang.String kotaasal, java.lang.String kotatujuan, java.lang.String berat, java.lang.String keterangan, java.lang.String teleponpenerima, java.lang.String teleponpengirim, java.lang.String namapenerima, java.lang.String namapengirim, java.lang.String username) {
        service.PentolineService_Service service = new service.PentolineService_Service();
        service.PentolineService port = service.getPentolineServicePort();
        return port.kirim(waktu, namaBarang, paket, link, alamattujuan, alamatasal, kotaasal, kotatujuan, berat, keterangan, teleponpenerima, teleponpengirim, namapenerima, namapengirim, username);
    }
    
    

}
