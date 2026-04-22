package com.Session13.BTTH.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên bệnh nhân không được để trống")
    @Size(min = 5, message = "Tên bệnh nhân phải từ 5 ký tự trở lên")
    private String patientName;

    @Pattern(regexp = "^[0-9]{10}$", message = "Số điện thoại phải đúng 10 chữ số")
    private String phoneNumber;

    @NotNull(message = "Vui lòng chọn giờ khám")
    private LocalTime appointmentTime;

    private String reason;

    private Integer status = 0;
}