# Real World Use Cases of Abstraction

## 1. Database Access (Data Access Object / Repository Pattern)
In an enterprise application, you rarely write raw SQL queries in your business logic. Instead, you define an abstraction, like a `UserRepository` interface with methods like `findById(id)` and `save(user)`. The implementation (`PostgresUserRepository` or `MongoDbUserRepository`) handles the complex SQL or NoSQL queries. The business logic remains abstracted away from the database technology.

## 2. File Storage Systems
Cloud applications often need to store files. By creating a `FileStorageService` abstraction (with methods like `upload(file)` and `download(fileId)`), the system doesn't need to know if the files are being saved to the local disk, AWS S3, or Google Cloud Storage.

## 3. Notification Systems
A `NotificationSender` abstraction can have implementations like `EmailSender`, `SmsSender`, or `PushNotificationSender`. When an order is placed, the checkout system just calls `NotificationSender.send(user, message)`, abstracting away the complexities of SMTP servers or SMS gateways.

## 4. UI Frameworks (e.g., React, Android SDK)
When you render a `Button` on a screen, you are using an abstraction. You don't need to write the low-level graphics rendering code (OpenGL/Canvas) to draw the pixels, handle the click coordinates, and trigger the animation. The framework abstracts all of that away.
