# This file is to test if your arduino is able to send data to your RPi serially
import serial

ser = serial.Serial('/dev/ttyACM0',9600)

while True:
    read_serial=ser.readline()

    print read_serial
