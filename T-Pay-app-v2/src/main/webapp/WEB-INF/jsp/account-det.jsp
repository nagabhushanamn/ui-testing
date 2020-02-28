<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T-pay</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
</head>
<body class="container">
	<hr />
	<h1>T-pay</h1>
	<hr />

	<hr />
	
	<ul class="nav nav-pills">
		<li class="nav-item">
			<a class="nav-link" href="home">Home</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="txr">Pay</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="account">Account</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="logout">logout</a>
		</li>
	</ul>

	<hr />


	<div class="jumbotron">
		<pre>
			Account Number  : <span>${account.num}</span>
			Account Balance : <span>${account.balance}</span>
		</pre>
	</div>


</body>
</html>