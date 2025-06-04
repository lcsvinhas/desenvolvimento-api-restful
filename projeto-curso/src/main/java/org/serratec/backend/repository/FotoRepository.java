package org.serratec.backend.repository;

import org.serratec.backend.entity.Foto;
import org.serratec.backend.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FotoRepository extends JpaRepository<Foto, Long> {
    Optional<Foto> findByFuncionario(Funcionario funcionario);
}
