from appium import webdriver
from appium.options.common import AppiumOptions
from appium.webdriver.common.appiumby import AppiumBy
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

APP = "https://github.com/appium-pro/TheApp/releases/download/v1.12.0/TheApp.apk"
APPIUM = 'http://localhost:4723'

CAPS = {
    "platformName": "Android",
    "appium:options": {
        "platformVersion": "14.0",  # optional
        "deviceName": "Android Emulator",
        "automationName": "UiAutomator2",
        "app": APP
    }
}

OPTIONS = AppiumOptions().load_capabilities(CAPS)

driver = webdriver.Remote(
    command_executor=APPIUM,
    options=OPTIONS
)

try:
    driver.get("theapp://login/alice/mypassword")
    wait = WebDriverWait(driver, 10)
    login_text = wait.until(EC.presence_of_element_located(
        (AppiumBy.XPATH, "//android.widget.TextView[contains(@text, 'You are logged in')]")))
    assert "alice" in login_text.text
except Exception as e:
    print(f"Error: {e}")
finally:
    if driver:
        driver.quit()