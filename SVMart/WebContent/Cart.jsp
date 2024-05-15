<%@ page import="java.util.List"%>
<%@ page import="model.CartItem"%>
<%@ page import="model.Cart"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    HttpSession session1 = request.getSession();
    Cart cart = (Cart) session1.getAttribute("cart");
    if (cart == null) {
        cart = new Cart();
        session1.setAttribute("cart", cart);
    }
    List<CartItem> items = cart.getItems();
    System.out.println("Number of items in cart: " + items.size());
    for(CartItem l:items){
    	System.out.println(l.getName());
    System.out.println(l.getGst());
    }
%>
<style>
body {
	background: #eecda3;
	background: -webkit-linear-gradient(to right, #eecda3, #ef629f);
	background: linear-gradient(to right, #eecda3, #ef629f);
	min-height: 100vh;
}
</style>
<html>
<head>
<title>Shopping Cart</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
<link rel="stylesheet"
	herf="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	    <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
	
	

</head>
<body>
	<div class="px-4 px-lg-0">
		<!-- For demo purpose -->
		<div class="container text-white py-5 text-center">
			<h1 class="display-4">
				<Strong>Shopping Cart</Strong>
			</h1>
			<p class="lead mb-0">Shop With Us!</p>
		</div>
		<!-- End -->

		<div class="pb-5">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

						<!-- Shopping cart table -->
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th scope="col" class="border-0 bg-light">
											<div class="p-2 px-3 text-uppercase">Product</div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase">Price</div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase">GST </div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase">Shipping Price</div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase">Quantity</div>
										</th>
										<th scope="col" class="border-0 bg-light">
											<div class="py-2 text-uppercase">Remove</div>
										</th>
									</tr>
								</thead>
								<tbody>
									<% for (CartItem item : items) { %>
									<tr id="row_<%= item.getId() %>">
										<th scope="row" class="border-0">
											<div class="p-2">
												<img src="<%= item.getImage()%>" alt="" height="150"
													width="70" class="img-fluid rounded shadow-sm">
												<div class="ml-3 d-inline-block align-middle">
													<h5 class="mb-0">
														<a href="#" class="text-dark d-inline-block align-middle"><%= item.getName() %></a>
													</h5>
													<span
														class="text-muted font-weight-normal font-italic d-block">Product
														id=<%= item.getId() %></span>
												</div>
											</div>
										</th>
										<td class="border-0 align-middle"><strong
											id="price_<%= item.getId() %>">$<%= item.getPrice() %></strong></td>
											<td class="border-0 align-middle"><strong
											id="price_<%= item.getId() %>">$<%= item.getGst() %></strong></td>
										<td class="border-0 align-middle"><input id="quantity_<%= item.getId() %>" type="number" value="<%=item.getQuantity() %>" min="1" class="form-control quantity-input"></td>
										<td class="border-0 align-middle"><a href="#"
											onClick="removeItem('<%= item.getId() %>')" class="text-dark"><i
												class="fa fa-trash"></i></a></td>
									</tr>
									<% } %>
									<tr>
										<td class="border-0 align-middle"><button type="button"
												class="btn btn-dark rounded-pill py-2 btn-block"
												onClick="getPrice()">Procced to Checkout</button></td>
								</tbody>
							</table>
						</div>
						<!-- End -->
					</div>
				</div>

				<div class="row py-5 p-4 bg-white rounded shadow-sm">
					<div class="col-lg-6">
						<div
							class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Coupon
							code</div>
						<div class="p-4">
							<p class="font-italic mb-4">If you have a coupon code, please
								enter it in the box below</p>
							<div class="input-group mb-4 border rounded-pill p-2">
								<input type="text" placeholder="Apply coupon"
									aria-describedby="button-addon3" class="form-control border-0">
								<div class="input-group-append border-0">
									<button id="button-addon3" type="button"
										class="btn btn-dark px-4 rounded-pill">
										<i class="fa fa-gift mr-2"></i>Apply coupon
									</button>
								</div>
							</div>
						</div>
						<div
							class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Instructions
							for seller</div>
						<div class="p-4">
							<p class="font-italic mb-4">If you have some information for
								the seller you can leave them in the box below</p>
							<textarea name="" cols="30" rows="2" class="form-control"></textarea>
						</div>
					</div>
					<div class="col-lg-6">
						<div
							class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order
							summary</div>
						<div class="p-4">
							<p class="font-italic mb-4">Shipping and additional costs are
								calculated based on values you have entered.</p>
							<ul class="list-unstyled mb-4">
								<li class="d-flex justify-content-between py-3 border-bottom"><strong
									class="text-muted ">Order Subtotal </strong><strong
									class="totalCost"></strong></li>
								<li class="d-flex justify-content-between py-3 border-bottom"><strong
									class="text-muted">Shipping and handling</strong><strong >
										</strong></li>
								<li class="d-flex justify-content-between py-3 border-bottom"><strong
									class="text-muted">Tax</strong><strong>$0.00</strong></li>
								<li class="d-flex justify-content-between py-3 border-bottom"><strong
									class="text-muted">Total</strong>
									<h5 class="font-weight-bold totalCost "></h5></li>
							</ul>
							<a href="#" class="btn btn-dark rounded-pill py-2 btn-block">Procceed
								to Payamount</a>
								<form id="paymentForm">
    <input type="text" name="amount" placeholder="Enter Amount (in paise)">
    <button type="submit">Pay with Razorpay</button>
</form>
								
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
		function removeItem(pid) {
			console.log(pid);
			$.ajax({
				type : "POST",
				url : "RemoveServlet",
				data : {
					"pid" : pid
				},
				success : function(response) {
					alert("item removed");
					//console.log(response);
					$('#row_' + pid).remove();
				}
			})
		}
		function getPrice() {
			var items = [];
			console.log("getpriced");
			$('.quantity-input').each(
					function() {
						var itemId = $(this).attr('id').split('_')[1]; // Get the item id
						var quantity = $(this).val(); // Get the quantity value
						var price = parseFloat($('#price_' + itemId).text()
								.replace('$', '')); // Get the price of the item

						// Create an object for the item with id, quantity, and price
						var item = {
							itemId : itemId,
							quantity : quantity,
							price : price
							
						};

						items.push(item); // Push the item object to the items array
					});

			// Send items array to servlet via AJAX
			$.ajax({
				type : 'POST',
				url : 'GetPrice', // Specify your servlet URL here
				data : JSON.stringify(items),
				contentType : 'application/json',// Send items array as JSON string
				success : function(response) {
					// Handle success response from servlet
					$('.totalCost').text('$' + response);
					console.log('Items sent successfully');
					console.log(response);
					
					
				},
				error : function(error) {
					// Handle error response
					console.error('Error sending items:', error);
				}
			});
		}
	</script>
	
	<script>
    document.getElementById('paymentForm').addEventListener('submit', function(event) {
        event.preventDefault();
        
        var amount = document.getElementsByName('amount')[0].value;

        fetch('razorpay', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ amount: amount })
        })
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            var options = {
                "key": "rzp_test_GV2KGzgdhEGvYm",
                "amount": amount,
                "currency": "INR",
                "name": "Your Company Name",
                "description": "Test Payment",
                "order_id": data.id,
                "handler": function(response) {
                    // Handle successful payment
                    alert('Payment successful: ' + response.razorpay_payment_id);
                },
                "prefill": {
                    "name": "Test User",
                    "email": "sudheerarigela47@gmail.com"
                },
                "theme": {
                    "color": "#3399cc"
                }
            };
            var rzp = new Razorpay(options);
            rzp.open();
        })
        .catch(function(error) {
            console.error('Error:', error);
        });
    });
</script>
</body>
</html>
