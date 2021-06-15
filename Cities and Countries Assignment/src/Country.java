public class Country {
    String Name;
    String Code;

    public Country(String code, String name) {
        this.Name = name;
        this.Code = code;
    }

    public String getCode() {
        return this.Code;
    }

    public void setCode(String code) {
        this.Code = code;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
