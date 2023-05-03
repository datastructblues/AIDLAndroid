# AIDL Example

This example demonstrates the use of AIDL (Android Interface Definition Language) for exchanging data between Android applications.

![GIF](https://github.com/datastructblues/datastructblues/blob/main/images/aidl.gif)

## What is AIDL?

AIDL is a language and interface definition format used to exchange data between Android applications. AIDL is used to make remote procedure calls and includes interface definitions for data types, methods, and properties. AIDL is used to facilitate communication between applications that use a Client-Server architecture.
`Don't forget you must download AIDLServer.apk to use this example app properly.`

## What's in this Example?

This example includes a server application (`AIDLServer`) and a client application (`AIDLClient`). The client application includes a button that, when clicked, calls the `getNames()` function in the server application and displays a random name as a toast message. Clicking the same button again calls the `getColor()` function and changes the color of the button.

## How to Use?

1. Clone this repository locally or download as a ZIP file.

2. Download the server application using [this link](https://drive.google.com/file/d/1Mb3hLljsiN_5gy8H2NNUB0YS-puIvFQu/view?usp=sharing).

3. Install and run the server application. The server application runs as a service and will work in the background.

4. Import the `AIDLClient` project into Android Studio.

5. Run the client application.

6. Click the button in the client application. The color of the button will change, and a random name from the server application's name list will be displayed as a toast message.

7. Click the same button again. The color of the button will change again, and a random name from the server application's name list will be displayed as a toast message.

8. Repeat this process to see that the color of the button changes each time and that different names are fetched from the server.

## Resources

- [Android Developer Documentation: AIDL](https://developer.android.com/guide/components/aidl)
