package br.edu.senai.controle;

import java.io.IOException;

import br.edu.senai.entidade.Funcionario;
import br.edu.senai.persistencia.FuncionarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Essa anotação serve para identificar o servlet 
//para as paginas jsps e assim poder chamar as métodos
//doPost e doGet
@WebServlet("/Controle")  //Anotação do Servlet 3.0
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	public Controle() {
		super();
	}

	// doGet -> São requisições das paginas jsps enviadas por link
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cmd = request.getParameter("cmd");
		
		if(cmd.equalsIgnoreCase("buscar")){
			buscar(request,response);
		}
		
		if(cmd.equalsIgnoreCase("excluir")){
			excluir(request,response);
		}		
	}
	
	// doPost -> São requisições das paginas jsps enviadas por formulario  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// comando para resgatar um valor da pagina JSP
		String cmd = request.getParameter("cmd");
		
			if(cmd.equalsIgnoreCase("gravar")){
				gravar(request,response);
			}
			
			if(cmd.equalsIgnoreCase("alterar")){
				alterar(request,response);
			}	
	}

	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		Double salario = new Double(request.getParameter("salario"));
		
		Funcionario f = new Funcionario();
		f.setNome(nome);
		f.setSalario(salario);
		
			try {
				
				new FuncionarioDao().create(f);
				// Comando para enviar uma msg para pagina jsp
				request.setAttribute("msg", "Dados Gravados");
				
			} catch (Exception e) {
			request.setAttribute("msg", "Error" + e.getMessage());
			}
			finally{
			//Comando para redirecionar para pagina jsp de resposta			
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
			}		
	}
	
	protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer cod = new Integer(request.getParameter("cod"));
		
		try {
			
			Funcionario func = new FuncionarioDao().findByCode(cod);
			
			request.setAttribute("funcionario", func);
			request.getRequestDispatcher("altera.jsp").forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}		
	}
	
	protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer cod = new Integer(request.getParameter("cod"));
		String nome = request.getParameter("nome");
		Double salario = new Double(request.getParameter("salario"));
		
		Funcionario f = new Funcionario();
		f.setIdFuncionario(cod);
		f.setNome(nome);
		f.setSalario(salario);
		
			try {
				
				new FuncionarioDao().update(f);
				
				request.setAttribute("msg", "Dados Alterados");
				request.getRequestDispatcher("lista.jsp").forward(request, response);
			} catch (Exception e) {
				request.setAttribute("msg", "Error" + e.getMessage());
				request.getRequestDispatcher("sistema.jsp").forward(request, response);
			}		
	}
	
	protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer cod = new Integer(request.getParameter("cod"));
		
		try {
			
			new FuncionarioDao().delete(cod);
			
			request.setAttribute("msg", "Dados Excluídos");
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("msg", "Error " + e.getMessage());
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
		}		
	}	
}
