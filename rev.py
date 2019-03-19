import serial
import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
import time


#print("Debug1")

cred = credentials.Certificate('/home/pi/Documents/firebase/vaak-eeda0-firebase-adminsdk-13upq-49eac33bac.json')
#default_app = firebase_admin.initialize_app(cred)
firebase_admin.initialize_app(cred, {
    'databaseURL': 'https://vaak-eeda0.firebaseio.com/'
})


while True:
    ser = serial.Serial('/dev/ttyACM0',9600)
    ref = db.reference()
    read_serial=ser.readline()
    print read_serial
    ref.update({
        'Data':read_serial
    })
    #ser.close()
