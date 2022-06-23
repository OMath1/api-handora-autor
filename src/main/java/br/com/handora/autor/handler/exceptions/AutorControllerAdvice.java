package br.com.handora.autor.handler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@RestControllerAdvice
public class AutorControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<String> mensagens = new ArrayList<>();

        bindingResult.getFieldErrors().forEach(b -> mensagens.add(b.getDefaultMessage()));
        return ResponseEntity.badRequest().body(mensagens);

    }

    @ExceptionHandler(ResponseStatusException.class)
    public List<String> ResponseStatusException(ResponseStatusException exception) {
        String bindingResult = exception.getReason();

        List<String> mensagens = new ArrayList<>();
        mensagens.add(bindingResult);

        return mensagens;
    }
    @ExceptionHandler(NullPointerException.class)
    public List<String> ResponseStatusException(NullPointerException exception) {
        String bindingResult = exception.getMessage();
        String cpf = "Ou seja, cpf NÃO PODE SER VAZIO, seu bobao";

        List<String> mensagens = new ArrayList<>();
        mensagens.add(bindingResult);
        mensagens.add(cpf);

        return mensagens;
    }
}
