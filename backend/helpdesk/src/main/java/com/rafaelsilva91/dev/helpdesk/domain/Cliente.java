package com.rafaelsilva91.dev.helpdesk.domain;

import com.rafaelsilva91.dev.helpdesk.domain.enums.PerfilEnum;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa{

    private static final long serialVersionUID = -8981510161454059603L;

    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
        addPerfil(PerfilEnum.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(PerfilEnum.CLIENTE);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
