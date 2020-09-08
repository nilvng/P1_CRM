
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InteractionManager implements Manager<Interaction> {
    private static final InteractionManager INSTANCE;
    private List<Interaction> data;
    private FileUtils<Interaction> fileUtils;
    static {
        INSTANCE = new InteractionManager();
    }

    private InteractionManager() {
    }

    public static InteractionManager getInstance(){
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

    private void saveToFile(){
        if ( fileUtils != null){
            try {
                fileUtils.saveData();
            } catch (IOException e) {
                System.out.println("File do not exist");
            }
        }
    }

    public void setFileUtils(FileUtils<Interaction> fileUtils) {
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
    public void viewAll() throws NullPointerException {
        data.forEach(System.out::println);
    }

    @Override
    public void add(Interaction interaction) throws NullPointerException {
        data.add(interaction);
        saveToFile();
    }

    @Override
    public void update(Interaction interaction, int index) throws  NullPointerException {
        data.set(index, interaction);
        saveToFile();
    }

    @Override
    public void delete(int i) throws NullPointerException {
        data.remove(i);
        saveToFile();
    }

    public Interaction findElement(String id) {
        // return a clone of data to preserve data integrity
        for (Interaction i : data) {
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
