package br.com.handora.autor.model;


import br.com.handora.autor.validaCPF.CPFValida;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Entity
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @AssertTrue(message = "CPF DEVE SER VALIDO!!")
    private boolean isCPF() {
        return CPFValida.isCPF(this.cpf);
    }

    public Autor(String nome, String email, String descricao, String cpf) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
