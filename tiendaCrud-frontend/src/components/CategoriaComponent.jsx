import React, { useEffect, useState } from "react";
import { createCategoria, getCategoria, updateCategoria } from "../services/CategoriaService";
import { useNavigate, useParams } from "react-router-dom";

const CategoriaComponent = () => {
  const [descripcion, setDescripcion] = useState("");
  const [estado, setEstado] = useState("");

  const [errors, setErrors] = useState({
    descripcion: "",
    estado: ""
  });

  const { id } = useParams();

  const navigator = useNavigate();

  useEffect(() => {
    if (id) {
      getCategoria(id).then((response) => {
        setDescripcion(response.data.descripcion);
        setEstado(response.data.estado);
      }).catch(error => {
        console.error(error);
      })
    }
  }, [id])

  const handleDescripcion = (e) => {
    setDescripcion(e.target.value);
  };

  const handleEstado = (e) => {
    setEstado(e.target.value);
  };

  const saveOrUpdateCategoria = (e) => {
    e.preventDefault();

    if (validateForm()) {

      const categoria = { descripcion, estado };
      console.log(categoria);

      if (id) {
        updateCategoria(id, categoria).then((response) => {
          console.log(response.data);
          navigator('/categorias');
        }).catch(error => {
          console.error(error);
        })
      } else {
        createCategoria(categoria).then((response) => {
          console.log(response.data);
          navigator("/categorias");
        }).catch(error => {
          console.error(error);
        })
      }
    }


  };

  const validateForm = () => {
    let valid = true;

    const errorsCopy = { ...errors }

    if (!descripcion.trim()) {
      errorsCopy.descripcion = 'La descripción es obligatoria';
      valid = false;
    }

    if (!estado.trim()) {
      errorsCopy.estado = 'El estado es obligatorio';
      valid = false;
    }

    setErrors(errorsCopy);

    return valid;
  }

  const pageTitle = () => {
    if (id) {
      return <h2 className="text-center">Editar Categoría</h2>

    } else {
      return <h2 className="text-center">Agregar Categoría</h2>
    }
  }

  return (
    <div className="container">
      <br />
      <br />
      <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          {pageTitle()}
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">Descripción:</label>
                <input
                  type="text"
                  placeholder="Ingresa la descripcion"
                  name="descripcion"
                  value={descripcion}
                  className={`form-control ${errors.descripcion ? 'is-invalid' : ''}`}
                  onChange={handleDescripcion}
                />
                {errors.descripcion && <div className="invalid-feedback"> {errors.descripcion} </div>}
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Estado:</label>
                <input
                  type="text"
                  placeholder="Ingresa el estado"
                  name="estado"
                  value={estado}
                  className={`form-control ${errors.estado ? 'is-invalid' : ''}`}
                  onChange={handleEstado}
                />
                {errors.estado && <div className="invalid-feedback"> {errors.estado} </div>}
              </div>

              <button className="btn btn-success" onClick={saveOrUpdateCategoria}>
                Enviar
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CategoriaComponent;
