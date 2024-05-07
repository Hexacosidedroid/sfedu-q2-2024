import java.io.File
import java.sql.DriverManager.getConnection
import java.sql.PreparedStatement
import javax.xml.bind.JAXBContext

fun main(args: Array<String>) {
    val jaxbContext = JAXBContext.newInstance(Department::class.java)
    val unmarshaller = jaxbContext.createUnmarshaller()
    val unmarshal =
        unmarshaller.unmarshal(File("/Users/slava_ivanov_saikyo/IdeaProjects/Receiver/src/main/resources/test.xml")) as Department
    println(unmarshal)

    val connection = getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgrespostgres")
    unmarshal.student.forEach {
        val result = connection.prepareStatement("Insert into students(name) values ('${it.name}')").execute()
        println("$result - insert ${it.name}")
    }

}
