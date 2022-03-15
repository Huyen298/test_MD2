import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Manager {
    public static List<PhoneBook> phoneBookList = PhoneBookFile.readFile();

    public static void addNewPhone(PhoneBook newPhone) {
        phoneBookList.add(newPhone);
    }

    public static void showList() {
        for (PhoneBook p : phoneBookList
        ) {
            System.out.println(p);
        }
    }

    public static PhoneBook creatNew() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập nhóm");
        String group = scanner.nextLine();
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String add = scanner.nextLine();
        PhoneBook phoneBook = new PhoneBook(phoneNumber,group,name,gender,add);
        return phoneBook;
    }
    public static int getPhoneByNumber(String phoneNumber){
        boolean check = false;
        for (int i = 0; i < phoneBookList.size(); i++) {
            PhoneBook phoneBook = phoneBookList.get(i);
            if (phoneBook.getPhoneNumber().equals(phoneNumber)){
                check = true;
                return i;
            }
        }
        if (!check){
            System.out.println("Số điện thoại không có trong danh bạ. Mời nhập lại số điện thoại:");
        }
        return -1;
    }
    public static void editPhoneNumber(int index, PhoneBook newPhone){
        phoneBookList.set(index,newPhone);
    }
    public static void deletePhone(){
        System.out.println("Mời nhập số điện thoại muốn xóa: ");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        for (int i = 0; i < phoneBookList.size(); i++) {
            PhoneBook phoneBook = phoneBookList.get(i);
            if (number.equals(phoneBook.getPhoneNumber())){
                phoneBookList.remove(i);
            }
        }
        for (PhoneBook p:phoneBookList
             ) {
            System.out.println(p);
        }
        try {
            PhoneBookFile.writeFile(phoneBookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void findPhoneNumber(List<PhoneBook> phoneBookList){
        System.out.println("Mời nhập số điện thoại: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < phoneBookList.size(); i++) {
            PhoneBook phoneBook = phoneBookList.get(i);
            if (input.equals(phoneBook.getPhoneNumber())){
                System.out.println(phoneBook);
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Không tìm thấy số điện thoại trong danh bạ");
        }
    }
}