package br.com.reneg.oslc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class OlscResponse {
    private Long numeroJornada;
    private Double valor;
    private LocalDate dataJornada;
    private String cpfCnpj;
}
