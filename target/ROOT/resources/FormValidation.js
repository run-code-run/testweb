$().ready(function () {


    $("#orderForm").validate({
        rules: {
            orderNumber: {
                required: true,
                text: true,
                digits: true,

            },

            sum: {

                required: true,
                digits: true,
                maxlength: 5,
            },
        },
        messages: {
            orderNumber: "Please enter valid order number",
            sum: {
                required: "Please enter sum",
                maxlength: "Sum mustn`t be more then 5 characters long"

            },

        }

    });
});
