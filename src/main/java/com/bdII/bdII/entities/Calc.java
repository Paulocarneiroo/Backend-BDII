package com.example.healthtracker.model;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.jetbrains.annotations.NotNull;
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

}