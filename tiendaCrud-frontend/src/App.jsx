import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListCategoriaComponent from './components/ListCategoriaComponent'
import {BrowserRouter, Route, Routes} from 'react-router-dom'

function App() {

  return (
	<>
		<BrowserRouter>
			<HeaderComponent />
				<Routes>
					{/* // http://localhost:3000 */}
					<Route path='/' element = {<ListCategoriaComponent />}></Route>
					{/* // http://localhost:3000/categorias */}
					<Route path='/categorias' element = {<ListCategoriaComponent />}></Route>
				</Routes>
			<FooterComponent />
		</BrowserRouter>
	</>
  )
}

export default App
