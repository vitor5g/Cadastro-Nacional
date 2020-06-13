$().ready(async function () {
    $('.btnInsert').attr("disabled", "disabled");
    $('.btnUpdate').attr("disabled", "disabled");

    $(window).keydown(function (event) {
        if (event.keyCode == 13) {
            event.preventDefault();
            return false;
        }
    });

    var pais, cidade;


    if ($(".pais")[0].value != null && $(".cidade")[0].value != null) {

        pais = $(".pais")[0].value;
        cidade = $(".cidade")[0].value;
    } else {

        pais = "";
        cidade = "";
    }

    if ($(".cidade_id")[0].value != 0) {
        $("#titulo")[0].innerText = "Edição de Endereço";
        $("#btnEditar").attr('style', 'display: inline');
        $("#btnCadastrar").attr('style', 'display: none');

    }

    $(".btnVoltar").click(function () {
        $(".pais")[0].value = pais;
        $(".cidade")[0].value = cidade;
    })

    $(".pais").change(function () {
        if ($(".pais")[0].value == " ") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor selecione um país";
            $(".pais")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);
        }
        verifica();
    })

    $(".cidade").keyup(function () {
        if ($(".cidade")[0].value.trim() == "") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor preencha o campo nome";
            $(".pais")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);
        }
        verifica();
    })

    $(".cidade").focusout(function () {
        if ($(".cidade")[0].value.trim() == "") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor preencha o campo nome";
            $(".cidade")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);

        }
        verifica();

    })
    verifica();
});

function verifica() {
    if ($(".cidade")[0].value.trim() && $(".pais")[0].value != " ") {
        $('.btnInsert').removeAttr("disabled");
        $('.btnInsert').removeClass("disabled");
        $('.btnUpdate').removeAttr("disabled");
        $('.btnUpdate').removeClass("disabled");

    } else {
        $('.btnInsert').attr("disabled", "disabled");
        $('.btnUpdate').attr("disabled", "disabled");
        $('.btnInsert').addClass("disabled");
        $('.btnUpdate').addClass("disabled");
    }
}



