import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

public class Main {

    public static void main(String[] args) {
       Phone phone = new Phone();

        phone.setPrice(456.3);
        phone.setManufacturer ("Sony");
        System.out.println ( phone.getManufacturerSPrice());

    }


}
