<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="utils.DateUtils" %>

<!DOCTYPE html>
<html>
<%@ include file="./components/head.jsp" %>
<body class="pb-3 no-select">

	<%@ include file="./components/navbar.jsp" %>

	<h1 class="text-center text-[2rem] font-bold">Search Results for: <span id="searchString" class="capitalize">${searchString}</span> </h1>

	<div class="p-4 m-3">
		<table class="bg-black/40 backdrop-blur-md mx-auto shadow-lg shadow-[#262626a4] p-4 rounded-lg grid grid-cols-1">
			<tr class="p-6 gap-4 border-b w-full text-left">
				<th class="p-2">Id</th>
				<th class="p-2">Title</th>
				<th class="p-2">Year</th>
				<th class="p-2">Director</th>
				<th class="p-2">Stars</th>
				<th class="p-2 max-w-max">Review</th>
			</tr>
			<c:forEach items="${films}" var="f">
				<tr class="p-6 gap-4 border-b last:border-b-0 last:pb-4 w-full text-sm text-left">
					<td class="p-2">${f.getId()}</td>
					<td class="p-2"><b>${f.getTitle()}</b></td>
					<td class="p-2">${f.getYear()}</td>
					<td class="p-2">${f.getDirector()}</td>
					<td class="p-2">${f.getStars()}</td>
					<td class="p-2 max-w-max text-justify">${f.getReview()}</td>
		            <c:choose>
		                <c:when test="${f.getLastModified() eq f.getAdded()}">
							<td class="p-2">Added ${DateUtils.timeAgo(f.getAdded())}</td>
		                </c:when>
			            <c:otherwise>
		                    <td class="p-2">Edited ${DateUtils.timeAgo(f.getLastModified())}</td>
		                </c:otherwise>
		            </c:choose>
					<td class="p-2">
						<form action="./delete" method="POST">
							<input type="hidden" name="id" value="${f.getId()}" /> 
							<button type="submit" class="bg-red-700 px-4 py-2 text-white hover:bg-red-800 sm:px-8 sm:py-3 rounded-lg"><i class="fa-solid fa-trash-can"></i></button>
						</form>
					</td>
					<td class="p-2">
						<a class="bg-black/80 px-4 py-2 text-white hover:bg-black sm:px-8 sm:py-3 rounded-lg" href="edit?id=${f.getId()}"><i class="fa-solid fa-pen-to-square"></i></a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!--
	<ul id="pagination" class="m-4 py-2">
	    <li class="cursor-pointer" id="prev-result-page"><a><<</a></li>
	    <li id="result-page-num">Page 1</li>
	    <li class="cursor-pointer" id="next-result-page"><a>>></a></li>
  	</ul>
  	-->
  	<br>

	<script src="./js/main.js"></script>
</body>
</html>