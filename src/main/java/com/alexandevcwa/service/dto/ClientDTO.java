package com.alexandevcwa.service.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author AlexanDev_CWA
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    
    private int id;
    
    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max = 75, message = "El nombre es demaciado largo")
    @Pattern(regexp = "^[a-zA-ZáéíóúüÁÉÍÓÚÜ\\s]*$", message = "El nombre no puede contener dígitos o símbolos")
    private String name;
    
    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 150, message = "La dirección no puede contener mas de 150 caracteres")
    private String address;
    
    @NotBlank(message = "El número de NIT no puede estar vacío")
    @Size(max = 12, message = "El NIT no puede contener más de 12 dígitos")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Formato de NIT incorrecto")
    private String nit;
    
    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo no contiene un formato correcto")
    private String email;
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 100, message = "La contraseña debe de tener como mínimo 8 caracteres")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "La contraseña no cumple los requerimientos de seguridad")
    private String password;
    
    @NotBlank(message = "El número de teléfono no puede estar vacío")
    @Size(min = 8, max = 10, message = "El teléfono debe de contener como mínimo 8 dígitos")
    @Pattern(regexp = "\\d", message = "El número de teléfono solo puede contener dígitos")
    private String phone;
    
    private String systemDate;
    private String updateDate;
}