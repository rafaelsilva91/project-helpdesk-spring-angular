package com.rafaelsilva91.dev.helpdesk.repositories;

import com.rafaelsilva91.dev.helpdesk.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
