const baseUrl = 'https://localhost:8080'; // Change the port number here

document.getElementById("gpaForm").addEventListener("submit", function(event) {
  event.preventDefault();
  const grade = document.getElementById("grade").value.toUpperCase();
  const credits = parseInt(document.getElementById("credits").value);
  if (isNaN(credits)) {
    alert("Please enter a valid number for credits.");
    return;
  }

  fetch(`${baseUrl}/addCourse`, { // Use the baseUrl variable
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ grade, credits }),
  })
  .then(response => response.json())
  .then(data => {
    console.log('Course added:', data);
    displayCourses();
    calculateGPA();
  })
  .catch((error) => {
    console.error('Error:', error);
  });
});

function calculateGPA() {
  fetch(`${baseUrl}/calculateGPA`) // Use the baseUrl variable
  .then(response => response.json())
  .then(data => {
    console.log('GPA calculated:', data);
    document.getElementById("result").textContent = `GPA: ${data.toFixed(2)}`;
  })
  .catch((error) => {
    console.error('Error:', error);
  });
}

function displayCourses() {
  // You can implement this function to display the list of courses in your frontend UI
}
