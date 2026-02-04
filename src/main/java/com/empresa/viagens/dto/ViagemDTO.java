package com.empresa.viagens.dto;

/**
 * Data Transfer Object for Viagem (Trip).
 *
 * <p>Represents a travel trip with destination and user information.
 */
public class ViagemDTO {

  private Long id;
  private Long usuarioId;
  private Long destinoId;
  private String dataPartida;
  private String dataRetorno;
  private Double orcamento;
  private String status;

  public ViagemDTO() {}

  public ViagemDTO(
      Long usuarioId, Long destinoId, String dataPartida, String dataRetorno, Double orcamento) {
    this.usuarioId = usuarioId;
    this.destinoId = destinoId;
    this.dataPartida = dataPartida;
    this.dataRetorno = dataRetorno;
    this.orcamento = orcamento;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(Long usuarioId) {
    this.usuarioId = usuarioId;
  }

  public Long getDestinoId() {
    return destinoId;
  }

  public void setDestinoId(Long destinoId) {
    this.destinoId = destinoId;
  }

  public String getDataPartida() {
    return dataPartida;
  }

  public void setDataPartida(String dataPartida) {
    this.dataPartida = dataPartida;
  }

  public String getDataRetorno() {
    return dataRetorno;
  }

  public void setDataRetorno(String dataRetorno) {
    this.dataRetorno = dataRetorno;
  }

  public Double getOrcamento() {
    return orcamento;
  }

  public void setOrcamento(Double orcamento) {
    this.orcamento = orcamento;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
