package com.prueba.bbva.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prueba.bbva.Persons;
import com.prueba.bbva.DAO.PersonsDAO;

public class PersonController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PersonsDAO personDAO;
	private String ACTION_PETICION = "default";

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		personDAO = new PersonsDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertPerson(request, response);
				break;
			case "/delete":
				deletePerson(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updatePerson(request, response);
				break;
			case "/busqueda":
				search(request, response);
				break;
			case "/searchBy":
				searchBy(request, response);
				break;
			default:
				listPerson(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listPerson(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Persons> listPerson;
		listPerson = personDAO.listAllPersons();
		request.setAttribute("listPerson", listPerson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("PersonList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("PersonForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Persons existingPerson = personDAO.getPerson(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("PersonForm.jsp");
		request.setAttribute("person", existingPerson);
		dispatcher.forward(request, response);

	}

	private void insertPerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String amat = request.getParameter("apat");
		String apat = request.getParameter("amat");
		String telef = request.getParameter("tel");
		String email = request.getParameter("mail");
		String genero = request.getParameter("gender");
		String rfc = request.getParameter("rfc");

		Persons newPerson = new Persons(name, amat, apat, telef, email, genero, rfc);
		personDAO.insertPerson(newPerson);
		response.sendRedirect("list");
	}

	private void updatePerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String amat = request.getParameter("apat");
		String apat = request.getParameter("amat");
		String telef = request.getParameter("tel");
		String email = request.getParameter("mail");
		String genero = request.getParameter("gender");
		String rfc = request.getParameter("rfc");
		
		Persons person = new Persons(id, name, amat, apat, telef, email, genero, rfc);
		personDAO.updatePerson(person);
		response.sendRedirect("list");
	}

	private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Persons person = new Persons(id);
		personDAO.deletePerson(person);
		response.sendRedirect("list");

	}
	
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("busquedaPs.jsp");
		dispatcher.forward(request, response);
	}
	
	private void searchBy(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Persons> listPerson;
		Persons person = new Persons();

		person.setId(Integer.parseInt(request.getParameter("searchId")));
		person.setNombre(request.getParameter("searchName"));
		person.setRfc(request.getParameter("searchRfc"));
			
		listPerson = personDAO.listAllPersons();
		request.setAttribute("listPerson", listPerson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("resultBusqueda.jsp");
		dispatcher.forward(request, response);
	}	
}