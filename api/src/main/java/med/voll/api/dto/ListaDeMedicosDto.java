package med.voll.api.dto;

import med.voll.api.enums.Especialidade;
import med.voll.api.model.Medico;

public record ListaDeMedicosDto(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public ListaDeMedicosDto(Medico medico){
      this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
