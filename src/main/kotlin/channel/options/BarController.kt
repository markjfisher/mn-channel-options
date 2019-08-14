package channel.options

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus

@Controller("/bar")
class BarController() {

    @Get("/")
    fun index(): String {
        return "Bar!"
    }
}