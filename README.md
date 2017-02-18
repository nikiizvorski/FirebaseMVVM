# FirebaseMVVM

Sample MVVM Project containing FireBase implementation and DI with Dagger2 and Java 1.8. You can use lambdas and streams. Lambdas are used only on functional interfaces where you can perform Intermediate and Terminate Operations. Functional interfaces can have as many as needed methods as long they are static and default and only one of them is abstract. Default methods are the one that you can provide implementation without the need of providing implementatio for them. There are a lot functional interfaces included in the standart API. If you need to use some of them you may have to check for the support in android.

This is how a proper non-spagetti code should look like! It have a good architecture a slight defects here and 

there which can be fixed but i wanted to share my knowlege with the rest and see how they can manage to 

fix this if they can actually see the problems. 

This project contains a proper Dagger2 implementation and a good MVVM architecture which can be easy maintained and tested.

In the project you have Firebase login and some data from the firebase app. 

It can be a good step for someone that is just getting in to these libraries and into the android world.

If you decide to use RxJava don't forget to unsubscribe and make sure to make a subscription since you will

understand what will happen if you don't :) simply your observable will just push or request data while there is none.

How?

- Easy they changed to RxJava2 Version now which is pretty much the same thing but there is a lot more control and it works 
really awesome compared to the old one! Added most of the functionallity that already exists in Functional Java 1.8 and above.

- really realy good news.

Is it Awesome?

- I started working with MVVM more and more and i get to see that it is really good it can be used with most projects really easy.

- This one contains a really god architecture that you can use for your personal projects but have slight defects on purpose.

- Be sure to check my other MVVM Projects to understand it better.

Project not Running?

There may be some problems on older emulators which doesn't support Google Play Services 10+ if you have them simply test on a real device or wait for the update from google!
Project Structure? Updated for the latest 2.8 libs

Component and Module -> Dagger2 -> DI
ViewModel -> Presentation Layer
Activity -> View Layer
Iterator and Model classes -> Model Layer
Using Parcelable? - these are just a couple ways to pass data between your activities

Yes we are using Parcelable since it is specificly made for Android rather than the slow Serilizalable. If you want to read more on the topic you can go and find what marshaling and unmarshaling means in Java.
Removed transitions?

There you go the level is D:LoginActivity and you can follow onAuthStateChanged:signed_in or onAuthStateChanged:signed_out. The rest i leave to you.
Why Firebase?

Firebase is one of the best out there and i think is one of the most powerful, secure and wth a lot of tools and it is lightning fast too. But there are some weird stuff going on in the debugger? Well there are you know google as i do. Just Update the libs to latest and don't pay that much attention to their logs. Other than that it works really great! And it is cross platform. You have everything you may need in an app. I will leave you to look it yourself and find all the awesome tools you may use.
Java 1.8?

I suggest you do use the 1.8 since it is awesome and it is really helpfull and you will see that for yourself even if you denide it right now. It simply remove a ot of boilerplate and give you really really great flexability and it is really readable and removes completely the imperative style of programming which is like 20 years old. But if you want to remove it and not use it just remove the jack and the compabability options and you are ready to go. Now you can use the Instant run again.
Author

Niki Izvorski (nikiizvorski@gmail.com)
