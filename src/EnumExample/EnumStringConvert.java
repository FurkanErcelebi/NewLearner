package EnumExample;

public class EnumStringConvert {

    public static void main(String[] args) {
        
        String weather = null;
        WeatherTypes weatherType = null;
        
        weather = convertILetter("Rainy".toUpperCase());
        weatherType = WeatherTypes.valueOf(weather);
        if(weatherType.equals(WeatherTypes.RAINY)){
            System.out.println("Types converted for Rainy");
        }
        else{
            System.err.println("Types not converted");
        }

        weather = "Cloudy".toUpperCase();
        weatherType = WeatherTypes.valueOf(weather);
        if(weatherType.equals(WeatherTypes.CLOUDY)){
            System.out.println("Types converted for Cloudy");
        }
        else{
            System.err.println("Types not converted");
        }

        weather = "Sunny".toUpperCase();
        weatherType = WeatherTypes.valueOf(weather);
        if(weatherType.equals(WeatherTypes.SUNNY)){
            System.out.println("Types converted for Sunny");
        }
        else{
            System.err.println("Types not converted");
        }

        weather = "Snow".toUpperCase();
        weatherType = WeatherTypes.valueOf(weather);
        if(weatherType.equals(WeatherTypes.SNOW)){
            System.out.println("Types converted for Snow");
        }
        else{
            System.err.println("Types not converted");
        }

        weather = "Hot".toUpperCase();
        weatherType = WeatherTypes.valueOf(weather);
        if(weatherType.equals(WeatherTypes.HOT)){
            System.out.println("Types converted for Hot");
        }
        else{
            System.err.println("Types not converted");
        }

        weather = "Windy";
        try {
            weatherType = WeatherTypes.valueOf(weather); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Converting completed");

    }


    public static String convertILetter(String str){

        String tmp = str; 
        int i = 0;
        if(str.contains("İ")){
            for (char chr : str.toCharArray()) {

                if(chr == 'İ'){
                    
                    tmp = tmp.substring(0,i) + "I" + tmp.substring(i + 1);

                }

                i++;
            }

        }

        return tmp;
    }

}
