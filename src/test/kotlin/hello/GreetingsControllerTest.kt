package hello

import io.kotlintest.specs.FeatureSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.TestContextManager

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingsControllerTest : FeatureSpec() {
    @Autowired
    val restTemplate: TestRestTemplate? = null

    override fun beforeAll() {
        TestContextManager(this.javaClass).prepareTestInstance(this)
    }

    init {
        feature("hello endpoint") {
            scenario("Asserting getting the greeting") {
                val result = restTemplate?.getForEntity("/", String::class.java)
                result?.statusCodeValue shouldBe 200
                result?.body shouldBe "hello!"
            }
        }
    }
}