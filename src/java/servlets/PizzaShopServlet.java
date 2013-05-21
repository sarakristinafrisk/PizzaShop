/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.IngredientListBean;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author emmarangert
 */
public class PizzaShopServlet extends HttpServlet {
    private static String shopPage=null;

    private static String jdbcURL = null;
    private IngredientListBean ingredientList = null;

    /**
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        shopPage = config.getInitParameter("SHOP_PAGE");


        jdbcURL = config.getInitParameter("JDBC_URL");
        
        try {
            ingredientList = new IngredientListBean("jdbc:mysql://localhost/pizzashop?user=root&password=yourpasswordhere");//jdbcURL);//"jdbc:mysql://localhost/pizzashop?user=root&password=yourpasswordhere");
        } catch(Exception e) {
            throw new ServletException(e);
        }
        
        // servletContext is the same as scope Application
	// store the booklist in application scope
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("ingredientList", ingredientList);
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        HttpSession sess = request.getSession();
        RequestDispatcher rd = null;
        sess.setAttribute("jdbcURL",jdbcURL);
        
        
        if(request.getParameter("action") == null) {
            rd = request.getRequestDispatcher("/login.jsp"); 
            rd.forward(request,response);
                
        } else if (request.getParameter("action").equals("shop")){
	    
            // A request dispatcher that's connected to the page.
	    
            //Rätta till så att den hämtar i web.xml
            rd = request.getRequestDispatcher("/shop.jsp"); 
            rd.forward(request,response);
        } else if (request.getParameter("action").equals("editProfile")) {
             rd = request.getRequestDispatcher("/create_profile.jsp"); 
            rd.forward(request,response);
        } else if (request.getParameter("action").equals("checkout")) {
             rd = request.getRequestDispatcher("/check_out.jsp"); 
            rd.forward(request,response);
        }
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
