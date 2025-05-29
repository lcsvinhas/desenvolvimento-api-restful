package org.serratec.backend.dto;

import org.serratec.backend.entity.Consulta;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate dateConsulta;
    private String nomePaciente;
    private String nomeMedico;
    private List<ProcedimentoDTO> procedimentosDTO;
    private Double totalGeral;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Consulta consulta) {
        this.dateConsulta = consulta.getDataConsulta();
        this.nomePaciente = consulta.getPaciente().getNome();
        this.nomeMedico = consulta.getMedico().getNome();
        this.procedimentosDTO = consulta.getProcedimentos().stream().map(ProcedimentoDTO::new).collect(Collectors.toList());
        this.totalGeral = consulta.getTotalGeral();
    }

    public LocalDate getDateConsulta() {
        return dateConsulta;
    }

    public void setDateConsulta(LocalDate dateConsulta) {
        this.dateConsulta = dateConsulta;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public List<ProcedimentoDTO> getProcedimentosDTO() {
        return procedimentosDTO;
    }

    public void setProcedimentosDTO(List<ProcedimentoDTO> procedimentosDTO) {
        this.procedimentosDTO = procedimentosDTO;
    }

    public Double getTotalGeral() {
        return totalGeral;
    }

    public void setTotalGeral(Double totalGeral) {
        this.totalGeral = totalGeral;
    }
}
