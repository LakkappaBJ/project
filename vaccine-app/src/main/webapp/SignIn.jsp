<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Vaccine-App</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
	<style type="text/css">
		@import url('https://fonts.googleapis.com/css2?family=Oswald&family=Rubik+Marker+Hatch&display=swap');

		body {
			margin: 0;
		}

		header {
			background: black;
			color: rgba(244, 225, 79, 0.774);
			padding: 8px 0px 6px 40px;
			height: 70px;
		}

		header h1 {
			display: inline;
			font-family: 'Oswald', sans-serif;
			font-family: 'Rubik Marker Hatch', cursive;
			font-weight: 500px;
			font-size: 60px;
			float: left;
			margin-top: 0px;
			margin-right: 10px;
		}

		nav ul {
			display: inline;
			padding: 0px;
			float: left;
		}
		.card {
			width: 500px;
			height: 300px;
			box-shadow: 5px 5px 20px 0px #0a0a09d4;
			z-index: 1;
			/* display: flex; */
			justify-content: center;
			align-items: center;
		}
		.Email{
			width:300px;
		}

		.validate {
			border-radius: 20px;
			height: 40px;
			background-color: rgb(17, 13, 226);
			border: 5px solid rgb(207, 38, 226);
			width: 150px
		}

		.img {
			background-image: url(vaccineImg.jpg);
			/* background-size: cover; */
			/* position: relative; */
			height: 90vh;
			width: 100%;
			opacity: 60%;

		}

		.c-email__header {
			height: 114px;
			margin-top: -81px;
		}

		.c-email__header__title {
			font-size: 28px;
			font-family: 'Open Sans';
			font-weight: bold;
			height: 80px;
			line-height: 60px;
			margin: 0;
			text-align: center;
			color: black;
		}
	</style>
</head>

<body>
	<header>
		<nav>
			<h1>Vaccine</h1>
		</nav>
	</header>
	 <div class="img">
	<div class="container height-100 d-flex justify-content-center align-items-center">
		<div class="position-relative">
			<div class="card p-2 text-center">
				<div class="c-email__header">
					<h1 class="c-email__header__title">SignIn for vaccination</h1>
				</div>

				<form action="onGetOTPSave.vaccine" method="post">
					<input type="text" name="emailId" placeholder="Enter email" class="Email"> <br> <br>
					<input type="submit" value="Get OTP" class="btn btn-danger px-4 validate">
				</form>

			</div>
		</div>
	</div>
</div>
</body>

</html>