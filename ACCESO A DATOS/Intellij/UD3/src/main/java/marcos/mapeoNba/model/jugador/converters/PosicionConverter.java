package marcos.mapeoNba.model.jugador.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import marcos.mapeoNba.model.jugador.Posicion;

@Converter
public class PosicionConverter implements AttributeConverter<Posicion,String> {
    @Override
    public String convertToDatabaseColumn(Posicion posicion) {
        return posicion.getCodigo();
    }

    @Override
    public Posicion convertToEntityAttribute(String s) {
        return Posicion.getPosicion(s);
    }
}
