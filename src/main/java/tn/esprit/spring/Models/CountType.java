package tn.esprit.spring.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountType {
    private  Long count;
    private  String niveau;
}
