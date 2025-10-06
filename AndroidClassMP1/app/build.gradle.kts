plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.jorgeromo.androidClassMp1"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.jorgeromo.androidClassMp1"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Core KTX
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // BOM de Compose (gestiona versiones de Compose)
    implementation(platform(libs.androidx.compose.bom))

    // Artefactos Compose (sin versión explícita)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("androidx.compose.foundation:foundation") // Para Pager, etc.
    implementation("androidx.compose.material:material-icons-extended")

    // Navegación
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")

    // Firebase
    implementation(libs.firebase.messaging)

    // DataStore
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // Networking (Retrofit & OkHttp)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // Lottie para animaciones
    implementation("com.airbnb.android:lottie-compose:6.4.1")

    // CameraX y ML Kit para QR
    implementation("androidx.camera:camera-core:1.3.0")
    implementation("androidx.camera:camera-camera2:1.3.0")
    implementation("androidx.camera:camera-lifecycle:1.3.0")
    implementation("androidx.camera:camera-view:1.3.0")
    implementation("com.google.mlkit:barcode-scanning:17.0.3")
    implementation("com.google.mlkit:vision-common:17.3.0")

    // Coil para imágenes
    implementation("io.coil-kt:coil-compose:2.5.0")

    // ✅ DEPENDENCIAS AÑADIDAS DEL PRIMER ARCHIVO
    implementation("com.google.android.gms:play-services-location:21.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    // Dependencias de Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // ❌ DEPENDENCIAS REDUNDANTES ELIMINADAS (ya estaban cubiertas por el BOM o el catálogo 'libs')
    // implementation ("androidx.activity:activity-compose:1.9.2")
    // implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    // implementation ("androidx.compose.material3:material3:1.2.1")
}