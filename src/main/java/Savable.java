import java.util.List;

public interface Savable<T> {
    void setFileUtils( FileUtils fileUtils);
    void saveToFile();
    List<T> getData();
    void setData( List<T> list);
}
