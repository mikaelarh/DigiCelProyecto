
package comandos;

import java.io.IOException;
import javax.servlet.ServletException;
/**
 *
 * @author xykukulkan
 */
public class Logout extends FrontCommand{

    @Override
    public void process() throws ServletException, IOException {
        this.response.setContentType("text/html;charset=UTF-8");
        this.request.getSession().invalidate();
        this.forward("login");
        //response.sendRedirect("login.jsp");    
    }

   

}
