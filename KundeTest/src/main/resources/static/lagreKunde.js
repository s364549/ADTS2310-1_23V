function lagreKunde() {
    const kunde = {
        navn : $("#navn").val(),
        adresse : $("#adresse").val(),
    };
    $.post( "/lagreKunde", kunde, function() {
        window.location.href = 'index.html';
    });
}

