package org.serratec.backend.repository;

import org.serratec.backend.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByOrigemIdOrDestinoId(Long idOrigem, Long idDestino);

}
