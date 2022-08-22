package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.imdbPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class US001 {

    HttpURLConnection huc = null;
    int respCode = 200;

    String director;
    String writer;
    String stars;

    imdbPage imdbPage = new imdbPage();


    @Given("Kullanici {string}  adresine gider")
    public void kullanici_adresine_gider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @Then("Kullanici arama çubugunun sol tarafında bulunan Menu butonuna tiklar")
    public void kullanici_arama_çubugunun_sol_tarafında_bulunan_menu_butonuna_tiklar() {
        imdbPage.menuDropDownButton.click();
    }

    @Then("Kullanici gelen ekranda Award & Events başlığı altında bulunan Oscars butonuna tiklar")
    public void kullanici_gelen_ekranda_award_events_başlığı_altında_bulunan_oscars_butonuna_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        imdbPage.oscarsSection.click();

    }

    @Then("Kullanici event History başlığı altında {int} degerine tiklar")
    public void kullanici_event_history_başlığı_altında_degerine_tiklar(Integer int1) throws InterruptedException {
        Thread.sleep(1000);
        imdbPage.yearSection.click();
    }

    @Then("Kullanici honorary Award başlığı altında The Circus \\(Charles Chaplin) secer")
    public void kullanici_honorary_award_başlığı_altında_the_circus_charles_chaplin_secer() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(imdbPage.honoryAwardSection).perform();
        Thread.sleep(1000);
        imdbPage.movie.click();
    }

    @Then("Kullanici gelen ekranda, The Circus’a ait Director, Writer ve Stars bilgilerini kayit eder")
    public void kullanici_gelen_ekranda_the_circus_a_ait_director_writer_ve_stars_bilgilerini_kayit_eder() {
        director = imdbPage.director.getText();
        writer = imdbPage.writer.getText();
        stars = imdbPage.stars.getText();
    }

    @Then("Kullanici ekranın sol ustunde bulunan IMDb butonuna tıklanarak Anasayfa’ya döner")
    public void kullanici_ekranın_sol_ustunde_bulunan_ım_db_butonuna_tıklanarak_anasayfa_ya_döner() {
        imdbPage.imbdButton.click();
    }

    @Then("Kullanici arama çubuguna “The Circus” yazar ve tiklar")
    public void kullanici_arama_çubuguna_the_circus_yazar_ve_tiklar() throws InterruptedException {
        imdbPage.searchBar.sendKeys("The Circus");
        Thread.sleep(1000);
        imdbPage.searchBarFirstResult.click();
    }

    @Then("Kullanici gelen ekranda; Director Writer Stars  bilgisi kayit edilen Starts’la ayni mi kontrol eder")
    public void kullanici_gelen_ekranda_director_writer_stars_bilgisi_kayit_edilen_starts_la_ayni_mi_kontrol_eder() {

        String actualDirector = imdbPage.director.getText();
        String actualWriter = imdbPage.writer.getText();
        String actualStars = imdbPage.stars.getText();

        Assert.assertEquals(director, actualDirector);
        Assert.assertEquals(writer, actualWriter);
        Assert.assertEquals(stars, actualStars);

    }

    @Then("Kullanici Kontrolleri yaptiktan  sonra Photos  linkine tiklar")
    public void kullanici_kontrolleri_yaptiktan_sonra_photos_linkine_tiklar() {
        imdbPage.photosButton.click();
    }

    @Then("Kullanici Gelen ekranda butun fotograflarin linklerinin kirik olmadigini kontrol eder.")
    public void kullanici_gelen_ekranda_butun_fotograflarin_linklerinin_kirik_olmadigini_kontrol_eder() {
        List<WebElement> links = Driver.getDriver().findElements(By.tagName("img"));

        for (WebElement webEl : links
        ) {
            String url = webEl.getAttribute("src");
            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }

            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }
}
