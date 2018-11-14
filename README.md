# test-ribs
This is following steps on [uber/RIBs Android Tutorial](https://github.com/uber/RIBs/wiki/Android-Tutorial-1) to test Uber's cross-platform mobile architecture framework - RIBs

## Getting Started

### Prerequisites

* Java SE Development Kit (>=8)
* Android Emulator (suggest [Genymotion](https://www.genymotion.com) or [Bluestacks](https://www.bluestacks.com))
* [Android Studio](https://developer.android.com/studio/) (optional)
* [RIBs Code Generation Plugin for Android Studio and IntelliJ](https://github.com/uber/RIBs/wiki/Android-Tooling#ribs-code-generation-plugin-for-android-studio-and-intellij) (optional)

### Installing

Use **Android Studio** or execute the following command or 
```
./gradlew :test:installDebug
```

## Test
<img width="500" alt="image" src="https://user-images.githubusercontent.com/4859095/48468148-0845e600-e826-11e8-8ee2-1c3642286b0b.png">

After you tapping the *LOGIN* button, you should be able to see *loginName* in logs.
<img width="600" alt="image" src="https://user-images.githubusercontent.com/4859095/48468366-9752fe00-e826-11e8-92e7-f36828fd4db9.png">
