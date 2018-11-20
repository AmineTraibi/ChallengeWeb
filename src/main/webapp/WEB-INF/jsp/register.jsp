<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<title>Challenge|Register</title>
<link href="/resources/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="/resources/css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Bilbo Swash Caps' rel='stylesheet'>
<style>
.register-bottom-grid input[type="password"]{
	border: 1px solid #EEE;
	outline-color:#00BFF0;
	width: 96%;
	font-size: 1em;
	padding: 0.5em;
	font-family: 'Open Sans', sans-serif;
}
.SubmitButton{
	color: #FFF;
	font-family: 'Open Sans', sans-serif;
	font-size: 0.95em;
	font-weight: normal;
	padding:15px 40px;
	text-transform: uppercase;
	background:#E25050;
	display: inline-block;
	-webkit-transition: all 0.3s ease-out;
	-moz-transition: all 0.3s ease-out;
	-ms-transition: all 0.3s ease-out;
	-o-transition: all 0.3s ease-out;
	transition: all 0.3s ease-out;
	font-weight: 100;
	border: none;
	cursor: pointer;
	outline:none;
}
</style>
</head>
<body>
     <div class="main">
      <div class="shop_top">
	     <div class="container">
						<form class="" action="adduser" method="post"> 
								<div class="register-top-grid">
										<h3>PERSONAL INFORMATION</h3>
										<div>
											<span>First Name<label>*</label></span>
											<input type="text" name="nom"> 
										</div>
										<div>
											<span>Last Name<label>*</label></span>
											<input type="text" name="prenom"> 
										</div>
										
										<div class="clear"> </div>
								</div>
								<div class="clear"> </div>
								
								<div class="register-bottom-grid">
										<h3>LOGIN INFORMATION</h3>
										<div>
											<span>Email Address (login)<label>*</label></span>
											<input type="text" name="login">
										</div>
										<div>
											<span>Password<label>*</label></span>
											<input type="password" name="password">
										</div>
										<div class="clear"> </div>
								</div>
								<div class="clear"> </div>
								<input type="submit" name="Submit" class="SubmitButton" value="submit">
						</form>
					</div>
		   </div>
	  </div>
	  
</body>
</html>