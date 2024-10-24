package CafeProject.cafe.project;

public class ContactUs {

    private String email = "bestcafe@cafe.fi";
    private String phoneNumber = "+358 123 4567";
    private String address = "Bakerstreet 221B";

    public String getContactInfo() {
        return "Cafe Contact Information:\n" +
               "Email: " + email + "\n" +
               "Phone: " + phoneNumber + "\n" + 
               "Address: " + address;
    }
}
