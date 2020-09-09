
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InteractionManager implements Manager, Savable<Interaction> {
    private static InteractionManager INSTANCE;
    private List<Interaction> data;
    private FileUtils fileUtils;
    private InteractionView interactionView;

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

    public void setInteractionView(InteractionView interactionView) {
        this.interactionView = interactionView;
    }

    public void setFileUtils(FileUtils fileUtils) {
        this.fileUtils = fileUtils;
        try {
            fileUtils.fetchData();
        } catch (IOException e) {
            System.out.println("File do not exist");
        }    }

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
        interactionView.enterInteraction(interaction);
        interaction.generateId(data.size());
        data.add(interaction);
        saveToFile();
    }

    @Override
    public void update() throws  NullPointerException {
        String id = interactionView.enterId();
        Interaction interaction = this.findElement(id);
        int i = this.findIndex(id);
        data.set(i, interaction);
        saveToFile();
    }

    @Override
    public void delete() throws NullPointerException {
        String id = interactionView.enterId();
        int i = this.findIndex(id);
        data.remove(i);
        saveToFile();
    }

    Interaction findElement(String id) {
        for (Interaction i : data) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null; // TODO handle null
    }

    int findIndex(String id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
