/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.izv.controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Aarón
 */
@WebServlet(name = "ControladorSubir", urlPatterns = {"/subir/controlsubir"})
@MultipartConfig
public class ControladorSubir extends HttpServlet {

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
        boolean error=false;
        String descripcion = request.getParameter("descripcion"); // Retrieves <input type="text" name="description">
        Part archivoPost = request.getPart("archivo"); // Retrieves <input type="file" name="file">
        String nombreArchivoPost = archivoPost.getSubmittedFileName();
        InputStream fileContent = archivoPost.getInputStream();
        String destino = getServletContext().getRealPath("/") + "subir/subido/";
        System.out.println(destino);
        response.setContentType("application/json");
        try {
            try (OutputStream os = new FileOutputStream(destino + nombreArchivoPost)) {
                byte[] b = new byte[2048];
                int length;
                while ((length = fileContent.read(b)) != -1) {
                    os.write(b, 0, length);
                }
            } catch (Exception e) {
                error=true;
            } finally {
                fileContent.close();
            }
        } catch (Exception ex) {
        }

        try (PrintWriter out = response.getWriter()) {
            if(error){
                out.println("{\"r\":0}");
            }else{
                out.println("{\"r\":1}"); // respuesta json chapucera
            }
            
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
