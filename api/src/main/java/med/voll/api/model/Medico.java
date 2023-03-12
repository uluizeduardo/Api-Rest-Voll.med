package med.voll.api.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.MedicoDto;
import med.voll.api.enums.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDto medicoDto){
        this.nome = medicoDto.nome();
        this.email = medicoDto.email();
        this.crm = medicoDto.crm();
        this.especialidade = medicoDto.especialidade();
        this.endereco = new Endereco(medicoDto.endereco());
    }
}
