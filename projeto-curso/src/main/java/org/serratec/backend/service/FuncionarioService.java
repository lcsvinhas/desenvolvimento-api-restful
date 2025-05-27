package org.serratec.backend.service;

import org.serratec.backend.dto.FuncionarioResponseDTO;
import org.serratec.backend.entity.Funcionario;
import org.serratec.backend.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioResponseDTO> listar() {
        List<Funcionario> funcionarios = repository.findAll();
        return funcionarios.stream().map(FuncionarioResponseDTO::new).collect(Collectors.toList());
    }

    public Page<FuncionarioResponseDTO> listarPorPagina(Pageable pageable) {
        Page<Funcionario> funcionarios = repository.findAll(pageable);
        return funcionarios.map(FuncionarioResponseDTO::new);
    }

    public Page<FuncionarioResponseDTO> listarPorPaginaFaixaSalarial(Double faixa1, Double faixa2, Pageable pageable) {
        Page<Funcionario> funcionarios = repository.findBySalarioBetween(faixa1, faixa2, pageable);
        return funcionarios.map(FuncionarioResponseDTO::new);
    }

    public Page<FuncionarioResponseDTO> listarPorNome(String nome, Pageable pageable) {
        Page<Funcionario> funcionarios = repository.findByNomeContainingIgnoreCase(nome, pageable);
        return funcionarios.map(FuncionarioResponseDTO::new);
    }
}
