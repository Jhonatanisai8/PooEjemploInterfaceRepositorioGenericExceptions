package org.jhonatan.pooInterface.Repositori.Lista;

import org.jhonatan.pooInterface.Repositori.exceptions.EscrituraAccesoDatoException;

public class RegistroDuplicadoAccesoDatoExcepion extends EscrituraAccesoDatoException {

    public RegistroDuplicadoAccesoDatoExcepion(String mensaje) {
        super(mensaje);
    }

}
