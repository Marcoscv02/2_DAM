package marcos.ad.model.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import marcos.ad.model.Categoria;

@Converter
public class CategotiaConverter implements AttributeConverter<Categoria,String> {
    @Override
    public String convertToDatabaseColumn(Categoria categoria) {

        return categoria.getCodigo();
    }

    @Override
    public Categoria convertToEntityAttribute(String s) {

        return Categoria.valueOf(s);
    }
}
