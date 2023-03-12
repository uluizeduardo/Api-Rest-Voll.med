package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoDto;
import med.voll.api.model.Medico;
import med.voll.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> cadastrarMedico(@RequestBody @Valid MedicoDto medicoDto){
        return new ResponseEntity<Medico>(medicoService.cadastrarMedico(medicoDto), HttpStatus.CREATED);
    }
}
