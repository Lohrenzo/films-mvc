<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@ include file="./components/head.jsp" %>
<body class="no-select">

	<%@ include file="./components/navbar.jsp" %>
	<h2 class="font-bold text-3xl ps-16 mb-2">Update Film: ${film.title}</h2><br>
	<form action="edit" method="POST" class="pb-4 px-16 mx-auto *:mb-2">
	    <input type="hidden" name="id" value="${film.id}">
	    <div>
	        <label for="title">Title:</label>
	        <input type="text" id="title" name="title" class="p-2 border border-gray-700 active:border-[#0000a2] rounded-lg w-full" value="${film.title}">
	    </div>
	    <div>
	        <label for="year">Year:</label>
	        <input type="number" id="year" name="year" class="p-2 border border-gray-700 active:border-[#0000a2] rounded-lg w-full" value="${film.year}">
	    </div>
	    <div>
	        <label for="director">Director:</label>
	        <input type="text" id="director" name="director" class="p-2 border border-gray-700 active:border-[#0000a2] rounded-lg w-full" value="${film.director}">
	    </div>
	    <div>
	        <label for="stars">Stars:</label>
	        <input type="text" id="stars" name="stars" class="p-2 border border-gray-700 active:border-[#0000a2] rounded-lg w-full" value="${film.stars}">
	    </div>
	    <div>
	        <label for="year">Review:</label>
	        <textarea rows="10" cols="50" class="p-2 border border-gray-700 active:border-[#0000a2] rounded-lg w-full" name="review">${film.review}</textarea>
	    </div>
	    <div>
	        <button type="submit" class="bg-black/70 mb-4 px-6 py-2 text-white hover:bg-black/90 sm:px-8 sm:py-3 rounded-lg">Update</button>
	    </div>
	</form>
	
	<script src="./js/main.js"></script>
</body>
</html>