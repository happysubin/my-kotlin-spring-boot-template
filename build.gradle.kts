
plugins {
	kotlin("jvm")
	kotlin("kapt")
	kotlin("plugin.spring") apply false
	kotlin("plugin.jpa") apply false
	id("org.springframework.boot") apply false
	id("io.spring.dependency-management") apply false
	id("org.jlleitschuh.gradle.ktlint") apply false
}


java {
	toolchain {
		languageVersion = JavaLanguageVersion.of("${property("javaVersion")}")
	}
}

allprojects {

	group = "${property("projectGroup")}"
	version = "${property("applicationVersion")}"

	repositories {
		mavenCentral()
	}
}

subprojects {

	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.kapt")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
		apply(plugin = "org.jlleitschuh.gradle.ktlint")
	}

	tasks.getByName("bootJar") {
		enabled = false
	}

	tasks.getByName("jar") {
		enabled = true
	}

	kotlin {
		compilerOptions {
			freeCompilerArgs.addAll("-Xjsr305=strict")
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}


