<%@ page contentType="text/html; charset=UTF-8"
	import="dao.*, model.*, java.util.*"%>
	
	<%
			ProductDAO obj = new ProductDAOImpl();
			List<List<Object>> productList = null;
			try {
					productList = (ArrayList) obj.getProductList();
			} catch (Exception e) {
				e.printStackTrace(); // Log or handle the exception appropriately
				}
	%>




<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shopping Store</title>
<link rel="stylesheet" href="styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="cartjquery.js"></script>

<!-- jQuery UI for dialog box -->
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>

	<header class="main-header">
		<div class="logo">
			<img
				src="https://pennanttech.com/wp-content/uploads/2021/08/Pennant-logo-color-1.png"
				alt="Company Logo">
		</div>
		<div class="search-bar">
			<h2>
				<strong>Shopping Store</strong>
			</h2>
		</div>

		<div class="cart-icon">
			<a href="Cart.jsp"><img
				src="https://cdn-icons-png.flaticon.com/128/2838/2838895.png"
				alt="Cart" width="40px"></a>
			<p>
				<strong>Cart</strong>
			</p>
		</div>
	</header>
	
	<nav class="categories-nav">
		<div class="categories-toggle"></div>
		<div class="categories-dropdown">
			<select id="category-select">
				<option value="default">Select Category...</option>
				<option value="category1">Category 1</option>
				<option value="category2">Category 2</option>
				<option value="category3">Category 3</option>
				<!-- Add more categories as needed -->
			</select>
		</div>
		<div class="scrolling-offer">
			<marquee behavior="scroll" direction="left">
				<strong>Special offers! Buy now and save...</strong>
			</marquee>
		</div>

		</div>
	</nav>




	<main>
		<!-- carouselll -->
		<div class="main-pic">
			<img
				src="https://www.omnisend.com/blog/wp-content/uploads/2021/03/21-03-19-Fashion-ecommerce.jpg" />
		</div>

		<section id="productlists" class="product-list">
			<%
        		for (List<Object> row : productList) {
           			 // Extract Product and ProductStock objects from the inner list
            		Product p = (Product) row.get(0);
            		ProductStock ps = (ProductStock) row.get(1);
    		%>
    		<div class="product-card">
        			<img src="<%=p.getImage()%>" alt="Product">
        			<h2><%=p.getPname()%></h2>
        			<h5><%=ps.getProd_price()%></h5>
        			<!-- Display ProductStock information -->
        			<p><%=ps.getProd_stock()%></p>
        			<!--  <p>Batch No: <%=ps.getProd_batchno()%></p>-->
       				<p><%=ps.getProd_mrp()%></p>
       				<h3><%=p.getPcatid()%></h3>
       				<h4><%=p.getPid()%></h4>
        			<button id="addCart" class="add-to-Cart" type="button">Add to Cart</button>
    		</div>
    		<%
        		}
    		%>
		</section>
	</main>
	

	<footer>
		<div class="footer-content">
			<p>About Us</p>
			<p>Contact Details: contact@example.com</p>
			<p>Helpline Number: XXX-XXX-XXXX</p>
			<p>Customer Service: customerservice@example.com</p>
		</div>
	</footer>



</body>

</html>