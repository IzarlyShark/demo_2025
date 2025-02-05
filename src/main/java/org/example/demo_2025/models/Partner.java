package org.example.demo_2025.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Partner {
    @Getter // Явно указываем, что нужен только геттер для id
    private final int id; // Сделаем поле final, чтобы оно не изменялось после инициализации
    private String type;
    private String companyName;
    private String legalAddress;
    private String inn;
    private String directorName;
    private String contactPhone;
    private String contactEmail;
    private byte[] logo; // Логотип в виде aмассива байтов
    private String rating;
    private String salesPlaces;
    private String discountHistory;

}