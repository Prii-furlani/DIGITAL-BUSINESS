package br.com.fiap.progamer.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.progamer.dao.SetupDao;
import br.com.fiap.progamer.model.Setup;

// Colocar @Produces na Classe indica que TODOS os métodos produzem um JSON
@Path("/setups")
@Produces(MediaType.APPLICATION_JSON)
public class SetupEndPoint {
	
	private SetupDao dao = new SetupDao();
	
	@GET
	public Response index() {
		try {
			List<Setup> list = dao.getAll();
			return Response.status(Response.Status.OK).entity(list).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Setup setup) {
		if (setup == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		try {
			dao.save(setup);
			return Response.status(Response.Status.CREATED).entity(setup).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Long codigo) {
		Setup setup = dao.findById(codigo);
		if ( setup == null ) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).entity(setup).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long codigo, Setup setup) {
		if (codigo == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		if (setup == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		if (dao.findById(codigo) == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		setup.setCodigo(codigo);
		try {
			dao.update(setup);
			return Response.status(Response.Status.OK).entity(setup).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
