<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<style>
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    body{
        min-height: 100vh;
        background: #eee;
        display: flex;
        font-family: sans-serif;
    }
    .group{
        margin: auto;
        width: 500px;
        max-width: 90%;
    }
    .group form{
        width: 100%;
        height: 100%;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 4px;
        box-shadow: 0 8px 16px rgba(0,0,0,.3);
    }
    .group form h1{
        text-align: center;
        margin-bottom: 24px;
        color: #222;
    }
    .group form .form-control{
        width: 90%;
        height: 30px;
        background: white;
        border-radius: 4px;
        border: 1px solid silver;
        margin: 4px 0 8px 0;
        padding: 0 10px;
    }

    .group .btn{
        margin-left: 25%;
        transform: translateX(-50%);
        width: 120px;
        height: 34px;
        border: none;
        outline: none;
        background: #7d38af;
        cursor: pointer;
        font-size: 16px;
        text-transform: uppercase;
        color: white;
        border-radius: 4px;
        transition: .3s;
    }
    .group .btn:hover{
        opacity: .7;
    }



</style>
<body>
<div class ="group">
<div align="center">

    <form action="<%=request.getContextPath()%>/login" method="post">

        <table style="with: 100%">
            <tr>
                <div class= "group form">
                    <h1 style="color:black;">Login Form</h1>
                <td>Username</td>
                <td><input type="text" class ="form-control" name="username" /></td>
                </div>
            </tr>
            <tr>
                <div class= "group form">
                <td>Password</td>
                <td><input type="password" class ="form-control" name="password" /></td>
                </div>
            </tr>

        </table>

        <input type="submit" class = "btn" value="login" />
    </form>
</div>
</div>
</body>
</html>