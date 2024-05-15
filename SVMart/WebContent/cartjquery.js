$(document).ready(function(){
	
	
	//Jquery code to load category-wise products on the page
	
	$('#category-select').on('focus',function(){
		fetchfromdb($('#category-select'));
	});
	function fetchfromdb(selectedElement){
		selectedElement.empty();
		console.log("sending ajax call to retrive the catagory");
		$.ajax({
			url:"GetCatagoryServlet",
			type:"GET",
			dataType:"json",
			success:function(responsedata){
				console.log("recived catagory data");
				console.log(responsedata);				
				$.each(responsedata,function(a){
					var optionHtml = `<option value="${responsedata[a].pcatid}">${responsedata[a].pcatname}</option>`;
					selectedElement.append(optionHtml);
				});
			}
		});	
	}
	
	//JQuery ajax call to add the products to the cart
	
	$('#category-select').on('change',function(){
		
		$('#productlists').empty();
		console.log("sending ajax call to retrive the selected catagory product");
		var selectCtg=$(this).val();
		$.ajax({
			url:"GetSelectedPCatagory",
			type:"GET",
			data:{"selectctg":selectCtg},
			dataType:"json",
			success:function(responseData){
				console.log("recived selected catagory data");
				console.log(responseData);
				$.each(responseData,function(products){
					var divstart='<div class="product-card">';
					
					var img=`<img src="${responseData[products].image}" alt="Product 1">`;
					var id = `<h3>${responseData[products].pid}</h3>`
					var h3=`<h2>${responseData[products].pname}</h2>`;
					var p=`<p>${responseData[products].price}</p>`;
					var button=`<button type="button"  class="add-to-Cart">Add to Cart</button>`;
					var divend=`</div>`;
					let div=divstart+id+img+h3+p+button+divend;
					$('#productlists').append(div);
					$(".add-to-Cart").click(clicked);
				});
			}
		});
	});
	
	
	//jquery code to make an ajax call to AddToCart Servlet to do the manipulations
	
	$(".add-to-Cart").click(clicked);
	
		function clicked(){
		
			
			var productId = $(this).closest('div').find('h4').text();
			var productName = $(this).closest('div').find('h2').text();
			var productPrice = $(this).closest('div').find('h5').text();
			var productImage = $(this).closest('div').find('img').attr('src');
			var productCatId = $(this).closest('div').find('h3').text();
			
			// Prompt the user for the PIN code
        var pinCode = prompt("Please enter your PIN code:");
        
        if (pinCode != null) {
            // User entered a PIN code, proceed to add the product to the cart
			 
			//console.log(productPrice);
			var productDetails = {
				id : productId,
				name : productName,
				price : productPrice,
				image : productImage,
				pinCode: pinCode,
				prodCatId: productCatId
			};
			//console.log(productDetails.price);

			$.ajax({
				type : "POST",
				url : "AddToCartServlet",
				data : productDetails,
				success : function(response) {
					alert(response);
				},
				error : function(response) {
				alert("Not added");
				}
			});
			}
		}
		
		
		
	
});