package dio.project.restaurant.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseRestaurant {

    private Integer status;
    private HttpStatus httpStatus;
    private String message;
    private Object object;
    private List<String> errors = new ArrayList<>();
    private Exception exception;

    public ResponseRestaurant(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.message = message;
    }

    public ResponseRestaurant(HttpStatus httpStatus, Object object){
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.object = object;
    }

    public ResponseRestaurant(HttpStatus httpStatus, Exception exception){
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.exception = exception;
        this.errors.add(exception.getMessage());
    }

    public ResponseRestaurant(HttpStatus httpStatus, String ... errors){
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.errors.addAll(List.of(errors));
    }

}
