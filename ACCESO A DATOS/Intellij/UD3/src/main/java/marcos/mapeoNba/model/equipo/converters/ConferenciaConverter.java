package marcos.mapeoNba.model.equipo.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import marcos.mapeoNba.model.equipo.Conferencia;

@Converter
public class ConferenciaConverter implements AttributeConverter<Conferencia,String> {
    @Override
    public String convertToDatabaseColumn(Conferencia conferencia) {
        return conferencia.getCodigo();
    }

    @Override
    public Conferencia convertToEntityAttribute(String s) {
        return Conferencia.getConferencia(s);
    }
}
