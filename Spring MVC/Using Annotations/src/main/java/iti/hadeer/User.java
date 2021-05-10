package iti.hadeer;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class User {
    String name;
    @Min(value = 20, message = "Salary is less than min")
    @Max(value = 20000, message = "Salary more than max")
    double salary;

}
