package Java.JSON.appMeteoGalicia;

import java.util.Arrays;
import java.util.Objects;

public enum VariableMeteo {
    CIELO("ceo"), LLUVIA("pchoiva"), TEMPERATURA_MAXIMA("tmaxFranxa"),
    TEMPERATURA_MINIMA("tminFranxa"), VIENTO("vento");

    private String nome;

    VariableMeteo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static VariableMeteo getVariableMeteo(String nome){

        return Arrays.stream(VariableMeteo.values()).
                filter(v -> nome.equalsIgnoreCase(v.getNome()))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return nome;
    }
}
