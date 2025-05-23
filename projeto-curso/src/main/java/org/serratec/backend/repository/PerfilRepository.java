package org.serratec.backend.repository;

import org.serratec.backend.entity.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<UsuarioPerfil, Long> {
}
