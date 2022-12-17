package bot;

import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LKParser {
    public static boolean loginIn(String login, String password) {
        try {

        Document page = Jsoup.connect("http://lk.stu.lipetsk.ru").get();
        
        Elements elements = page.getElementsByTag("input");
        Element loginField = elements.get(2);
        Element passwordField = elements.get(3);
        
        loginField.text(login);
        passwordField.text(password);
        Element button = page.getElementsByClass("btn btn-default").get(0);

        // TODO: pressing button...?

        return true;

        } catch (Exception exception) {
            System.out.println(exception);
            return false;
        }
    }

    public static Optional<Element> getTimetable(String login, String password) {
        try {
            if (!loginIn(login, password))
                return Optional.empty();

            Document page = Jsoup.connect("http://lk.stu.lipetsk.ru/education/0/5:117084346").get();
            Elements timetable = page.getElementsByClass("table table-small");
            timetable.wait(200); //NOTE: Waiting until LK starts showing data
            return Optional.of(timetable.first());

        } catch(Exception exception) {
            System.out.println(exception);
            return Optional.empty();
        }
    }
}
