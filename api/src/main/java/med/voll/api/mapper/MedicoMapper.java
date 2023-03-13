package med.voll.api.mapper;

import med.voll.api.dto.ListaDeMedicosDto;
import med.voll.api.dto.MedicoDto;
import med.voll.api.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);
    Medico dtoParaMedico (MedicoDto medicoDto);

    MedicoDto medicoParaDto(Medico medico);

    List<ListaDeMedicosDto> medicoParalistaDeMedicoDto(List<Medico> medico);
}
