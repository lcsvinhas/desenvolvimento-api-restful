package org.serratec.backend.service;

import org.serratec.backend.dto.ConsultaDTO;
import org.serratec.backend.entity.Consulta;
import org.serratec.backend.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository repository;

    public ConsultaDTO buscar(Long id) {
        Consulta consulta = repository.findById(id).orElseThrow(() -> new RuntimeException("Consulta inexistente!"));
        return new ConsultaDTO(consulta);
    }

    public List<ConsultaDTO> listar() {
        List<Consulta> consultas = repository.findAll();
        return consultas.stream().map(ConsultaDTO::new).collect(Collectors.toList());
    }

//    public ConsultaDTO inserir(Consulta consulta) {
//        Consulta consultaSalva = repository.save(consulta);
//        return new ConsultaDTO(consultaSalva);
//    }
}
