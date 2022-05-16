package projet.cflex.oda_cflex_smart_city1.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DemandeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
    public DemandeNotFoundException(String message) {
		super(message);
	}
}
