package lk.jiat.XpectWeb.dto;

public class AllEventResponse {
    private String eventName;
    private String eventDescription;
    private String eventTime;
    private String eventUniqueId;
    private String eventDate;
    private String categoryName;

    public AllEventResponse() {
    }

    public AllEventResponse(String eventName, String eventUniqueId, String eventDate) {
        this.eventName = eventName;
        this.eventUniqueId = eventUniqueId;
        this.eventDate = eventDate;
    }

    public AllEventResponse(String eventName, String eventDescription, String eventTime, String eventUniqueId, String eventDate, String categoryName) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventTime = eventTime;
        this.eventUniqueId = eventUniqueId;
        this.eventDate = eventDate;
        this.categoryName = categoryName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventUniqueId() {
        return eventUniqueId;
    }

    public void setEventUniqueId(String eventUniqueId) {
        this.eventUniqueId = eventUniqueId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
