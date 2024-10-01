import React, {useEffect, useState} from 'react'
import { listCategoria } from '../services/CategoriaService'


const ListCategoriaComponent = () => {
    
	const [categorias, setCategorias] = useState([])

	useEffect(() => {
		listCategoria().then((response) => {
			setCategorias(response.data);
		}).catch(error => {
			console.error(error);
		})

	}, [])

	return (
		<div className='container'>
			<h2 className='text-center'>Lista de categorías</h2>
			<table className='table table-striped table-bordered'>
				<thead>
					<tr>
						<th>Id</th>
						<th>Descripcion</th>
						<th>Estado</th>
					</tr>
				</thead>
				<tbody>
					{
						categorias.map(categoria => 
								<tr key={categoria.id}>
									<td>{categoria.id}</td>
									<td>{categoria.descripcion}</td>
									<td>{categoria.estado}</td>
								</tr>
							)
					}
				</tbody>
			</table>
		</div>
	)
}

export default ListCategoriaComponent