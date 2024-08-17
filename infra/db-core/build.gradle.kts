allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    api("org.springframework.boot:spring-boot-starter-data-jpa") 이 방식은 JpaRepository와 같은 의존성 사용 가능
    runtimeOnly("com.mysql:mysql-connector-j")
}
