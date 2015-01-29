$(document).ready(function() {
    $("#submit").click(function () {
        var from = $("#from").val();
        var target = $("#target").val();
        var value = $("#value").val();
        var desciprion = $("#desciprion").val();
        var json = {from: from, target : target, value : value, desciprion : desciprion};
        alert(JSON.stringify(json));
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/transactions",
            contentType: 'application/json',
            accept: 'application/json',
            data: JSON.stringify(json),
            success: function (html) {
                alert(html);

            },
            beforeSend: function () {
                $("#message").html("<p class='text-center'><img src='template/images/ajax-loader.gif'></p>")
            }
        });

        return false;
    });
});