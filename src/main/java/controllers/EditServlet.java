package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.FilmDaoEnum;
import models.Film;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDaoEnum dao = FilmDaoEnum.INSTANCE;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		Film f = dao.getFilmByID(id);

		if (f == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			throw new IllegalStateException("Film with ID: " + id + " does not exist.");
		}

		request.setAttribute("film", f);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		dispatcher.include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String title = request.getParameter("title").toUpperCase();
		int year = Integer.parseInt(request.getParameter("year"));
		String director = request.getParameter("director").toUpperCase();
		String stars = request.getParameter("stars").toUpperCase();
		String review = request.getParameter("review");

		try {
			Film existingFilm = dao.getFilmByID(id);

			if (existingFilm == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				throw new IllegalStateException("Contact with ID: " + id + " does not exist.");
			}

			// Input Validation
			if ((title == null && String.valueOf(year) != null && director != null && stars != null && review != null)
					|| (title.trim().isEmpty() && !String.valueOf(year).trim().isEmpty() && !director.trim().isEmpty() && !stars.trim().isEmpty()
							&& !review.trim().isEmpty())) {
				existingFilm.setYear(year);
				existingFilm.setDirector(director);
				existingFilm.setStars(stars);
				existingFilm.setReview(review);
			} else if ((String.valueOf(year) == null && title != null && director != null && stars != null && review != null)
					|| (!title.trim().isEmpty() && String.valueOf(year).trim().isEmpty() && !director.trim().isEmpty() && !stars.trim().isEmpty()
							&& !review.trim().isEmpty())) {
				existingFilm.setTitle(title);
				existingFilm.setDirector(director);
				existingFilm.setStars(stars);
				existingFilm.setReview(review);
			} else if ((director == null && String.valueOf(year) != null && title != null && stars != null && review != null)
					|| (director.trim().isEmpty() && !title.trim().isEmpty() && !String.valueOf(year).trim().isEmpty() && !stars.trim().isEmpty()
							&& !review.trim().isEmpty())) {
				existingFilm.setYear(year);
				existingFilm.setTitle(title);
				existingFilm.setStars(stars);
				existingFilm.setReview(review);
			} else if ((stars == null && director != null && String.valueOf(year) != null && title != null && review != null)
					|| (stars.trim().isEmpty() && !director.trim().isEmpty() && !title.trim().isEmpty() 
							&& !String.valueOf(year).trim().isEmpty() && !review.trim().isEmpty())) {
				existingFilm.setYear(year);
				existingFilm.setTitle(title);
				existingFilm.setDirector(director);
				existingFilm.setReview(review);
			} else if ((review == null && stars != null && director != null && String.valueOf(year) != null && title != null)
					|| (review.trim().isEmpty() && !stars.trim().isEmpty() && !director.trim().isEmpty()
							&& !title.trim().isEmpty() && !String.valueOf(year).trim().isEmpty())) {
				existingFilm.setYear(year);
				existingFilm.setTitle(title);
				existingFilm.setDirector(director);
				existingFilm.setStars(stars);
			} else if ((review != null && stars != null && director != null && String.valueOf(year) != null && title != null)
					|| (!review.trim().isEmpty() && !stars.trim().isEmpty() && !director.trim().isEmpty()
							&& !title.trim().isEmpty() && !String.valueOf(year).trim().isEmpty())) {
				existingFilm.setYear(year);
				existingFilm.setTitle(title);
				existingFilm.setDirector(director);
				existingFilm.setStars(stars);
				existingFilm.setReview(review);
			}

			boolean updateResult = dao.updateFilm(existingFilm);
			if (updateResult) {
				response.setStatus(HttpServletResponse.SC_OK);
				response.sendRedirect("films"); // Redirect.
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		} catch (SQLException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace(); // Log this error
		}
	}

}
