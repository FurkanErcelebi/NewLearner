package NetworkExample;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public class UrlExample {
    
    public static void main(String[] args) throws URISyntaxException, MalformedURLException, UnsupportedEncodingException {

        String urlString2Decode = "http://localhost:8080/api/file/download?path=ExpenseForm/2022/20220126/17342/26.01.2022-10:48:31.121-2022 smmm aidatı.PNG";
        String decodedURL = URLDecoder.decode(urlString2Decode, "UTF-8");
        URL url = new URL(decodedURL);
        URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
        String decodedURLAsString = uri.toASCIIString();
        System.out.println(decodedURLAsString);

    }

}
