# Basic-Ecommerce-Item-Manager
 simple Java backend application that implements a RESTful API for managing a collection of items (example: ecommerce(lke flipcart), movies(like Netflix), etc.
🛒 Ecommerce Item Manager

A simple web-based application to manage ecommerce items using Thymeleaf and HTML/CSS.
This project allows users to add new items, search items by ID, view selected items, and display all available items.

Features

Add Item: Add new products with name, description, and price.

Search Item by ID: Search for a specific product and view details.

Display Selected Item: Shows the searched item in a highlighted box.

Available Items List: Displays all added items in a structured card layout.

Responsive Design: Works well on desktops and mobile devices.

Ecommerce-Item-Manager/
│
├── src/main/resources/templates/
│   └── index.html          # Main Thymeleaf template
│
├── src/main/resources/static/css/
│   └── style.css           # CSS styles for layout and design
│
└── README.md               # Project documentation


Setup & Usage

Clone the repository:

git clone https://github.com/your-username/ecommerce-item-manager.git

Open the project in your IDE.

Start the backend (if using Spring Boot):

./mvnw spring-boot:run

Open the frontend: Navigate to http://localhost:8080 in your browser.

Add items, search by ID, and view available/selected items.
