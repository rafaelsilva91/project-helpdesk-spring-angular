package com.rafaelsilva91.dev.helpdesk.services;

import com.rafaelsilva91.dev.helpdesk.domain.Chamado;
import com.rafaelsilva91.dev.helpdesk.domain.Cliente;
import com.rafaelsilva91.dev.helpdesk.domain.Tecnico;
import com.rafaelsilva91.dev.helpdesk.domain.dtos.ChamadoDTO;
import com.rafaelsilva91.dev.helpdesk.repositories.ChamadoRepository;
import com.rafaelsilva91.dev.helpdesk.repositories.PessoaRepository;
import com.rafaelsilva91.dev.helpdesk.services.exceptions.ObjectNotFoundExceptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    private ChamadoRepository repository;

    private TecnicoService tecnicoService;
    private ClienteService clienteService;

    public ChamadoService(ChamadoRepository repository
                         ,TecnicoService tecnicoService
                         , ClienteService clienteService) {
        this.repository = repository;
        this.tecnicoService = tecnicoService;
        this.clienteService = clienteService;
    }

    public Chamado findById(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExceptions("Chamado não encontrado! Id: "+id));
    }

    public List<Chamado> findAll(){
        List<Chamado> list = repository.findAll();
        return list;
    }

    public Chamado create(ChamadoDTO objDTO) {
        objDTO.setId(null);

        Tecnico tecnico = tecnicoService.findById(objDTO.getTecnico());
        Cliente cliente = clienteService.findById(objDTO.getCliente());

        Chamado chamado = new Chamado(objDTO);
        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);

        return repository.save(chamado);
    }

    public Chamado update(Integer id, ChamadoDTO objDTO) {
        objDTO.setId(id);
        Tecnico tecnico = tecnicoService.findById(objDTO.getTecnico());
        Cliente cliente = clienteService.findById(objDTO.getCliente());
        Chamado oldChamado = findById(id);
        oldChamado = new Chamado(objDTO);
        oldChamado.setCliente(cliente);
        oldChamado.setTecnico(tecnico);
        return repository.save(oldChamado);
    }


//
//    public void delete(Integer id) {
//        Chamado obj = findById(id);
//        if(obj.getId().is .size() > 0 ){
//            throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
//        }
//        repository.deleteById(id);
//    }

}
