package br.com.crudjdbc.database.servico;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
	
	@GET
	@Path("todas_categorias")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<CategoryEntity> todasCetegorias() {
		try {
			return categoryDao.findALl();
		} catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Path("categoria/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public  CategoryEntity categoriaPorId(@PathParam("id")Long id ) {
		try {
			return categoryDao.findByID(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	/*
	
	public void testUpdate() {
		logger.debug(String.format("Testing %s update method.", CategoryDao.class));
		CategoryEntity category = new CategoryEntity();
		category.setId(1L);;
		category.setName("CATEGORY 1 UPDATED");
		categoryDao.update(category);
	}
	
	public void testDelete() {
		logger.debug(String.format("Testing %s delete method.", CategoryDao.class));
		CategoryEntity category = new CategoryEntity();
		category.setId(1L);;
		categoryDao.delete(category);
	}*/
	
	
}
