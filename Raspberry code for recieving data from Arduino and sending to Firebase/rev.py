#This file is to recieve your data from your arduino uno and sending it to your realtime firebase database
import serial
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
import time




cred = credentials.Certificate('#Location_of_your_private_key_generated_in_firebase(a json file)')
# You can generate the file for this @Project Settings(Icon next to Project Overview) > Service Accounts > Generate new private key
# It will be a json file


default_app = firebase_admin.initialize_app(cred)
#Remove or comment the line above after your first run

firebase_admin.initialize_app(cred, {
    'databaseURL': '#Link_to_your_realtime_database'
    # You can find your link after creating your realtime database.
    # You can find it by going to Develop > Database >Realtime Database > (copy the link in the form "https://Project-name.firebaseio.com")
})


while True:
    ser = serial.Serial('/dev/ttyACM0',9600)#9600 is the baud rate
    ref = db.reference()
    read_serial=ser.readline()
    print read_serial
    #Use ref.set() to create non-existing data and ref.update() for updating existing data
    ref.update({
        'Data':read_serial
    })
