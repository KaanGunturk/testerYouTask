Feature: US002

  @smokeTest
  Scenario:Menü üzerinden gidilerek "The Jazz Singer" filmi bulunur ve bu film arama çubuğundan arattırılır.
  Director, Writer, Stars bilgilerinin aynı olduğu doğrulanır

    Given Kullanici "imdb"  adresine gider
    Then  Kullanici arama çubugunun sol tarafında bulunan Menu butonuna tiklar
    Then  Kullanici gelen ekranda Award & Events başlığı altında bulunan Oscars butonuna tiklar
    Then  Kullanici event History başlığı altında 1929 degerine tiklar
    Then  Kullanici Best Writing, Adaptation başlığı altında The Jazz Singer secer
    Then  Kullanici gelen ekranda, “The Jazz Singer’a ait Director, Writer ve Stars bilgilerini kayit eder
    Then  Kullanici ekranın sol ustunde bulunan IMDb butonuna tıklanarak Anasayfa’ya döner
    Then  Kullanici arama çubuguna ““The Jazz Singer” yazar ve tiklar
    Then  Kullanici gelen ekranda; “The Jazz Singer” filminin Director Writer Stars  bilgisi kayit edilen Starts’la ayni mi kontrol eder
    Then  Kullanici Kontrolleri yaptiktan  sonra Photos  linkine tiklar
    Then  Kullanici Gelen ekranda butun fotograflarin linklerinin kirik olmadigini kontrol eder.