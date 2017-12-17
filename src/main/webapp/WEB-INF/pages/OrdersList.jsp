<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Orders List:</title>
</head>
<body>


<div class="container">
    <table class="table table hover">
        <thead>
        <tr>
            <th>Order Number</th>
            <th>Sum</th>
            <th>Currency</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.orderNumber}</td>
                <td>${order.sum}</td>
                <td>${order.currency}</td>
                <td>${order.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
