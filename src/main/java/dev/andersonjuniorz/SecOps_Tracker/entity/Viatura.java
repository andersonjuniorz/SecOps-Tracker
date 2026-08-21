package dev.andersonjuniorz.SecOps_Tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_viatura")
public class Viatura {

    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome da placa é obrigatória")
    @Column(nullable = false, unique = true, length = 7)
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusViatura status = StatusViatura.DISPONIVEL;
}
