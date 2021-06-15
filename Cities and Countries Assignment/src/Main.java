import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
        public static List<City> sort(List<City> CityList){
            CityList.sort(new Compartor());

            return CityList;
        }
        public static void main(String[] args) {
            File Contfile= new File("C:\\Users\\georg\\IdeaProjects\\Assignment\\src\\Country1.csv");
            File CitFile = new File ( "C:\\Users\\georg\\IdeaProjects\\Assignment\\src\\City1.csv");

            List<String> CountryLines = new ArrayList<>();
            List<String> CityLines = new ArrayList<>();
            List<Country> Countrylist= new ArrayList<>();
            List<City> Citylist= new ArrayList<>();
            try{
                CountryLines= Files.readAllLines(Contfile.toPath());
                CityLines= Files.readAllLines(CitFile.toPath());

            }catch(Exception e){
                System.out.println("Unable to read");
            }
            for (int i=0; i<CountryLines.size();i++){

                String line =CountryLines.get(i);
                String[] split = line.split(",");
//            System.out.println(split[0]);
//            System.out.println(split[1]);
                Countrylist.add(new Country(split[0],split[1]));
            }
//        System.out.println(Countrylist);

            for (int i=0; i<CityLines.size();i++){

                String line =CityLines.get(i);
                String[] split = line.split(",");
//            System.out.println(split[0]);
//            System.out.println(split[1]);
//            System.out.println(split[2]);
//            System.out.println(Integer.parseInt(split[3]));
//            System.out.println(Integer.parseInt(split[4]));
                Citylist.add(new City(split[0],split[1],split[2],Integer.parseInt(split[3]),Integer.parseInt(split[4])));
            }
//        System.out.println(Citylist);

            Map<String,List<City>> map= new HashMap<>();

            for (int i=0; i<Countrylist.size();i++){
                map.put(Countrylist.get(i).getCode(),new ArrayList<>());
            }
            for (int i=0;i<Citylist.size();i++){
                List<City> list = map.get(Citylist.get(i).Code);
                list.add( Citylist.get( i ) );
                map.put(Citylist.get(i).Code,list);
            }
            for(int i=0; i<map.get("2").size();i++){
                System.out.println(map.get("2").get(i).getName());
            }
            List<City> updatelist =sort(map.get("2"));
//        System.out.println(updatelist.get(1));

            List<City> Highpopcity= Citylist.stream().collectors.groupby(Citylist.getContinent());
            System.out.println(Highpopcity);

        }


}


