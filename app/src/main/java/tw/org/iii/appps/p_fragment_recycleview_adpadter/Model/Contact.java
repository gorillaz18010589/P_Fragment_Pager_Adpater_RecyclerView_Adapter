package tw.org.iii.appps.p_fragment_recycleview_adpadter.Model;

public class Contact {
    private String Name,Phone;
    private  int Photo;
    public Contact() {
    }

    public Contact(String name, String phone, int photo) {
        Name = name;
        Phone = phone;
        Photo = photo;
    }

    //getter
    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setName(String name) {
        Name = name;
    }

    //setter
    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
