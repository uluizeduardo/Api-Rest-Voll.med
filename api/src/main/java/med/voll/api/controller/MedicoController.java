package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.DadosAtualizacaoMedicoDto;
import med.voll.api.dto.ListaDeMedicosDto;
import med.voll.api.dto.MedicoDto;
import med.voll.api.model.Medico;
import med.voll.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> cadastrarMedico(@RequestBody @Valid MedicoDto medicoDto){
        return new ResponseEntity<Medico>(medicoService.cadastrarMedico(medicoDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ListaDeMedicosDto>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return ResponseEntity.ok(medicoService.listarMedicos(pageable));
    }

    @PutMapping
    public void atualizarMedico(@RequestBody @Valid DadosAtualizacaoMedicoDto dadosAtualizacaoMedicoDto){
        medicoService.atualizaMedico(dadosAtualizacaoMedicoDto);
    }
}
