<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>

        h1 {
            color: rebeccapurple;
            font-family: Arial;
            font-size: 200%;
        }
        h2 {
            color: rebeccapurple;
            font-family: Arial;
            font-size: 160%;
        }
        .content-table{
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 0.9em;
            min-width: 600px;
            border-radius: 4px;
            box-shadow: 0 8px 16px rgba(0,0,0,.3);

        }

        .content-table th{
            background-color: #7d38af;
        }
        .content-table td{
            padding: 12px 15px;

        }
        .content-table tbody tr{

        }

        .content-table tbody tr :above-level{
            border-radius:  4px; solid-color:  #7d38af;
        }
        .btn{
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
        .btn:hover{
            opacity: .7;
        }
    </style>



    <title>Student Management Application</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/studentForm.jsp">Add new Student</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/ControllerServlet">List all Students</a>

    </h2>
</center>
<div align="center"  >
    <c:if test="${requestScope.student != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${requestScope.student == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5" class="content-table" >
                <caption>
                    <h2>
                        <c:if test="${requestScope.student != null}">
                            Edit Student
                        </c:if>
                        <c:if test="${requestScope.student == null}">
                            Add New Student
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${requestScope.student != null}">
                    <input type="hidden" name="id" value="<c:out value='${requestScope.student.id}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${requestScope.student.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Course: </th>
                    <td>
                        <input type="text" name="course" size="45"
                               value="<c:out value='${requestScope.student.course}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Age: </th>
                    <td>
                        <input type="text" name="age" size="5"
                               value="<c:out value='${requestScope.student.age}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" class = "btn" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>


</body>
</html>
