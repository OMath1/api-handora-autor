package br.com.handora.autor.dto;

import br.com.handora.autor.model.Autor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {
    @Size(max = 120)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Size(max = 120)
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Size(max = 2500)
    @NotBlank(message = "Descrição obrigatório")
    private String descricao;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao, this.cpf);
    }
}
