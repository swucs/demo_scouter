package com.example.scouter.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private Long id;

    private String no;

    private String name;
}
