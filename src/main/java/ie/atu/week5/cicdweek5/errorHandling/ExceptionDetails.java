package ie.atu.week5.cicdweek5.errorHandling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails
{



    private String fieldName;
    private String fieldValue;
}
