
import java.io.IOException;
import java.util.*;

public interface Manager {

    public void viewAll() throws NullPointerException;
    public void add() throws IOException, NullPointerException;
    public void update() throws IOException, NullPointerException;
    public void delete() throws IOException, NullPointerException;

}