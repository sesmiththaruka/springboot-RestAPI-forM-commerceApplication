package lk.jiat.XpectWeb.service;

import jakarta.transaction.Transactional;
import lk.jiat.XpectWeb.dto.AllEventResponse;
import lk.jiat.XpectWeb.dto.CategoryDTO;
import lk.jiat.XpectWeb.dto.EventDTO;
import lk.jiat.XpectWeb.dto.UserDTO;
import lk.jiat.XpectWeb.entity.*;
import lk.jiat.XpectWeb.repo.*;
import lk.jiat.XpectWeb.util.Varlist;
import org.aspectj.weaver.ast.Var;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EventService {
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private EventTypeRepo eventTypeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveEvent(EventDTO eventDTO) {
        if (eventRepo.existsById(eventDTO.getId())) {
            return Varlist.RSP_DULICATED;
        } else {


            User existingUser = userRepo.getUserByFirebaseUserId(eventDTO.getUserId());
//            if (existingUser==null){
//                return Varlist.RSP_FAIL;
//            }
            Category existingCategory = categoryRepo.findById(eventDTO.getCategoryId()).orElse(null);
            EventType existingEventType = eventTypeRepo.findById(eventDTO.getTypeId()).orElse(null);

//            if (existingUser == null) {
//                return Varlist.RSP_FAIL;
//            }
            Event event = new Event();
            event.setName(eventDTO.getName());
            event.setDescription(eventDTO.getDescription());
            event.setDate(eventDTO.getDate());
            event.setTime(eventDTO.getTime());
            event.setEventUniqueId(eventDTO.getEventUniqueId());
            event.setUserId(existingUser);
            event.setCategoryId(existingCategory);
            event.setTypeId(existingEventType);

            eventRepo.save(event);

            return Varlist.RSP_SUCCESS;
        }
    }

    public List<AllEventResponse> getAllEvent(){
        return eventRepo.getAllEventsResponse();
    }

    public EventDTO getEventByUniqueId(String uniqueID){
        Event eventByUniqueId = eventRepo.getEventByUniqueId(uniqueID);
        return modelMapper.map(eventByUniqueId, EventDTO.class);
//        return eventByUniqueId;

    }
    public AllEventResponse getEventByUniqueId1(String uniqueID){
        AllEventResponse eventByUniqueId = eventRepo.getAllEventsResponse1(uniqueID);
        return eventByUniqueId;
//        return eventByUniqueId;

    }
    public List<AllEventResponse> getEventByUser(String userId){
        return eventRepo.getEventByUser(userId);

    }

    public void updateEventByUniqueId(String eventName,String eventDescription,String date,String time,String eventUniqueId){
        eventRepo.updateEventByEventUniqueId(eventName,eventDescription,date,time,eventUniqueId);
    }

//    public void getEventByEventName(String eventName){
//        eventRepo.getEventByEventName(eventName);
//    }
}
