import javax.xml.bind.annotation.*

@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
data class Department(
    @XmlElement(name = "room")
    var room: String? = null,
    @XmlElementWrapper(name = "students")
    val student: MutableList<Student> = mutableListOf()
)