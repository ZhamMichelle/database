package zham.example.database.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private int id;
    @NotEmpty(message = "should not be empty")
    @Size(min=2, max=30, message = "should be from 2 to 30")
    private String name;
    @Min(value = 0, message = "Age should be greater then 0")
    private int age;
    @NotEmpty(message = "should not be empty")
    @Email(message = "email should be valid")
    private String email;
}
