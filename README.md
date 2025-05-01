# BDD
4th Assignment: Transforming requirements into test cases using the Behavior-Driven Development (BDD) approach.

<div dir="rtl">

## بخش اول - اجرای یک مثال


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

تست `maven` با موفقیت اجرا می‌شود:

![maven-test-success.png](images/maven-test-success.png)

اما اگر feature را به تنهایی اجرا کنیم به مشکل می‌خوریم:

![feature-run-error.png](images/feature-run-error.png)

برای رفع این مشکل در `pom.xml` این تغییر را می‌دهیم:

![update-dependency.png](images/update-dependency.png)

بر روی خود فایل `calculator.feature`
هم می‌رویم و با راست کلیک گزینه‌ی کانفیگ آن را هم به این صورت تغییر می‌دهیم:

![calculator-config.png](images/calculator-config.png)

اسم پکیج فایل `.feature` را هم تغییر می‌دهیم تا در نهایت با موفقیت اجرا شود.

![feature-pass.png](images/feature-pass.png)


حال به سراغ ایجاد `RunnerTest` می‌رویم.
ابتدا همان طور که گفته شده است، فقط انوتیشن `@RunWith(Cucumber.class)`
را استفاده می‌کنیم.

![RunnerTest-Fail.png](images/RunnerTest-Fail.png)

که همان طور که مشاهده می‌شود با ارور مواجه می‌شویم.
حال از انوتیشن `@CucumberOptions`
نیز استفاده می‌کنیم.

![RunnerTest-Pass.png](images/RunnerTest-Pass.png)

مشاهده می‌شود که با تغییر تست هم همه چیز به خوبی اجرا می‌شود.

![Change-Test.png](images/Change-Test.png)

حال  `Scenario Outline` را اضافه می‌کنیم. مشاهده می‌شود که نتیجه‌ی اجرای تست با مشکل روبه‌رو است.

![Scenario-test-fail.png](images/Scenario-test-fail.png)

با بررسی تست فیل شده متوجه میشویم تعریف ما اعداد منفی را در نظر نمیگیرد. حال کد موجود برای stepdefs را تغییر می‌دهیم و به صورت زیر انوتیشن‌ها را قرار می‌دهیم، تا هر عدد صحیحی دربرگرفته شود.


```java
    @Given("Two input values, {int} and {int}")
    public void two_input_values_and(Integer int1, Integer int2) {
        value1 = int1;
        value2 = int2;
    }
    @When("I add the two values")
    public void i_add_the_two_values() {
        calculator = new Calculator();
        result = calculator.add(value1, value2);
        System.out.println(result);
    }
    @Then("I expect the result {int}")
    public void i_expect_the_result(Integer int1) {
        int expected = int1;
        Assert.assertEquals(expected, result);
    }
```

حال مشاهده می‌شود که با تغییرات انجام شده، تست سناریو هم به درستی اجرا می‌شود.

![Scenario-test-pass.png](images/Scenario-test-pass.png)


## بخش آخر - ماشین حساب پیشرفته

در این بخش باید طبق دستور کار یک ماشین حساب پیاده سازی کنیم که قابلیت گرفتن اعداد و برخی عملگرها را داشته باشد. در فایل جدیدی به اسم `ourcalculator.feature`
شروع به اضافه کردن سناریوهای عادی و همچنین `Scenario Outline` می‌کنیم. به عنوان مثال، `Scenario Outline` به این صورت است:

![ourcalculator-outline.png](images/ourcalculator-outline.png)

برخی از سناریوهای عادی هم به این صورت هستند:

![ourcalculator-happy-scenario.png](images/ourcalculator-happy-scenario.png)

یک سری سناریوی خطای دیگر از جمله اورفلو، تقسیم بر صفر و... نیز در سناریوها آمده‌اند:

![zero-to-zero.png](images/zero-to-zero.png)


![over-under-flow.png](images/over-under-flow.png)

به علاوه، باید این عبارتها را مشابه قسمت قبل در فایل `ourstepdefs`
تعریف هم بکنیم.
به عنوان مثال:

![ourstepdefs.png](images/ourstepdefs.png)

برای پیاده‌سازی ماشین حساب و در نظر گرفتن ارورهای مختلف، می‌توان از کتابخانه‌ی `Math` و توابعی مانند `Math.addExact`
استفاده کرد.
مثلا:

```java
 public int add(int a, int b) {
        try {
            return Math.addExact(a, b);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Integer overflow");
        }
    }
```

حال به سراغ اجرا کردن تست‌ها می‌رویم.
اجرا کردن فایل `ourcalculator.feature`:

![ourcalculator-feature-pass.png](images/ourcalculator-feature-pass.png)

اجرا کردن فایل `RunnerTest`:

![Runner-test-final.png](images/Runner-test-final.png)

همان طور که مشخص است، همه‌ی تست‌ها به درستی اجرا می‌شوند.
    
توجه داشته باشید که در فایل `RunnerTest`
از آنجا که هم تعاریف بخش اول و دوم پروژه هر دو در یک پکیج قرار گرفته‌اند (`stepdefs`)
و هم فیچرها در یک پکیج قرار گرفته‌اند،
همان کانفیگ قبلی (و با `glue=stepdefs`)
کارساز است. 

</div>