package org.example.entidades;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@ToString(exclude = "articulos")
public class Promocion {

    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private double precioPromocional;
    @Enumerated(EnumType.STRING)
    private TipoPromocion tipoPromocion;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "promocion_articulo",
            joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id"))
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<Articulo>();

    @OneToMany
    @JoinColumn(name = "imagen_id")
    @Builder.Default
    private Set<Imagen> promoImagen = new HashSet<>();

}
