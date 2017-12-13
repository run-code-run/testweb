<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/additional-methods.js"></script>
    <script src="../../resources/FormValidation.js"></script>
</head>
<body>

<div class="container">
    <h2>Order form</h2>
    <form class="form-horizontal" id="orderForm" method="post" action="#">
        <div class="form-group">
            <label class="control-label col-sm-2" for="orderNumber">Order:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="orderNumber" class="required"
                       placeholder="Enter your order number" name="orderNumber">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="description">Description:</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="description" name="description"
                          placeholder="Put your description here"></textarea>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="sum">Sum:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="sum" class="required" placeholder="Enter desired sum"
                       name="sum">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="currency">Currency:</label>
            <div class="col-sm-10">
                <select class="form-control" id="currency" name="currency">
                    <option value="USD">USD</option>
                    <option value="EUR">EUR</option>
                </select>

            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
    </form>
</div>


<%--<script type="text/javascript">
    $(document).ready(function () {
        $('form').validate();
    });
</script>--%>

</body>
</html>

