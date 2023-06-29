package Controladores;

import Modelos.Agencia;
import ModelosDao.AgenciaImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ControladorAgencias", value = "/ControladorAgencias")
public class ControladorAgencias extends HttpServlet {

          // Direcciones de las vistas JSP
    private final String listar = "vistas/agencias/listar.jsp";
    private final String add = "vistas/agencias/agregar.jsp";
    private final String edit = "vistas/agencias/editar.jsp";

    // Instancias de los objetos necesarios
    private Agencia agencia = new Agencia();
    private AgenciaImp agenciaImp = new AgenciaImp();
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
            out.println("<title>Servlet ControladorAgencias</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAgencias at " + request.getContextPath() + "</h1>");
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
            String nombre = request.getParameter("txtNombre");
            String codigoInterno = request.getParameter("txtCodigoInterno");
            String direccion = request.getParameter("txtDireccion");


            // Establecer los valores en el objeto ruta
            agencia.setNombre(nombre);
            agencia.setCodigo_interno(codigoInterno);
            agencia.setDireccion(direccion);



            // Llamar al método agregar de la clase rutaImp para agregar la ruta a la base de datos
            agenciaImp.agregar(agencia);

            acceso = listar; // Después de agregar, redirigir a la página de listar
        }

        else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idAgencia", request.getParameter("id"));
            acceso = edit;
        }else if (accion.equalsIgnoreCase("Actualizar")) {
            int id = Integer.parseInt(request.getParameter("txtId"));
            String nombre = request.getParameter("txtNombre");
            String codigoInterno = request.getParameter("txtCodigoInterno");
            String direccion = request.getParameter("txtDireccion");
            boolean estado = request.getParameter("chkEstado") != null && request.getParameter("chkEstado").equals("1");

            AgenciaImp agenciaImp = new AgenciaImp();
            Agencia agencia = agenciaImp.obtenerPorId(id);
            agencia.setNombre(nombre);
            agencia.setCodigo_interno(codigoInterno);
            agencia.setDireccion(direccion);
            agencia.setEstado(estado);
            agenciaImp.editar(agencia);

            String listar = "ControladorAgencias?accion=listar";
            response.sendRedirect(listar);
        }


        else if (accion.equalsIgnoreCase("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            agencia.setId(id);
            agenciaImp.eliminar(id);
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
