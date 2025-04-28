# BDD
4th Assignment: Transforming requirements into test cases using the Behavior-Driven Development (BDD) approach.

## بخش اول - اجرای یک مثال

### شماره‌ی ۱ الی ۵

ابتدا پروژه را ایجاد کرده و فایل `pom.xml` را با محتوای زیر درست می‌کنیم:

![pom.png](images/pom.png)

حال `maven project`
را با استفاده از کلیک راست روی `pom.xml`
و `add as maven project`
راه‌اندازی می‌کنیم تا دانلود‌های مورد نظر انجام شوند.

![maven.png](images/maven.png)

در این حالت روی نوار سمت راست صفحه کلیک کرده و تست maven را اجرا می‌کنیم:

![maven-test.png](images/maven-test.png)

مشاهده می‌شود که به خطا می‌خوریم:

![maven-test-error1.png](images/maven-test-error1.png)

برای رفع خطا بخش `properties`
را این‌گونه اضافه می‌کنیم:

![properties.png](images/properties.png)

مشاهده می‌شود که بیلد با موفقیت اجرا می‌شود

![build-success.png](images/build-success.png)

و به همین ترتیب junit, cucumber هم با موفقیت ایمپورت شده‌اند:

![imports.png](images/imports.png)

