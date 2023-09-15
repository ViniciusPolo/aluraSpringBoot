package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

//    @PostMapping
//    public void cadastrar(@RequestBody String json){
//        System.out.println(json);
//    }
    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

//    @GetMapping
//    public List<Medico> Listar() {
//        return repository.findAll();
//    }

    @GetMapping
    public List<DadosListagemMedicos> Listar() {
        return repository.findAll().stream().map(DadosListagemMedicos::new).toList();
    }

}
