function perfil(){
    var menu = document.getElementById('menuDropdown');
    if (menu.style.display === 'none') {
    menu.style.display = 'block';
    } else {
    menu.style.display = 'none';
    }
}

function cambiar(){
    var sec1 = document.getElementById('seccion1');
    var sec2 = document.getElementById('seccion2');
    if (sec2.style.display === 'none') {
    sec2.style.display = 'block';
    sec1.style.display = 'none';
    } else {
    sec2.style.display = 'none';
    sec1.style.display = 'block';
    }
}