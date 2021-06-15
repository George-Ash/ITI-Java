import com.sun.tools.javac.util.List;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class PyramidsCSVDAO {
    ArrayList<PyramidsInfo> pyramidsinfo;

    public PyramidsCSVDAO() throws FileNotFoundException {

        this.pyramidsinfo = new ArrayList<PyramidsInfo>();

        File pyramidsintofile = new File( "C:\\Users\\georg\\IdeaProjects\\Pyramids\\Resources\\Pyramidsnew.csv" );
        Scanner myreader = new Scanner( pyramidsintofile );
        while (myreader.hasNext()) {
            String data = myreader.nextLine();
            System.out.println( data );
        }
    List<String> lines = new List<String>;
        try {
            lines = (List<String>) Files.readAllLines( pyramidsintofile.toPath() );
        } catch (Exception e) {
            System.out.println( "An issue has happened" );
        }

        String[] fields = new String[0];
        for (int lineId = 1; lineId < lines.size(); lineId++) {
            String line = lines.get( lineId );
            fields = line.split( "," );
            for (int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++) {
                fields[fieldIndex] = fields[fieldIndex].trim();
            }
        }
        PyramidsInfo pyramidsinfo = new PyramidsInfo( fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], fields[9], fields[10],
                fields[11], fields[12], fields[13], fields[14], fields[15], fields[16] );

    }
}

