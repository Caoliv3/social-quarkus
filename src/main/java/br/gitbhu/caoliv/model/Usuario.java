package br.gitbhu.caoliv.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Nome nao preenchido")
    private String name;
    @Min(value = 1, message = "Idade nao preenchida")
    private Integer age;
}
