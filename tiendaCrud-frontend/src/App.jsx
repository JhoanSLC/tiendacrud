import './App.css'
import CategoriaComponent from './components/CategoriaComponent'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListCategoriaComponent from './components/ListCategoriaComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

function App() {

	return (
		<>
			<BrowserRouter>
				<HeaderComponent />
				<Routes>
					{/* // http://localhost:5173 */}
					<Route path='/' element={<ListCategoriaComponent />}></Route>
					{/* // http://localhost:5173/categorias */}
					<Route path='/categorias' element={<ListCategoriaComponent />}></Route>

					{/* // http://localhost:5173/add-categoria */}
					<Route path='/add-categoria' element={<CategoriaComponent />}></Route>

					{/* // http://localhost:5173/edit-categoria/1  */}
					<Route path='/edit-categoria/:id' element={<CategoriaComponent />}></Route>
				</Routes>
				<FooterComponent />
			</BrowserRouter>
		</>
	)
}

export default App
