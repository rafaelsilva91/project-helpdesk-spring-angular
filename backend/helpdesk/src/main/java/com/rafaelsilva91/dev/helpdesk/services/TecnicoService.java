package com.rafaelsilva91.dev.helpdesk.services;

import com.rafaelsilva91.dev.helpdesk.domain.Cliente;
import com.rafaelsilva91.dev.helpdesk.domain.Pessoa;
import com.rafaelsilva91.dev.helpdesk.domain.Tecnico;
import com.rafaelsilva91.dev.helpdesk.domain.dtos.TecnicoDto;
import com.rafaelsilva91.dev.helpdesk.repositories.PessoaRepository;
import com.rafaelsilva91.dev.helpdesk.repositories.TecnicoRepository;
import com.rafaelsilva91.dev.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.rafaelsilva91.dev.helpdesk.services.exceptions.ObjectNotFoundExceptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    private TecnicoRepository repository;

    private PessoaRepository pessoaRepository;

    public TecnicoService(TecnicoRepository tecnicoRepository, PessoaRepository pessoaRepository) {
        this.repository = tecnicoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExceptions("Tecnico não encontrado! Id: "+id));
    }

    public List<Tecnico> findAll(){
        List<Tecnico> list = repository.findAll();
        return list;
    }

    public Tecnico create(TecnicoDto objDTO) {
        objDTO.setId(null);
        validacaoPorCpfEmail(objDTO);
        Tecnico tecnico = new Tecnico(objDTO);
        return repository.save(tecnico);

    }

    public Tecnico update(Integer id, TecnicoDto objDTO) {
        objDTO.setId(id);
        Tecnico oldTecnico = findById(id);
        validacaoPorCpfEmail(objDTO);

        oldTecnico = new Tecnico(objDTO);
        return repository.save(oldTecnico);
    }

    private void validacaoPorCpfEmail(TecnicoDto objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }


    public void delete(Integer id) {
        Tecnico obj = findById(id);
        if(obj.getChamados().size() > 0 ){
            throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
        }
        repository.deleteById(id);
    }
}
