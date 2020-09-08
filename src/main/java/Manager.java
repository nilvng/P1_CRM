
import java.io.IOException;
import java.util.*;

public interface Manager<T> {
    public void setFileUtils( FileUtils<T> fileUtils);
    public List<T> getData();
    public void setData( List<T> list);
    public void viewAll() throws NullPointerException;
    public void add(T t) throws IOException, NullPointerException;
    public void update(T t, int index) throws IOException, NullPointerException;
    public void delete(int i) throws IOException, NullPointerException;

}