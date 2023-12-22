package lk.jiat.XpectWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String date;
    private String time;
    @Column(name = "event_unique_id")
    private String eventUniqueId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User userId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category categoryId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id",referencedColumnName = "id")
    private EventType typeId;



}
