plugins {
    id("org.springframework.boot") version("3.4.3")
    id("java")
}

version = "1.0.2"
group = "org.gradle.samples"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.4.3"))

    implementation("org.springframework.boot:spring-boot-starter")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
