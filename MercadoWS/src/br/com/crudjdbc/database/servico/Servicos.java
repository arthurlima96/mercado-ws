package br.com.crudjdbc.database.servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.crudjdbc.database.daos.CategoryDao;
import br.com.crudjdbc.database.entities.CategoryEntity;
import br.com.crudjdbc.database.factories.ConnectionFactory;
import br.com.crudjdbc.database.interfaces.ICategoryDao;

@Path("servico")
public class Servicos {
	
	private ICategoryDao categoryDao;
	
	public Servicos() {
		categoryDao = new CategoryDao();
	}
	
	@GET
	@Path("conexao")
	public String test() {
		ConnectionFactory.getConnection();
		return "Funciona";
	}
	
	@POST
	@Path("add_categoria")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionarCategoria(CategoryEntity categoria) {
		try {
			categoryDao.insert(categoria);			
			return Response.status(Status.CREATED).build();
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).build();
		}
	}
	
	
}
