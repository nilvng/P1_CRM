
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class StatsReport {
    public StatsReport() {
    }
    public void GroupAge() {
        LeadStorage ls = null;
        try {
            ls = new LeadStorage();
            ls.AgeStat();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void InteractionByMonth() {
        // TODO implement here
    }

    /**
     * 
     */
    public void InteractionByPotential() {
        // TODO implement here
    }

}