package webdriver.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class direcionamentoSteps {
    private WebDriver driver;

    @Before
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\estaf\\OneDrive\\Documentos\\Ciência de dados\\Testes com java\\Automação rjux iw\\lib\\chromedriver-win64");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Dado("que o usuário seja direcionado para um novo site")
    public void novaGuia() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.amazon.com.br/");
        assertTrue(driver.getTitle().contains("Amazon"), "Página inicial não carregada corretamente.");
    }

    @E("que o usuário acesse os mangás")
    public void hqMangas() {
        WebElement iconeBarra = driver.findElement(By.className("hm-icon"));
        iconeBarra.click();

        WebElement barraLatVerTudo = driver.findElement(By.xpath("(//a[@aria-label='See all'])[1]"));
        barraLatVerTudo.click();

        WebElement livros = driver.findElement(By.xpath("(//a[@class='hmenu-item'])[26]"));
        livros.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hq = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='HQs e Mangás']")));
        hq.click();
    }

    @Quando("clicar no filtro Mangás HQs, Mangás e Graphic Novels")
    public void filtro() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mangas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='a-spacing-micro apb-browse-refinements-indent-2'])[2]")));
        mangas.click();
    }

    @Então("irá clicar em uma categoria")
    public void categoria() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mangaCategoria = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h3[normalize-space()='Mangá de Mistério, Suspense e Crime'])[1]")));
        mangaCategoria.click();
    }

    @E("irá filtrar buscando o autor Junji Ito")
    public void filtroAutor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement autor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='apb-browse-refinements-checkbox_20']//i[@class='a-icon a-icon-checkbox']")));
        autor.click();

        WebElement manga = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")));
        manga.click();
    }
}
