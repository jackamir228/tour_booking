package models;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
public class Tour {
    private String name;
    private String description;
    private BigDecimal price;
    private String currency;
}
