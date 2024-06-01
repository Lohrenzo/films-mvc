/**
 * 
 */


// Wait for the DOM content to fully load before this function can be called
document.addEventListener("DOMContentLoaded", function() {
	const upButton = document.getElementById("up");

	// Initially hide the button when the page is loaded
	upButton.style.display = "none";

	window.addEventListener("scroll", () => {
		if (window.scrollY > 70) { // If the page has been scrolled to 100px
			upButton.style.display = "flex"; // Show the button
		} else {
			upButton.style.display = "none"; // Hide the button
		}
	});

	upButton.addEventListener("click", function() {
		window.scrollTo({
			top: 0,
			behavior: 'smooth'
		});
	});
});

function confirmDelete(event) {
	// Prevent the default form submission
	event.preventDefault();

	// Display confirmation dialog
	if (confirm("Are you sure you want to delete this film?")) {
		// If confirmed, submit the form
		event.target.closest('form').submit();
	}
}

// Attach event listener to all delete buttons
document.addEventListener('DOMContentLoaded', function() {
	var deleteButtons = document.querySelectorAll('.delete-btn');
	deleteButtons.forEach(function(button) {
		button.addEventListener('click', confirmDelete);
	});
});

// Get the elements by their ID
var openPopup = document.getElementById("open-add-popup");
var popupWindow = document.getElementById("add-popup");
var closePopup = document.getElementById("close-add-popup");

// Show the pop-up window when the link is clicked
openPopup.addEventListener("click", function(event) {
	event.preventDefault();
	popupWindow.classList.add("active"); // Use class to control visibility and transformation
});

// Hide the pop-up window when the close button is clicked
closePopup.addEventListener("click", function() {
	popupWindow.classList.remove("active"); // Remove class to hide and scale down
});



var page = 1;
const postPerPage = 10;
var currentPage = document.getElementById("page-num"); // Assuming this element exists
var prevPage = document.getElementById("prev-page");
var nextPage = document.getElementById("next-page");

function updatePageAndRedirect(newPage) {
	page = newPage;
	const offset = (page - 1) * postPerPage;
	const paginatedURL = `films?limit=${postPerPage}&offset=${offset}`;
	// Before redirecting, attempt to update the page number display
	// This will not be visible to the user because the page will redirect and reload
	currentPage.innerText = "Page " + page;
	window.location.href = paginatedURL; // Redirect to the updated URL
}

const noSelectElements = document.querySelectorAll(".no-select");
noSelectElements.forEach((element) => {
	element.style.webkitUserSelect = "none";
	element.style.mozUserSelect = "none";
	element.style.msUserSelect = "none";
	element.style.userSelect = "none";
});
