 # Basic Library Application(Basit Kütüphane Uygulaması)


  Uygulama'yı IntelliJ IDE'sını kullanarak geliştirdim.O yüzden IntelliJ üzerinden nasıl import edilip çalıştırılacağını kısaca anlatacağım.
  
  Github üzerinden projeyi zip olarak yada clone olarak indirdikten sonra(Tercih sizin,fakat zip olarak indirdikten sonra tabiki bir dizin çıkartma işlemi daha gerekicektir.)
  IntelliJ uygulamamızı açalım ve görseldede gördülüğü gibi 'Import Project' kısmına basalım.
  
  ![openImport](https://user-images.githubusercontent.com/45934056/95691096-3f48f000-0c25-11eb-9e48-fc448c213034.png)
  
  Bu kısımdan sonra karşımıza import edilecek projenin dizinin girilmesini istiyecek bir pencere ile karşılaşacaksınızdır aşağıdaki örnek
  resimdeki gibi dosya dizinimizi yazalım.
  
  ![openDirectory](https://user-images.githubusercontent.com/45934056/95691181-e594f580-0c25-11eb-9b23-373056aaf865.png)
  
  Dizinimizide başarılı bir şekilde yazdıkdan sonra proje'nin nasıl import edileceği hakkında bir pencereyle karışılaşacağız.
  
  ![selectMaven](https://user-images.githubusercontent.com/45934056/95691232-4b817d00-0c26-11eb-84bb-b27187f8ef4a.png)
  
  'Import project from external model' kutucuğunu seçtikten sonra 'Maven' seçeneğini seçelim.
  
  Bu seçimlerimizden sonraki penceleredeki ayarları 'default' şekilde bırakabilirsiniz kısaca next next :) 
  
  Projemizi başarıyla import ettikden sonra IntelliJ ye bir kaç saniye kendisine gelmesi için süre verelim.
  
  Bu sürenin ardından sağ üst kısımda görseldeki gibi olan yerden 'Run'Application tuşuna başalım yada Shift+F10'da basılabilir.
  
 ![Adsız](https://user-images.githubusercontent.com/45934056/95691301-cd71a600-0c26-11eb-8396-14c77daf5a6a.png)

  İlk kez runlayanlar için bir kaç log erroru gösterip projeyi başlatmayabilir yada geç başlatabilir bu gibi bi durumda tekrar 'Run'Application
  tuşuna basmanız sorunu çözücektir.
  
  Kodumuz çalıştıkdan sonra ise localhost:8080 adresinden uygulamaya göz atabilirsiniz.
  
  
  
  ### Ne Nerde Neden?
  - <b>H2 Database</b>:H2 database'ni seçmemin sebebi farklı bir bilgisiyarda kodu çalıştırmaya çalıştığınızda bir database konfigürasyonu yapmanıza gerek kalmadan direk kodu 
  - çalıştırılabilmesi içindir.
  - <b>Lombok</b>: Lombok aslında yaygın olarak kullanılan bir kütüphane, lombok bize encapsulation,loglama vs gibi pek çok kısımda yardımcı olduğu için tercih ettim.
  - <b>Mapstruct</b>: Mapstruct' da bildiğim kadarıyla yaygın kullanılan bir kütüphane DTO objelerinin işlemlerinde kolaylık sağlıyabilmesi amacıyla tercih ettim.
