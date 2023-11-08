package com.loja.faculdade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.faculdade.entities.Brinquedo;
import com.loja.faculdade.entities.exceptions.BrinquedoNotFoundException;
import com.loja.faculdade.entities.exceptions.InvalidBrinquedoException;
import com.loja.faculdade.services.BrinquedoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/brinquedo")
public class BrinquedoController {

	@Autowired
	private BrinquedoService brinquedoService;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<?> list = brinquedoService.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			Brinquedo brinquedo = brinquedoService.findById(id);
			return ResponseEntity.ok(brinquedo);
		} catch (BrinquedoNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertBrinquedo(@RequestBody Brinquedo brinquedo) {
		try {
	        // Adicione logs para verificar os dados recebidos
	        System.out.println("Dados recebidos: " + brinquedo.toString());

	        Brinquedo brinquedo1 = brinquedoService.insert(brinquedo);
	        return ResponseEntity.ok(brinquedo1);
	    } catch (InvalidBrinquedoException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	    }
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBrinquedo(@PathVariable Long id, @RequestBody Brinquedo updatedBrinquedo) {
		try {
			updatedBrinquedo.setId(id);
			Brinquedo brinquedo1 = brinquedoService.update(updatedBrinquedo);

			if (brinquedo1 != null) {
				return ResponseEntity.ok(brinquedo1);
			} else {
				throw new BrinquedoNotFoundException("Brinquedo não encontrado com o ID: " + id);
			}
		} catch (BrinquedoNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			brinquedoService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (BrinquedoNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
