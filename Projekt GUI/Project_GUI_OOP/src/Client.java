import java.time.LocalDate;

public class Client {
    private String name;
    private String surname;
    private String id;
    private String address;


    public void showDateOfBirth(){
        char[] idChar = id.toCharArray();

        int year = (int)(idChar[0] + idChar[1]);
        int month = (int)(idChar[2] + idChar[3]);
        int day = (int)(idChar[4] + idChar[5]);

        LocalDate dateOfBirth = LocalDate.of(year, month, day);

        System.out.println(dateOfBirth);
    }
}
