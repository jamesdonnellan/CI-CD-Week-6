package ie.atu.week5.cicdweek5.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;



@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class Passenger
{
    @NotBlank(message = "ID is required")
    @Size (message = "ID cannot exceed 40 characters" ,max = 40)
    private String passengerId;

    @NotBlank(message = "Name is required")
    @Size(message = "Name cannot exceed 60 characters", max = 60)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid address")
    private String email;
}