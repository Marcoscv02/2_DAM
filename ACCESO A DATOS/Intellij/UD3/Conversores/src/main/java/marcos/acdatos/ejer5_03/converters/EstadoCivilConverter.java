package marcos.acdatos.ejer5_03.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import marcos.acdatos.ejer5_03.model.EstadoCivil;

@Converter
public class EstadoCivilConverter implements AttributeConverter <EstadoCivil, String> {

    @Override
    public String convertToDatabaseColumn(EstadoCivil estadoCivil) {
        return estadoCivil.getCodigo();
    }

    @Override
    public EstadoCivil convertToEntityAttribute(String s) {
        return EstadoCivil.valueOf(s);
    }
}
