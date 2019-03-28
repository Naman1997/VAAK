# Circuit Connections Guide

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This guide explains how you can connect your flex sensors with your arduino and get changes in resistance values.

# Introduction
A flex sensor can give a range of changes in resistance values. One side of the sensor is printed with a polymer ink that has conductive particles embedded in it. When the sensor is straight, the particles give the ink a resistance of about 30k Ohms. When the sensor is bent away from the ink, the conductive particles move further apart, increasing this resistance.
When the sensor straightens out again, the resistance returns to the original value. By measuring the resistance, you can determine how much the sensor is being bent.
 However, since we need binary values from our sensors, we are gonna divide the range in two equal halves(in arduino code).
Now, one flex sensor gives us 2 values; either 1 or 0. In our latest version of the code, we are using *arduino_with_5_flex_sensors.ino* (meaning we have connected 5 flex sensors to the arduino), we get 2^5 combination. Since the english alphabet contains only 26 letters, we are left with 6 combinations which will have no mapping.

# Components used
- Arduino Uno R3 ATmega328P
- Connecting wires
- 5 flex sensors
- Raspberry Pi (With raspbian OS)
- 5 resistors (3.9k ohms)
- USB cable(Arduino to RPi connection)
# Arduino connection with flex sensors
You can see below how you can connect one flex sensor to the arduino uno board.
[![N|Solid](https://cdn.sparkfun.com/assets/learn_tutorials/5/1/1/example_circuit_bb.png)](https://learn.sparkfun.com/tutorials/flex-sensor-hookup-guide/all)

However, we are using 5 flex sensors, and their connections is as shown below

[![N|Solid](http://www.marcopucci.it/wp-content/uploads/2014/06/flex_sensor_5_dita_giallo.jpg)](https://learn.sparkfun.com/tutorials/flex-sensor-hookup-guide/all)

You can further find a proper guide by clicking on the images above or going [here](https://learn.sparkfun.com/tutorials/flex-sensor-hookup-guide/all)

