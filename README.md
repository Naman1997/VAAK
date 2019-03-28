# Raspberry Setup Guide and Overall Introduction
[![N|Solid](https://i.ebayimg.com/images/g/pT0AAOSwX~dWmbz4/s-l300.jpg)](https://www.arduino.cc/)
[![N|Solid](https://s3.amazonaws.com/ionic-marketplace/ionic-2-firebase-auth-starter/icon.png)](https://firebase.google.com/)
[![N|Solid](https://raw.githubusercontent.com/iiiypuk/rpi-icon/master/256.png)](https://www.raspberrypi.org/)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This guide expalins how to setup your raspberry pi and the general structure of the project

# Introduction
VAAK is a college project under the TARP course. Under this course we had to make groups and come up with creative solutions to real world problems and implement them. Our group decided to make a project that helped specially-abled people who cannot speak by making a device that took input from their fingers in a fixed format(For example: American Sign Language), process it and play out the processed data via a speaker that is either interfaced with an android smartphone or simply a smartphone's inbuilt speaker. Members under the project are:

  - Naman Arora
  - Rishabh Agarwal
  - Soham Sengupta
  - Aditya Kshetriya
  - Arpan Satpathi
  - Dharoori Rakesh Acharya
  
  Checkout out our product website [here](https://arpan2798.github.io/Product_Showcase/index.html#home)
  
# Brief working of the project

We use flex sensors for getting the input from the fingers of the user. These sensors are connected to an arduino uno, which processes and sends the data to a raspberry pi serially or to a wifi card, which then sends the data to a firebase realtime database. The android app interacts with this database and reads out the interpreted text.

For now, we did not study the American Sign Language, so we used the sensors to send alphabet combinations instead.
For example, since we have 26 alphabets, we use 5 flex sensors and assign each binary combinaion of the input to a specific alphabet.
In this repository, however, we have only used 2 sensors, so make sure to edit the .ino file accordingly.


So the project can be divided in the following parts:
  - Getting the data from arduino uno
  - Processing the data inside the arduino script
  - Sending the data to a raspberry pi, or a wifi module
  - Transmitting the data to a specific firebase realtime database
  - Using the android app to consume the data from the database
  - Using the app to control the speakers connected to the device and reading out the text/alphabet

The code given in this repo is only for *alphabet* reading and nothing else.

We used a raspberry pi to send the data to the firebase realtime database using the *rev.py* script. You can learn more about it [here](https://www.instructables.com/id/Raspberry-Pi-Arduino-Serial-Communication/).

### Installation for RPi

The application requires [Arduino IDE](https://www.microsoft.com/en-in/p/arduino-ide/9nblggh4rsd8?ocid=badge&rtc=1&activetab=pivot%3Aoverviewtab) so that you can push your code into your arduino and needs [Android Studio](https://developer.android.com/studio) so that you can build the android app files.

First push the arduino.ino file to your arduino and then test it on your pc for testing the accuracy of your sensors. For that you will need to replace all *Serial.write* commands with *Serial.print* commands in the arduino.ino file.

If you are using a raspberry pi as we have to send the data over to a firebase realime database, you will need to install the following dependencies:


```sh
$ pip install serial
$ pip install firebase-admin
$ pip install time      #only if you want to give delays like: time.sleep(3)
```

After making sure you are getting the accurate values from your arduino, connect your raspberry pi with your arduino as mentioned [here](https://www.instructables.com/id/Raspberry-Pi-Arduino-Serial-Communication/).
Now our arduino code is running on a serial connection on the raspberry pi continuously. You can check if your raspberry pi detected your arduino by running the following command in your terminal:

```sh
ls /dev/tty*
```
If /dev/ttyACM0 shows up in the list, you're good to go!
Now run the python script by running the following command in your terminal:
```sh
python rev.py
```
This will send your arduino data to your firebase realtime database. Which you can use in an android app.
