package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.imdbPage;
import utilities.Driver;

public class US002 {

    String director;
    String writer;
    String stars;
    imdbPage imdbPage = new imdbPage();

    @Then("Kullanici Best Writing, Adaptation başlığı altında The Jazz Singer secer")
    public void kullanici_best_writing_adaptation_başlığı_altında_the_jazz_singer_secer() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(imdbPage.bestWritingAdaptationSection).perform();
        Thread.sleep(1000);
        imdbPage.theJazzSinger.click();
    }

    @Then("Kullanici gelen ekranda, “The Jazz Singer’a ait Director, Writer ve Stars bilgilerini kayit eder")
    public void kullanici_gelen_ekranda_the_jazz_singer_a_ait_director_writer_ve_stars_bilgilerini_kayit_eder() {
        director = imdbPage.director.getText();
        writer = imdbPage.writer.getText();
        stars = imdbPage.stars.getText();
    }

    @Then("Kullanici arama çubuguna ““The Jazz Singer” yazar ve tiklar")
    public void kullanici_arama_çubuguna_the_jazz_singer_yazar_ve_tiklar() throws InterruptedException {
        imdbPage.searchBar.sendKeys("Caz Mugannisi");
        Thread.sleep(1000);
        imdbPage.searchBarFirstResult.click();
    }

    @Then("Kullanici gelen ekranda; “The Jazz Singer” filminin Director Writer Stars  bilgisi kayit edilen Starts’la ayni mi kontrol eder")
    public void kullanici_gelen_ekranda_the_jazz_singer_filminin_director_writer_stars_bilgisi_kayit_edilen_starts_la_ayni_mi_kontrol_eder() {
        String actualDirector = imdbPage.director.getText();
        String actualWriter = imdbPage.writer.getText();
        String actualStars = imdbPage.stars.getText();

        Assert.assertEquals(director, actualDirector);
        Assert.assertEquals(writer, actualWriter);
        Assert.assertEquals(stars, actualStars);
    }
}
