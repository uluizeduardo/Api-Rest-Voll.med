package med.voll.api.model;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.api.dto.EnderecoDto;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;

    private String bairro;

    private String cep;

    private String numero;

    private String complemento;

    private String cidade;

    private String uf;

    public Endereco(EnderecoDto enderecoDto){
        this.logradouro = enderecoDto.logradouro();
        this.bairro = enderecoDto.bairro();
        this.cep = enderecoDto.cep();
        this.numero = enderecoDto.numero();
        this.complemento = enderecoDto.complemento();
        this.cidade = enderecoDto.cidade();
        this.uf = enderecoDto.uf();
    }
}
