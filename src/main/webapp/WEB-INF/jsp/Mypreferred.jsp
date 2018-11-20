<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.ensa.entities.*"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Challenge|Mypreferred</title>
<link href="/resources/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="/resources/css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Bilbo Swash Caps' rel='stylesheet'>
<style>
.dislike{
	float:left;
}
.like{
	float:right;
}
.like a, .dislike a{
	color: #000;
	font-size: 0.8125em;
	text-transform: uppercase;
	font-weight: 600;
	text-decoration:none;
}
.like a:hover{
	color:#3e22db;
}
.dislike a:hover{
	color:#ff0000;
}
</style>
</head>

<body>
<div class="header">
		<div class="container">
			<div class="row">
			  <div class="col-md-12">
				 <div class="header-left">
					 <div class="logo">
						<a href="#" style="text-decoration: none;"><h1 style="font-family:'Bilbo Swash Caps';font-size: 27px;color:white;">Welcome ,${user.nom}<span> </span>${user.prenom}</h1></a>
					 </div>					
	    		    <div class="clear"></div>
	    	    </div>
	       <div class="header_right">
		   <div class="clear"></div>
	       </div>
	      </div>
		 </div>
	    </div>
	  </div>
	  <div class="main">
	  <div class="button1">
        <a href="back"><input type="submit" name="Submit" value="Back to all shop"></a>
	  </div>
		<div class="container">
		<div class="row">
       <c:forEach var="l" items="${lshop}"> 
				<div class="col-md-3 shop_box" style="margin-top:30px;margin-bottom:30px;">
				<div class="col-item" >
					<img src="/resources/images/shop_img.jpg"  class="img-responsive" alt=""/>
					<div class="shop_desc">
						<h3><a href="#">${l.pk.shop.nom_shop}</a></h3>
						<ul class="buttons">
							<li class="dislike"><a href="deletefavorite?id=${l.pk.shop.idshop}">Delete</a></li>
							<div class="clearfix"></div>
					    </ul>
				    </div>
				
				</div>
				</div>
				
	    </c:forEach>
		</div>
		</div>
		</div>


</body>
</html>