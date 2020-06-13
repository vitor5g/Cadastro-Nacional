$(document).ready(function () {
//    location.reload();
    setTimeout(function () {
        $('.msg').attr('style', 'display: none'); //mostra o modal
    }, 3000);
});

function detail_it(caller) {
    var table = $('#endTable').DataTable();
    $('#responsiveModal').modal(); //mostra o modal
    data = caller.parentNode.parentNode;
//    console.log(data.getElementsByTagName('td')[0].innerHTML);
//    console.log(data.getElementsByTagName('td')[1].innerHTML);
//    console.log(data.getElementsByTagName('td')[2].innerHTML);
//    console.log(data.getElementsByTagName('td')[3].innerHTML);
//    console.log(data.getElementsByTagName('td')[4].innerHTML);
//    console.log(data.getElementsByTagName('td')[5].innerHTML);
//    console.log(data.getElementsByTagName('td')[6].innerHTML);
//    console.log(data.getElementsByTagName('td')[7].innerHTML
    $(".endereco_id")[0].value = data.getElementsByTagName('td')[0].innerHTML;
    $(".endereco")[0].value = data.getElementsByTagName('td')[1].innerHTML;
    $(".endereco2")[0].value = data.getElementsByTagName('td')[2].innerHTML;
    $(".cidade")[0].value = data.getElementsByTagName('td')[4].innerHTML;
    $(".pais")[0].value = data.getElementsByTagName('td')[5].innerHTML;
    $(".bairro")[0].value = data.getElementsByTagName('td')[3].innerHTML;
    $(".cep")[0].value = data.getElementsByTagName('td')[6].innerHTML;
    $(".telefone")[0].value = data.getElementsByTagName('td')[7].innerHTML;



}

