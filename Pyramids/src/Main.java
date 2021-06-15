import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main (String[] args){

        PyramidsCSVDAO pDAO= null;
        try {
            pDAO = new PyramidsCSVDAO();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<PyramidsInfo> pyramids= pDAO.readPyramidsFromCSV("C:\\Users\\georg\\IdeaProjects\\Pyramids\\Resources\\Pyramidsnew.csv");

        int i=0;
        for(Pyramid p:pyramids){
            System.out.println("#"+(i++)+p);
        }
    }
}
