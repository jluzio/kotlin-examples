import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
//	id("org.jetbrains.kotlin.plugin.allopen") version "1.9.20"
	kotlin("jvm") version "1.9.20"
	kotlin("plugin.spring") version "1.9.20"

	// Lombok
	id("io.freefair.lombok") version "8.4"
	kotlin("plugin.lombok") version "1.9.20"
}

group = "com.example.kotlin"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_20

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("org.jetbrains.kotlin:kotlin-test")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("jakarta.enterprise:jakarta.enterprise.cdi-api:4.0.1")
	implementation("com.google.guava:guava:32.1.3-jre")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "20"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

allOpen {
	annotation("com.example.kotlin.playground.compiler.KotlinAllOpen")
	annotation("com.example.kotlin.playground.testing.MockableV2")
	// annotations("com.another.Annotation", "com.third.Annotation")
}
