package med.voll.api.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
public class Endereco {

    private String logradouro;

    private String bairro;

    private String cep;

    private String numero;

    private String complemento;

    private String cidade;

    private String uf;
}
