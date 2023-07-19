// Call the dataTables jQuery plugin
$(document).ready(function() {$('#usuarios').DataTable();});
cargarUsuarios();


    async function cargarUsuarios(){

          const request = await fetch('usuarios', {
            method: 'GET',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          });
          const usuarios = await request.json();

          let listadoHtml = '';
          for (let usuario of usuarios) {
              let usuarioHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.email + '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td>';
              listadoHtml += usuarioHtml;
          }


          //let usuario='<tr><td>123</td><td>juan martelli</td><td>x@hotmail.com</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td>';

          document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
    }





