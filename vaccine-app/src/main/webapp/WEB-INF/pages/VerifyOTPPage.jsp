<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        body {
           background-color: black;
        }

        .height-100 {
            height: 100vh
        }

        .card {
            width: 500px;
            border: none;
            height: 300px;
            box-shadow: 5px 5px 20px 0px #0a0a09d4;
            z-index: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .card h6 {
            color: red;
            font-size: 17px
        }

        .validate {
            border-radius: 20px;
            height: 40px;
            background-color: red;
            border: 5px solid red;
            width: 140px
        }


        .c-email__header {
            /* background-color: yellowgreen; */
            background: linear-gradient(135deg, rgb(200, 42, 30) 40%, rgb(0, 255, 4));
            opacity: 70%;
            width: 104%;
            height: 50px;
            margin-top: -80px;
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
</head>

<body style="background-color: rgba(36, 102, 235, 0.496);">


    <div class="container height-100 d-flex justify-content-center align-items-center">
        <div class="position-relative">
        <h6 style="color: green; font-family: sans-serif;">${SuccessMsg}</h6>
        <h6 style="color: red;">${ErrMsg}</h6>
            <div class="card p-2 text-center">
                <div class="c-email__header">
                    <h1 class="c-email__header__title">Your OTP Verification </h1>
                </div>
                <div class="forms">
                    <h6>Please enter the One Time Password <br> to SignIn your account</h6>
                    <div> <span>Enter the OTP you received at </span> <small style="font-weight: bold;">${mailId}</small> </div>

                    <form action="verifyOTP.vaccine" method="post">
                        <input type="text" placeholder="Enter OTP" name="userOTP">
                        <div class="mt-4"> <input type="submit" value="verify" class="btn btn-danger px-4 validate" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
