
package servelets;

import comandos.FrontCommand;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FRONT CONTROLLER
 * @author xykukulkan
 */
public class FrontControllerServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request
            , HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        FrontCommand frontCommand = getCommand(request);
        frontCommand.init(getServletContext(), request, response);
        frontCommand.process();
        
    }
    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            System.out.println("CACAC");
            System.out.println("*"+String.format("comandos.%s"
                    , request.getParameter("comando")).trim()+"*");
            Class type = Class.forName(String.format(
              "comandos.%s",
              request.getParameter("comando").trim()));
            return (FrontCommand) type
              .asSubclass(FrontCommand.class)
              .newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request
            , HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request
            , HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
