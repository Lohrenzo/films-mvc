<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div
	class="backdrop-blur-md bg-black/90 text-white z-40 sticky top-0 left-0 right-0 shadow w-full flex flex-row items-center justify-between px-4 py-7 mb-6">
	<a href="/" class="p-2 font-bold">Films App (MVC)</a>
	<% if (request.getRequestURI().equals("/films-mvc/") || request.getRequestURI().equals("/films-mvc/search") || request.getRequestURI().equals("/") || request.getRequestURI().equals("/films") || request.getRequestURI().equals("/search")) { %>
        <%@ include file="search-bar.jsp" %>
    <% } %>
	<button id="open-add-popup" class="relative p-2 font-bold group/popup sm:text-base text-[0.7rem] flex flex-row items-center justify-center gap-2">
		Add New Film <i class="fa-solid fa-plus"></i>
		<p class="invisible group-hover/popup:visible absolute right-0 top-10 bg-white/55 backdrop-blur-sm rounded-s-full rounded-br-full rounded-tr-full text-black p-1 font bold w-[150px]">
            Add New Film
        </p>
	</button>
</div>

<div id="add-popup"
	class="z-50 py-6 px-24 mx-auto fixed top-0 w-full h-[100vh] bg-black/70">
	<button id="close-add-popup"
		class="absolute top-8 right-8 w-[30px] h-[30px] flex items-center justify-center rounded-lg text-3xl font-bold bg-white/80 duration-150 hover:scale-125 transition-all hover:rotate-180 text-black">
		<i class="fa-solid fa-xmark"></i>
	</button>
	<form action="films" method="POST"
		class="*:mb-5 add-popup-body mx-auto w-full p-6 rounded-lg shadow-lg shadow-[#00000081]">
		<h2 class="text-3xl text-center w-full font-bold text-white">Add New Film</h2>
		<input type="text" name="title" placeholder="Title"
			class="p-2 border border-gray-700 active:border-[#0000a2] rounded-lg w-full" />
		<input type="number" name="year" placeholder="Year"
			class="p-2 border border-gray-700 active:border-[#0000a2] rounded-lg w-full" />
		<input type="text" name="director" placeholder="Director"
			class="p-2 border border-gray-700 active:border-[#0000a2] rounded-lg w-full" />
		<input type="text" name="stars" placeholder="Stars"
			class="p-2 border border-gray-700 active:border-[#0000a2] rounded-lg w-full" />
		<textarea rows="10" cols="50" placeholder="Review" class="p-2 border border-gray-700 active:border-[#0000a2] rounded-lg w-full" name="review"></textarea>
		<button type="submit"
			class="bg-gray-900 text-white mb-4 px-6 py-2 hover:bg-white/30 transition-all duration-125 sm:px-8 sm:py-3 rounded-lg">Add</button>
	</form>
</div>

<button id="up"
	class="z-40 fixed bg-white hover:scale-110 duration-125 transition-all border p-3 w-[2.7rem] h-[2.7rem] flex items-center justify-center rounded-full shadow bottom-5 right-4 text-black text-2xl">
	<i class="fa-solid fa-angles-up"></i>
</button>