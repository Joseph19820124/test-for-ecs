package com.nike.im.java_service_A.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {

    private String id;
    @NotEmpty
    private String fileName;

    private byte[] data;
}
