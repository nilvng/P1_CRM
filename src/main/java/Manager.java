
import java.io.IOException;
import java.util.*;

public interface Manager {

    public void viewAll();
    public void add() throws IOException;
    public void update() throws IOException;
    public void delete() throws IOException;

}