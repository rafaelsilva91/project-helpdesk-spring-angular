package com.rafaelsilva91.dev.helpdesk.services;

import com.rafaelsilva91.dev.helpdesk.domain.Cliente;
import com.rafaelsilva91.dev.helpdesk.domain.Pessoa;
import com.rafaelsilva91.dev.helpdesk.domain.Tecnico;
import com.rafaelsilva91.dev.helpdesk.domain.dtos.ClienteDto;
import com.rafaelsilva91.dev.helpdesk.domain.dtos.TecnicoDto;
import com.rafaelsilva91.dev.helpdesk.repositories.ClienteRepository;
import com.rafaelsilva91.dev.helpdesk.repositories.PessoaRepository;
import com.rafaelsilva91.dev.helpdesk.repositories.TecnicoRepository;
import com.rafaelsilva91.dev.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.rafaelsilva91.dev.helpdesk.services.exceptions.ObjectNotFoundExceptions;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository repository;
    private PessoaRepository pessoaRepository;

    public ClienteService(ClienteRepository repository, PessoaRepository pessoaRepository) {
        this.repository = repository;
        this.pessoaRepository = pessoaRepository;
    }

    public Cliente findById(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExceptions("Cliente não Encontrado! Id: "+id));
    }

    public List<Cliente> findAll(){
        List<Cliente> list = repository.findAll();
        return list;
    }

    public Cliente create(ClienteDto objDTO) {
        objDTO.setId(null);
        validacaoPorCpfEmail(objDTO);
        Cliente cliente = new Cliente(objDTO);
        return repository.save(cliente);
    }

    public Cliente update(Integer id, ClienteDto objDTO) {
        objDTO.setId(id);
        Cliente oldCliente = findById(id);
        validacaoPorCpfEmail(objDTO);

        oldCliente = new Cliente(objDTO);
        return repository.save(oldCliente);
    }

    private void validacaoPorCpfEmail(ClienteDto objDTO) {
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
        Cliente obj = findById(id);
        if(obj.getChamados().size() > 0){
            throw new DataIntegrityViolationException("Cliente possui ordens de serviço e não pode ser deletado!");
        }
        repository.deleteById(id);
    }

}
