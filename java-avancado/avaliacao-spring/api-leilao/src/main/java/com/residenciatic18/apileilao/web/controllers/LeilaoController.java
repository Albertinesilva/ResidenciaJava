package com.residenciatic18.apileilao.web.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.residenciatic18.apileilao.entities.Leilao;
import com.residenciatic18.apileilao.services.LeilaoService;
import com.residenciatic18.apileilao.web.dto.LeilaoResponseDto;
import com.residenciatic18.apileilao.web.dto.form.LeilaoForm;
import com.residenciatic18.apileilao.web.dto.mapper.LeilaoMapper;

@RestController
@RequestMapping("/leilao")
public class LeilaoController {

  @Autowired
  private LeilaoService leilaoService;

  @PostMapping("/create")
  public ResponseEntity<LeilaoResponseDto> create(@RequestBody LeilaoForm createDto) {
    Leilao obj = leilaoService.salvar(LeilaoMapper.toLeilao(createDto));
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(LeilaoMapper.toDto(obj));
  }

  @GetMapping("/{id}")
  public ResponseEntity<List<LeilaoResponseDto>> getById(@PathVariable Long id) {
    List<LeilaoResponseDto> leiloes = leilaoService.buscarTodos(id);

    if (!leiloes.isEmpty()) {
      return ResponseEntity.ok().body(leiloes);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/")
  public ResponseEntity<List<LeilaoResponseDto>> getAll() {
    List<LeilaoResponseDto> leiloes = LeilaoMapper.toListDto(leilaoService.findAll());
    return ResponseEntity.ok().body(leiloes);
  }

  @PutMapping("/{id}")
  public ResponseEntity<LeilaoResponseDto> update(@PathVariable Long id, @RequestBody LeilaoForm createDto) {
    try {
      return ResponseEntity.ok(LeilaoMapper.toDto(leilaoService.update(id, createDto)));

    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {

    if (leilaoService.isExisteId(id)) {

      try {
        leilaoService.delete(id);
        return ResponseEntity.ok().build();

      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}