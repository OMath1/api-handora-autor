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

//    Todo autor cadastrado tem um nome, email, descrição e CPF;
//    Todas as informações de um autor são obrigatórias;
//    O nome e email devem ter tamanho máximo de 120 caracteres;
//    A descrição deve ter tamanho máximo de 2500 caracteres;
//    O CPF deve ser válido;


//    Para sua API REST:
//            6.1 Em caso de sucesso, a resposta de sua API devera retorna no cabeçalho a location do novo recurso criado, o STATUS HTTP 201 e o corpo devera ser vazio.
//            6.2 Em caso de falha, a resposta de sua API devera retorna o STATUS HTTP 400 e o corpo devera conter as mensagens amigaveis sobre os erros de validação.

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
