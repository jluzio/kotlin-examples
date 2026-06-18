plugins {
	id("org.springframework.boot") version "4.0.2"
	id("io.spring.dependency-management") version "1.1.7"
//	id("org.jetbrains.kotlin.plugin.allopen") version "2.4.0"
	kotlin("jvm") version "2.4.0"
	kotlin("plugin.spring") version "2.4.0"
	kotlin("plugin.serialization") version "2.4.0"

	// Lombok
	id("io.freefair.lombok") version "9.5.0"
	kotlin("plugin.lombok") version "2.4.0"
}

group = "com.example.kotlin"
version = "1.0"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	val kotlinxHtmlVersion = "0.12.0"

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("org.jetbrains.kotlin:kotlin-test")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-debug")

	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm")

	// include for JVM target
	implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinxHtmlVersion")
	// include for JS target
//	implementation("org.jetbrains.kotlinx:kotlinx-html-js:$kotlinxHtmlVersion")
	// include for Common module
	implementation("org.jetbrains.kotlinx:kotlinx-html:$kotlinxHtmlVersion")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("jakarta.enterprise:jakarta.enterprise.cdi-api:4.0.1")
	implementation("com.google.guava:guava:33.6.0-jre")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mockito.kotlin:mockito-kotlin:6.3.0")
	testImplementation("io.kotest:kotest-runner-junit5:6.2.0")
	testImplementation("io.strikt:strikt-jvm:0.35.1")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
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
