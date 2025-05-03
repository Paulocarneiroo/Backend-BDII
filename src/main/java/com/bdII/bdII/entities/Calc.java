package com.bdII.bdII.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calc {

    @Id
    private Long id;

    private String type;

    private double res;

    private Date createdDate;

    private String situation;

}