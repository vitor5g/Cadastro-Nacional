$().ready(async function () {
    $('.btnInsert').attr("disabled", "disabled");
    $('.btnUpdate').attr("disabled", "disabled");
    var dado;

    $(window).keydown(function (event) {
        if (event.keyCode == 13) {
            event.preventDefault();
            return false;
        }
    });

    if ($(".pais")[0].value != null) {

        dado = $(".pais")[0].value;
    } else {

        dado = "";
    }

    if ($(".pais_id")[0].value != 0) {
        $("#titulo")[0].innerText = "Edição de País";
        $("#btnEditar").attr('style', 'display: inline');
        $("#btnCadastrar").attr('style', 'display: none');
        $('.btnUpdate').attr("disabled", "disabled");


    }
    $(".btnVoltar").click(function () {
        $(".pais")[0].value = dado;
    })

    $(".pais").focusout(function () {
        if ($(".pais")[0].value.trim() == "") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor preencha o campo nome";
            $(".pais")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);
        }
        verifica();
    })
    $(".pais").keyup(function () {
        if ($(".pais")[0].value.trim() == "") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor preencha o campo nome";
            $(".pais")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);
        }
        verifica();
    })
    verifica();
});

function verifica() {
    if ($(".pais")[0].value.trim()) {
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

