  # Basic Library Application(Basit Kütüphane Uygulaması)
  # Uygulamayı Kurma
  Projeyi çalıştırabilmek için maven komutları kullanılacaktır bu yüzden öncelikle bilgisiyarınızda maven bulunuyor mu? Buna bir göz atalım.
  Bilgisayarınzda maven bulunup bulunmadığını anlamak için bilgisayarın konsol uygulamasını açıp 'mvn -version' yazınız.
  
  ![version](https://user-images.githubusercontent.com/45934056/95883170-49810080-0d83-11eb-9fca-c8ee74ae6cc3.png)
  
  Eğer üsteki görsele benzer bir görsel ile karşılaşmıyor yada hata yaşıyorsanız 
  https://mkyong.com/maven/how-to-install-maven-in-windows/ linki üzerinden bilgisiyarınıza maven kurunuz.
  
  Mavenı başarıyla kurduktan sonra Github üzerinden projeyi indiriniz.
  Projeyi indirdikten sonra bilgiyar konsolunuz üzerinden projenin bulunduğu kısıma geçiniz.
  
  Projenin bulunduğu dizine geçtikten sonra konsol kısmına 'maven install' yazınız.
 ![mvn install](https://user-images.githubusercontent.com/45934056/95891047-32dfa700-0d8d-11eb-90ea-504e8f45d14a.png)

  Proje başarıyla build edildikten sonra 'target' adlı yeni bir dizin oluşucaktır bu dizine geçiniz.
  ![target](https://user-images.githubusercontent.com/45934056/95890164-15f6a400-0d8c-11eb-84bb-1b0a1566868c.png)
  Target dizinine geçtikden sonra aşağıda görseldeki gibi oluşan jar dosyasını 'java -jar <jarName>' komutu ile çalıştırınız.Jar dosyamızıda başarıyla çalıştıkdan sonra     
  uygulamaya localhost:8080 adresinden ulaşabilirsiniz.


  # Uygulamayı IntelliJ'ye import etme:
  
  Github üzerinden projeyi zip olarak ya da clone olarak indirdikten sonra(Tercih sizin fakat zip olarak indirdikten sonra tabii ki bir dizin çıkartma işlemi daha gerekicektir.)
  IntelliJ uygulamasını açalım ve görselde de gördülüğü gibi 'Import Project' kısmına basalım.
  
  ![openImport](https://user-images.githubusercontent.com/45934056/95691096-3f48f000-0c25-11eb-9e48-fc448c213034.png)
  
  Bu kısımdan sonra karşımıza import edilecek projenin dizininin girilmesini istiyecek bir pencere ile karşılaşacaksınız. Aşağıdaki örnek görselde olduğu
  gibi dosya dizininizi yazın.
  
  ![openDirectory](https://user-images.githubusercontent.com/45934056/95691181-e594f580-0c25-11eb-9b23-373056aaf865.png)
  
  Dizininizi de başarılı bir şekilde yazdıktan sonra projenin nasıl import edileceği hakkında bir pencereyle karşılaşacaksınız.
  
  ![selectMaven](https://user-images.githubusercontent.com/45934056/95691232-4b817d00-0c26-11eb-84bb-b27187f8ef4a.png)
  
  'Import project from external model' kutucuğunu seçtikten sonra 'Maven' seçeneğini seçiniz.
  
  Bu seçimlerinizden sonraki penceleredeki ayarları 'default' şekilde bırakabilirsiniz kısaca next next :) 
  
  Projemizi başarıyla import ettikten sonra IIntelliJ'ye birkaç saniye kendisine gelmesi için süre verelim.
  
  Bu sürenin ardından sağ üst kısımda; görseldeki gibi olan yerden 'Run'Application tuşuna basınız.Ya da Shift+F10 kombinasyonu da kullanılabilir
  
 ![Adsız](https://user-images.githubusercontent.com/45934056/95691301-cd71a600-0c26-11eb-8396-14c77daf5a6a.png)

  İlk kez runlayanlar için bir kaç log erroru gösterip projeyi başlatmayabilir yada geç başlatabilir bu gibi bi durumda tekrar 'Run'Application
  tuşuna basmanız sorunu çözücektir.
  
  Kodumuz çalıştıktan sonra ise localhost:8080 adresinden uygulamaya göz atabilirsiniz.
  
  
  
  ### Ne Nerde Neden?
  - <b>H2 Database</b>:Kod, farklı bir bilgisiyarda çalıştırılmak istendiğinde bir database konfigürasyonu yapmamamıza gerek kalmadan direkt olarak kodun çalıştırılabilmesine     olanak sağlamak maksadıyla H2 database'ni seçtim.
  - <b>Lombok</b>: Lombok aslında yaygın olarak kullanılan bir kütüphanedir.Lombok bize encapsulation,loglama vs gibi pek çok kısımda yardımcı olduğu için tercih ettim.
  - <b>Mapstruct</b>: Mapstruct bildiğim kadarıyla yaygın kullanılan bir kütüphane DTO objelerinin işlemlerinde kolaylık sağlıyabilmesi amacıyla tercih ettim.
