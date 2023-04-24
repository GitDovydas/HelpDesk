package helpdesk.model;

public class RequestForm {
    private int id;
    private String requestType;
    private String email;
    private String title;
    private String description;
    private boolean isPictureIncluded;
    private String areaOfInterest;
    private int userId;

    public RequestForm() {
    }

    public RequestForm(String requestType, String email, String title, String description, boolean isPictureIncluded, String areaOfInterest) {
        this.requestType = requestType;
        this.email = email;
        this.title = title;
        this.description = description;
        this.isPictureIncluded = isPictureIncluded;
        this.areaOfInterest = areaOfInterest;
    }

    public RequestForm(int id, String requestType, String email, String title, String description, boolean isPictureIncluded, String areaOfInterest, int userId) {
        this.id = id;
        this.requestType = requestType;
        this.email = email;
        this.title = title;
        this.description = description;
        this.isPictureIncluded = isPictureIncluded;
        this.areaOfInterest = areaOfInterest;
        this.userId = userId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPictureIncluded() {
        return isPictureIncluded;
    }

    public void setPictureIncluded(boolean pictureIncluded) {
        isPictureIncluded = pictureIncluded;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
