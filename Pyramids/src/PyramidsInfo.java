public class PyramidsInfo {
    private String Pharaoh;
    private String Ancient_name;
    private String Modern_name;
    private int Dynasty;
    private String Site;
    private double Base1;
    private double Base2;
    private double Height;
    private double Slope;
    private double Volume;
    private double Latitude;
    private double Longitude;
    private String Type;
    private String Lepsius;
    private String Material;

    public PyramidsInfo(String pharaoh, String field, String Pharaoh, String Ancient_name, String Modern_name, String Dynasty, String Site, String Base1, String Base2, String Height, String Slope, String Volume, String Latitude, String Longitude, String Type, String Lepsius, String Material) {
        this.Pharaoh = Pharaoh;
        this.Ancient_name = Ancient_name;
        this.Modern_name = Modern_name;

        try {
            this.Dynasty = Integer.valueOf(Dynasty.replaceAll("s", ""));
        } catch (Exception var24) {
            this.Dynasty = -1;
        }

        this.Site = Site;

        try {
            this.Base1 = Double.valueOf(Base1.replaceAll("s", ""));
        } catch (Exception var23) {
            this.Base1 = -1.0D;
        }

        try {
            this.Base2 = Double.valueOf(Base2.replaceAll("s", ""));
        } catch (Exception var22) {
            this.Base2 = -1.0D;
        }

        try {
            this.Height = Double.valueOf(Height.replaceAll("s", ""));
        } catch (Exception var21) {
            this.Height = -1.0D;
        }

        try {
            this.Slope = Double.valueOf(Slope.replaceAll("s", ""));
        } catch (Exception var20) {
            this.Slope = -1.0D;
        }

        try {
            this.Volume = Double.valueOf(Volume.replaceAll("s", ""));
        } catch (Exception var19) {
            this.Volume = -1.0D;
        }

        try {
            this.Latitude = Double.valueOf(Latitude.replaceAll("s", ""));
        } catch (Exception var18) {
            this.Latitude = -1.0D;
        }

        try {
            this.Longitude = Double.valueOf(Longitude.replaceAll("s", ""));
        } catch (Exception var17) {
            this.Longitude = -1.0D;
        }

        this.Type = Type;
        this.Lepsius = Lepsius;
        this.Material = Material;
    }

    public String getName() {
        return this.Pharaoh;
    }
}

