package marcos.acdatos.ejer5_03.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import marcos.acdatos.ejer5_03.model.Sexoooooo;

@Converter
public class SexoConverter implements AttributeConverter<Sexoooooo, String> {
    @Override
    public String convertToDatabaseColumn(Sexoooooo sexoooooo) {
        return sexoooooo.getCodigo();
    }

    @Override
    public Sexoooooo convertToEntityAttribute(String letra) {
        return Sexoooooo.valueOf(letra);
    }
}
