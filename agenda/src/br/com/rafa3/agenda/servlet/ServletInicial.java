package br.com.rafa3.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletInicial extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> ServletInicial</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Teste</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
