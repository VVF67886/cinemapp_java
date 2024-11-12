package it.vvf.cinemapp.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse implements	Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4860551708853568330L;
	private Long id;
    private String email;
    private String fullName;
    private LocalDateTime registrationDate;
}
