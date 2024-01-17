@Test
    public void testLoginNormally() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement screen = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.AccessibilityId("Login Screen")));
        screen.click();

        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.AccessibilityId("username")));
        username.sendKeys("alice");

        WebElement password = driver.findElement(AppiumBy.AccessibilityId("password"));
        password.sendKeys("mypassword");

        WebElement login = driver.findElement(AppiumBy.AccessibilityId("loginBtn"));
        login.click();

        WebElement loginText = wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//android.widget.TextView[contains(@text, 'You are logged in')]")));

        assert(loginText.getText().contains("alice"));
    }
