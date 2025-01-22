import React, { useState, useEffect } from 'react';
import TextScramble from '@dilrukr/react-text-scramble';
import '/transformers-frontend/transformers-frontend/src/css_styles/Inicio.css';
import axios from '../../axiosConfig';
import { FaCopy } from "react-icons/fa";


const Inicio = () => {

    const baseUrl = "http://localhost:8080/"
    const [inputValue, setInputValue] = useState("Bots/nombre/Silverbolt");
    const [text, setText] = useState("");
    const [registro, setRegistro] = useState(null);

    //Comando para copiar la url en el portapapeles.
    const copiarTexto = () => {
        setInputValue(inputValue.replace(/ /g, '%20')); //Quita los espacios y los reemplaza por %20
        const fullUrl = baseUrl + inputValue;
        navigator.clipboard
            .writeText(fullUrl)
            .then(() => {
                setText('Copiado');
                setTimeout(() => setText(""), 3000);
            })
            .catch((err) => console.error('Error al copiar el texto', err));
    }

    const getBots = async () => {
        try {
            const url = baseUrl + inputValue;
            const response = await axios.get(url);
            console.log('Respuesta de la API:', response.data);
            if(response.data[0]){
                setRegistro(response.data[0]);
            } else {
                setRegistro(response.data);
            }
      
        } catch (error) {
            console.log("Ha ocurrido un error al recuperar los datos")
            console.error(error);
            borrador();
        }
    }

    const borrador = ()=>{
        console.log('Ejecutando borrado');
        setRegistro(null);
    }

    const render = (registro) => {
        if(registro.altura && registro.peso){
            return <div>
                <p><strong>"idTransformer":</strong> {registro.idTransformer}</p>
                <p><strong>"nombreTrans":</strong> {registro.nombreTrans}</p>
                <p><strong>"altura":</strong> {registro.altura} metros</p>
                <p><strong>"peso":</strong> {registro.peso} kilos</p>
                <p><strong>"rango":</strong> {registro.rango}</p>
                <p><strong>"modoAlterno":</strong> {registro.modoAlterno}</p>
                <p><strong>"personalidad":</strong> {registro.personalidad}</p>
                <p><strong>"genero":</strong> {registro.genero}</p>
                <p><strong>"urlImagen":</strong> {registro.urlImagen}</p>
                <p><strong>"faccion": </strong> {"{"} 
                                <p><strong>"idFaccion":</strong> {registro.faccion.idFaccion}</p>
                                <p><strong>"nombreFaccion":</strong> {registro.faccion.nombreFaccion}</p>                          
                                <p><strong>"lider":</strong> {registro.faccion.lider}</p>
                                 {"}"}</p>
                {/* Validar los casos de transformer sin subfaccion*/}
                {registro.subFaccion ? (
                    <p><strong>"subFaccion":</strong>{"{"}
                    <p><strong>"idSubFaccion":</strong>{registro.subFaccion.idSubFaccion}</p>
                    <p><strong>"nombreSubFaccion":</strong>{registro.subFaccion.nombreSubFaccion}</p>
                    <p><strong>"lider":</strong>{registro.subFaccion.lider}</p>
                    <p><strong>"faccionPrincipal":</strong>{"{"}
                                    <p><strong>"idFaccion":</strong>{registro.subFaccion.faccionPrincipal.idFaccion}</p>
                                    <p><strong>"nombreFaccion":</strong>{registro.subFaccion.faccionPrincipal.nombreFaccion}</p>
                                    <p><strong>"lider":</strong>{registro.subFaccion.faccionPrincipal.lider}</p>
                                    {"}"} </p>
                                    {"}"}</p> 
                ):null}                
                </div>
        }
        else if(registro.idFaccion && registro.nombreFaccion){
            return <div>
                 <p><strong>"idFaccion":</strong> {registro.idFaccion}</p>
                                <p><strong>"nombreFaccion":</strong> {registro.nombreFaccion}</p>                          
                                <p><strong>"lider":</strong> {registro.lider}</p>
            </div>
        } 
        else if(registro.nombreSubFaccion && registro.idSubFaccion){
            return <div>
                <p><strong>"idSubFaccion":</strong>{registro.idSubFaccion}</p>
                    <p><strong>"nombreSubFaccion":</strong>{registro.nombreSubFaccion}</p>
                    <p><strong>"lider":</strong>{registro.lider}</p>
                    <p><strong>"faccionPrincipal":</strong>{"{"}
                                    <p><strong>"idFaccion":</strong>{registro.faccionPrincipal.idFaccion}</p>
                                    <p><strong>"nombreFaccion":</strong>{registro.faccionPrincipal.nombreFaccion}</p>
                                    <p><strong>"lider":</strong>{registro.faccionPrincipal.lider}</p>
                                    {"}"} </p>
            </div>
        }
        else{
            return <p>Ha ocurrido un error</p>
        }
    }

    return (
        <div>
            <div className='inicio-Title'>
                TRANSFORMERS
            </div>
            <div style={{ fontSize: '1500%', marginTop: '-10%' }} className='inicio-Title'>
                API
            </div>
            <div className='inicio-SubTitle1'>
                Toda la información disponible de tus Transformers favoritos en una sola API REST hecha por fans.
            </div>
            {/* Sección de copiado de la Url*/}
            <div>
                {/*Titulo Enlace */}
                <p style={{
                    fontSize: '150%',
                    color: 'rgb(3, 160, 223)',
                    marginTop: '15%',
                    marginLeft: '47%',
                    textShadow: '0px 0 20px rgba(3, 161, 223, 0.44)',
                    fontStyle: 'italic'
                }}>Enlace</p>
                {/* Sección para copiar*/}
                <div className='SeccionCopia'>
                    <div className='CajaUrl'>
                        {baseUrl}
                    </div>
                    <input
                        className='inputUrl'
                        type='text'
                        value={inputValue}
                        onChange={(e) => setInputValue(e.target.value)}
                    >
                    </input>
                    <button onClick={copiarTexto} className='copiarButton'>
                        <FaCopy />
                    </button>
                    <button onClick={getBots} className='buscarButton'>Buscar</button>
                </div>
                {text && (
                    <p style={{
                        color: 'rgb(197, 133, 248)',
                        marginTop: '1%',
                        marginLeft: '48%'
                    }}>{text}</p>
                )}
            </div>
            <div>
                <div className='campoCodigo'>
                    {registro ? (
                        <div>
                            {render(registro)}
                            </div>
                    ) : (<p>...</p>)
                    }
                </div>
            </div>
        </div>
    );
};

export default Inicio;

