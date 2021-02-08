package com.uniovi.sdi;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletComentarios
 */
@WebServlet("/ServletComentarios")
public class ServletComentarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletComentarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		HashMap<String, String> comentarios = (HashMap<String, String>) request.getSession().getAttribute("comentarios");
//			No	hay	carrito,	creamos	uno	y	lo	insertamos	en	sesión
		if (comentarios == null) {
			comentarios = new HashMap<String, String>();
			request.getSession().setAttribute("comentarios", comentarios);
		}
		String comentario = request.getParameter("comentario");
		String nombre = request.getParameter("nombre");
		if (comentario != null && nombre != null) {
			insertarEnComentario(comentarios, comentario, nombre);
		}
		comentarios.put("prueba", "prueba");
		request.setAttribute("comentarios", comentarios);
		getServletContext().getRequestDispatcher("/vista-comentarios.jsp").forward(request, response);
	}

	private void insertarEnComentario(HashMap<String, String> comentarios, String comentario, String nombre) {
		if (comentarios.get(nombre) == null)
			comentarios.put(nombre, comentario);
		else {
			String numeroComentarios = comentarios.get(nombre);
			comentarios.put(nombre, numeroComentarios + "<br> "+ comentario);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
