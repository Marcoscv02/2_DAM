package marcos.nba.model.equipo.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import marcos.nba.model.equipo.Division;

@Converter
public class DivisionConverter implements AttributeConverter<Division,String> {
    @Override
    public String convertToDatabaseColumn(Division division) {
        return division.getCodigo();
    }

    @Override
    public Division convertToEntityAttribute(String s) {
        return Division.getDivision(s);
    }
}
