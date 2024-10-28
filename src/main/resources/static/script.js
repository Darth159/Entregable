const apiUrl = 'http://localhost:8090/sergio/'; // Asegúrate de que esta URL sea correcta

        // Función para crear un nuevo producto
        function createProduct() {
            const cantidad = document.getElementById('Cantidad').value;
            const descripcion = document.getElementById('Descripcion').value;
            const precioUnitario = document.getElementById('precioUnitario').value;
            const importe = document.getElementById('Importe').value;

            if (!cantidad || !descripcion || !precioUnitario || !importe) {
                alert('Por favor, completa todos los campos.');
                return;
            }

            fetch(apiUrl+'Person/crear-persona', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    cantidad: parseInt(cantidad),
                    descripcion: descripcion,
                    precioUnitario: parseFloat(precioUnitario),
                    importe: parseFloat(importe)
                })
            })
            .then(response => {
                if (response.ok) {
                    alert('Producto creado con éxito');
                } else {
                    alert('Error al crear el producto');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error en la solicitud');
            });
        }

        function getAllProducts() {
            fetch(apiUrl+'Person/persons')
            .then(response => response.json())
            .then(data => {
                const resultDiv = document.getElementById('result');
                resultDiv.innerHTML = '';
                data.forEach(product => {
                    resultDiv.innerHTML += `<p>ID: ${product.id}, Cantidad: ${product.cantidad}, Descripción: ${product.descripcion}, Precio Unitario: ${product.precioUnitario}, Importe: ${product.importe}</p>`;
                });
            })
            .catch(error => {
                console.error('Error:', error);
            });
        }

        // Función para actualizar un producto
        function updateProduct() {
            const id = document.getElementById('updateId').value;
            const cantidad = document.getElementById('updateCantidad').value;
            const descripcion = document.getElementById('updateDescripcion').value;
            const precioUnitario = document.getElementById('updatePrecioUnitario').value;
            const importe = document.getElementById('updateImporte').value;

            if (!cantidad || !descripcion || !precioUnitario || !importe) {
                alert('Por favor, completa todos los campos.');
                return;
            }

            fetch(`${apiUrl}Person/update-person/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    cantidad: parseInt(cantidad),
                    descripcion: descripcion,
                    precioUnitario: parseFloat(precioUnitario),
                    importe: parseFloat(importe)
                })
            })
            .then(response => {
                if (response.ok) {
                    alert('Producto actualizado con éxito');
                } else {
                    alert('Error al actualizar el producto');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error en la solicitud');
            });
        }

        function clearUpdateForm() {
            document.getElementById('updateId').value = '';
            document.getElementById('updateCantidad').value = '';
            document.getElementById('updateDescripcion').value = '';
            document.getElementById('updatePrecioUnitario').value = '';
            document.getElementById('updateImporte').value = '';
        }
        function clearUpdateForm2() {
            document.getElementById('Cantidad').value = '';
            document.getElementById('Descripcion').value = '';
            document.getElementById('precioUnitario').value = '';
            document.getElementById('Importe').value = '';
        }
        

        function deleteProduct() {
            const id = document.getElementById('deleteId').value;

            if (!id) {
                alert("Por favor, introduce el ID del producto a eliminar");
                return;
            }

            fetch(`${apiUrl}Person/delete-person/${id}`, {
                method: 'DELETE',
            })
            .then(response => {
                if (response.ok) {
                    alert('Producto eliminado con éxito');
                } else {
                    alert('Error al eliminar el producto');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error en la solicitud');
            });
        }
        function toggleUpdateForm() {
            const updateForm = document.getElementById('updateForm');
            if (updateForm.style.display === 'none') {
                updateForm.style.display = 'block';  
            } else {
                updateForm.style.display = 'none';   
            }
        }
        function showDeleteForm() {
            const deleteForm = document.getElementById('deleteForm');
            if (deleteForm .style.display === 'none') {
                deleteForm .style.display = 'block';  
            } else {
                deleteForm .style.display = 'none';   
            }
        }
        function clearDeleteForm() {
            document.getElementById('deleteId').value = '';
        }