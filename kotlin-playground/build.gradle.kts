import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.0"
//	id("org.jetbrains.kotlin.plugin.allopen") version "1.8.10"
	kotlin("jvm") version "1.8.10"
	kotlin("plugin.spring") version "1.8.10"
}

group = "com.example.kotlin"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_17

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
	implementation("com.google.guava:guava:31.1-jre")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
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