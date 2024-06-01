package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FilmDaoEnum;
import models.Film;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchStr = request.getParameter("searchStr");
		FilmDaoEnum dao = FilmDaoEnum.INSTANCE;
		ArrayList<Film> searchResult = dao.searchFilm(searchStr);
		request.setAttribute("films", searchResult);
		request.setAttribute("searchString", searchStr);
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.include(request, response);
	}
}
