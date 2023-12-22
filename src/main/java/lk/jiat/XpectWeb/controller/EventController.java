package lk.jiat.XpectWeb.controller;


import lk.jiat.XpectWeb.dto.AllEventResponse;
import lk.jiat.XpectWeb.dto.EventDTO;
import lk.jiat.XpectWeb.dto.ResponseDTO;
import lk.jiat.XpectWeb.dto.UserDTO;
import lk.jiat.XpectWeb.service.EventService;
import lk.jiat.XpectWeb.service.UserService;
import lk.jiat.XpectWeb.util.Varlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/event")
public class EventController {
    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    private EventService eventService;

    @PostMapping("/saveevent")
    public ResponseEntity saveUser(@RequestBody EventDTO eventDTO) {
        try {

            String res = eventService.saveEvent(eventDTO);
            System.out.println(res);
            responseDTO.setCode(Varlist.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(eventDTO);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        } catch (Exception ex) {

            responseDTO.setCode(Varlist.RSP_FAIL);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/getallevent")
    public List<AllEventResponse> getEvent() {
        return eventService.getAllEvent();
//        return allEvent;
    }

    @GetMapping("/geteventbyuniqueid/{eventUniqueId}")
    public EventDTO getEventByUniqueId(@PathVariable String eventUniqueId) {
        System.out.println(eventUniqueId);
        return eventService.getEventByUniqueId(eventUniqueId);
    }
    @GetMapping("/geteventbyuniqueid1/{eventUniqueId}")
    public AllEventResponse getEventByUniqueId1(@PathVariable String eventUniqueId) {
        System.out.println(eventUniqueId);
        return eventService.getEventByUniqueId1(eventUniqueId);
    }

    @GetMapping("/geteventbyuserid/{eventuserId}")
    public List<AllEventResponse> getEventByUser(@PathVariable String eventuserId) {
        System.out.println(eventuserId);
        return eventService.getEventByUser(eventuserId);
    }


    @PostMapping("/updateevent")
    public void updateEventByUniqueId(@RequestBody EventDTO eventDTO) {
        eventService.updateEventByUniqueId(eventDTO.getName(), eventDTO.getDescription(), eventDTO.getDate(), eventDTO.getTime(), eventDTO.getEventUniqueId());
    }

//    @GetMapping("/search/{eventName}")
//    public List<EventDTO> getEventByEventName(@PathVariable String eventName){
//        return eventService.getEventByEventName(eventName);
//    }


}
