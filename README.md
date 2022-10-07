# fitnessCenterManager

[Gereksinimler Dökümanı]

[Gereksinim Belgesi]

Bir spor salonu, kayıt olan müşterilerinin kaydını tutmak ve kayıtlı müşterilerin bilgilerini
düzenlemek için bir sistem oluşturmak istiyor.

[Ön Koşul]

Bu programı sadece spor salonu için “yönetici” erişimine sahip kullanıcılar
kullanabilmelidir.(Programı kullanan kişinin yönetici olduğu varsayılır.)

[Yönetim Paneli]

♦ Yeni kayıt oluşturabilir

♦ Kayıt düzenleyebilir

♦ Kayıt silebilir

♦ Kayıtlı müşterilerin isim,soyisim,üyelik paketi,ödenen ücret,başlangıç ve bitiş tarihini
görebilir.

♦ Kayıtlı müşteriler arasında arama yapabilir.

♦ Müşteri kayıtları güncellendiğinde veritabanını yenileyebilir.


[Kayıtlı Müşteri]

Bir müşteri şunlardan oluşur

♦ ID

♦ Name

♦ Surname

♦ Membership

♦ Start Date

♦ Expiration Date

♦ Discount

♦ Total Price


[Discount]

Müşterinin kayıt olduğu süreye göre belirli bir miktar indirim yapılır. Bu miktarlar şöyledir

♦ 6-12 Months : %5

♦ 1-2 Years : %10

♦ 2-4 Years : %15

[Membership Pack]

Müşteri kayıt olurken belirli hazır paketlerden birini seçer. Bu paketler şöyledir

♦ Fullpack

♦ Dualpack

♦ Swimming


[Add New Customer]

Bir müşteriyi kaydetmek için yönetici şu bilgileri doldurmalıdır

♦ Name

♦ Surname

♦ Membership pack

♦ Start Date

♦ Expiration Date

Yönetici bu bilgileri girip “ADD” butonuna tıkladığında sistem otomatik olarak bir ID ve
girilen bilgilere göre indirimi ve son fiyatı uygular.

[Remove a Customer]

Bir müşteri kayıt süresini doldurmuşsa veya herhangi bir sebepten silinmesi gerekiyorsa
yönetici veritabanından müşteriyi seçip herhangi bir bilgi doldurmasına gerek kalmadan
“Delete Selected User” butonuna tıklayarak müşteriyi silebilir.

[Edit a Customer]

Bir müşterinin şu verileri düzenlenebilir

♦ Name

♦ Surname

♦ Membership pack

♦ Start Date

♦ Expiration Date

ID, discount ve total price sistem tarafından otomatik olarak belirlendiğinden değiştirilemez.

[Veritabanı]

Yöneticinin, kayıtlı müşteriler üzerinde yaptığı değişiklikleri depolaması için bir veritabanı
bağlantısı gereklidir. Bu yazılımda MySQL ile bir localhost bağlantısı oluşturulmalıdır. Bu
veritabanını koruması için programın id,pass,url bağlantıları doğru bir şekilde
tanımlanmalıdır.

Mysql-connector kütüphanesinden yararlanılır.

[Tema,Tasarım]

Bu program göze daha hoş gözükmesi ve kullanımı kolay olması için normal Java ile
hazırlanan projelerin haricinde JavaFX ile yapılır ve ek olarak JMetro kütüphanesiyle
kendisine şık bir tasarım oluşturur.

[Analiz]

Yönetici tüm işlemleri tek bir program üzerinden aksaklık olmadan yapabilmesi gereklidir. Bir
pencereyi açtığında diğer pencerelerin kapanmaması ve kullanıma açık olması
gerekmektedir.

Yönetici yeni bir müşteri kaydı eklediğinde , var olan bir kaydı sildiğinde veya düzenlediğinde
ana ekranda gözükmesi için “Refresh” butonuna tıklayarak listeyi güncellemelidir.

