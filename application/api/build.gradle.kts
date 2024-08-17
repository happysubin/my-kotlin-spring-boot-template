tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {

    implementation(project(":core"))
    implementation(project(":support"))
    implementation(project(":infra"))
    implementation(project(":client"))

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.security:spring-security-test")
}
