package com.tecsup.javaweb.sesion02.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OperacionesServlet
 */
@WebServlet("/OperacionesServlet")
public class OperacionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperacionesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public final static String SUMA = "01";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				String txtOpe1 = request.getParameter("txtOpe1");
				String txtOpe2 = request.getParameter("txtOpe2");
				String txtTipoOpe = request.getParameter("txtTipoOpe");
				
				System.out.println(txtOpe1);
				System.out.println(txtOpe2);
				System.out.println(txtTipoOpe);
				
				int res = -1;
				
				if (SUMA.equals(txtTipoOpe)) {
					
					res =  Integer.parseInt(txtOpe1) +  Integer.parseInt(txtOpe2);
				}
				
				
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("Resultado ["+ res +"]");
				out.println("</body>");
				out.println("</html>");
				out.close();
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
