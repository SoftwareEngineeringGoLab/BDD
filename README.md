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

### شماره‌ی ۶ الی ۱۰

ابتدا همان طور که گفته شده است بخش `src/test/resources` را می‌سازیم.

![resources.png](images/resources.png)

![test-root.png](images/test-root.png)

حال در این بخش `calculator.feature`
را می‌سازیم:
![calculator-feature.png](images/calculator-feature.png)

همان طور که گفته شده است تعریف استپ‌ها را هم قرار می‌دهیم:

![step-defs.png](images/step-defs.png)

و کد جمع دو عدد را در calculator قرار می‌دهیم:

![calculator-java.png](images/calculator-java.png)

تست میون با موفقیت اجرا می‌شود:

![maven-test-success.png](images/maven-test-success.png)

اما اگر feature را به تنهایی اجرا کنیم به مشکل می‌خوریم:

![feature-run-error.png](images/feature-run-error.png)

برای رفع این مشکل در `pom.xml` این تغییر را می‌دهیم:

![update-dependency.png](images/update-dependency.png)

بر روی خود فایل `calculator.feature`
هم می‌رویم و با راست کلیک گزینه‌ی کانفیگ آن را هم به این صورت تغییر می‌دهیم:

![calculator-config.png](images/calculator-config.png)

اسم پکیج فایل فیچر را هم تغییر می‌دهیم تا در نهایت با موفقیت اجرا شود.

![feature-pass.png](images/feature-pass.png)
