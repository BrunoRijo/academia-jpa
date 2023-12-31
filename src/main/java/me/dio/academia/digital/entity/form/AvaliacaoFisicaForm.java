package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  @NotNull
  @Positive(message = "'${validatedValue}' precisa ser positivo!")
  private Long alunoId;

  @NotNull
  @Positive(message = "'${validatedValue}' precisa ser positivo!")
  private double peso;

  @NotNull
  @Positive(message = "'${validatedValue}' precisa ser positivo!")
  @DecimalMin(value = "150", message =  "'${validatedValue}' precisa ser no minimo {value}!")
  private double altura;
}
