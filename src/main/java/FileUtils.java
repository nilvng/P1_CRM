import java.io.IOException;

public interface FileUtils<T> {
    void fetchData() throws IOException;
    void saveData() throws IOException;
}
