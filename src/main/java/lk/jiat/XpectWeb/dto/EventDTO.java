package lk.jiat.XpectWeb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private int id;
    private String name;
    private String description;
    private String date;
    private String time;
    private String eventUniqueId;
    private String userId;
    private int categoryId;
    private int typeId;


}
