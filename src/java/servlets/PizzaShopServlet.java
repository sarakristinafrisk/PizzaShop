/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.IngredientListBean;
import beans.ProfileBean;
import beans.ProfileListBean;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ProfileListBean profileList = null;
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
            ingredientList = new IngredientListBean("jdbc:mysql://localhost/PizzaShop?user=root&password=yourpasswordhere");//jdbcURL);//"jdbc:mysql://localhost/pizzashop?user=root&password=yourpasswordhere");
        } catch(Exception e) {
            throw new ServletException(e);
        }
        
        try {
            profileList = new ProfileListBean("jdbc:mysql://localhost/PizzaShop?user=root&password=yourpasswordhere");//jdbcURL);//"jdbc:mysql://localhost/pizzashop?user=root&password=yourpasswordhere");
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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        
        HttpSession sess = request.getSession();
        RequestDispatcher rd = null;
        sess.setAttribute("jdbcURL",jdbcURL);
        
        // A request dispatcher that's connected to the page.

        if(request.getParameter("action") == null) {
            rd = request.getRequestDispatcher("/login.jsp"); 
            rd.forward(request,response);
            
        } else if (request.getParameter("action").equals("loginCheck")){
            
            String user_name = request.getParameter("user_name_input");
            String user_password = request.getParameter("user_password_input");

            if (profileList.checkIfExisting(user_name, user_password)) {
                rd = request.getRequestDispatcher("/shop.jsp"); 
                rd.forward(request,response);
            } else {
                //Error page
            }
            
            

            
        } else if (request.getParameter("action").equals("shop")){
            //Rätta till så att den hämtar i web.xml
            rd = request.getRequestDispatcher("/shop.jsp"); 
            rd.forward(request,response);
            
        } else if (request.getParameter("action").equals("createProfile")) {
            rd = request.getRequestDispatcher("/create_profile.jsp"); 
            rd.forward(request,response);
                
        } else if (request.getParameter("action").equals("createProfileCheck")) {
            
           String user_name = request.getParameter("user_name_input");
           String user_password = request.getParameter("user_password_input");
           String user_firstname = request.getParameter("user_firstname_input");
           String user_surname = request.getParameter("user_surname_input");
           String user_email = request.getParameter("user_email_input");
           String user_address = request.getParameter("user_address_input");
           String user_postcode = request.getParameter("user_postcode_input");
           String user_city = request.getParameter("user_city_input");
           String user_country = request.getParameter("user_country_input");
           

           /*if (user_name.equals("") || user_firstname.equals("") || user_surname.equals("") || user_email.equals("") || 
                    user_address.equals("") || user_postcode.equals("") || user_city.equals("") || user_country.equals("")) {
               //Fel-sida
           } else */if (profileList.checkIfExisting(user_name)) {
               //Fel-sida
           } else {
               ProfileBean pBean = new ProfileBean();
               pBean.setUsername(user_name);
               pBean.setFirstname(user_firstname);
               pBean.setSurname(user_surname);
               pBean.setPassword(user_password);
               pBean.setEmail(user_email);
               pBean.setAddress(user_address);
               pBean.setPostcode(user_postcode);
               pBean.setCity(user_city);
               pBean.setCountry(user_country);

               profileList.addProfileBean(pBean);
               //Skapa böna
               
               rd = request.getRequestDispatcher("/shop.jsp"); 
               rd.forward(request,response);
           }
           
            
             
        } else if (request.getParameter("action").equals("editProfile")) {
            
            /* FYLL I FÄLT */
            
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PizzaShopServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PizzaShopServlet.class.getName()).log(Level.SEVERE, null, ex);
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
