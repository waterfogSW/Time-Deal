import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "3.0.1"
  id("io.spring.dependency-management") version "1.1.0"
  id("org.asciidoctor.jvm.convert") version "3.3.2"
  kotlin("jvm") version "1.7.22"
  kotlin("plugin.spring") version "1.7.22"
  kotlin("plugin.jpa") version "1.7.22"
}

group = "com.waterfogsw"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
  mavenCentral()
}

val snippetsDir by extra { file("build/generated-snippets") }

dependencies {
  // spring-web
  implementation("org.springframework.boot:spring-boot-starter-web")

  // jpa
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")

  // kotlin
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  // mysql
  runtimeOnly("com.mysql:mysql-connector-j")

  // test
  testImplementation("io.mockk:mockk:1.13.2")
  testImplementation("com.ninja-squad:springmockk:4.0.0")
  testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
  testImplementation("io.kotest:kotest-assertions-core:5.5.4")
  testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
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

tasks.test {
  outputs.dir(snippetsDir)
}

tasks.asciidoctor {
  inputs.dir(snippetsDir)
  dependsOn(tasks.test)
}
