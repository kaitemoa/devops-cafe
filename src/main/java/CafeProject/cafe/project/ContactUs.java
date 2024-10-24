package CafeProject.cafe.project;

public class ContactUs {

    private final String email = "bestcafe@cafe.fi";
    private final String phoneNumber = "+358 123 4567";

    public String getContactInfo() {
        return "Cafe Contact Information:\n" +
               "Email: " + email + "\n" +
               "Phone: " + phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
