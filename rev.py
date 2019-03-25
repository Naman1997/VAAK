import serial
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
import time


#print("Debug1")

cred = credentials.Certificate('#Location of your private key generated in firebase(a json file)')
#default_app = firebase_admin.initialize_app(cred)
firebase_admin.initialize_app(cred, {
    'databaseURL': '#Link_to_your_realtime_database'
})


while True:
    ser = serial.Serial('/dev/ttyACM0',9600)#9600 is the baud rate
    ref = db.reference()
    read_serial=ser.readline()
    print read_serial
    ref.update({
        'Data':read_serial
    })
