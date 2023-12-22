package lk.jiat.XpectWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id",referencedColumnName = "id")
    private Event event;
}
