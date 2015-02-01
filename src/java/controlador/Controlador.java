package controlador;

import modelo.ModeloInmueble;
import hibernate.Inmueble;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aarón
 */
@WebServlet(name = "Controlador", urlPatterns = {"/control"})
public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destino = "index.html";
        boolean forward = false;
        String target, op, action, view;

        //..
        target = request.getParameter("target");
        op = request.getParameter("op");
        action = request.getParameter("action");
        System.out.println("****************************************************");
        System.out.println(target + " " + op + " " + action);
        
        if (target.equals("inmueble") && op.equals("select") && action.equals("view")) {
            forward = true;
            destino = "WEB-INF/inmueble/index.jsp";
            request.setAttribute("datos", ModeloInmueble.get());
        } else {
            if (target.equals("inmueble") && op.equals("delete") && action.equals("op")) {
                forward = false;
                ModeloInmueble.delete(request.getParameter("id"));
                destino = "control?target=inmueble&op=select&action=view";
            } else {
                if (target.equals("inmueble") && op.equals("insert") && action.equals("view")) {
                    forward = true;
                    destino = "WEB-INF/inmueble/insert.jsp";
                } else {
                    if (target.equals("inmueble") && op.equals("insert") && action.equals("op")) {
                        forward = false;
                        destino = "control?target=inmueble&op=select&action=view";
                        Inmueble inmueble = new Inmueble();
                        inmueble.setDireccion(request.getParameter("direccion"));
                        inmueble.setLocalidad(request.getParameter("localidad"));
                        inmueble.setTipo(request.getParameter("tipo"));
                        inmueble.setPrecio(Double.parseDouble(request.getParameter("tipo")));
                        inmueble.setUsuario("Aaron");
                        Calendar c=Calendar.getInstance();
                        inmueble.setFechaalta(c.getTime());
                        ModeloInmueble.insert(inmueble);
                    } else {
                        if (target.equals("inmueble") && op.equals("edit") && action.equals("view")) {
                            forward = true;
                            request.setAttribute("inmueble", ModeloInmueble.get(request.getParameter("id")));
                            destino = "WEB-INF/inmueble/edit.jsp";
                        } else {
                            if (target.equals("inmueble") && op.equals("edit") && action.equals("op")) {
                                forward = false;
                                destino = "control?target=inmueble&op=select&action=view";
                                Inmueble inmueble = new Inmueble();
                                inmueble.setDireccion(request.getParameter("direccion"));
                                inmueble.setLocalidad(request.getParameter("localidad"));
                                inmueble.setTipo(request.getParameter("tipo"));
                                inmueble.setUsuario(request.getParameter("usuario"));
                                inmueble.setFechaalta(Date.valueOf(request.getParameter("fecha")));
                                ModeloInmueble.update(inmueble);
                            } else {
                                if (target.equals("inmueble") && op.equals("viewfoto") && action.equals("view")) {
                                    forward = true;
                                    request.setAttribute("inmueble", ModeloInmueble.get(request.getParameter("id")));
                                    destino = "WEB-INF/inmueble/viewfoto.jsp";
                                } else {
                                    if (target.equals("inmueble") && op.equals("addfoto") && action.equals("view")) {
                                        forward = true;
                                        request.setAttribute("inmueble", ModeloInmueble.get(request.getParameter("id")));
                                        destino = "WEB-INF/inmueble/addfoto.jsp";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        /*else {
         if(target.equals("inmueble") && op.equals("insert") && action.equals("view") && view.equals("")){
         String valor = target+op+action+view;
         request.setAttribute("valorcalculado", valor);
         destino="inmueble/viewinsert.jsp";
         forward=true;
         }else{
         if(target.equals("inmueble") && op.equals("insert") && action.equals("op") && view.equals("")){
         //modelo para insertar
         destino="inmueble/index.jsp";
         forward=false;
         }else{
                    
         }
         } 
         }
         */
        //transferencia de control ya esta hecha
        if (forward) {
            request.getRequestDispatcher(destino).forward(request, response);
        } else {
            response.sendRedirect(destino);
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
