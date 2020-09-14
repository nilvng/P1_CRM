import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeadManager implements Manager, Savable<Lead> {
    private static LeadManager INSTANCE;
    private List<Lead> data;
    private FileUtils fileUtils;
    private HandleInput handler = new HandleInput();

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
        lead.setName(handler.enterString("lead's name:", false));
        lead.setDob(handler.enterDate("lead's dob:", false));
        lead.setGender(handler.enterGender("lead's gender (F for Female and M for Male):", false));
        lead.setPhone(handler.enterPhone("lead's phone number:", false));
        lead.setEmail(handler.enterEmail("lead's email", false));
        lead.setAddress(handler.enterString("lead's address:", false));
        lead.generateId(lastItemId());
        data.add(lead);
        System.out.println("Added! " + lead);
        saveToFile();
    }

    @Override
    public void update() throws  NullPointerException {
        String id = handler.enterLeadId("lead's id", false);
        Lead lead = this.findElement(id);
        int i = this.findIndex(id);
        lead.setName(handler.enterString("lead's name:", true));
        lead.setDob(handler.enterDate("lead's dob:", true));
        lead.setGender(handler.enterGender("lead's gender (F for Female and M for Male):", true));
        lead.setPhone(handler.enterPhone("lead's phone number:", true));
        lead.setEmail(handler.enterEmail("lead's email", true));
        lead.setAddress(handler.enterString("lead's address:", true));
        data.set(i, lead);
        System.out.println("Updated!\n" + lead);
        saveToFile();
    }

    @Override
    public void delete() throws NullPointerException {
        InteractionManager interactionManager = InteractionManager.getInstance();
        String id = handler.enterLeadId("lead's id", false);
        int i = this.findIndex(id);
        if (!interactionManager.findInterByLeadId(id)){
            data.remove(i);
            System.out.println("deleted!");
        } else {
            System.out.println("Cannot delete this lead because they have been in one of the interactions");
        }
        saveToFile();
    }


    public Lead findElement(String id) {
        // return a clone of data to preserve data integrity
        for (Lead i : data) {
            if (i.getId().equals(id)) {
                return i;
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

    public int lastItemId(){
        Lead lead = data.get(data.size() - 1);
        String currentId = lead.getId();
        return Integer.parseInt(currentId.substring(currentId.length() - 3));
    }

    public FileUtils getFileUtils() {
        return fileUtils;
    }

    public HandleInput getHandler() {
        return handler;
    }

    public void setHandler(HandleInput handler) {
        this.handler = handler;
    }
}

