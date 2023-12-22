package lk.jiat.XpectWeb.repo;

import lk.jiat.XpectWeb.dto.AllEventResponse;
import lk.jiat.XpectWeb.dto.EventDTO;
import lk.jiat.XpectWeb.entity.Event;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface EventRepo extends JpaRepository<Event, Integer> {

    @Query(value = "SELECT e.name AS eventName, e.description AS eventDescription, e.time AS eventTime, e.event_unique_id AS eventUniqueId,e.date AS eventDate, c.name AS categoryName " +
            "FROM Event e " +
            "INNER JOIN Category c ON e.category_id = c.id", nativeQuery = true)
    List<Object[]> getAllEvents();

    default List<AllEventResponse> getAllEventsResponse() {
        List<Object[]> results = getAllEvents();
        List<AllEventResponse> responses = new ArrayList<>();

        for (Object[] row : results) {
            AllEventResponse response = new AllEventResponse(
                    (String) row[0],
                    (String) row[1],
                    (String) row[2],
                    (String) row[3],
                    (String) row[4],
                    (String) row[5]
            );
            responses.add(response);
        }

        return responses;
    }

    @Query(value = "SELECT * FROM Event WHERE event_unique_id = ?1", nativeQuery = true)
    Event getEventByUniqueId(String eventId);
    @Query(value = "SELECT e.name AS eventName, e.description AS eventDescription, e.time AS eventTime, e.event_unique_id AS eventUniqueId,e.date AS eventDate, c.name AS categoryName " +
            "FROM Event e " +
            "INNER JOIN Category c ON e.category_id = c.id WHERE e.event_unique_id =?1", nativeQuery = true)
    List<Object[]> getEventByUniqueId1(String eventId);
    default AllEventResponse getAllEventsResponse1(String eventId) {
        List<Object[]> results = getEventByUniqueId1(eventId);

        if (results != null && !results.isEmpty()){
            Object[] result = results.get(0);
            AllEventResponse response = new AllEventResponse(
                    (String) result[0],
                    (String) result[1],
                    (String) result[2],
                    (String) result[3],
                    (String) result[4],
                    (String) result[5]
            );
            return response;
        }else {
            return null;
        }

    }
    @Query("SELECT NEW lk.jiat.XpectWeb.dto.AllEventResponse(e.name,e.eventUniqueId,e.date) FROM Event e INNER JOIN e.userId u WHERE u.firebaseUserId = ?1")
    List<AllEventResponse> getEventByUser(String firebaseUserId);

    @Modifying
    @Query("UPDATE Event e SET e.name = :eventName, e.description = :eventDescription, e.date = :date, e.time = :time WHERE e.eventUniqueId = :eventUniqueId")
    void updateEventByEventUniqueId(@Param("eventName") String eventName,
                                    @Param("eventDescription") String eventDescription,
                                    @Param("date") String date,
                                    @Param("time") String time,
                                    @Param("eventUniqueId") String eventUniqueId);




}
