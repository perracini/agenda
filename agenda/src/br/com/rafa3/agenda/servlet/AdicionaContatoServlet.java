package br.com.rafa3.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rafa3.agenda.dao.ContatoDao;
import br.com.rafa3.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("DataNascimento");
		Calendar dataNascimento = null;
		
		try{
			Date date = new SimpleDateFormat("dd/MM/yy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro no parse da data");
			return;
		}
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Contato " + contato.getNome() + "adicionado com sucesso</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
