package org.serratec.backend.service;

import org.serratec.backend.entity.Usuario;
import org.serratec.backend.exception.UsuarioException;
import org.serratec.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> u = repository.findById(id);
        if (u.isPresent()) {
            return u.get();
        }
        throw new UsuarioException("Usuário inexistente!");

    }

    public Usuario inserir(Usuario usuario) {
        Optional<Usuario> u = repository.findByEmail(usuario.getEmail());
        if (u.isPresent()) {
            throw new UsuarioException("Email já cadastrado!");
        }
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }

    public List<Usuario> inserirLista(List<Usuario> lista) {
        for (Usuario usuario : lista) {
            Optional <Usuario> u = repository.findByEmail(usuario.getEmail());
            if (u.isPresent()) {
                throw new UsuarioException("Email já cadastrado!");
            } else {
                usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            }
        }
        return repository.saveAll(lista);
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        Optional<Usuario> u = repository.findById(id);
        if (u.isPresent()) {
            usuario.setId(id);
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return repository.save(usuario);
        }
        throw new UsuarioException("Usuário inexistente!");
    }

    public void deletar(Long id) {
        Optional<Usuario> u = repository.findById(id);
        if (u.isEmpty()) {
            throw new UsuarioException("Usuário inexistente!");
        }
        repository.delete(u.get());
    }
}
