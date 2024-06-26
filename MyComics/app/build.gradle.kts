plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlinx-serialization")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.xramos.mycomics"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.xramos.mycomics"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Basics
    implementation("androidx.core:core-ktx:1.12.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    // Navigation
    implementation("androidx.navigation:navigation-runtime-ktx:${rootProject.extra["navigation_version"]}")
    implementation("androidx.navigation:navigation-ui-ktx:${rootProject.extra["navigation_version"]}")
    implementation("androidx.navigation:navigation-compose:${rootProject.extra["navigation_version"]}")

    // Compose
    implementation("androidx.compose.compiler:compiler:1.5.11")
    implementation("androidx.compose.ui:ui:1.6.4")
    implementation("androidx.compose.ui:ui-graphics:1.6.4")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.4")
    //implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.material3:material3-android:1.2.1")
    implementation("androidx.compose.foundation:foundation-android:1.6.4")
    implementation("androidx.activity:activity-compose:1.8.2")

    // Androidx Core
    implementation("androidx.core:core-splashscreen:1.0.1")

    // LiveData
    implementation("androidx.compose.runtime:runtime-livedata:1.6.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // Ktor
    implementation("io.ktor:ktor-client-android:${rootProject.extra["ktor_version"]}")
    implementation("io.ktor:ktor-client-serialization:${rootProject.extra["ktor_version"]}")
    implementation("io.ktor:ktor-client-logging-jvm:${rootProject.extra["ktor_version"]}")

    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    // DaggerHilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")
    kapt("androidx.hilt:hilt-compiler:1.2.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Coil
    implementation("io.coil-kt:coil-compose:${rootProject.extra["coil_version"]}")

    // JUnit
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

kapt {
    correctErrorTypes = true
}