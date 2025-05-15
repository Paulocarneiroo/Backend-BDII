package com.bdII.bdII.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "tb_calc")
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

    private Long userId;

}