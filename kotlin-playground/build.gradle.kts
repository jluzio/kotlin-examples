import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
//	id("org.jetbrains.kotlin.plugin.allopen") version "1.9.22"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	kotlin("plugin.serialization") version "1.9.22"

	// Lombok
	id("io.freefair.lombok") version "8.4"
	kotlin("plugin.lombok") version "1.9.22"
}

group = "com.example.kotlin"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_21

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	val kotlinxHtmlVersion = "0.11.0"

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("org.jetbrains.kotlin:kotlin-test")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-debug")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")

	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm")

	// include for JVM target
	implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinxHtmlVersion")
	// include for JS target
//	implementation("org.jetbrains.kotlinx:kotlinx-html-js:$kotlinxHtmlVersion")
	// include for Common module
	implementation("org.jetbrains.kotlinx:kotlinx-html:$kotlinxHtmlVersion")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("jakarta.enterprise:jakarta.enterprise.cdi-api:4.0.1")
	implementation("com.google.guava:guava:33.0.0-jre")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mockito.kotlin:mockito-kotlin:5.2.1")
	testImplementation("io.kotest:kotest-runner-junit5:5.8.0")
	testImplementation("io.strikt:strikt-jvm:0.34.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "21"
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
