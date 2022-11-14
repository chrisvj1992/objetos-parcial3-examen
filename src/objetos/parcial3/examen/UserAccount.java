package objetos.parcial3.examen;

public class UserAccount {
    private  String id;
    private String email;
    private String name;
    private String zipCode;
    private String phoneNumber;

    public void setEmail(String email){
        if(email == null){
            throw new  EmailRequiredException("The Email is Required");
        }
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber)  {
        if(phoneNumber == null){
            throw new PhoneNumberRequiredException("The Email is Required");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getId() {
        return id;
    }

}
