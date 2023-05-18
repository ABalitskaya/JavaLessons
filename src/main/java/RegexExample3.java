import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample3 {
    // пример парсинга сайта

    public static void main(String[] args) throws Exception {
        String site = "https://en.wikipedia.org/wiki/List_of_cities_in_Germany_by_population";
        StringBuilder content = new StringBuilder();

        URLConnection connection = new URL(site).openConnection();

        // обработка потока в котором хранится исходный код страницы
        Scanner scanner = new Scanner(connection.getInputStream());

        while (scanner.hasNextLine()) {
            String tmp = scanner.nextLine();
            if (!tmp.equals(""))
                content.append(tmp);
        }
        scanner.close();

        Pattern tag1 = Pattern.compile("<table class=\"wikitable sortable\">");
        Pattern tag2 = Pattern.compile("id=\"Gallery\"");

        Matcher matcher1 = tag1.matcher(content.toString());

        int start = 0;
        int finish = 0;

        while (matcher1.find())
            start = matcher1.start();

        Matcher matcher2 = tag2.matcher(content.toString());
        while (matcher2.find())
            finish = matcher2.start();

        String tmp_content = content.substring(start, finish);

        String[] splitted = tmp_content.split("</td>");

        List<String> listAfterProcessing = new ArrayList<>();

        for (int i = 0; i < splitted.length; i++) {
            String s = splitted[i];

//            if (s.contains("title=") && s.contains("span"))
            if (s.contains("flagicon"))
                listAfterProcessing.add(s.split("href=\"/wiki/")[1].split("title=\"")[1].split("\"")[0]);
        }

        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < listAfterProcessing.size(); i += 2) {
            map.put(listAfterProcessing.get(i), listAfterProcessing.get(i+1));
        }

//        System.out.println(listAfterProcessing);
//        System.out.println(listAfterProcessing.size());

        System.out.println(map);


    }

}
