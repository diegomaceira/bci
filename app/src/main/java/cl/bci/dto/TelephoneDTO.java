package cl.bci.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelephoneDTO {
    private int id;
    private long number;
    private int citycode;
    private String contrycode;
}