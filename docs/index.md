![Asset 1](assets/header.png)

[![GitHub stars](https://img.shields.io/github/stars/kasem-sm/SlimeKT?style=social)](https://github.com/kasem-sm/SlimeKT/stargazers)
[![GitHub watchers](https://img.shields.io/github/watchers/kasem-sm/SlimeKT?style=social)](https://github.com/kasem-sm/SlimeKT/watchers)

## Introduction 🙋‍♂️

Article sharing platform where you can _**personalize, subscribe to your favourite topics, get
daily-read reminders, explore new authors and share your articles**_. It uses the most cutting edge
technology in the frontend and backend part such as <b>Ktor, MongoDB and Jetpack Compose.</b>

## App Architecture Diagram

It follows the recommended app architecture as stated in
official [Android documentation](https://developer.android.com/jetpack/guide). Please refer to [this](https://kasem-sm.github.io/SlimeKT/guide/app_architecture/) page for more information on this topic.

![Asset 2](assets/app_architecture.svg)

## Module Graph

![Asset 3](modules/module_graph.png)

## Repository overview 📂

SlimeKT has its own backend built with Ktor. The folder [`/api`](https://github.com/kasem-sm/SlimeKT/tree/dev/api) consists of our
backend deployed on Heroku. SlimeKT Android application resides inside of the [`/app`](https://github.com/kasem-sm/SlimeKT/tree/dev/app) folder.

## Screenshots 📱

<table>
    <tr>
        <td>
            <figure>
                <a href="#1">
                    <img src="screenshots/1.png">
                </a>
                <figcaption>Home screen</figcaption>
            </figure>
        </td>
        <td>
            <figure>
                <a href="#2">
                    <img src="screenshots/2.png">
                </a>
                <figcaption>Explore Screen</figcaption>
            </figure>
        </td>
    </tr>
    <tr>
        <td>
            <figure>
                <a href="#3">
                    <img src="screenshots/3.png" width=300>
                </a>
                <figcaption>Detail Screen</figcaption>
            </figure>
        </td>
        <td>
            <figure>
                <a href="#6">
                    <img src="screenshots/6.png" width=300>
                </a>
                <figcaption>Register sheet</figcaption>
            </figure>
        </td>
    </tr>
    <tr>
        <td>
            <figure>
                <a href="#4">
                    <img src="screenshots/4.png" width=300>
                </a>
                <figcaption>Subscribe Topics Screen</figcaption>
            </figure>
        </td>
        <td>
            <figure>
                <a href="#5">
                    <img src="screenshots/5.png" width=300>
                </a>
                <figcaption>Login sheet</figcaption>
            </figure>
        </td>
    </tr>
    <tr>
        <td>
            <figure>
                <a href="#7">
                    <img src="screenshots/7.png" width=300>
                </a>
                <figcaption>Profile Screen (WIP)</figcaption>
            </figure>
        </td>
        <td>
            <figure>
                <a href="#8">
                    <img src="screenshots/8.png" width=300>
                </a>
                <figcaption>Home screen with search query</figcaption>
            </figure>
        </td>
    </tr>
</table>

## Medium Articles 🖋

1. [SlimeKT - Kotlin Powered open source project. (Android app with Ktor backend)](https://medium.com/@kasem.sm/slimekt-136a56864e57)
2. Android’s IME Actions: Don’t ignore them. [Read here](https://proandroiddev.com/androids-ime-actions-don-t-ignore-them-36554da892ac)
3. Create Animated PlaceHolder for your Jetpack Compose text fields [Read here](https://medium.com/@kasem.sm/animated-placeholder-with-jetpack-compose-60c85547b47a)
4. When Jetpack's Glance met his fellow worker, WorkManager (Coming soon)

More articles by [_kasem-sm_](https://medium.com/@kasem.sm) on Medium.

## Contact 🤙

Direct Messages on [My Twitter](https://twitter.com/KasemSM_) are always open. If you have any questions related to SlimeKT or Android development, ping me anytime!

## Credits 💎

- [**Tivi**](https://github.com/chrisbanes/tivi) by [chrisbanes](https://github.com/chrisbanes) - A divine project for me to explore. I refer to this project as Gold 🥇.
- [**Gabor Varadi**](https://twitter.com/Zhuinden) - He is always willing to answer my questions. A great man and a blessing to the Android community (AKA, the `SavedStateHandle` preacher).
- [**Doris Liu**](https://twitter.com/doris4lt) and [**Manuel Vivo**](https://twitter.com/manuelvicnt) - They always help review my code snippets and add their value to them.
- [**Hadi**](https://twitter.com/hadilq) - Assisted me in improving the modularized structure of this project.
