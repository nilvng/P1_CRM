import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeadManager implements Manager<Lead>{
    private static LeadManager INSTANCE;
    private List<Lead> data;
    private FileUtils<Lead> fileUtils;
    static {
        INSTANCE = new LeadManager();
    }

    private LeadManager() {
    }


    public static LeadManager getInstance(){
        return INSTANCE;
    }

    @Override
    public void setFileUtils(FileUtils<Lead> fileUtils) {
        this.fileUtils = fileUtils;
        try {
            fileUtils.fetchData();
        } catch (IOException e) {
            System.out.println("File do not exist");
        }
    }

    @Override
    public List<Lead> getData() {
        List<Lead> copyOfData = new ArrayList<>();
        for (Lead i : data) {
            copyOfData.add(i.deepCopy());
        }
        return copyOfData;
    }

    private void saveToFile(){
        if ( fileUtils != null){
            try {
                fileUtils.saveData();
            } catch (IOException e) {
                System.out.println("File do not exist");
            }
        }
    }

    @Override
    public void setData(List<Lead> list) {
        List<Lead> copyOfData = new ArrayList<>();
        for (Lead i : list) {
            copyOfData.add(i.deepCopy());
        }
        this.data = copyOfData;
    }

    @Override
    public void viewAll() throws NullPointerException {
        data.forEach(System.out::println);
    }

    @Override
    public void add(Lead lead)throws NullPointerException {
        data.add(lead);
        saveToFile();
    }

    @Override
    public void update(Lead lead, int index) throws NullPointerException {
        data.set(index, lead);
        saveToFile();
    }

    @Override
    public void delete(int i) throws NullPointerException {
        data.remove(i);
        saveToFile();
    }


    public Lead findElement(String id) {
        // return a clone of data to preserve data integrity
        for (Lead i : data) {
            if (i.getId().equals(id)) {
                return i.deepCopy();
            }
        }
        return null;
    }

    public int findIndex(String id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public int getSize(){
        return data.size();
    }
}
