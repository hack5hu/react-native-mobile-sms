# react-native-mobile-sms

`react-native-mobile-sms` is a React Native package designed to facilitate direct SMS sending on Android devices. This package uses the native `MobileSms` module, allowing you to send messages without user interaction with the default messaging app—perfect for emergency alerts or automated messaging systems.

## 🚀 Features

- **Send SMS directly**: Send messages from your app without user interaction.
- **Emergency alerts**: Ideal for sending quick emergency notifications.
- **Automated messaging**: Seamlessly integrate SMS functionality into your apps.
- **Android support**: Currently supports Android devices only.

## 📦 Installation

Get started quickly by installing the package with npm or yarn:

```bash
npm install react-native-mobile-sms
```

or

```bash
yarn add react-native-mobile-sms
```

## 📚 Usage

Import `react-native-mobile-sms` in your React Native component and call the `sendDirectSms` method with the recipient's mobile number and your message.

```javascript
import React from 'react';
import { Button, View } from 'react-native';
import mobileSms from 'react-native-mobile-sms';

const App = () => {
  const sendEmergencySms = () => {
    const mobileNumber = '1234567890';
    const message = `I had an accident, please come to this location: https://maps.google.com/?q=12.821888+12.86541`;

    mobileSms.sendDirectSms(mobileNumber, message);
  };

  return (
    <View>
      <Button title="Send Emergency SMS" onPress={sendEmergencySms} />
    </View>
  );
};

export default App;
```

### 📋 API

#### `sendDirectSms(mobileNumber: string, message: string)`

- **mobileNumber** (string): The recipient's mobile number.
- **message** (string): The text message to be sent.

## 🛠️ Example

```javascript
import React from 'react';
import { Button, View } from 'react-native';
import mobileSms from 'react-native-mobile-sms';

const App = () => {
  const sendEmergencySms = () => {
    const mobileNumber = '1234567890';
    const message = `I had an accident, please come to this location: https://maps.google.com/?q=12.821888+12.86541`;

    mobileSms.sendDirectSms(mobileNumber, message);
  };

  return (
    <View>
      <Button title="Send Emergency SMS" onPress={sendEmergencySms} />
    </View>
  );
};

export default App;
```

## ⚙️ Permissions

Ensure you have the necessary permissions in your Android `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.SEND_SMS"/>
```

## ⚠️ Notes

- This package is currently only supported on Android devices.
- Ensure the mobile number is correctly formatted and the device has the necessary permissions to send SMS.

## 📝 Future Updates

We have some exciting features planned for future updates:

1. **iOS Support**: We're working on extending support to iOS devices, so you can send SMS across both major platforms.
2. **SIM Selection**: Adding functionality to select the SIM card for sending SMS, giving users more control over their messaging.

## 📜 License

This project is licensed under the MIT License.

## 🤝 Contributing

We welcome contributions! Please open an issue or submit a pull request for any changes or improvements.

## 🙋 Support

Encounter any issues or have questions? Open an issue on the [GitHub repository](https://github.com/hack5hu/react-native-mobile-sms/issues).

---

Make your React Native app more interactive and responsive with `react-native-mobile-sms`. Install it today and experience seamless SMS integration.
