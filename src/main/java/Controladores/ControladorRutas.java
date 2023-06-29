package Controladores;

import Modelos.Ruta;
import ModelosDao.RutaImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ControladorRutas", value = "/ControladorRutas")
public class ControladorRutas extends HttpServlet {
    
       // Direcciones de las vistas JSP
    private final String listar = "vistas/rutas/listar.jsp";
    private final String add = "vistas/rutas/agregar.jsp";
    private final String edit = "vistas/rutas/editar.jsp";

    // Instancias de los objetos necesarios
    private Ruta ruta = new Ruta();
    private RutaImp rutaImp = new RutaImp();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorRutas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorRutas at " + request.getContextPath() + "</h1>");
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
        
        String acceso = ""; // Variable para almacenar la página de acceso
        String accion = request.getParameter("accion"); // Obtener el parámetro "accion" de la solicitud

// Verificar el valor del parámetro "accion" y asignar la página correspondiente a la variable "acceso"
        if (accion.equalsIgnoreCase("listar")) {
            acceso = listar; // Página para listar
        } else if (accion.equalsIgnoreCase("add")) {
            acceso = add; // Página para agregar
        } else if (accion.equalsIgnoreCase("agregar")) {
            // Obtener los valores de los parámetros de inicio y destino de la solicitud
            String inicio = request.getParameter("txtInicio");
            String destino = request.getParameter("txtDestino");

            // Establecer los valores en el objeto ruta
            ruta.setInicio(inicio);
            ruta.setDestino(destino);

            // Llamar al método agregar de la clase rutaImp para agregar la ruta a la base de datos
            rutaImp.agregar(ruta);

            acceso = listar; // Después de agregar, redirigir a la página de listar
        }

        else if(accion.equalsIgnoreCase("editar")){
            request.setAttribute("idRuta", request.getParameter("id"));
            acceso=edit;
        }
        else if(accion.equalsIgnoreCase("Actualizar")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            String inicio = request.getParameter("txtInicio");
            String destino = request.getParameter("txtDestino");
            ruta.setId(id);
            ruta.setInicio(inicio);
            ruta.setDestino(destino);
            rutaImp.editar(ruta);
            acceso=listar;

        } else if (accion.equalsIgnoreCase("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ruta.setId(id);
            rutaImp.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
