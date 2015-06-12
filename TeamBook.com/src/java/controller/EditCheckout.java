/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AkunDAO;
import dao.BuktiTransferDAO;
import dao.CheckoutDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Akun;
import model.BuktiTransfer;
import model.Checkout;

/**
 *
 * @author moh.afifun
 */
public class EditCheckout extends HttpServlet {

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
            out.println("<title>Servlet EditCheckout</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditCheckout at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        CheckoutDAO dao = new CheckoutDAO();
        BuktiTransferDAO daoBT = new BuktiTransferDAO();
        BuktiTransfer bt = daoBT.getBuktiTransferByCheckout(id);
        Checkout ck = dao.getCheckout(id);
        
        request.setAttribute("checkout", ck);
        request.setAttribute("bukti_transfer", bt);
        request.getRequestDispatcher("edit-checkout.jsp").forward(request, response);
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
        
        String konfirmasi = request.getParameter("konfirmasi");
        String IDOrder = request.getParameter("ID");
        CheckoutDAO daoC = new CheckoutDAO();
        AkunDAO daoAkun = new AkunDAO();
        if(konfirmasi != null){
            Checkout co = daoC.getCheckout(IDOrder);
            Akun temp = daoAkun.getAkun("" + co.getIdAkun());
            String result = kirim(co.getWaktuPenerimaan(), "Paket buku " + temp.getNama(), co.getJenisPaket(), "http://teambook.cloudapp.net", temp.getAlamatShipping(), "Jalan Margonda", "Depok", temp.getKota(), ""+co.getBeratPaket(),"Paket buku harus sampai pada " + temp.getNama() + ", pada pukul " + co.getWaktuPenerimaan() + " WIB.", temp.getPhone(), "081233115617", temp.getNama(), "TeamBook", "teambook");
            
            StringTokenizer token = new StringTokenizer(result, "|");
            token.nextToken();
            String id = token.nextToken();
            co.setStatus(3);
            co.setIdOrderKurir(id);
            daoC.update(co);
            response.sendRedirect("ListCheckoutAdmin");
        }
        else {
            response.sendRedirect("ListCheckoutAdmin");
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
