package EnumExample;

public enum WeatherTypes {

    RAINY("Rainy"),
    CLOUDY("Cloudy"),
    SUNNY("Sunny"),
    SNOW("Snow"),
    HOT("Hot");
        
    private String value;

    WeatherTypes(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
