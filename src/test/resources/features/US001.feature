
@smokeTest
Feature: US001
  Scenario:Menü üzerinden gidilerek “The Circus” filmi bulunur ve bu film arama çubuğundan arattırılır. Director, Writer, Stars bilgilerinin aynı olduğu doğrulanır

    Given Kullanici "imdb"  adresine gider
    Then  Kullanici arama çubugunun sol tarafında bulunan Menu butonuna tiklar
    Then  Kullanici gelen ekranda Award & Events başlığı altında bulunan Oscars butonuna tiklar
    Then  Kullanici event History başlığı altında 1929 degerine tiklar
    Then  Kullanici honorary Award başlığı altında The Circus (Charles Chaplin) secer
    Then  Kullanici gelen ekranda, The Circus’a ait Director, Writer ve Stars bilgilerini kayit eder
    Then  Kullanici ekranın sol ustunde bulunan IMDb butonuna tıklanarak Anasayfa’ya döner
    Then  Kullanici arama çubuguna “The Circus” yazar ve tiklar
    Then  Kullanici gelen ekranda; Director Writer Stars  bilgisi kayit edilen Starts’la ayni mi kontrol eder
    Then  Kullanici Kontrolleri yaptiktan  sonra Photos  linkine tiklar
    Then  Kullanici Gelen ekranda butun fotograflarin linklerinin kirik olmadigini kontrol eder.
