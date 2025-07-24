[![](https://jitpack.io/v/FosanzDev/runpod-java.svg)](https://jitpack.io/#FosanzDev/runpod-java)


# RunPod Java SDK (Unofficial)
An unofficial Java SDK for the RunPod API by FosanzDev

**Note**: This is a community-maintained SDK and is not officially affiliated with RunPod.

## Add the dependency

Add JitPack to repos
```kotlin
repositories {
    // ...
    maven { url = uri("https://jitpack.io") }
}
```

Add the dependency
```kotlin
// For latest version on master branch
implementation("com.github.FosanzDev:runpod-java:-SNAPSHOT")
```

## Usage

```java
RunPodClient client = new RunPodClient("<your_api_key>");

// Get all GPU Types
List<GpuType> gpuList = client.queries.gpu.getGpuTypes();
```