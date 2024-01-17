@Test
    public void testLoginWithDeepLink() {
        driver.get("theapp://login/alice/mypassword");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement loginText = wait.until(ExpectedConditions.presenceOfElementLocated(
            AppiumBy.xpath("//android.widget.TextView[contains(@text, 'You are logged in')]")));

        assert(loginText.getText().contains("alice"));
    }
}
