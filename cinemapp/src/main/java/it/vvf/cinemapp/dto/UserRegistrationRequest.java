package it.vvf.cinemapp.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRegistrationRequest implements	Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 9048557904749657933L;

	@NotBlank(message = "L'email è obbligatoria")
    @Email(message = "Formato email non valido")
    private String email;
    
    @NotBlank(message = "La password è obbligatoria")
    @Size(min = 6, message = "La password deve essere di almeno 6 caratteri")
    private String password;
    
    @NotBlank(message = "Il nome completo è obbligatorio")
    private String fullName;
}

