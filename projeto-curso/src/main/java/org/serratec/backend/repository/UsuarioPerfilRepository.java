package org.serratec.backend.repository;

import org.serratec.backend.entity.UsuarioPerfil;
import org.serratec.backend.entity.pk.UsuarioPerfilPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, UsuarioPerfilPK> {
}
