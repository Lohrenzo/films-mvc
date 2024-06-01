package controllers;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class FilmsServlet
 */
@WebServlet("/films")
public class FilmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	FilmDaoEnum dao = FilmDaoEnum.INSTANCE;
        ArrayList<Film> allFilms = dao.getAllFilms();
        request.setAttribute("films", allFilms);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title").toUpperCase();
		
	    int year = 0; // Default value if year is not provided or is invalid
	    
	    // Attempt to parse the year from the request, use default if parsing fails
	    try {
	        year = Integer.parseInt(request.getParameter("year"));
	    } catch (NumberFormatException e) {
	        // If there's a NumberFormatException, year will remain 0
	        System.out.println("Year input is invalid or not provided, defaulting to 0.");
	    }

		String director = request.getParameter("director").toUpperCase();
		String stars = request.getParameter("stars").toUpperCase();
		String review = request.getParameter("review");

		FilmDaoEnum dao = FilmDaoEnum.INSTANCE;
		Film f = new Film(title, year, director, stars, review);

		try {
			dao.insertFilm(f);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("films"); // Redirect to doGet to display the updated list of films.
	}

}
