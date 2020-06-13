$(document).ready(function () {
    $('.btnInsert').attr("disabled", "disabled");
    $('.btnUpdate').attr("disabled", "disabled");

    $(window).keydown(function (event) {
        if (event.keyCode == 13) {
            event.preventDefault();
            return false;
        }
    });

    var cidade, endereco, endereco2, bairro, telefone, cep;

    if ($(".cidade")[0].value != null && $(".endereco")[0].value != null && $(".endereco2")[0].value != null && $(".bairro")[0].value != null && $(".telefone")[0].value != null && $(".cep")[0].value != null) {

        cidade = $(".cidade")[0].value;
        endereco = $(".endereco")[0].value;
        endereco2 = $(".endereco2")[0].value;
        bairro = $(".bairro")[0].value;
        telefone = $(".telefone")[0].value;
        cep = $(".cep")[0].value;
    } else {

        cidade = "";
        endereco = "";
        endereco2 = "";
        bairro = "";
        telefone = "";
        cep = "";
    }

    if ($(".endereco_id")[0].value != 0) {
        $("#titulo")[0].innerText = "Edição de Endereço";
        $("#btnEditar").attr('style', 'display: inline');
        $("#btnCadastrar").attr('style', 'display: none');


    }

    $(".btnVoltar").click(function () {
        $(".cidade")[0].value = cidade;
        $(".endereco")[0].value = endereco;
        $(".endereco2")[0].value = endereco2;
        $(".bairro")[0].value = bairro;
        $(".telefone")[0].value = telefone;
        $(".cep")[0].value = cep;
    })

    $(".cidade").change(function () {
        if ($(".cidade")[0].value == " ") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor selecione uma cidade";
            $(".cidade")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);
        }
        verifica();
    })

    $(".endereco").focusout(function () {
        if ($(".endereco")[0].value.trim() == "") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor preencha o campo endereço"; 
            $(".endereco")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);

        }
        verifica();
    })

    $(".endereco").keyup(function () {
        if ($(".endereco")[0].value.trim() == "") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor preencha o campo endereço";
            $(".endereco")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);
        }
        verifica();
    })

    $(".bairro").focusout(function () {
        if ($(".bairro")[0].value.trim() == "") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor preencha o campo bairro"; 
            $(".bairro")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);
        }
        verifica();
    })
    
    $(".bairro").keyup(function () {
        if ($(".bairro")[0].value.trim() == "") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor preencha o campo bairro";
            $(".bairro")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);
        }
        verifica();
    })
    
    $(".telefone").focusout(function () {
        if ($(".telefone")[0].value.trim() == "") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor preencha o campo telefone";
            $(".telefone")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);
        }
        verifica();
    })
    
    $(".telefone").keyup(function () {
        if ($(".telefone")[0].value.trim() == "") {
            $('#msg').attr("style", "display: block; color: red; font-family: Arial, Helvetica, sans-serif; font-size: 14px; align-items: center; text-align: center")
            $('#msg')[0].innerText = "Por favor preencha o campo telefone";
            $(".telefone")[0].focus();
            setTimeout(function () {
                $('#msg').attr("style", "display: none;")
            }, 4000);
        }
        verifica();
    })
    
    $(".endereco2").keyup(function () {
        verifica();
    })
    $(".cep").keyup(function () {
        verifica();
    })
    
    verifica();
});

function verifica() {
    if ($(".endereco")[0].value.trim() && $(".bairro")[0].value.trim() && $(".telefone")[0].value.trim() && $(".cidade")[0].value != " ") {
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





