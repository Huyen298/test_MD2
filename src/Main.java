import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<PhoneBook> phoneBookList = PhoneBookFile.readFile();

    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu: ");
            System.out.println("1. Hiển thị danh sách ");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhật ");
            System.out.println("4. Xóa ");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi từ file");
            System.out.println("8. Thoát");
            System.out.println("Mời bạn nhập lựa chọn:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    Manager.showList();
                    break;
                case 2:
                    addNew();
                    break;
                case 3:
                    System.out.println("Nhập số điện thoại:");
                    Scanner scanner = new Scanner(System.in);
                    String inputNumber = scanner.nextLine();
                    int index = Manager.getPhoneByNumber(inputNumber);
                    Manager.editPhoneNumber(index,Manager.creatNew());
                case 4:
                    Manager.deletePhone();
                    break;
                case 5:
                    Manager.findPhoneNumber(phoneBookList);
                    break;
                case 6:
                case 7:
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại lựa chọn:");
            }
        }
    }
    public static void addNew(){
        Manager.phoneBookList = phoneBookList;
        PhoneBook phoneBook = Manager.creatNew();
        Manager.addNewPhone(phoneBook);
        try {
            PhoneBookFile.writeFile(phoneBookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}