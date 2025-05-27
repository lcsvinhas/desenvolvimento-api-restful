package org.serratec.backend.repository;

import org.serratec.backend.entity.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
//    @Query(value = "SELECT * FROM FUNCIONARIO WHERE SALARIO BETWEEN :faixa1 and :faixa2", nativeQuery = true)
//    Page<Funcionario> faixaSalarial(Double faixa1, Double faixa2, Pageable pageable);
//
//    @Query(value = "SELECT * FROM FUNCIONARIO WHERE NOME ILIKE CONCAT('%', :nome, '%')", nativeQuery = true)
//    Page<Funcionario> buscarPorNome(String nome, Pageable pageable);

    Page<Funcionario> findBySalarioBetween(Double faixa1, Double faixa2, Pageable pageable);
    Page<Funcionario> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

}
