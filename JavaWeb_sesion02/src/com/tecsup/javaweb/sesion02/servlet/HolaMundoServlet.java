package com.tecsup.javaweb.sesion02.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(value = "/HolaMundoServlet", initParams = { 
		   @WebInitParam(name = "NombreInstituto", value = "TECSUP"), 
		   @WebInitParam(name = "NombreCurso", value = "Java Web") 
		}) 
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        String usuario = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
        ServletContext sc = request.getServletContext();
		PrintWriter out = response.getWriter();
		
		
        out.println("<html>");
        out.println("<body>");
        out.println("---------------- ["+ getInitParameter("NombreInstituto") +"] ------------------ <br>");
        out.println("---------------- ["+ getInitParameter("NombreCurso") +"] ------------------ <br>");
        out.println("Bienvenido ["+ usuario +"] con clave ["+ clave + "] <br>");
        out.println("Directorio ["+ sc.getInitParameter("directorioPDF") +"] <br>");
 
        out.println("------------------------------------------------------- <br>");
	    out.println("request.getHeader()  ["+ request.getHeader("host") +"] <br>");
	    
        out.println("------------------------------------------------------- <br>");
        out.println("request  ["+ request.getContextPath() +"] <br>");
        
        out.println("------------------------------------------------------- <br>");
	    out.println("request.getServletPath()  ["+ request.getServletPath() +"] <br>");

        out.println("------------------------------------------------------- <br>");
	    out.println("request.getQueryString()  ["+ request.getQueryString() +"] <br>");
        	    
        out.println("------------------------------------------------------- <br>");
	    out.println("request.getMethod()  ["+ request.getMethod() +"] <br>");

        out.println("------------------------------------------------------- <br>");
        Enumeration<String> headers = request.getHeaderNames();
	    while (headers.hasMoreElements()) {
	    	String name = (String) headers.nextElement();
	    	String value = request.getHeader(name);
	    	out.println(""+ name + " =  ["+ value +"] <br>");
	    }
	    
        out.println("</body>");
        out.println("</html>");
        out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Llamada a metodo init()");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
		System.out.println("Llamada a metodo service()");
	}	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Llamada a metodo destroy()");
	}
	
}
