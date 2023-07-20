// Call the dataTables jQuery plugin
$(document).ready(function() {$('#usuarios').DataTable();});
cargarUsuarios();


    async function cargarUsuarios(){
    const response = await fetch('http://localhost:8080/api/usuarios');
      const usuarios = await response.json();
      console.log(usuarios);

          const request = await fetch('api/usuarios', {
            method: 'GET',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          });
          const users = await request.json();
          let listadoHtml = '';
          for (let usuario of users) {
              let botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
              let usuarioHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.email +
              '</td><td>'+botonEliminar+'</td>';
              listadoHtml += usuarioHtml;
          }
          document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
    }

    async function eliminarUsuario(id) {

        if (!confirm("¿Está seguro que desea eliminar el usuario?")) {
            return;
        }
        const request = await fetch('api/usuarios/'+ id, {
                        method: 'DELETE',
                        headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                         }
                      });
        location.reload();
    }




