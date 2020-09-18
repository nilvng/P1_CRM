package service;//import Features.Interaction;

import fileOperator.FileUtils;
import domain.Interaction;
import util.HandleInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InteractionManager implements Manager, Savable<Interaction> {
    private static InteractionManager INSTANCE;
    private List<Interaction> data;
    private FileUtils fileUtils;
    private HandleInput handler = new HandleInput();
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

        interaction.setDate(handler.enterDate("Interaction's date", false));
        interaction.setLead(handler.enterLeadId("Lead's id", true));
        interaction.setMeans( handler.enterSpecificString("Interaction's means", validMeans,false));
        interaction.setPotential(handler.enterSpecificString("Interaction's potential", validPotential, false));
        interaction.generateId(lastItemId());

        System.out.println("Added! " + interaction);
        data.add(interaction);
        saveToFile();
    }

    @Override
    public void update() throws  NullPointerException {
        String id = handler.enterInteractionId("interaction's id you want to update", false);
        Interaction interaction = this.findElement(id);
        System.out.println("Here is the interaction you will update" + interaction);
        int i = this.findIndex(id);

        interaction.setDate(handler.enterDate("Interaction's date", true));
        interaction.setLead(handler.enterLeadId("Lead's id", true));
        interaction.setMeans( handler.enterSpecificString("Interaction's means", validMeans,true));
        interaction.setPotential(handler.enterSpecificString("Interaction's potential", validPotential, true));

        data.set(i, interaction);

        System.out.println("Updated!\n" + interaction);
        saveToFile();
    }

    @Override
    public void delete() throws NullPointerException {
        String id = handler.enterInteractionId("interaction's id you want to delete", false);
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

    public HandleInput getHandler() {
        return handler;
    }

    public void setHandler(HandleInput handler) {
        this.handler = handler;
    }
}
