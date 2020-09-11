
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InteractionManager implements Manager, Savable<Interaction> {
    private static InteractionManager INSTANCE;
    private List<Interaction> data;
    private FileUtils fileUtils;
    private HandleUserInput handler = new HandleUserInput();
    private static List<String> validPotential = new ArrayList<>(Arrays.asList("positive","negative","neutral"));
    private static List<String> validMeans = new ArrayList<>(Arrays.asList("phone", "email", "Facebook"));
    private InteractionManager() {
    }

    public static InteractionManager getInstance(){
        if (INSTANCE == null){
            INSTANCE = new InteractionManager();
        }
        return INSTANCE;
    }

    public List<Interaction> getData() {
        // return a clone of data to preserve data integrity
        List<Interaction> copyOfData = new ArrayList<>();
        for (Interaction i : data) {
            copyOfData.add(i.deepCopy());
        }
        return copyOfData;
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

    public void setFileUtils(FileUtils fileUtils) {
        this.fileUtils = fileUtils;
        try {
            fileUtils.fetchData();
        } catch (IOException e) {
            System.out.println("File do not exist");
        }    }
    public FileUtils getFileUtils() {
        return fileUtils;
    }

    public void setData(List<Interaction> list) {
        List<Interaction> copyOfData = new ArrayList<>();
        for (Interaction i : list) {
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
        Interaction interaction = new Interaction();
        System.out.println("Create new interaction: ");

        interaction.setLead(handler.enterLeadId("Lead's id", false));
        interaction.setDate(handler.enterDate("Interaction's date", false));
        interaction.setPotential(handler.enterSpecificString("Interaction's potential", validPotential, false));
        interaction.setMeans( handler.enterSpecificString("Interaction's means", validMeans,false));
        interaction.generateId(lastItemId());

        System.out.println(interaction);
        data.add(interaction);
        saveToFile();
    }

    @Override
    public void update() throws  NullPointerException {
        String id = handler.enterInteractionId("interaction's id you wish to update", false);
        Interaction interaction = this.findElement(id);
        int i = this.findIndex(id);

        interaction.setLead(handler.enterLeadId("Lead's id", true));
        interaction.setDate(handler.enterDate("Interaction's date", true));
        interaction.setPotential(handler.enterSpecificString("Interaction's potential", validPotential, true));
        interaction.setMeans( handler.enterSpecificString("Interaction's means", validMeans,true));

        data.set(i, interaction);

        System.out.println("Updated!\n" + interaction);
        saveToFile();
    }

    @Override
    public void delete() throws NullPointerException {
        String id = handler.enterInteractionId("interaction's id you wish to update", false);
        int i = this.findIndex(id);
        data.remove(i);
        System.out.println("deleted!");
        saveToFile();
    }

    Interaction findElement(String id) {
        for (Interaction i : data) {
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

    public boolean findInterByLeadId(String id){
        for (Interaction i : data) {
            if (i.getLead().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public int lastItemId(){
        Interaction i = data.get(data.size() - 1);
        String currentId = i.getId();
        return Integer.parseInt(currentId.substring(currentId.length() - 3));
    }

    public HandleUserInput getHandler() {
        return handler;
    }

    public void setHandler(HandleUserInput handler) {
        this.handler = handler;
    }
}
