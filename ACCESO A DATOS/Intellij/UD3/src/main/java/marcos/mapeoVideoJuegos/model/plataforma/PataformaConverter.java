package marcos.mapeoVideoJuegos.model.plataforma;

import jakarta.persistence.AttributeConverter;

public class PataformaConverter implements AttributeConverter<Plataforma,String> {
    @Override
    public String convertToDatabaseColumn(Plataforma plataforma) {
        return plataforma.getCodigo();
    }

    @Override
    public Plataforma convertToEntityAttribute(String s) {
        return Plataforma.getPlataforma(s);
    }
}
