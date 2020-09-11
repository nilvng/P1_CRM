
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeadManager implements Manager, Savable<Lead>{
    private static LeadManager INSTANCE;
    private List<Lead> data;
    private FileUtils fileUtils;
    private LeadView leadView;

    private LeadManager() {
    }

    public static LeadManager getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LeadManager();
        }
        return INSTANCE;
    }

    @Override
    public void setFileUtils(FileUtils fileUtils) {
        this.fileUtils = fileUtils;
        try {
            fileUtils.fetchData();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public void saveToFile(){
        if ( fileUtils != null){
            try {
                fileUtils.saveData();
            } catch (IOException e) {
                System.out.println("File not found");
            }
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

    @Override
    public void setData(List<Lead> list) {
        List<Lead> copyOfData = new ArrayList<>();
        for (Lead i : list) {
            copyOfData.add(i.deepCopy());
        }
        this.data = copyOfData;
    }

    @Override
    public void viewAll(){
        this.data.forEach(System.out::println);
    }

    @Override
    public void add() {
        Lead lead = new Lead();
        leadView.enterLead(lead);
        lead.generateId(data.size());
        data.add(lead);
        saveToFile();
    }

    @Override
    public void update() throws  NullPointerException {
        String id = leadView.enterId();
        Lead lead = this.findElement(id);
        int i = this.findIndex(id);
        data.set(i, lead);
        saveToFile();
    }

    @Override
    public void delete() throws NullPointerException {
        String id = leadView.enterId();
        int i = this.findIndex(id);
        data.remove(i);
        saveToFile();
    }


    public Lead findElement(String id) {
        // return a clone of data to preserve data integrity
        for (Lead i : data) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null; // TODO handle null here
    }

    public int findIndex(String id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public FileUtils getFileUtils() {
        return fileUtils;
    }

    public LeadView getLeadView() {
        return leadView;
    }
    public void setLeadView(LeadView leadView) {
        this.leadView = leadView;
    }

}

