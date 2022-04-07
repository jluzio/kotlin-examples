import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.jetbrains.kotlin.plugin.allopen") version "1.6.20"
	kotlin("jvm") version "1.6.20"
	kotlin("plugin.spring") version "1.6.20"
}

group = "org.example.kotlin"
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
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("javax.enterprise:cdi-api:2.0")
	implementation("com.google.guava:guava:31.1-jre")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mockito:mockito-core:4.4.0")
	testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
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
	annotation("org.example.kotlin.playground.compiler.KotlinAllOpen")
	annotation("org.example.kotlin.playground.testing.MockableV2")
	// annotations("com.another.Annotation", "com.third.Annotation")
}