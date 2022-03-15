import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookFile {
    public static void writeFile(List<PhoneBook> phoneBookList) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("list.dat");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(phoneBookList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            oos.close();
            fos.close();
        }
    }
    public static List<PhoneBook> readFile(){
        File file = new File("list.dat");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            List<PhoneBook> phoneBookList = (List<PhoneBook>) result;
            ois.close();
            fis.close();
            return phoneBookList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
