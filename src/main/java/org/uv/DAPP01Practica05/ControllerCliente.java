package org.uv.DAPP01Practica05;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/clientes")
public class ControllerCliente {
    
    @Autowired
    private RepositoryCliente repositoryCliente;
    
    @GetMapping()
    public List<Cliente> list() {
        return repositoryCliente.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable Long id) {
        Optional<Cliente> opt=repositoryCliente.findById(id);
        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get());
        }
        else{
        return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> put(@PathVariable Long id, @RequestBody Cliente input) {
        Optional<Cliente> resclient = repositoryCliente.findById(id);
        if (resclient.isPresent()) {
            Cliente clienteToEdit = resclient.get();
            clienteToEdit.setNombre(input.getNombre());
            Cliente clienteEdited = repositoryCliente.save(clienteToEdit);
            return ResponseEntity.ok(clienteEdited);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<Cliente> post(@RequestBody Cliente input) {
        Cliente clienteNew = repositoryCliente.save(input);
        return ResponseEntity.ok(clienteNew);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id) {
        Optional<Cliente> resCli = repositoryCliente.findById(id);
        if (resCli.isPresent()) {
            Cliente cliToDelete=resCli.get();
            repositoryCliente.delete(cliToDelete);
            return ResponseEntity.ok(cliToDelete);
        }
        return ResponseEntity.notFound().build();
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
