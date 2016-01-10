import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kolos on 09.01.2016.
 */
//If someone is reading this code - don't judge, i was practicing
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kolos\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\Kolos\\Desktop\\VK.html");
        List<Post> jokes = new ArrayList();
        int publicNumber = 28229175;
        int id = 10898;
        for (int i = 0; i < 1000000; i++) {
            //3911 is id of the last joke
            if (id == 3911) break;
            WebElement text = null;
            try {
                text = driver.findElement(By.id("wpt-" + publicNumber + "_" + id));
                //if there is no exception at this point, we understand that element exists, and we can work with it
                WebElement like = driver.findElement(By.id("like_count-" + publicNumber + "_" + id));
                WebElement post = driver.findElement(By.id("share_count-" + publicNumber + "_" + id));
                int likeGood = 0;

                try {
                    likeGood = Integer.parseInt(like.getText());
                } catch (NumberFormatException e) {
                    likeGood = 0;
                }
                if (likeGood >= 1750) {
                    jokes.add(new Post(text.getText(), Integer.parseInt(like.getText()),
                            Integer.parseInt(post.getText())));
                    System.out.println("\"" + text.getText() + "\"" + "," + Integer.parseInt(like.getText()) + "," +
                            Integer.parseInt(post.getText()));
                }
                id--;
            } catch (NoSuchElementException e) {
                id--;
            }
        }

    }
}
