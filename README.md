# kotlin_mvvm

This is a sample Android project built with **Kotlin**, using **Jetpack Compose** for the UI, **MVVM architecture**, **Retrofit** for network calls, and **Dagger Hilt** for dependency injection. The project implements Clean Architecture principles to separate concerns and keep the codebase maintainable and scalable.

## 🔧 Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **MVVM (Model-View-ViewModel)**
- **Clean Architecture**
- **Coroutines** – For asynchronous operations
- **Retrofit** - For HTTP networking
- **Dagger Hilt** - For dependency injection
- **Navigation Component** - For screen navigation

## 🌐 APIs Used

Using dummy REST API endpoints from [JSONPlaceholder](https://jsonplaceholder.typicode.com/):

- `/posts`
- `/comments`
- `/photos`

## 🚀 Features

- Fetch and display data for **Posts**, **Comments**, and **Photos**
- Use **ViewModel** and **State** handling for UI updates
- Navigate between multiple screens
- Display images using `AsyncImage` with error fallback
- Follows SOLID principles using **Clean Architecture**

## 🛠️ Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/muchamadiqbaal08/kotlin_mvvm.git

## 📁 Project Structure

```text
com.example.kotlin_jetpack_compose_mvvm/
├── data/               # DTOs, repository implementations, API services
├── domain/             # Use cases, domain models, and interfaces
├── di/                 # Hilt modules for DI
├── presentation/       # ViewModels, Screens, and UI logic
├── ui/
│   └── navigation/     # Navigation setup and screen routes
└── MainActivity.kt     # App launcher