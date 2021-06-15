public class City {
    public City(String code, String name, String continent, Integer population, Integer area){
        Name=name;
        Continent= continent;
        Population= population;
        Code= code;
        Area= area;
    }
    public String getCode(){
        return Code;
    }

    public void setCode(String code){
        Code=code;
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        Name= name;
    }
    public String getContinent(){
        return Continent;
    }

    public void setContinent(String continent){
        Continent= continent;
    }
    public Integer getPopulation(){
        return Population;
    }

    public void setPopulation(int population){
        Population= population;
    }
    public Integer getArea(){
        return Area;
    }

    public void setArea(int area){
        Area=area;
    }
    String Code;
    String Name;
    String Continent;
    int Population;
    int Area;

}
