import React, { useEffect, useState } from 'react'
import '/transformers-frontend/transformers-frontend/src/css_styles/cardsInicio.css'
const fetchInicio = async () => {
  try {
    const response = await fetch('http://localhost:8080/Faccion');
    if (response) {
      throw new Error(`Error en la solicitud: ${response.status}`);
    }
    const data = await response.json();
    console.log(data);
    return data;
  } catch (Error) {
    console.error('Error en la recuperación', error);
  }
};

const cardsInicio = () => {
  const [faccion, setFaccion] = useState([]);
  useEffect(()=> {
    const fetchData = async () =>{
      const data = await fetchInicio();
      faccion(data);
    };
    fetchData();
  }, []);
  return (
    <div className='card' style={{ marginLeft: '1%' }}>
      <h1 style={{ display: 'flex', justifyContent: 'center' }}>DECEPTICONS</h1>
      <li key='2'>{faccion.nombreFaccion}</li>
    </div>
  )
}

export default cardsInicio