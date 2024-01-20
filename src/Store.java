import java.util.ArrayList;

public class Store {
    private ArrayList<CISItem> cisItems = new ArrayList<>();

    public void addBook(Book book){
        cisItems.add(book);
    }
    public void addPhone(Phone phone){
        cisItems.add(phone);
    }
    public void addMagazine(Magazine magazine){
        cisItems.add(magazine);
    }
    public void addArduino(Arduino arduino){
        cisItems.add(arduino);
    }

    public void updatePhonesLocation(String location){
        for(CISItem item: cisItems){
            if(item instanceof Phone) {
                item.setLocation(location);
            }
        }
    }
    public ArrayList<Phone> getAllPhones(){
        ArrayList<Phone> phone = new ArrayList<>();
        for(CISItem item: cisItems){
            if(item instanceof Phone) {
                phone.add((Phone) item);
            }
        }
        return phone;
    }

    public ArrayList<CISItem> getItems(String type){
        ArrayList<CISItem> itemOfType = new ArrayList<>();
        if(type.toLowerCase().equals("phone")){
            for(CISItem item: cisItems){
                if(item instanceof Phone) {
                    itemOfType.add(item);
                }
            }
        } else if(type.toLowerCase().equals("magazine")){
            for(CISItem item: cisItems){
                if(item instanceof Magazine) {
                    itemOfType.add(item);
                }
            }
        } else if(type.toLowerCase().equals("book")){
            for(CISItem item: cisItems){
                if(item instanceof Book) {
                    itemOfType.add(item);
                }
            }
        } else if(type.toLowerCase().equals("arduino")){
            for(CISItem item: cisItems){
                if(item instanceof Arduino) {
                    itemOfType.add(item);
                }
            }
        }
        return itemOfType;
    }

    public void updateItems(String itemType, String property, String value){
        ArrayList<CISItem> itemOfType = getItems(itemType);
        if(property.toLowerCase().equals("name")){
            for(CISItem item: itemOfType) {
                item.setName(value);
            }
        } else if(property.toLowerCase().equals("location")){
            for(CISItem item: itemOfType) {
                item.setLocation(value);
            }
        } else if(property.toLowerCase().equals("price")){
            for(CISItem item: itemOfType) {
                item.setPrice(Integer.parseInt(value));
            }
        } else if(property.toLowerCase().equals("description")){
            for(CISItem item: itemOfType) {
                item.setDescription(value);
            }
        } else if(property.toLowerCase().equals("wordcount")){
            for(CISItem item: itemOfType){
                if(item instanceof ReadingItem) {
                    ((ReadingItem)item).setWordCount(Integer.parseInt(value));
                }
            }
        } else if(property.toLowerCase().equals("datepublished")){
            for(CISItem item: itemOfType){
                if(item instanceof ReadingItem) {
                    ((ReadingItem)item).setDatePublished(value);
                }
            }
        } else if(property.toLowerCase().equals("author")){
            for(CISItem item: itemOfType){
                if(item instanceof ReadingItem) {
                    ((ReadingItem)item).setAuthor(value);
                }
            }
        } else if(property.toLowerCase().equals("isbn")){
            for(CISItem item: itemOfType){
                if(item instanceof Book) {
                    ((Book)item).setIsbn(value);
                }
            }
        } else if(property.toLowerCase().equals("edition")){
            for(CISItem item: itemOfType){
                if(item instanceof Book) {
                    ((Book)item).setEdition(value);
                }
            }
        } else if(property.toLowerCase().equals("title")){
            for(CISItem item: itemOfType){
                if(item instanceof Book) {
                    ((Book)item).setTitle(value);
                }
            }
        } else if(property.toLowerCase().equals("coverstorytitle")){
            for(CISItem item: itemOfType){
                if(item instanceof Magazine) {
                    ((Magazine)item).setCoverStoryTitle(value);
                }
            }
        } else if(property.toLowerCase().equals("printdate")){
            for(CISItem item: itemOfType){
                if(item instanceof Magazine) {
                    ((Magazine)item).setPrintDate(value);
                }
            }
        } else if(property.toLowerCase().equals("storagecapacity")){
            for(CISItem item: itemOfType){
                if(item instanceof ElectronicItem) {
                    ((ElectronicItem)item).setStorageCapacity(Integer.parseInt(value));
                }
            }
        } else if(property.toLowerCase().equals("model")){
            for(CISItem item: itemOfType){
                if(item instanceof ElectronicItem) {
                    ((ElectronicItem)item).setModel(value);
                }
            }
        } else if(property.toLowerCase().equals("maker")){
            for(CISItem item: itemOfType){
                if(item instanceof ElectronicItem) {
                    ((ElectronicItem)item).setMaker(value);
                }
            }
        } else if(property.toLowerCase().equals("operatingsystem")){
            for(CISItem item: itemOfType){
                if(item instanceof ElectronicItem) {
                    ((ElectronicItem)item).setOperatingSystem(value);
                }
            }
        } else if(property.toLowerCase().equals("networktype")){
            for(CISItem item: itemOfType){
                if(item instanceof Phone) {
                    ((Phone)item).setNetworkType(value);
                }
            }
        } else if(property.toLowerCase().equals("screensize")){
            for(CISItem item: itemOfType){
                if(item instanceof Phone) {
                    ((Phone)item).setScreenSize(Integer.parseInt(value));
                }
            }
        } else if(property.toLowerCase().equals("version")){
            for(CISItem item: itemOfType){
                if(item instanceof Arduino) {
                    ((Arduino)item).setVersion(value);
                }
            }
        }
    }

    public void showAllInfo(){
        for(CISItem item: cisItems){
            System.out.println(item.toString());
        }
    }
}
