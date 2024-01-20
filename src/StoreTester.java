import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class StoreTester {
    @Test
    void addBookTest(){
        Store store = new Store();
        Book book = new Book();
        store.addBook(book);
        assertTrue(true);
    }
    @Test
    void addBookAndPhoneTest(){
        Store store = new Store();
        Book book = new Book();
        Phone phone = new Phone();
        store.addPhone(phone);
        store.addBook(book);
        assertTrue(true);
    }

    @Test
    void updatePhoneLocationGetAllPhones(){
        Store store = new Store();
        for(int i = 0; i < 20; i++){
            store.addPhone(new Phone());
        }
        store.updatePhonesLocation("Room 514");
        ArrayList<Phone> phone = store.getAllPhones();
        for(Phone p: phone){
            assertEquals(p.getLocation(), "Room 514");
        }
    }

    @Test
    void getItemTest(){
        Store store = new Store();
        for(int i = 0; i < 5; i++){
            store.addBook(new Book());
            store.addPhone(new Phone());
            store.addMagazine(new Magazine());
            store.addArduino(new Arduino());
        }

        ArrayList<CISItem> book = store.getItems("Book");
        assertEquals(book.size(), 5);
        for(CISItem item: book) assertTrue(item instanceof Book);

        ArrayList<CISItem> phone = store.getItems("Phone");
        assertEquals(phone.size(), 5);
        for(CISItem item: phone) assertTrue(item instanceof Phone);

        ArrayList<CISItem> magazine = store.getItems("Magazine");
        assertEquals(magazine.size(), 5);
        for(CISItem item: magazine) assertTrue(item instanceof Magazine);

        ArrayList<CISItem> arduino = store.getItems("Arduino");
        assertEquals(arduino.size(), 5);
        for(CISItem item: arduino) assertTrue(item instanceof Arduino);
    }

    @Test
    void updateItems(){
        Store store = new Store();
        store.addBook(new Book());
        store.addPhone(new Phone());
        store.addMagazine(new Magazine());
        store.addArduino(new Arduino());

        store.updateItems("book", "author", "helloWorld");
        ArrayList<CISItem> book = store.getItems("book");
        for(CISItem item : book){
            assertEquals(((Book) item).getAuthor(), "helloWorld");
        }

        store.updateItems("phone", "location", "helloWorld");
        ArrayList<CISItem> phone = store.getItems("phone");
        for(CISItem item : phone){
            assertEquals(item.getLocation(), "helloWorld");
        }

        store.updateItems("magazine", "datepublished", "helloWorld");
        ArrayList<CISItem> magazine = store.getItems("magazine");
        for(CISItem item : magazine){
            assertEquals(((Magazine) item).getDatePublished(), "helloWorld");
        }

        store.updateItems("arduino", "version", "helloWorld");
        ArrayList<CISItem> arduino = store.getItems("arduino");
        for(CISItem item : arduino){
            assertEquals(((Arduino) item).getVersion(), "helloWorld");
        }
    }
}