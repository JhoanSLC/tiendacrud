import React, { useEffect, useState } from 'react'
import { listCategoria } from '../services/CategoriaService'
import { useNavigate } from 'react-router-dom'

const ListCategoriaComponent = () => {

	const [categorias, setCategorias] = useState([])

	const navigator = useNavigate();

	useEffect(() => {
		listCategoria().then((response) => {
			setCategorias(response.data);
		}).catch(error => {
			console.error(error);
		})

	}, [])

	function addNewCategoria() {
		navigator('/add-categoria')
	}

	function updateCategoria(id) {
		navigator(`/edit-categoria/${id}`)
	}

	return (
		<div className='container'>
			<h2 className='text-center'>Lista de categorías</h2>
			<button className='btn btn-primary mb-2' onClick={addNewCategoria}>Agregar Categoría</button>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
						<th>Id</th>
						<th>Descripcion</th>
						<th>Estado</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					{
						categorias.map(categoria =>
							<tr key={categoria.id}>
								<td>{categoria.id}</td>
								<td>{categoria.descripcion}</td>
								<td>{categoria.estado}</td>
								<td><button className="btn btn-info" onClick={() => updateCategoria(categoria.id)}>Editar</button></td>
							</tr>
						)
					}
				</tbody>
			</table>
		</div>
	)
}

export default ListCategoriaComponent