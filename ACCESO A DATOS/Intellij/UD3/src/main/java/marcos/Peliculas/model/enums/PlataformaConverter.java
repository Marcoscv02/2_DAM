package marcos.Peliculas.model.enums;

import jakarta.persistence.AttributeConverter;

public class PlataformaConverter implements AttributeConverter<Plataforma,String> {
    @Override
    public String convertToDatabaseColumn(Plataforma plataforma) {
        return plataforma.getCodigo();
    }

    @Override
    public Plataforma convertToEntityAttribute(String s) {
        return Plataforma.getPlataforma(s);
    }
}
