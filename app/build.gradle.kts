plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.catalog"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.catalog"
        minSdk = 30
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.1"
        useLiveLiterals = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}
kapt {
    correctErrorTypes = true
}


dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    implementation ("com.google.dagger:hilt-android:2.50")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.50")

    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.2")
    implementation("androidx.compose.material3:material3-adaptive:1.0.0-alpha05")
    implementation("androidx.compose.material3:material3-adaptive-navigation-suite:1.0.0-alpha02")


// Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation("androidx.test:core-ktx:1.5.0")

// LifeCycle
    val lifecycle_version = "2.5.1"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

// Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

// Jetpack Compose
    val compose_version = "1.4.2"
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("androidx.compose.ui:ui-tooling:$compose_version")
    implementation("androidx.compose.foundation:foundation:$compose_version")
    implementation("androidx.compose.runtime:runtime-livedata:$compose_version")
    implementation("androidx.compose.runtime:runtime:$compose_version")
    implementation ("androidx.navigation:navigation-compose:2.7.6")

    implementation ("androidx.fragment:fragment-ktx:1.4.0")
    implementation ("androidx.activity:activity-ktx:1.3.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.19.0")
    implementation("androidx.core:core-splashscreen:1.0.0-alpha01")

    //Hilt
    implementation ("com.google.dagger:hilt-android:2.50")
    kapt ("com.google.dagger:hilt-compiler:2.50")


// Hilt Navigation Compose integration
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")

// Hilt Jetpack Compose integration
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")

// Hilt ViewModels for Jetpack Compose
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")

// RxJava
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

    testImplementation("org.mockito:mockito-core:3.11.2")
    androidTestImplementation("org.mockito:mockito-android:3.11.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

// Truth library for ViewMatchers.assertThat
    implementation("com.google.truth:truth:1.1.3")

// LiveData testing
    testImplementation("androidx.arch.core:core-testing:2.1.0")

}