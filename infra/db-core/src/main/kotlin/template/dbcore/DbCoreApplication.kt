package template.dbcore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DbCoreApplication

fun main(args: Array<String>) {
    runApplication<DbCoreApplication>(*args)
}
