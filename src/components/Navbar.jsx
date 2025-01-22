import React from 'react'
import '/transformers-frontend/transformers-frontend/src/css_styles/Navbar.css'
const Navbar = () => {
  return (
    <header className='header'>
        <a href='/' className='logo'>Logo</a>
        <nav className='navbar'>
            <a href='/'>Inicio</a>
            <a href='/documentacion'>Documentación</a>
            <a href='/personajes'>Personajes</a>
        </nav>
    </header>
  )
}

export default Navbar