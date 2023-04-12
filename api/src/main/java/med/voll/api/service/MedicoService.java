package med.voll.api.service;

import med.voll.api.dto.DadosAtualizacaoMedicoDto;
import med.voll.api.dto.ListaDeMedicosDto;
import med.voll.api.dto.MedicoDto;
import med.voll.api.mapper.MedicoMapper;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public Medico cadastrarMedico(MedicoDto medicoDto){
        Medico medico = MedicoMapper.INSTANCE.dtoParaMedico(medicoDto);
        return medicoRepository.save(medico);
    }

    public Page<ListaDeMedicosDto> listarMedicos(Pageable pageable) {
        return medicoRepository.findAll(pageable).map(ListaDeMedicosDto::new);
    }

    @Transactional
    public void atualizaMedico(DadosAtualizacaoMedicoDto dadosAtualizacaoMedicoDto) {
        var medico = medicoRepository.getReferenceById(dadosAtualizacaoMedicoDto.id());
        medico.atualizarDadosMedico(dadosAtualizacaoMedicoDto);
    }

    /*@Transactional
    public void deletarMedico(Long id){
        medicoRepository.deleteById(id);
    }*/

    @Transactional
    public void excluir(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
