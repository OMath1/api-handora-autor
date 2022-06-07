package br.com.handora.autor.dto;

import br.com.handora.autor.model.Autor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {
    
    @Size(max = 120)
    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @Size(max = 120)
    @NotNull(message = "Email é obrigatório")
    private String email;

    @Size(max = 2500)
    @NotNull(message = "Descrição obrigatório")
    private String descricao;

    @NotNull(message = "CPF é obrigatório")
    private String cpf;

    public Autor converter() {
        return new Autor(nome, email, descricao, cpf);
    }}
