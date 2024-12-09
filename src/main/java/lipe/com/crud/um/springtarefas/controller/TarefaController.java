package lipe.com.crud.um.springtarefas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lipe.com.crud.um.springtarefas.dto.TarefaDTO;
import lipe.com.crud.um.springtarefas.model.Tarefa;
import lipe.com.crud.um.springtarefas.model.Tarefa.StatusTarefa;
import lipe.com.crud.um.springtarefas.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
  private final TarefaService service;

  public TarefaController(TarefaService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody TarefaDTO dto) {
    Tarefa tarefa = service.criTarefa(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
  }

  @GetMapping
  public List<Tarefa> listarTarefas() {
    return service.listarTarefas();
  }

  @PatchMapping("/{id}/status")
  public Tarefa atualizarTarefa(@PathVariable Long id, @RequestParam StatusTarefa novoStatus) {
    return service.atualizarStatus(id, novoStatus);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluirTarefa(@PathVariable Long id) {
    service.excluirTarefa(id);
    return ResponseEntity.noContent().build();
  }
}
