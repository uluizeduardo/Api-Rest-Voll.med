package med.voll.api.service;

import med.voll.api.dto.ListaDeMedicosDto;
import med.voll.api.dto.MedicoDto;
import med.voll.api.mapper.MedicoMapper;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public Medico cadastrarMedico(MedicoDto medicoDto){
        Medico medico = MedicoMapper.INSTANCE.dtoParaMedico(medicoDto);
        return medicoRepository.save(medico);
    }

    public List<ListaDeMedicosDto> listarMedicos() {
        List<ListaDeMedicosDto> listaDeMedicosDto = MedicoMapper.INSTANCE.medicoParalistaDeMedicoDto(medicoRepository.findAll());
        return listaDeMedicosDto;
    }
}
