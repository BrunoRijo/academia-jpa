package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaUpdateForm {

  @NotNull
  @Positive(message = "'${validatedValue}' precisa ser positivo!")
  private double peso;

  @NotNull
  @Positive(message = "'${validatedValue}' precisa ser positivo!")
  @DecimalMin(value = "150", message =  "'${validatedValue}' precisa ser no minimo {value}!")
  private double altura;
}
